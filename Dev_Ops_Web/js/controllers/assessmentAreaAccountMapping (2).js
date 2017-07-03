'use strict';
angular.module('genpactApp').controller('addAssessmentAreaCtrl1', function($scope, $aside, $location, $localStorage, commonServices, $rootScope, $http,appConfig) {
    // this represents the state of the dialog: a visible flag and the assessmentArea being edited
    var EditAssessmentDialogModel = function() {
        this.visible = false;
    };
    EditAssessmentDialogModel.prototype.open = function(assessmentArea,assessmentId,assessmentAreaList,originalWeightage) {
        this.originalAssesmentID=assessmentId
        console.log(assessmentId);
        this.assessmentArea = assessmentArea;
        this.activeFlag=assessmentArea.activeFlag;
        this.assessmentAreaList=assessmentAreaList;
        this.originalassessmentAreaName=assessmentArea.assessmentAreaName;
        this.originalWeightage=originalWeightage
        this.modelAssessmentAreaName=assessmentArea.assessmentAreaName;
        this.modelWeightage=assessmentArea.weightage;
        this.visible = true;
    };
    EditAssessmentDialogModel.prototype.close = function() {
        var tempWeight;
        //var totalWeight=0;
        $scope.assessmentAreaList=$scope.model.assessmentAreaList
        var assessmentId='';
        var modelWeight=parseInt($scope.model.modelWeightage);
        //var totalWeight=parseInt($scope.model.modelWeightage);
        for(var i=0;i<$scope.assessmentAreaList.length;i++){

             if($scope.assessmentAreaList[i].assessmentAreaName==$scope.model.originalassessmentAreaName){
             tempWeight=$scope.assessmentAreaList[i].weightage;
             assessmentId=$scope.assessmentAreaList[i].assessmentId;
             continue;
             }
            modelWeight=modelWeight+$scope.assessmentAreaList[i].weightage;
        }
        console.log(modelWeight);
        if(modelWeight > 100){
            $scope.model.error=true;
        }
        else {


            var assementDetail="<?xml version='1.0' encoding='UTF-8'?><saveAssessment><assessmentId>"+assessmentId+"</assessmentId><assessmentName>"+$scope.model.modelAssessmentAreaName+"</assessmentName><weightage>" + $scope.model.modelWeightage +"</weightage><isActive>"+$scope.model.activeFlag+"</isActive></saveAssessment>";
            $http({
                method: 'POST',
                url: appConfig.saveAssessmentAreas,
                data: assementDetail,
                headers: { "Content-Type": 'application/xml'}

            }).success(function(data) {
                //console.log("data"+data);
                $http.post(appConfig.getAssessmentAreas).success(function(data,status){

                    for(var i=0;i<data.response.detail.assessmentAreaList.length;i++){
                         if(data.response.detail.assessmentAreaList[i].assessmentId==$scope.model.originalAssesmentID){
                                 $scope.assessmentAreaList[i].weightage=data.response.detail.assessmentAreaList[i].weightage;
                                 $scope.assessmentAreaList[i].assessmentAreaName=data.response.detail.assessmentAreaList[i].assessmentAreaName;
                                 $scope.assessmentAreaList[i].applicationName=data.response.detail.assessmentAreaList[i].applicationName;
                                 $scope.flag=false;
                                 $scope.model.error=false;
                                 $scope.model.visible = false;
                                 break;
                         }
                     }
                }).error(function(){
                    console.log("Failed to access");
                })

            }).error(function () {
                console.log("  System Exception !!! ");
            });
            $scope.model.visible = false;
            this.visible = false;
        }


    };

    $scope.editAssessmentDialog = new EditAssessmentDialogModel();

    $scope.init = function() {
        $scope.assessmentAreaToDelete = "";
        $scope.assessmentAreaName = "";
        $scope.sortType = 'assessmentAreaName'; // set the default sort type
        $scope.sortReverse = false;
        $scope.assessmentAreaList="";
        $http.post(appConfig.getAssessmentAreas).success(function(data,status){
        	console.log('before error');
            if(typeof data=='object'){
            	console.log('within if');
                $scope.assessmentAreaList=data.response.detail.assessmentAreaList;
                console.log("initial object")
                console.log($scope.assessmentAreaList)
            }
        }).error(function(){
            console.log("Failed to access");
        })
        
        var applicationRequest = "<application><showDistinctVals>true</showDistinctVals></application>";
        $http({
            method: 'POST',
            url: appConfig.fetchApplications,
            data: applicationRequest,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
                $scope.applicationList=data.response.details.applicationDetails;
        }).error(function () {
            console.log("  System Exception While Fetching The Business Units !!! ");
        });

    }

    $scope.searchApplicationPopup = function() {
        $('#applicationModal').modal('show');
    }

    $scope.showSelectedApplication = function(data) {
        for(var i =0; i< $scope.applicationList.length; i++){
            if(data == $scope.applicationList[i].applicationId){
                $scope.selectedApplication = $scope.applicationList[i].applicationName;
                $scope.selectedApplicationId = data;
          
            }
        }
    }
    
    $scope.addAssessmentArea = function(weightcheck) {
        if(weightcheck>100){
            $('#totalWeightError').modal('show');
        }
        var addAssessmentArea = {"assessmentAreaName": $scope.assessmentAreaName,"weightage": $scope.weight,"applicationName":$scope.selectedApplication};
        var assementDetail="<?xml version='1.0' encoding='UTF-8'?><saveAssessment><assessmentId>-1</assessmentId><assessmentName>"+$scope.assessmentAreaName+"</assessmentName><applicationId>"+$scope.selectedApplicationId+"</applicationId><weightage>" + $scope.weight +"</weightage><isActive>true</isActive></saveAssessment>";
        $http({
            method: 'POST',
            url: appConfig.saveAssessmentAreas,
            data: assementDetail,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
            if(data.response.header.statusCode===0){
                $('#noDuplicate').modal('show');
            }else {
                $scope.assessmentAreaList.push(addAssessmentArea);
            }
        }).error(function () {
            console.log("  System Exception !!! ");
        });
        $scope.assessmentAreaName = "";
        $scope.weight = "";
        $scope.selectedApplication = "";
    };

    $scope.deleteAssessmentArea = function(assessmentArea,indexPassed) {
        console.log(assessmentArea)
        assessmentArea.toggledColor=!assessmentArea.toggledColor;
        if(assessmentArea.activeFlag == 1){
            assessmentArea.activeFlag=0;
            assessmentArea.isClickable=!assessmentArea.isClickable;
        }else if(assessmentArea.activeFlag==0){
            assessmentArea.activeFlag=1;
            assessmentArea.isClickable=!assessmentArea.isClickable;
        }
        console.log("checking changed value of activeFlag"+assessmentArea.activeFlag)
        assessmentArea.isClickable=!assessmentArea.isClickable;
        $scope.deactivateColorChange=true;
        var isUpdate = false;
        var assementDetail="<?xml version='1.0' encoding='UTF-8'?><saveAssessment><assessmentId>" + assessmentArea.assessmentId + "</assessmentId><assessmentName>"+assessmentArea.assessmentAreaName+"</assessmentName><weightage>" + assessmentArea.weightage +"</weightage><isActive>"+assessmentArea.activeFlag+"</isActive></saveAssessment>";
        $http({
            method: 'POST',
            url: appConfig.saveAssessmentAreas,
            data: assementDetail,
            headers: { "Content-Type": 'application/xml'}
        }).success(function (data) {
            console.log(data);
            //console.log(" --- " + data.response.detail.assessmentAreaList.length);
            isUpdate = true;

            if(data.response.header.statusCode===1){
                console.log("successfull")
            }else {
            }
        }).error(function () {
            console.log("  System Exception !!! ");
        });

        if (isUpdate){
            var assementDetail = "<?xml version='1.0' encoding='UTF-8'?><saveAssessment><assessmentId>" + assessmentArea.assessmentId + "</assessmentId><assessmentName>" + assessmentArea.assessmentAreaName + "</assessmentName><weightage>" + assessmentArea.weightage + "</weightage><isActive>"+assessmentArea.activeFlag+"</isActive></saveAssessment>";
            $http({
                method: 'POST',
                url: appConfig.saveAssessmentAreas,
                data: assementDetail,
                headers: {"Content-Type": 'application/xml'}
            }).success(function (data) {
                if (data.response.header.statusCode == 0) {
                    $('#noDuplicate').modal('show');
                } else {
                    console.log("Hello");
                    // $scope.assessmentAreaList.push(addAssessmentArea);
                }
            }).error(function () {
                console.log("  System Exception !!! ");
            });
    }
    };

    $scope.confirmDelete = function() {
        var index = $scope.assessmentAreaList.indexOf($scope.assessmentAreaToDelete);
        if (index > -1) {
            $scope.assessmentAreaList.splice(index, 1);
        }
        console.log($scope.assessmentAreaToDelete.assessmentAreaName);
    };

    $scope.back = function() {
        history.back();
    };

    $scope.navigateTo = function(path) {
        $location.url(path);
    };

    $scope.save=function(){

    }

});