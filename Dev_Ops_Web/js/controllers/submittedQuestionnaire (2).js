'use strict';
angular.module('genpactApp').controller('submittedQuestionnaire', function($scope,fileUploadService,$http,appConfig,commonDataFactory) {

  $scope.init = function(){


        $scope.gridOptions = {};
        $scope.showProgressBar=false;
        $(document).ready(function(){
            $('[data-toggle="popover"]').popover();
        });

        $scope.assessmentQuestionnaireList = [];
        $scope.assessmentAreaList = [];
        $scope.noneSelect=0;
       
        $scope.sort=function(keyname){
            $scope.sortKey=keyname;
            $scope.reverse=!$scope.reverse;
        }

        $scope.currentPage=1;
        $scope.resetPage=function(){
           $scope.currentPage="1"
        }
        
        $scope.questionType = '';
        $scope.selectApplicationView = true;
        $scope.responseDataList = [];
    }

    $scope.uploadData = function () {

        console.log( $scope.gridOptions);
    }
    $scope.clickUpload = function() {
        var oldValue = $scope.gridOptions;
        angular.element('#upload').trigger('click');
        $scope.$watch(
            function handleFooChange( oldValue ) {
                var newValue = $scope.gridOptions;
                if(newValue !=oldValue) {
                    console.log(" Grid Count just got changed", newValue);
                    $scope.uploadData();
                }
            }
        );

    }


    $scope.searchApplicationPopup =function(){
    	$('#applicationModal').modal('show');

        $scope.areaSelected = true;
        var applicationRequest = "<application><showDistinctVals>true</showDistinctVals></application>";
        $http({
            method: 'POST',
            url: appConfig.fetchApplications,
            data: applicationRequest,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data,status){

            if(typeof data=='object'){
                $scope.applicationList=data.response.details.applicationDetails;
                angular.forEach($scope.applicationList,function(list,index) {
    	        	if (list.applicationId == -1) {
    	        	  $scope.applicationList.splice (index,1);
    	          }
    	        });
            }
        }).error(function(){
            console.log("Failed to access");
        })
    }




    $scope.showSelectedApplication = function(data,appList){

    	for(var i=0;i<appList.length;i++) {
    		

    		if (data == appList[i].applicationId) {
    			

    			 $scope.selectedApplication = appList[i].applicationName;
    		}
    	}
       
       
    }

    $scope.selectApplication = function(){
        $scope.selectApplicationView = true;
        $scope.showProgressBar=false;
    }

    $scope.startAssessment = function(selectedApplication,questionnaireType){

    	$scope.rate = "";
        var viewQuestionDetails = "<?xml version='1.0' encoding='UTF-8'?><viewQuestionDetails><applicationId>"+selectedApplication+"</applicationId><questionnaireType>"+questionnaireType+"</questionnaireType></viewQuestionDetails>";
        console.log("Start Assessment");
       $http({
       	method: 'POST',
           url: appConfig.viewQuestionResponse,
           data: viewQuestionDetails,
           headers: { "Content-Type": 'application/xml'}
       }).success(function(data) {
    	// Changes for Filtering the Assessment
           //console.log("data.response.detail.questionResponseDetails");
           //console.log(data.response.detail.questionResponseDetails);

           console.log(window.localStorage.accessLevel);

           var strProfileAccess       = window.localStorage.accessLevel;
           var businessNeedActive     = parseInt(strProfileAccess.split(":")[1]);
           var businessEnvNeedActive  = parseInt(strProfileAccess.split(":")[2]);
           var deliveryMaturityActive = parseInt(strProfileAccess.split(":")[3]);
           var filterQuestionList = [];

           for(var i=0;i<data.response.detail.questionResponseDetails.length;i++){

               if(parseInt(data.response.detail.questionResponseDetails[i].assessmentId) == 1 && parseInt(businessNeedActive)==1 ) {
                   filterQuestionList.push(data.response.detail.questionResponseDetails[i]);
               }
               if(parseInt(data.response.detail.questionResponseDetails[i].assessmentId) == 2 && parseInt(businessEnvNeedActive)==1) {
                   filterQuestionList.push(data.response.detail.questionResponseDetails[i]);
               }
               if(parseInt(data.response.detail.questionResponseDetails[i].assessmentId) == 3 && parseInt(deliveryMaturityActive)==1) {
                   filterQuestionList.push(data.response.detail.questionResponseDetails[i]);
               }
           }
           console.log(commonDataFactory.getLoggedInUserProfile().roleName);


            console.log(filterQuestionList.length);
           console.log(data.response.detail.questionResponseDetails);
           if(commonDataFactory.getLoggedInUserProfile().roleName == 'Lead Assessor'){
               console.log("Inside Lead Assessor");
               filterQuestionList = data.response.detail.questionResponseDetails

           }
           // The below single line is commented and above lines are used to filter
           //$scope.tempList = data.response.detail.questionResponseDetails;
         $scope.tempList = filterQuestionList;
         $scope.responseDataList = data.response.detail.questionResponseDetails;
       	 $scope.assessmentQuestionnaireList = $scope.tempList;
       	 
       	/* angular.forEach($scope.assessmentQuestionnaireList,function(list,index) {
	        	if (list.questionId == -1) {
	        	  $scope.assessmentQuestionnaireList.splice (index,1);
	          }
	        });*/
           // Populating the assessmentAreaList with Unique Assessment Areas
           for (var i = 0; i < $scope.assessmentQuestionnaireList.length; i++) {
               var Flag = true;
               for (var j = 0; j < $scope.assessmentAreaList.length; j++) {
               	if ($scope.assessmentAreaList[j].assessmentAreaName == $scope.assessmentQuestionnaireList[i].assessmentArea) {
               		Flag = false;
               		break;
               	}
               }
               if (Flag) {
               	$scope.assessmentAreaList[$scope.assessmentAreaList.length] = {
               			"assessmentAreaName": $scope.assessmentQuestionnaireList[i].assessmentArea
               	};
               }
             }

           for (var i = 0; i < $scope.assessmentQuestionnaireList.length; i++) {
               var optionOneVal = "1 - "+ $scope.assessmentQuestionnaireList[i].optionOneVal;
               var optionTwoVal = "2 - "+$scope.assessmentQuestionnaireList[i].optionTwoVal;
               var optionThreeVal = "3 - "+$scope.assessmentQuestionnaireList[i].optionThreeVal;
               var optionFourVal = "4 - "+$scope.assessmentQuestionnaireList[i].optionFourVal;
               var optionFiveVal = "5 - "+$scope.assessmentQuestionnaireList[i].optionFiveVal;
               var guidelines = optionOneVal + ',' + optionTwoVal + ',' + optionThreeVal + ',' + optionFourVal + ',' + optionFiveVal;
               var splitGuidelines = guidelines.split(',');
               $scope.assessmentQuestionnaireList[i].GuidelineLength = splitGuidelines.length;
               $scope.assessmentQuestionnaireList[i].GuidelineArray = [];
               for (var j=0; j < splitGuidelines.length ;j++){
               $scope.assessmentQuestionnaireList[i].GuidelineArray.push(splitGuidelines[j]);
               }
               }

           // FOR DISABLING RADIO BUTTONS
           for (var i = 0; i < $scope.assessmentQuestionnaireList.length; i++) {
               var numberArray = [];

               for (var j = 0; j < $scope.assessmentQuestionnaireList[i].GuidelineArray.length; j++) {
               var splitScore = $scope.assessmentQuestionnaireList[i].GuidelineArray[j].split('-');
               numberArray.push(splitScore[0].trim());
               }
               $scope.assessmentQuestionnaireList[i].disable1 = false;
               $scope.assessmentQuestionnaireList[i].disable2 = false;
               $scope.assessmentQuestionnaireList[i].disable3 = false;
               $scope.assessmentQuestionnaireList[i].disable4 = false;
               $scope.assessmentQuestionnaireList[i].disable5 = false;

               if(numberArray.indexOf("1") == -1){
               $scope.assessmentQuestionnaireList[i].disable1 = true;
               }
               if(numberArray.indexOf("2") == -1){
               $scope.assessmentQuestionnaireList[i].disable2 = true;
               }
               if(numberArray.indexOf("3") == -1){
               $scope.assessmentQuestionnaireList[i].disable3 = true;
               }
               if(numberArray.indexOf("4") == -1){
               $scope.assessmentQuestionnaireList[i].disable4 = true;
               }
               if(numberArray.indexOf("5") == -1){
               $scope.assessmentQuestionnaireList[i].disable5 = true;
               }
               }

           $scope.selectApplicationView = false;

           $scope.steps = [];

           for (var i = 0; i < $scope.assessmentAreaList.length; i++) {
           	$scope.steps[i] = $scope.assessmentAreaList[i].assessmentAreaName;
           }
          
           $scope.selection = $scope.steps[0];

       });
   }

    $scope.arrayToBePassed=[];
    $scope.modeltest={};
    $scope.rateMe=function(assessment,value){

        //$scope.assessment.AssessmentCriteria=5;
        $scope.modeltest[assessment.assessmentCriteria+value]=value;
        if(value=="1"){
            var flag=false;
            $scope.modeltest[assessment.assessmentCriteria+"2"]="";
            $scope.modeltest[assessment.assessmentCriteria+"3"]="";
            $scope.modeltest[assessment.assessmentCriteria+"4"]="";
            $scope.modeltest[assessment.assessmentCriteria+"5"]="";
            if($scope.arrayToBePassed.length==0){
                assessment.Rating=1;
                $scope.arrayToBePassed.push(assessment);
            }
            else {
                for(var i=0;i<$scope.arrayToBePassed.length;i++){
                    if($scope.arrayToBePassed[i].assessmentCriteria==assessment.assessmentCriteria){
                        flag=true;
                    }

                }
                if(flag==false){
                    assessment.Rating=1;
                    $scope.arrayToBePassed.push(assessment);
                }
            }

        }
        else if(value=="2"){
            var flag=false;
            $scope.modeltest[assessment.assessmentCriteria+"3"]="";
            $scope.modeltest[assessment.assessmentCriteria+"4"]="";
            $scope.modeltest[assessment.assessmentCriteria+"5"]="";
            $scope.modeltest[assessment.assessmentCriteria+"1"]="";

            if($scope.arrayToBePassed.length==0){
                assessment.Rating=2;
                $scope.arrayToBePassed.push(assessment);
            }
            else {
                for(var i=0;i<$scope.arrayToBePassed.length;i++){
                    if($scope.arrayToBePassed[i].assessmentCriteria==assessment.assessmentCriteria){
                        flag=true;
                    }

                }
                if(flag==false){
                    assessment.Rating=2;
                    $scope.arrayToBePassed.push(assessment);
                }
            }

            /* assessment.Rating=2;
             $scope.arrayToBePassed.push(assessment);*/
        }
        else if(value=="3"){
            var flag=false;
            $scope.modeltest[assessment.assessmentCriteria+"2"]="";
            $scope.modeltest[assessment.assessmentCriteria+"4"]="";
            $scope.modeltest[assessment.assessmentCriteria+"5"]="";
            $scope.modeltest[assessment.assessmentCriteria+"1"]="";
            if($scope.arrayToBePassed.length==0){
                assessment.Rating=3;
                $scope.arrayToBePassed.push(assessment);
            }
            else {
                for(var i=0;i<$scope.arrayToBePassed.length;i++){
                    if($scope.arrayToBePassed[i].assessmentCriteria==assessment.assessmentCriteria){
                        flag=true;
                    }

                }
                if(flag==false){
                    assessment.Rating=3;
                    $scope.arrayToBePassed.push(assessment);
                }
            }
            /*      assessment.Rating=3;
             $scope.arrayToBePassed.push(assessment);*/
        }
        else if(value=="4"){
            var flag=false;
            $scope.modeltest[assessment.assessmentCriteria+"2"]="";
            $scope.modeltest[assessment.assessmentCriteria+"3"]="";
            $scope.modeltest[assessment.assessmentCriteria+"5"]="";
            $scope.modeltest[assessment.assessmentCriteria+"1"]="";
            if($scope.arrayToBePassed.length==0){
                assessment.Rating=4;
                $scope.arrayToBePassed.push(assessment);
            }
            else {
                for(var i=0;i<$scope.arrayToBePassed.length;i++){
                    if($scope.arrayToBePassed[i].assessmentCriteria==assessment.assessmentCriteria){
                        flag=true;
                    }

                }
                if(flag==false){
                    assessment.Rating=4;
                    $scope.arrayToBePassed.push(assessment);
                }
            }
            /* assessment.Rating=4;
             $scope.arrayToBePassed.push(assessment);*/
        }
        else if(value=="5"){
            var flag=false;
            $scope.modeltest[assessment.assessmentCriteria+"2"]="";
            $scope.modeltest[assessment.assessmentCriteria+"4"]="";
            $scope.modeltest[assessment.assessmentCriteria+"3"]="";
            $scope.modeltest[assessment.assessmentCriteria+"1"]="";
            if($scope.arrayToBePassed.length==0){
                assessment.Rating=5;
                $scope.arrayToBePassed.push(assessment);
            }
            else {
                for(var i=0;i<$scope.arrayToBePassed.length;i++){
                    if($scope.arrayToBePassed[i].assessmentCriteria==assessment.assessmentCriteria){
                        flag=true;
                    }

                }
                if(flag==false){
                    assessment.Rating=5;
                    $scope.arrayToBePassed.push(assessment);
                }
            }
            /* assessment.Rating=5;
             $scope.arrayToBePassed.push(assessment);*/
        }

        /* if(rating!=null){
         assessment.Rating=rating;

         $scope.arrayToBePassed.push(assessment);
         console.log(rating)
         console.log(assessment)
         console.log($scope.arrayToBePassed)
         }*/


    }

    /*   $scope.rateMe=function(rating,assessment){
     $scope.starRating5=5;
     if(rating!=null){
     assessment.Rating=rating;

     $scope.arrayToBePassed.push(assessment);
     console.log(rating)
     console.log(assessment)
     console.log($scope.arrayToBePassed)
     }


     }*/

    $scope.submitAssessment=function(assessmentQuestionnaireList,selectedApplication){
    	console.log(selectedApplication);
        var questionScoreInfo = '';
        for (var i=0;i<assessmentQuestionnaireList.length;i++) {
                questionScoreInfo += "<questionScoreInfo><applicationId>"+selectedApplication+"</applicationId><id>"+assessmentQuestionnaireList[i].ID+"</id><questionId>"+assessmentQuestionnaireList[i].questionId+"</questionId><score>"+assessmentQuestionnaireList[i].scoreAdmin+"</score><comments>"+assessmentQuestionnaireList[i].comments+"</comments></questionScoreInfo>";
            }
            var reportDetail="<?xml version='1.0' encoding='UTF-8'?><saveQuestionScore>" + questionScoreInfo + "<userType>admin</userType></saveQuestionScore>";
     
        $http({
            method: 'POST',
            url: appConfig.saveQuestionScore,
            data: reportDetail,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data,status){

            $scope.saveSuccessful = true;
            }
        ).error(function () {
            console.log("  System Exception !!! ");
        });
        
        /* userService.fac=$scope.arrayToBePassed;
         console.log(userService.fac);*/
    }
    $scope.getCurrentStepIndex = function(){
        // Get the index of the current step given selection
        return _.indexOf($scope.steps, $scope.selection);
    };

    // Go to a defined step index
    $scope.goToStep = function(index) {

        if ( !_.isUndefined($scope.steps[index]) )
        {
            $scope.selection = $scope.steps[index];
        }
    };

    $scope.hasNextStep = function(){
        var stepIndex = $scope.getCurrentStepIndex();
        var nextStep = stepIndex + 1;
        // Return true if there is a next step, false if not
        return !_.isUndefined($scope.steps[nextStep]);
    };

    $scope.hasPreviousStep = function(){
        var stepIndex = $scope.getCurrentStepIndex();
        var previousStep = stepIndex - 1;
        // Return true if there is a next step, false if not
        return !_.isUndefined($scope.steps[previousStep]);
    };

    $scope.incrementStep = function() {

        if ( $scope.hasNextStep() )
        {
            var stepIndex = $scope.getCurrentStepIndex();
            var nextStep = stepIndex + 1;
            $("#"+stepIndex+"").addClass("completeNoImage");
            $("#"+stepIndex+"").removeClass("disabled");
            $("#"+stepIndex+"").addClass("active");
            $("#"+nextStep+"").removeClass("disabled");
            $scope.selection = $scope.steps[nextStep];
        }
    };

    $scope.decrementStep = function() {
        if ( $scope.hasPreviousStep() )
        {
            var stepIndex = $scope.getCurrentStepIndex();
            var previousStep = stepIndex - 1;
            $("#"+previousStep+"").addClass("active");
            $("#"+previousStep+"").removeClass("completeNoImage");
            $("#"+stepIndex+"").addClass("disabled");
            $("#"+stepIndex+"").removeClass("active");
            $scope.selection = $scope.steps[previousStep];
        }
    };

    $scope.back = function(){
        history.back();
    };

    $scope.navigateTo = function(path){
        $location.url(path);
    };
    
    $scope.rateMe2=function(assessment,value){

        $scope.arrayToBePassed.push(assessment.scoreUser.value)

    }



})


