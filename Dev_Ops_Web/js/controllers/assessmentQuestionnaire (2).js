'use strict';
angular.module('genpactApp').controller('assessmentQuestionnaireCtrl', function($scope, $aside, $location, $localStorage, $rootScope, $http,appConfig) {

    $scope.init = function(questionnaireTypeId) {
    	
    	console.log($scope);
        console.log($scope);
    	// For Fetching the Assessment Area
        $http.post(appConfig.getAssessmentAreas).success(function(data,status){
            if(typeof data=='object'){
                $scope.tempAssessmentAreaList=data.response.detail.assessmentAreaList;
                angular.forEach($scope.tempAssessmentAreaList,function(list,index) {
    	        	if (list.assessmentId == -1) {
    	        	  $scope.tempAssessmentAreaList.splice (index,1);
    	          }
    	        });
            }
        }).error(function(){
            console.log("  System Exception While Fetching the Assessment Area !!! ");
        })

        // For Fetching the Categories

        $http({
            method: 'POST',
            url: appConfig.getCategories+questionnaireTypeId,
            data: '',
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
        		$scope.tempCategoryList=data.response.detail.categoryDetails;
        		 angular.forEach($scope.tempCategoryList,function(list,index) {
     	        	if (list.categoryId == -1) {
     	        	  $scope.tempCategoryList.splice (index,1);
     	          }

     	        });
        }).error(function () {
            console.log("  System Exception While Fetching The Categories !!! ");
        });
        // For Fetching the Sub Categories
        $http({
            method: 'POST',
            url: appConfig.getSubCategories+questionnaireTypeId,
            data: '',
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
                $scope.tempSubCategoryList=data.response.detail.subCategoryDetails;
                angular.forEach($scope.tempSubCategoryList,function(list,index) {
     	        	if (list.subcategoryId == -1) {
     	        	  $scope.tempSubCategoryList.splice (index,1);
     	          }
     	        });
        }).error(function () {
            console.log("  System Exception While Fetching The Sub Categories !!! ");
        });

        /*$scope.assessmentAreaList = [{ "assessmentAreaName": "Initiation" },{"assessmentAreaName": "Estimation"}]*/
        /*$scope.categoryList = [{"categoryName": "Business Needs"}, {"categoryName": "Business and Environment Complexity"}, {         "categoryName": "Delivery Maturity"
        }]*/
        /*$scope.subCategoryList = [{  "subCategoryName": "Business Crticality"}, {"subCategoryName": "Technical Dependence"}]*/


        $scope.questionType = '';
        $scope.selectedAssessmentArea = '';
        $scope.selectedCategory = '';
        $scope.selectedSubCategory = '';

        // Creating a Temp Scope Variable to hold all the values of Question
        $scope.questionDetail = { "assessmentAreaName": "","assessmentAreaID":"" ,categoryName:"", categoryID:"",subCategoryName:"",subCategoryID:"",applicationID:"",applicationName:"",businessUnitID:"",businessUnitName:"" };

        $scope.ser1 = '';
        $scope.ser2 = '';
        $scope.ser3 = '';
        $scope.ser4 = '';
        $scope.ser5 = '';

        $scope.val1= '';
        $scope.val2 = '';
        $scope.val3 = '';
        $scope.val4 = '';
        $scope.val5 = '';

        $scope.chk1 = false;
        $scope.chk2 = false;
        $scope.chk3 = false;
        $scope.chk4 = false;
        $scope.chk5 = false;

        $scope.check1 = false;
        $scope.check2 = false;
        $scope.check3 = false;
        $scope.check4 = false;
        $scope.check5 = false;

        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
        });
    }

    $scope.steps = ['Add Question','Add Assessment Area','Add Category','Add Sub Category','Review'];

    $scope.selection = $scope.steps[0];

   
    
    $scope.searchAssessmentPopup = function() {
        $scope.searchAssessment = '';
    	
    	var tempObject = [];
    	for (var i=0; i< $scope.tempAssessmentAreaList.length; i++) {
    		if ($scope.questionDetail.applicationID == $scope.tempAssessmentAreaList[i].applicationId) {
    			tempObject.push ($scope.tempAssessmentAreaList[i]); 
    		}
    	}
    	
    	$scope.assessmentAreaList=tempObject;
        $('#assessmentAreaModal').modal('show');
    }

    
    
    $scope.showSelectedAssessmentArea = function(data) {
        for(var i =0; i< $scope.assessmentAreaList.length; i++){
            if(data == $scope.assessmentAreaList[i].assessmentId){
                $scope.selectedAssessmentArea = $scope.assessmentAreaList[i].assessmentAreaName;
                $scope.questionDetail.assessmentAreaName=$scope.assessmentAreaList[i].assessmentAreaName;
                $scope.questionDetail.assessmentAreaID=$scope.assessmentAreaList[i].assessmentId
            }
        }
    }

    $scope.searchCategoryPopup = function() {
        $scope.searchCategory = '';
    	var tempObject = [];
    	for (var i=0; i< $scope.tempCategoryList.length; i++) {
    		if ($scope.questionDetail.assessmentAreaID == $scope.tempCategoryList[i].assessmentId) {
    			tempObject.push ($scope.tempCategoryList[i]); 
    		}
    	}
    	$scope.categoryList=tempObject;
    	$('#categoryModal').modal('show');
    }

    $scope.showSelectedCategory = function(data) {
        for(var i =0; i< $scope.categoryList.length; i++){
            if(data == $scope.categoryList[i].categoryId){
                $scope.selectedCategory = $scope.categoryList[i].categoryName;
                $scope.questionDetail.categoryName=$scope.categoryList[i].categoryName;
                $scope.questionDetail.categoryID=$scope.categoryList[i].categoryId;
            }
        }
    }

    $scope.searchSubCategoryPopup = function() {
        $scope.searchsubCategory = '';
    	console.log($scope.tempSubCategoryList);
    	var tempObject = [];
    	for (var i=0; i< $scope.tempSubCategoryList.length; i++) {
    		if ($scope.questionDetail.categoryID == $scope.tempSubCategoryList[i].categoryId) {
    			tempObject.push ($scope.tempSubCategoryList[i]); 
    			console.log(tempObject);
    		}
    	}
    	$scope.subCategoryList=tempObject;
        $('#subCategoryModal').modal('show');
    }

    $scope.showSelectedSubCategory = function(data) {
        //$scope.selectedSubCategory = data;
        for(var i =0; i< $scope.subCategoryList.length; i++){
            if(data == $scope.subCategoryList[i].subcategoryId){
                $scope.selectedSubCategory = $scope.subCategoryList[i].subCategoryName;
                $scope.questionDetail.subCategoryName=$scope.subCategoryList[i].subCategoryName;
                $scope.questionDetail.subCategoryID=$scope.subCategoryList[i].subcategoryId;
            }
        }
    }


    $scope.getCurrentStepIndex = function() {
        // Get the index of the current step given selection
        return _.indexOf($scope.steps, $scope.selection);
    };


    // Go to a defined step index
    $scope.goToStep = function(index) {

        if (!_.isUndefined($scope.steps[index])) {
            $scope.selection = $scope.steps[index];
        }
    };

    $scope.hasNextStep = function() {
        var stepIndex = $scope.getCurrentStepIndex();
        var nextStep = stepIndex + 1;
        // Return true if there is a next step, false if not
        return !_.isUndefined($scope.steps[nextStep]);
    };

    $scope.hasPreviousStep = function() {
        var stepIndex = $scope.getCurrentStepIndex();
        var previousStep = stepIndex - 1;
        // Return true if there is a next step, false if not
        return !_.isUndefined($scope.steps[previousStep]);
    };

    $scope.incrementStep = function() {

        if ($scope.hasNextStep()) {
            var stepIndex = $scope.getCurrentStepIndex();
            var nextStep = stepIndex + 1;
            var prevStep = stepIndex - 1;
            $scope.selection = $scope.steps[nextStep];

            $("#"+stepIndex+"").addClass("complete");
            $("#"+stepIndex+"").removeClass("disabled");
            $("#"+stepIndex+"").addClass("active");
            $("#"+nextStep+"").removeClass("disabled");

        }
    };
    $scope.decrementStep = function() {
        if ($scope.hasPreviousStep()) {
            var stepIndex = $scope.getCurrentStepIndex();
            var previousStep = stepIndex - 1;
            $scope.selection = $scope.steps[previousStep];

            $("#"+previousStep+"").addClass("active");
            $("#"+previousStep+"").removeClass("complete");
            $("#"+stepIndex+"").addClass("disabled");
            $("#"+stepIndex+"").removeClass("active");
        }
    };
    $scope.submitQuestion = function(questionnaireType) {

    	var questionRequest="<?xml version='1.0' encoding='UTF-8'?><saveUpdateQuestion><questionnaireType>"+questionnaireType+"</questionnaireType>" +
    			"<assessmentId>"+$scope.questionDetail.assessmentAreaID+"</assessmentId><categoryId>"+$scope.questionDetail.categoryID+"</categoryId>" +
    			"<subCategoryId>"+$scope.questionDetail.subCategoryID+"</subCategoryId><questionId>-1</questionId>" +
    			"<questionText>"+$scope.questionType+"</questionText><optionOne>"+$scope.val1+"</optionOne><optionTwo>"+$scope.val2+"</optionTwo>" +
    			"<optionThree>"+$scope.val3+"</optionThree><optionFour>"+$scope.val4+"</optionFour><optionFive>"+$scope.val5+"</optionFive>" +
    			"<isActive>true</isActive>" +
    			"</saveUpdateQuestion>";
       console.log(questionRequest);
    	$http({
            method: 'POST',
            url: appConfig.saveQuestionnaire,
            data: questionRequest,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
            console.log($scope.questionDetail);
            console.log("Data Updated Successfully");
            $scope.questionSaveSuccess = true;
        }).error(function () {
            console.log("  System Exception While Submitting the Question !!! ");
        });

    };

    $scope.back = function() {
        history.back();
    };

    $scope.navigateTo = function(path) {
        $location.url(path);
    };

});