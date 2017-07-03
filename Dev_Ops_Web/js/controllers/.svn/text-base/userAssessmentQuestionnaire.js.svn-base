'use strict';
angular.module('genpactApp').controller('userAssessmentQuestionnaireCtrl', function($scope,$http,appConfig,commonDataFactory) {



    $scope.init = function(){
        var userBusinessUnitId;

        // For Fetching the Business Units
        var businessUnitRequest="<businessUnit><isViewOnly>true</isViewOnly><showDistinctBusinessUnits>false</showDistinctBusinessUnits><businessUnitId></businessUnitId><businessUnitName></businessUnitName><accountId></accountId><isActive></isActive></businessUnit>"
        $http({method: 'POST',url: appConfig.manageBusinessUnits,data: businessUnitRequest,headers: { "Content-Type": 'application/xml'}}).success(function(data) {
            if(typeof data=='object') {
                if(commonDataFactory.getLoggedInUserProfile()==''){
                    console.log(JSON.parse(window.localStorage.getItem("userProfile")));
                    var loggedInProfile=JSON.parse(window.localStorage.getItem("userProfile"));
                }
                else {
                    var loggedInProfile = commonDataFactory.getLoggedInUserProfile();
                    window.localStorage.setItem("userProfile",JSON.stringify(loggedInProfile));
                    console.log(JSON.parse(window.localStorage.getItem("userProfile")));
                }

                console.log(commonDataFactory.getLoggedInUserProfile());
                //var tempProfile= {'businessUnitId':'19','roleName':'Assessor'}
                  var tempProfile= {'businessUnit':'','roleName':loggedInProfile.roleName}
                for (var i = 0; i < data.response.detail.businessUnitDetails.length; i++) {

                    if (loggedInProfile.accountId == data.response.detail.businessUnitDetails[i].accountId) {
                        tempProfile.businessUnit = data.response.detail.businessUnitDetails[i].businessUnitId;
                    }
                }
            }
            // End of Fetching Business Unit
            console.log(data.response.detail.businessUnitDetails);
            console.log("loggedInProfile.businessUnit"+tempProfile.businessUnit);
            console.log("tempProfile"+tempProfile);
            $scope.userProfile = tempProfile;
            console.log($scope.userProfile);
        }).error(function () {
            console.log("  System Exception While Fetching The Business Units !!! ");
        });


        $(document).ready(function(){
            $('[data-toggle="popover"]').popover();
        });



        $scope.assessmentQuestionnaireList = [];
        $scope.assessmentAreaList = [];
        $scope.sort=function(keyname){
            $scope.sortKey=keyname;
            $scope.reverse=!$scope.reverse;
        }

        $scope.currentPage=1;
        $scope.resetPage=function(){
            //alert($scope.currentPage)
            // document.getElementById("check").innerHTML="<dir-pagination-controls max-size='5'current-page='current'direction-links='true'boundary-links='true'template-url='./views/dirPagination.tpl.html' > </dir-pagination-controls>"
            $scope.currentPage="1"
        }



        $scope.questionType = '';
        $scope.selectedApplication ='';
        $scope.showMess=false;
        $scope.showAgileMess=false;
        $scope.selectApplicationView = true;
        $scope.percentScore = 0;
        $scope.countScoreInitial = 0;

    }


        $scope.searchApplicationPopup = function() {
            var userBusinessUnitId ='';
            $('#applicationModal').modal('show');

        $scope.areaSelected = true;
        var applicationRequest = "<application><showDistinctVals>false</showDistinctVals></application>";
        $http({method: 'POST',url: appConfig.fetchApplications,data: applicationRequest,headers: { "Content-Type": 'application/xml'}
        }).success(function(data,status){

            //if(typeof data=='object'){
            //    $scope.applicationList = data.response.details.applicationDetails;
            //}

            var filteredApplicationList=[];
            if(typeof data=='object'){
                console.log(data.response.details.applicationDetails);
                console.log($scope.userProfile);
                if($scope.userProfile.roleName =='Assessor') {
                    for(var i=0;i<data.response.details.applicationDetails.length;i++){
                        console.log($scope.userProfile.businessUnit);
                        console.log(data.response.details.applicationDetails[i].businessUnit);
                        if($scope.userProfile.businessUnit == data.response.details.applicationDetails[i].businessUnit){
                            console.log(filteredApplicationList);
                            filteredApplicationList.push(data.response.details.applicationDetails[i]);

                         }
                    }

                    $scope.applicationList = filteredApplicationList;


                }else{
                    $scope.applicationList = data.response.details.applicationDetails;

                }

            }
        }).error(function(){
            console.log("Failed to access");
        })
    }

    
    $scope.test = function(){

        console.log($scope.rate);
    }

    $scope.selectApplication = function(){
        $scope.selectApplicationView = true;
    }


    $scope.startAssessment = function(selectedApplication,questionnaireType){

         $scope.rate = "";
         var viewQuestionDetails = "<?xml version='1.0' encoding='UTF-8'?><viewQuestionDetails><applicationId>"+selectedApplication+"</applicationId><questionnaireType>"+questionnaireType+"</questionnaireType></viewQuestionDetails>";
    	
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
            if (parseInt(businessNeedActive)==0 && parseInt(businessEnvNeedActive)==0 && parseInt(deliveryMaturityActive)==0 ){
                $scope.showMess=true;
            }
            if(parseInt(deliveryMaturityActive)==0){
                $scope.showAgileMess=true;
            }

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
            console.log(filterQuestionList.length);
            // The below single line is commented and above lines are used to filter
            //$scope.tempList = data.response.detail.questionResponseDetails;
            $scope.tempList =filterQuestionList;
        	 $scope.assessmentQuestionnaireList = $scope.tempList;
        	 console.log('$scope.tempList');
        	 console.log($scope.tempList);
        	 angular.forEach($scope.assessmentQuestionnaireList,function(list,index) {
 	        	if (list.questionId == -1) {
 	        	  $scope.assessmentQuestionnaireList.splice (index,1);
 	          }
 	        });

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

            $scope.count =0;
            $scope.questCount=[];
            for(var i=0; i< $scope.tempList.length; i++){

                if($scope.tempList[i].scoreUser !=0){
                    console.log($scope.count);
                    $scope.questCount.push($scope.tempList[i].ID);
                $scope.count++;
                }
            }
            $scope.pro=($scope.count*100/$scope.assessmentQuestionnaireList.length);
            $scope.proShow=Math.round($scope.pro);
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
  
    $scope.showSelectedApplication = function(data,appList){

    	for(var i=0;i<appList.length;i++) {
    		if (data == appList[i].applicationId) {
    			 $scope.selectedApplication = appList[i].applicationName;
    		}
    	}
    }


    $scope.arrayToBePassed=[];
    $scope.modeltest={};
    $scope.rateMe=function(assessment,value){
        console.log(value)
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

        var questionScoreInfo = '';
        console.log(selectedApplication);
      /*  if ($scope.role == 'LA') {
        for (var i=0;i<assessmentQuestionnaireList.length;i++) {
            questionScoreInfo += "<questionScoreInfo><questionId>"+assessmentQuestionnaireList[i].ID+"</questionId><score>"+assessmentQuestionnaireList[i].scoreAdmin+"</score><comments>"+assessmentQuestionnaireList[i].comments+"</comments></questionScoreInfo>";
        }
            var reportDetail="<?xml version='1.0' encoding='UTF-8'?><saveQuestionScore>" + questionScoreInfo + "<userType>admin</userType></saveQuestionScore>";
        }*/
       /* if ($scope.role == 'A')
        {*/
            for (var i=0;i<assessmentQuestionnaireList.length;i++) {
                questionScoreInfo += "<questionScoreInfo><applicationId>"+selectedApplication+"</applicationId><id>"+assessmentQuestionnaireList[i].ID+"</id><questionId>"+assessmentQuestionnaireList[i].questionId+"</questionId><score>"+assessmentQuestionnaireList[i].scoreUser+"</score><comments>"+assessmentQuestionnaireList[i].comments+"</comments></questionScoreInfo>";
            }
            var reportDetail="<?xml version='1.0' encoding='UTF-8'?><saveQuestionScore>" + questionScoreInfo + "<userType>user</userType></saveQuestionScore>";


       /* }*/

        $http({
            method: 'POST',
            url: appConfig.saveQuestionScore,
            data: reportDetail,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data,status){
            console.log('data saved successfully');
            $scope.saveSuccessful = true;
            $scope.progressBarFunc();
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
        console.log($scope.assessmentQuestionnaireList);
        console.log($scope.questionType);
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
    
    $scope.rateMe2=function(assessment,value ){
        console.log(assessment.ID);
        $scope.arrayToBePassed.push(assessment.scoreUser.value)
        if($scope.questCount.indexOf(assessment.ID) == -1){
            $scope.questCount.push(assessment.ID);

        $scope.pro =($scope.pro+ 100/$scope.assessmentQuestionnaireList.length);
            $scope.proShow=Math.round($scope.pro);
        console.log($scope.count);
        }

    }

    $scope.progressBarFunc = function() {

        for (var i = 0; i < $scope.assessmentQuestionnaireList.length; i++) {

            console.log($scope.assessmentQuestionnaireList[i].scoreUser);
            console.log("$scope.countScoreInitial"+$scope.countScoreInitial);
            if($scope.assessmentQuestionnaireList[i].scoreUser > 0) {
                $scope.countScoreInitial = parseInt($scope.countScoreInitial) + 1;
                console.log("$scope.countScoreInitial"+$scope.countScoreInitial);

            }
            console.log("$scope.countScoreInitial"+$scope.countScoreInitial);
            console.log("$scope.percentScore"+$scope.percentScore);
        }
        $scope.percentScore = (parseInt($scope.countScoreInitial) / ($scope.assessmentQuestionnaireList.length)) * 100;

        console.log("$scope.percentScore"+$scope.percentScore);
    }

});