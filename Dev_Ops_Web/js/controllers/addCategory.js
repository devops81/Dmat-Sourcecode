'use strict';
angular.module('genpactApp').controller('addCategoryCtrl', function($scope, $aside, $location, $localStorage, commonServices, $rootScope, $http,$timeout,appConfig) {

    // this represents the state of the dialog: a visible flag and the category being edited

    var EditCategoryDialogModel = function() {

        this.visible = false;
    }
    EditCategoryDialogModel.prototype.open = function(category,list,questionnaireType) {
        this.category = category;
        this.modelCategoryName=category.categoryName
        this.modelWeightage=category.weightage
        this.modelAssessmentAreaName=category.assessmentAreaName
        this.modelAssessmentID=category.assessmentId.toString();
        this.modelCategoryID=category.categoryId;
        this.modelAssessmentAreaList = $scope.assessmentAreas;
        this.questionnaireType = questionnaireType;
        this.list= list;
        this.visible = true;

        var tempList= [ ];
        $http.post(appConfig.getAssessmentAreas).success(function(data,status){
            $scope.tempList=data.response.detail.assessmentAreaList;
            for(var i=0;i<data.response.detail.assessmentAreaList.length;i++) {
                    var addAssessmentArea = {
                        "active": data.response.detail.assessmentAreaList[i].active,
                        "assessmentAreaName": data.response.detail.assessmentAreaList[i].assessmentAreaName,
                        "assessmentId": data.response.detail.assessmentAreaList[i].assessmentId,
                        "categoryId": data.response.detail.assessmentAreaList[i].categoryId,
                        "categoryName": data.response.detail.assessmentAreaList[i].categoryName,
                        "weightage": data.response.detail.assessmentAreaList[i].weightage
                    }
                    tempList.push(addAssessmentArea);
                }
            angular.forEach($scope.tempList,function(list,index) {
	        	if (list.assessmentId == -1) {
	        	  $scope.tempList.splice (index,1);
	          }
	        });
        }).error(function(){
            console.log("Failed to access");
        })
        this.modelAssessmentAreaList=tempList;
    };
    EditCategoryDialogModel.prototype.close = function() {

        var totalweight=parseInt($scope.model.modelWeightage);
        for(var i=0;i<$scope.model.list.length;i++){
            if(($scope.model.list[i].categoryName==$scope.model.originalCategoryName)&&($scope.model.list[i].assessmentAreaName==$scope.model.originalAssessmentAreaName)){
              console.log("$scope.model.list[i].categoryName"+$scope.model.list[i].categoryName)
                continue;
            }
            totalweight=totalweight+parseInt($scope.model.list[i].weightage);
            console.log("checking weight"+totalweight)
        }

        if(totalweight>100){
            $scope.model.error=true;
        }
        else {

            var detailRequest="<?xml version='1.0' encoding='UTF-8'?><saveupdateRequest><categoryId>"+$scope.model.modelCategoryID+"</categoryId><categoryName>"+$scope.model.modelCategoryName+ "</categoryName><assessmentId>"+$scope.model.modelAssessmentID+"</assessmentId><weightage>"+$scope.model.modelWeightage+"</weightage><isActive>1</isActive>" +
            		" <questionnaireType>"+$scope.model.questionnaireType+"</questionnaireType></saveupdateRequest>";
            
            console.log(detailRequest);
            $http({
                method: 'POST',
                url: appConfig.saveUpdateCategories,
                data: detailRequest,
                headers: { "Content-Type": 'application/xml'}

            }).success(function(data) {
                if(data.response.header.statusCode===0){
                    $('#noDuplicate').modal('show');
                    console.log("Category Was not Added Successfully");
                }else {

                    for(var i=0;i<$scope.model.list.length;i++){

                        if ($scope.model.list[i].categoryId == $scope.model.modelCategoryID){
                            $scope.model.list[i].assessmentId=$scope.model.modelAssessmentID
                            $scope.model.list[i].categoryName=$scope.model.modelCategoryName
                            $scope.model.list[i].weightage=$scope.model.modelWeightage
                            for(var j=0;j<$scope.model.modelAssessmentAreaList.length;j++){
                                console.log($scope.model.modelAssessmentAreaList)
                                if($scope.model.modelAssessmentID==$scope.model.modelAssessmentAreaList[j].assessmentId){

                                    $scope.model.list[i].assessmentAreaName=$scope.model.modelAssessmentAreaList[j].assessmentAreaName;
                                    console.log("$scope.model.list[i].assessmentAreaName"+$scope.model.list[i].assessmentAreaName)
                                    i=$scope.model.list.length;
                                    j=$scope.model.modelAssessmentAreaList.length;

                                }

                            }

                            //$scope.model.list[i].assessmentAreaName=tempAssessmentAreaName;

                        }
                    }
                }
            }).error(function () {
                console.log("  System Exception !!! ");
            });

            $scope.flag=false;
            $scope.model.error=false;
            $scope.model.visible = false;
        }
    };


    $scope.editCategoryDialog = new EditCategoryDialogModel();

    $scope.init = function(questionnaireType) {
    	
    	console.log(questionnaireType);
        $scope.areaSelected = false;
        $scope.categoryToDelete = "";
        $scope.categoryName = "";
        $scope.weight = "";
        $scope.sortType = 'categoryName'; // set the default sort type
        $scope.sortReverse = false;

        $http({
            method: 'POST',
            url: appConfig.getCategories+questionnaireType,
            data:'',
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
            if(data.response.header.statusCode===0){
                $scope.model.error=true;
            }else {
                $scope.categoryList=data.response.detail.categoryDetails;
                angular.forEach($scope.categoryList,function(list,index) {
    	        	if (list.categoryId == -1) {
    	        	  $scope.categoryList.splice (index,1);
    	          }
    	        });

            }
        }).error(function () {
            console.log("  System Exception While Fetching The Categories !!! ");
        });

        /*$scope.categoryList = [{
                "categoryName": "Business Crticality",
                "assessmentAreaName":"Business Needs"
                ,"subCategory":""
                ,"weightage": "20"
            }, {
                "categoryName": "Monitor",
                "assessmentAreaName": "Delivery Maturity"
               ,"subCategory":"Exists",
                 "weightage": "12"
            }
        ]*/

        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
        });

    }

    $scope.selectAssessmentPopup = function() {

        $('#assessmentAreasModal').modal('show');

        $scope.areaSelected = true;
        $http.post(appConfig.getAssessmentAreas).success(function(data,status){

            if(typeof data=='object'){
                $scope.assessmentAreas=data.response.detail.assessmentAreaList;
                console.log($scope.assessmentAreas);
                angular.forEach($scope.assessmentAreas,function(list,index) {
    	        	if (list.assessmentId == -1) {
    	        	  $scope.assessmentAreas.splice (index,1);
    	          }
    	        });
            }
        }).error(function(){
            console.log("Failed to access");
        })
    }

    $scope.currentareaname = '';

    $scope.showSelectedAssessmentAreas = function(data) {

            $scope.assementDetail = [{ "name": "","ID":"0" }];
            for(var i =0; i< $scope.assessmentAreas.length; i++){

                if(data == $scope.assessmentAreas[i].assessmentId){
                    $scope.assementDetail.name= $scope.assessmentAreas[i].assessmentAreaName;
                    $scope.assementDetail.ID=data;
                    i=$scope.assessmentAreas.length;
                }
            }
        $scope.assessmentAreaSelected = $scope.assementDetail.name;
    }

    $scope.addCategory = function(questionnaireType) {

        var weightage = 0;
        var addCategory = { "categoryName": $scope.categoryName,"assessmentAreaName":  $scope.assementDetail.name,"assessmentAreaid" :   $scope.assementDetail.ID,"weightage": $scope.weight };

        weightage = weightage + parseInt($scope.weight);
        console.log("this is the weight"+$scope.weight)

        if ($scope.categoryName ==='' || $scope.assessmentAreaSelected === '' || $scope.weight ==='' ) {
            $('#errorModalAddCategory').modal('show');
        }
        if (weightage >100) {
              $('#errorModal').modal('show');
        }
        else {

            var assementDetailRequest="<?xml version='1.0' encoding='UTF-8'?><saveupdateRequest><categoryId>-1</categoryId><categoryName>"+$scope.categoryName+ "</categoryName><assessmentId>"+$scope.assementDetail.ID+"</assessmentId><weightage>"+$scope.weight+"</weightage><isActive>1</isActive><questionnaireType>"+questionnaireType+"</questionnaireType></saveupdateRequest>";

            $http({
                method: 'POST',
                url: appConfig.saveUpdateCategories,
                data: assementDetailRequest,
                headers: { "Content-Type": 'application/xml'}

            }).success(function(data) {
                //console.log(data.response.detail); console.log(data.response.detail.statusMsg);console.log(data.response.header.statusCode);
                if(data.response.header.statusCode===0){
                    $('#noDuplicate').modal('show');
                    console.log("Category Was not Added Successfully");
                }else {
                        // To Fetch the Fresh List of Categories
                        $http({
                            method: 'POST',
                            url: appConfig.getCategories+questionnaireType,
                            data: '',
                            headers: { "Content-Type": 'application/xml'}

                        }).success(function(data) {
                            console.log(data);
                            console.log(data.response);
                            if(data.response.header.statusCode===0){
                                $scope.model.error=true;
                                //$('#noDuplicate').modal('show');
                            }else {
                                $scope.categoryList=data.response.detail.categoryDetails;
                                angular.forEach($scope.categoryList,function(list,index) {
                    	        	if (list.categoryId == -1) {
                    	        	  $scope.categoryList.splice (index,1);
                    	          }
                    	        });
                            }
                        }).error(function () {
                            console.log("  System Exception !!! ");
                        });

                }
            }).error(function () {
                console.log("  System Exception !!! ");
            });

            $scope.weight = "";
            $scope.assessmentAreaSelected = "";
            $scope.categoryName = "";

        }


    };

    $scope.deleteCategory = function(category,questionnaireType) {
        console.log("checking the category for active flags")
        console.log(category.active)
        //category.toggledColor=!category.toggledColor;
        if(category.active == true){
            category.active=false;
            category.isClickable=!category.isClickable;
        }else if(category.active==false){
            category.active=true;
            category.isClickable=!category.isClickable;
        }
        console.log("checking changed value of activeFlag"+category.active)
        category.isClickable=!category.isClickable;
        $scope.deactivateColorChange=true;
       var assementDetailRequest="<?xml version='1.0' encoding='UTF-8'?><saveupdateRequest><categoryId>"+category.categoryId+"</categoryId><categoryName>"+category.categoryName+ "</categoryName><assessmentId>"+category.assessmentId+"</assessmentId><weightage>"+category.weightage+"</weightage><isActive>"+category.active+"</isActive><questionnaireType>"+questionnaireType+"</questionnaireType></saveupdateRequest>";

        $http({
            method: 'POST',
            url: appConfig.saveUpdateCategories,
            data: assementDetailRequest,
            headers: { "Content-Type": 'application/xml'}

        }).success(function(data) {
           console.log("response data")
            console.log(data)
        })
            .error(function () {
            console.log("  System Exception !!! ");
        });
    

    };

    $scope.confirmDelete = function() {

        var index = $scope.categoryList.indexOf($scope.categoryToDelete);
        if (index > -1) {
            $scope.categoryList.splice(index, 1);
        }
        console.log($scope.categoryToDelete.categoryName);
    };

    $scope.back = function() {
        history.back();
    };

    $scope.navigateTo = function(path) {
        $location.url(path);
    };














});