'use strict';
angular.module('genpactApp').controller('addApplicationCtrl', function($scope, $http, commonDataFactory,appConfig) {

    $scope.init = function() {
        $scope.applicationName = "";
        $scope.selectedBusinessUnit = "";
        $scope.applicationExist=false;
        var businessUnitRequest="<businessUnit><isViewOnly>true</isViewOnly><showDistinctBusinessUnits>false</showDistinctBusinessUnits><businessUnitId></businessUnitId><businessUnitName></businessUnitName><accountId></accountId><isActive></isActive></businessUnit>"
        
        $http({method: 'POST',url:appConfig.manageBusinessUnits,data: businessUnitRequest,headers: { "Content-Type": 'application/xml'}}).success(function(data) {
console.log(data.response.detail.businessUnitDetails);
            $scope.businessUnitList=data.response.detail.businessUnitDetails;
            angular.forEach($scope.businessUnitList,function(list,index) {
                if (list.businessUnitId == -1) {
                  $scope.businessUnitList.splice (index,1);
              }
            });
            console.log($scope.businessUnitList);
            // Setting the Account Data in the Common Data Factory
            commonDataFactory.setBusinessUnits($scope.businessUnitList);

        }).error(function () {
            console.log("  System Exception While Fetching The Business Units !!! ");
        });

       //For displaying the application
        var applicationRequest = "<application><showDistinctVals>false</showDistinctVals></application>";
        $http({method: 'POST',url:appConfig.fetchApplications,data:applicationRequest,headers: { "Content-Type": 'application/xml'}}).success(function(data) {
            if(data.response.header.statusCode==0){
                $scope.model.error=true;
            }else {
                $scope.applicationList=data.response.details.applicationDetails;
                angular.forEach($scope.applicationList,function(list,index) {
    	        	if (list.applicationId == -1) {
    	        	  $scope.applicationList.splice (index,1);
    	          }
    	        });
            }
        }).error(function () {
            console.log("  System Exception While Fetching The Application !!! ");
        });
    }

    $scope.searchBusinessUnitPopup = function() {
        $('#businessUnitModal').modal('show');
    }
    $scope.showSelectedBusinessUnit = function(data) {
        for(var i =0; i< $scope.businessUnitList.length; i++){
            if(data == $scope.businessUnitList[i].businessUnitId){
                $scope.selectedBusinessUnit = $scope.businessUnitList[i].businessUnitName;
                $scope.selectedBusinessUnitId = data;
              
            }
        }
    }
    $scope.resetValues=function(){
        $scope.applicationExist=false;
        $scope.applicationAlreadyExist=false;
    }
    $scope.addApplication = function() {

        var addApplication = {"applicationName": $scope.applicationName,"applicationId":"","businessName": $scope.selectedBusinessUnit.businessUnit.businessUnitName};

        for(var i=0;i<$scope.applicationList.length;i++){
            if($scope.applicationList[i].applicationName.toLowerCase()==addApplication.applicationName.toLowerCase()){
                $scope.applicationExist=true;
            }
        }
        if($scope.applicationExist!=true) {
            var applicationRequest = "<saveApplication><applicationId>-1</applicationId><applicationName>" + $scope.applicationName + "</applicationName><businessUnitId>" + $scope.selectedBusinessUnit.businessUnit.businessUnitId + "</businessUnitId><isActive>true</isActive></saveApplication>"


            $http({
                method: 'POST',
                url: appConfig.saveApplication,
                data: applicationRequest,
                headers: {"Content-Type": 'application/xml'}
            }).success(function (data) {

                console.log(appConfig.saveApplication);
                console.log(applicationRequest);

                if (data.response.header.statusCode == 0) {
                    $scope.model.error = true;
                } else {
                    addApplication.applicationId = data.response.detail.applicationId;
                }

                $scope.applicationList.push(addApplication);
                $scope.applicationName = "";
            }).error(function () {
                console.log("  System Exception While Fetching The Application !!! ");
            });
        }
    };



    $scope.editApplicationStatus = function(application) {
        $scope.applicationToDelete = application;
       application.toggledColor=!application.toggledColor;
        if(application.active == true){
            application.active=false;
            application.isClickable=!application.isClickable;
        }else if(application.active==false){
            application.active=true;
            application.isClickable=!application.isClickable;
        }

        application.isClickable=!application.isClickable;
        $scope.deactivateColorChange=true;

        var applicationRequest="<saveApplication><applicationId>"+application.applicationId+"</applicationId><applicationName>"+application.applicationName+"</applicationName><businessUnitId>"+application.businessUnit+"</businessUnitId><isActive>"+application.active+"</isActive></saveApplication>"

        $http({
            method: 'POST',
            url: appConfig.saveApplication,
            data:applicationRequest,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {

            if(data.response.header.statusCode==0){
                $scope.model.error=true;
            }else {
                addApplication.applicationId=data.response.detail.applicationId;
            }
        }).error(function () {
            console.log("  System Exception While Fetching The Application !!! ");
        });

    };


    $scope.editApplication=function(application){
        $scope.editApplicationDetail=application;
        $scope.editApplicationDetail.businessUnit = $scope.editApplicationDetail.businessUnit.toString();
        $scope.businessUnitList=commonDataFactory.getBusinessUnitList();
        $('#editApplication').modal('show');
        $scope.oldApplication=application.applicationName;
    }

    $scope.applicationAlreadyExistFunc=function(applicationName){
        $scope.applicationAlreadyExist=false;
        for(var i=0;i<$scope.applicationList.length;i++){
            if($scope.applicationList[i].applicationName.toLowerCase()==applicationName.toLowerCase()&&applicationName.toLowerCase()!=$scope.oldApplication.toLowerCase()){
                $scope.applicationAlreadyExist=true;
            }
        }
    }
    $scope.updateApplication=function(){
        if($scope.applicationAlreadyExist!=true) {
            var applicationRequest = "<saveApplication><applicationId>" + $scope.editApplicationDetail.applicationId + "</applicationId><applicationName>" + $scope.editApplicationDetail.applicationName + "</applicationName><businessUnitId>" + $scope.editApplicationDetail.businessUnit + "</businessUnitId><isActive>" + $scope.editApplicationDetail.active + "</isActive></saveApplication>"

            $http({
                method: 'POST',
                url: appConfig.saveApplication,
                data: applicationRequest,
                headers: {"Content-Type": 'application/xml'}
            }).success(function (data) {

                for (var i = 0; i < commonDataFactory.getBusinessUnitList().length; i++) {
                    if (commonDataFactory.getBusinessUnitList()[i].businessUnitId == $scope.editApplicationDetail.businessUnit) {

                        $scope.editApplicationDetail.businessName = commonDataFactory.getBusinessUnitList()[i].businessUnitName;
                    }
                }

                if (data.response.header.statusCode == 0) {
                    $scope.model.error = true;
                }
            }).error(function () {
                console.log("  System Exception While Fetching The Application !!! ");
            });
            console.log($scope.editApplicationDetail);
            $('#editApplication').modal('hide');
        }
    }

    $scope.save=function(applicationName){

        var applicationRequest="<saveApplication><isActive>"+$scope.globalApplicationActiveFlag+"</isActive><applicationId>"+$scope.globalApplicationId+"</applicationId><applicationName>"+applicationName+"</applicationName><isActive>true</isActive></saveApplication>"

        $http({
            method: 'POST',
            url: appConfig.saveApplication,
            data:applicationRequest,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
            if(data.response.header.statusCode==0){
                $scope.model.error=true;
            }else {
                for(var i=0;i<$scope.applicationList.length;i++){

                    if($scope.applicationList[i].applicationId==$scope.globalApplicationId) {
                        $scope.applicationList[i].applicationName=applicationName;
                    }
                }
            }
        }).error(function () {
            console.log("  System Exception While Fetching The Application !!! ");
        });
    }
    $scope.applyBusinessUnit=function() {
        $scope.selectedBusinessUnit.businessUnit = JSON.parse($scope.selectedBusinessUnit.businessUnit)
         $('#selectAccount').modal('hide');
    }

    $scope.searchBusinessUnitPopup=function() {
        $scope.selectedBusinessUnit={businessUnit:''};
        $('#selectBusinessUnit').modal('show');
    }


    $scope.back = function() {
        history.back();
    };

    $scope.navigateTo = function(path) {
        $location.url(path);
    };
});