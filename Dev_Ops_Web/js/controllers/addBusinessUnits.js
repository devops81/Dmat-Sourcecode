'use strict';
angular.module('genpactApp').controller('addBusinessUnitCtrl', function($scope,$http,commonDataFactory,appConfig) {
	
    $scope.init = function() {

     // For Fetching the Business Units
        var businessUnitRequest="<businessUnit><isViewOnly>true</isViewOnly><showDistinctBusinessUnits>false</showDistinctBusinessUnits><businessUnitId></businessUnitId><businessUnitName></businessUnitName><accountId></accountId><isActive></isActive></businessUnit>"
        
        $http({
            method: 'POST',
            url: appConfig.manageBusinessUnits,
            data: businessUnitRequest,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
                $scope.businessUnitList=data.response.detail.businessUnitDetails;
                angular.forEach($scope.businessUnitList,function(list,index) {
    	        	if (list.businessUnitId == -1) {
    	        	  $scope.businessUnitList.splice (index,1);
    	          }
    	        });
            console.log($scope.businessUnitList);
        }).error(function () {
            console.log("  System Exception While Fetching The Business Units !!! ");
        });

        //For displaying the accounts
        var accountRequest = "<account><isViewOnly>true</isViewOnly><saveOrUpdate></saveOrUpdate><accountId></accountId><accountName></accountName><isActive></isActive></account>";
        $http({
            method: 'POST',
            url: appConfig.handleAccounts,
            data:accountRequest,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
            if(data.response.header.statusCode==0){
                $scope.model.error=true;
            }else {

                $scope.accountList=data.response.details.accountDetails;

                angular.forEach($scope.accountList,function(list,index) {
                    if (list.accountId == -1) {
                        $scope.accountList.splice (index,1);
                    }
                });
                // Setting the Account Data in the Common Data Factory
                commonDataFactory.setAccountList($scope.accountList);
            }
        }).error(function () {
            console.log("  System Exception While Fetching The Accounts !!! ");
        });
    }

    $scope.addBusinessUnit = function() {
        console.log( $scope.selectedAccountId);
        var addBusinessUnit = { "businessUnitName": $scope.businessUnitName,"businessUnitId":"","accountName": $scope.selectedAccount.accountName};
        var businessUnitRequest="<businessUnit><isViewOnly>false</isViewOnly><showDistinctBusinessUnits>false</showDistinctBusinessUnits>" +
        		" <businessUnitId>-1</businessUnitId><businessUnitName>"+$scope.businessUnitName+"</businessUnitName>" +
        				"<accountId>"+$scope.selectedAccount.accountId+"</accountId><isActive>true</isActive></businessUnit>";

        $http({method: 'POST',url: appConfig.manageBusinessUnits,data:businessUnitRequest,headers: { "Content-Type": 'application/xml'}}).success(function(data) {

            if(data.response.header.statusCode==0){
                $scope.model.error=true;
            }else {
            	addBusinessUnit.businessUnitId=data.response.detail.businessUnitId;
            }
            $scope.businessUnitList.push(addBusinessUnit);
            $scope.businessUnitName = "";
            $scope.accountName = "";

        }).error(function () {
            console.log("  System Exception While Saving The Business Unit !!! ");
        });

    
    };

    $scope.updateBusinessUnitStatus = function(businessUnit) {
    	
       if(businessUnit.active == true){
        	businessUnit.active=false;
        	businessUnit.isClickable=!businessUnit.isClickable;
        }else if(businessUnit.active==false){
        	businessUnit.active=true;
        	businessUnit.isClickable=!businessUnit.isClickable;
        }

        businessUnit.isClickable=!businessUnit.isClickable;
        $scope.deactivateColorChange=true;
        var businessUnitRequest="<businessUnit><isViewOnly>false</isViewOnly>" +
        "<businessUnitId>"+businessUnit.businessUnitId+"</businessUnitId>" +
        "<businessUnitName>"+businessUnit.businessUnitName+"</businessUnitName>" +
        "<accountId>"+businessUnit.accountId+"</accountId><isActive>"+businessUnit.active+"</isActive>" +
        "</businessUnit>"


        $http({
            method: 'POST',
            url: appConfig.manageBusinessUnits,
            data:businessUnitRequest,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
          // No Handling is needed to sync the active \ in active state
        }).error(function () {
            console.log("  System Exception While Fetching The Application !!! ");
        });

    }
    $scope.openBusinessUnitModel=function(businessUnit){

        $scope.editBusinessUnit = businessUnit;
        $scope.editBusinessUnit.accountId = $scope.editBusinessUnit.accountId.toString();
        $scope.accountList=commonDataFactory.getAccountList();
        $('#editBusinessUnit').modal('show');
    }
    $scope.saveBusinessUnitModel=function(){
        console.log($scope.editBusinessUnit.businessUnitId);
        var businessUnitRequest='<businessUnit><isViewOnly>false</isViewOnly><businessUnitId>'+$scope.editBusinessUnit.businessUnitId+'</businessUnitId><businessUnitName>'+$scope.editBusinessUnit.businessUnitName+'</businessUnitName><accountId>'+$scope.editBusinessUnit.accountId+'</accountId><isActive>'+$scope.editBusinessUnit.active+'</isActive></businessUnit>';
        $http({
            method: 'POST',
            url: appConfig.manageBusinessUnits,
            data:businessUnitRequest,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
            for(var i=0;i<commonDataFactory.getAccountList().length;i++){
                if( $scope.editBusinessUnit.accountId == commonDataFactory.getAccountList()[i].accountId){
                    $scope.editBusinessUnit.accountName = commonDataFactory.getAccountList()[i].account;
                }
            }
            // It is automatically handling the update
            if(data.response.header.statusCode==0){
                $scope.model.error=true;
            }
        }).error(function () {
            console.log("  System Exception While Fetching The Application !!! ");
        });
        $('#editBusinessUnit').modal('hide');
    }

    $scope.applySelectedAccount=function() {
        $scope.selectedAccount= JSON.parse($scope.userSelectedAccount.account);
        $('#selectAccount').modal('hide');
    }

    $scope.searchAccountPopup=function() {
        $scope.userSelectedAccount={account:''};
        $('#selectAccount').modal('show');
    }


    $scope.back = function() {
        history.back();
    };

    $scope.navigateTo = function(path) {
        $location.url(path);
    };



});
