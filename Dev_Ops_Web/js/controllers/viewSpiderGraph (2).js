'use strict';
angular.module('genpactApp').controller('viewSpiderGraphCtrl', function($scope, $rootScope,$http,graphDataFactory,appConfig) {

    $scope.init = function() {

        $scope.summaryList         = '';
        $scope.assessmentAreas     = '';
        var  uniqueAccounts          = [];
        var  uniqueBusinessUnits     = [];
        var  uniqueApplications      = [];
        var  uniqueAssessmentArea    = [];
        var  uniqueCategory          = [];
        var  uniqueSubCategory       = [];
        var  agileAssessmentList     = [];
        var  uniqueAccountList       = [];
        var  uniqueBusinessUnitList  = [];
        var  uniqueApplicationList   = [];
        var  uniqueAssessmentList    = [];
        var  uniqueCategoryList      = [];
        var  applicationWiseList     = [];
        var  userSelected            = {'accountId':'0','businessUnitId':'0','applicationId':'0'};
        var  defaultAccount          = {'accountId':'0','accountName':'Please Select An Account'};

        $scope.isUserOrAdmin=false;
        $scope.isUserAdmin = "isAdmin";
        $scope.disableFields=true;
        var userselection = {'isUserAdmin':'isAdmin'};
        $scope.userselection=userselection;
        //var d = new Date('1970-01-02');
        $http({ method: 'GET',url: './data/graphValueRange.json',data: ''}).success(function(data){
            var graphRange=data;
            console.log(graphRange);
            $scope.graphRange=graphRange;
        })
        var milliseconds = (new Date).getTime();
        console.log("Time-->"+milliseconds+" "+appConfig.viewQuestionResponse);
        var viewQuestionReport = "<?xml version='1.0' encoding='UTF-8'?><viewQuestionDetails><applicationId>-1</applicationId></viewQuestionDetails>";
        $http({ method: 'POST',url: appConfig.viewQuestionResponse,data: viewQuestionReport, headers: { "Content-Type": 'application/xml'}
          //$http({ method: 'GET',url: './data/graphData.json',data: ''
        }).success(function (data) {
            var milliseconds1 = (new Date).getTime();
            console.log("Time "+ milliseconds1);
            $scope.disableFields=false;
                var  questionResponseDetails = data.response.detail.questionResponseDetails;
            console.log(questionResponseDetails.length);
                var responseDataList =[];
                var agileResponseDataList=[];
                uniqueAccountList.push(defaultAccount);

                for(var m=0;m<questionResponseDetails.length;m++){
                    if (questionResponseDetails[m].category.indexOf("AHI") == -1) {
                        var responseData={"ID": '',"accountId": '',"accountName": '',"applicationId": '',"applicationName": '',"assessmentArea": '',"assessmentCriteria": '',"assessmentId": '',"businessUnitId": '',"businessUnitName": '',"category": '',"categoryId": '',"comments": '',"optionFiveVal": '',"optionFourVal": '',"optionOneVal": '',"optionThreeVal": '',"optionTwoVal": '',"questionId": '',"reportId": '',"scoreAdmin": '',"scoreUser": '',"subCategory": '',"subCategoryId": '',"submittedBy": ''}

                        responseData.ID=questionResponseDetails[m].ID;
                        responseData.accountId=questionResponseDetails[m].accountId;
                        responseData.accountName=questionResponseDetails[m].accountName;
                        responseData.applicationId=questionResponseDetails[m].applicationId;
                        responseData.applicationName=questionResponseDetails[m].applicationName;
                        responseData.assessmentArea=questionResponseDetails[m].assessmentArea;
                        responseData.assessmentCriteria=questionResponseDetails[m].assessmentCriteria;
                        responseData.assessmentId=questionResponseDetails[m].assessmentId;
                        responseData.businessUnitId=questionResponseDetails[m].businessUnitId;
                        responseData.businessUnitName=questionResponseDetails[m].businessUnitName;
                        responseData.category=questionResponseDetails[m].category;
                        responseData.categoryId=questionResponseDetails[m].categoryId;
                        responseData.comments=questionResponseDetails[m].comments;
                        responseData.optionFiveVal=questionResponseDetails[m].optionFiveVal;
                        responseData.optionFourVal=questionResponseDetails[m].optionFourVal;
                        responseData.optionOneVal=questionResponseDetails[m].optionOneVal;
                        responseData.optionThreeVal=questionResponseDetails[m].optionThreeVal;
                        responseData.optionTwoVal=questionResponseDetails[m].optionTwoVal;
                        responseData.questionId=questionResponseDetails[m].questionId;
                        responseData.reportId=questionResponseDetails[m].reportId;
                        responseData.scoreAdmin=questionResponseDetails[m].scoreAdmin;
                        responseData.scoreUser=questionResponseDetails[m].scoreUser;
                        responseData.subCategory=questionResponseDetails[m].subCategory;
                        responseData.subCategoryId=questionResponseDetails[m].subCategoryId;
                        responseData.submittedBy=questionResponseDetails[m].submittedBy;

                        responseDataList.push(responseData);



                    }else{
                        var agileResponseData={"ID": '',"accountId": '',"accountName": '',"applicationId": '',"applicationName": '',"assessmentArea": '',"assessmentCriteria": '',"assessmentId": '',"businessUnitId": '',"businessUnitName": '',"category": '',"categoryId": '',"comments": '',"optionFiveVal": '',"optionFourVal": '',"optionOneVal": '',"optionThreeVal": '',"optionTwoVal": '',"questionId": '',"reportId": '',"scoreAdmin": '',"scoreUser": '',"subCategory": '',"subCategoryId": '',"submittedBy": ''}

                        agileResponseData.ID=questionResponseDetails[m].ID;
                        agileResponseData.accountId=questionResponseDetails[m].accountId;
                        agileResponseData.accountName=questionResponseDetails[m].accountName;
                        agileResponseData.applicationId=questionResponseDetails[m].applicationId;
                        agileResponseData.applicationName=questionResponseDetails[m].applicationName;
                        agileResponseData.assessmentArea=questionResponseDetails[m].assessmentArea;
                        agileResponseData.assessmentCriteria=questionResponseDetails[m].assessmentCriteria;
                        agileResponseData.assessmentId=questionResponseDetails[m].assessmentId;
                        agileResponseData.businessUnitId=questionResponseDetails[m].businessUnitId;
                        agileResponseData.businessUnitName=questionResponseDetails[m].businessUnitName;
                        agileResponseData.category=questionResponseDetails[m].category;
                        agileResponseData.categoryId=questionResponseDetails[m].categoryId;
                        agileResponseData.comments=questionResponseDetails[m].comments;
                        agileResponseData.optionFiveVal=questionResponseDetails[m].optionFiveVal;
                        agileResponseData.optionFourVal=questionResponseDetails[m].optionFourVal;
                        agileResponseData.optionOneVal=questionResponseDetails[m].optionOneVal;
                        agileResponseData.optionThreeVal=questionResponseDetails[m].optionThreeVal;
                        agileResponseData.optionTwoVal=questionResponseDetails[m].optionTwoVal;
                        agileResponseData.questionId=questionResponseDetails[m].questionId;
                        agileResponseData.reportId=questionResponseDetails[m].reportId;
                        agileResponseData.scoreAdmin=questionResponseDetails[m].scoreAdmin;
                        agileResponseData.scoreUser=questionResponseDetails[m].scoreUser;
                        agileResponseData.subCategory=questionResponseDetails[m].subCategory;
                        agileResponseData.subCategoryId=questionResponseDetails[m].subCategoryId;
                        agileResponseData.submittedBy=questionResponseDetails[m].submittedBy;

                        agileResponseDataList.push(agileResponseData);
                    }
                }

                //console.log(agileResponseDataList);




                for (var i = 0; i < responseDataList.length; i++) {

                    // Uniquely Filter Account

                    if (uniqueAccounts.indexOf(responseDataList[i].accountId) == -1) {

                        uniqueAccounts.push(responseDataList[i].accountId);

                        var account = {'accountId': '', 'accountName': ''}
                        account.accountId = responseDataList[i].accountId;
                        account.accountName = responseDataList[i].accountName;

                        uniqueAccountList.push(account);

                    }

                    // Uniquely Filter Business Unit

                    if (uniqueBusinessUnits.indexOf(responseDataList[i].businessUnitId) == -1) {

                        uniqueBusinessUnits.push(responseDataList[i].businessUnitId)

                        var businessUnit = {
                            'accountId': '',
                            'accountName': '',
                            'businessUnitId': '',
                            'businessUnitName': ''
                        }
                        businessUnit.accountId = responseDataList[i].accountId;
                        businessUnit.accountName = responseDataList[i].accountName;
                        businessUnit.businessUnitId = responseDataList[i].businessUnitId;
                        businessUnit.businessUnitName = responseDataList[i].businessUnitName;

                        uniqueBusinessUnitList.push(businessUnit);

                    }

                    // Uniquely Filter Applications

                    if (uniqueApplications.indexOf(responseDataList[i].applicationId) == -1) {

                        uniqueApplications.push(responseDataList[i].applicationId);

                        var application = {
                            'accountId': '',
                            'accountName': '',
                            'businessUnitId': '',
                            'businessUnitName': '',
                            'applicationId': '',
                            'applicationName': ''
                        }

                        application.accountId = responseDataList[i].accountId;
                        application.accountName = responseDataList[i].accountName;
                        application.businessUnitId = responseDataList[i].businessUnitId;
                        application.businessUnitName = responseDataList[i].businessUnitName;
                        application.applicationId = responseDataList[i].applicationId;
                        application.applicationName = responseDataList[i].applicationName;

                        uniqueApplicationList.push(application);

                        var applicationAuditList = {
                            'applicationId': '',
                            'applicationName': '',
                            'businessUnitId': '',
                            'businessUnitName': '',
                            'auditList': []
                        };
                        applicationAuditList.applicationId = responseDataList[i].applicationId;
                        applicationAuditList.applicationName = responseDataList[i].applicationName;
                        applicationAuditList.businessUnitId = responseDataList[i].businessUnitId;
                        applicationAuditList.businessUnitName = responseDataList[i].businessUnitName;
                        applicationWiseList.push(applicationAuditList);
                        for(var j=0;j<agileResponseDataList.length;j++) {



                                if (agileResponseDataList[j].categoryId == 26) {
                                    var applicationAuditList = {
                                        'applicationId': '',
                                        'applicationName': '',
                                        'businessUnitId': '',
                                        'businessUnitName': '',
                                        'auditList': []
                                    };
                                    applicationAuditList.applicationId = agileResponseDataList[j].applicationId;
                                    applicationAuditList.applicationName = agileResponseDataList[j].applicationName;
                                    applicationAuditList.businessUnitId = agileResponseDataList[j].businessUnitId;
                                    applicationAuditList.businessUnitName = agileResponseDataList[j].businessUnitName;
                                    applicationWiseList.push(applicationAuditList);
                                }

                        }
                    }

                    //console.log(applicationWiseList);
                    // Uniquely Filter Assessment Area
                    if (uniqueAssessmentArea.indexOf(responseDataList[i].assessmentId) == -1) {

                        uniqueAssessmentArea.push(responseDataList[i].assessmentId);

                        var assessmentArea = {
                            'accountId': '',
                            'accountName': '',
                            'businessUnitId': '',
                            'businessUnitName': '',
                            'applicationId': '',
                            'applicationName': '',
                            'assessmentId': '',
                            'assessmentArea': ''
                        }

                        assessmentArea.accountId = responseDataList[i].accountId;
                        assessmentArea.accountName = responseDataList[i].accountName;
                        assessmentArea.businessUnitId = responseDataList[i].businessUnitId;
                        assessmentArea.businessUnitName = responseDataList[i].businessUnitName;
                        assessmentArea.applicationId = responseDataList[i].applicationId;
                        assessmentArea.applicationName = responseDataList[i].applicationName;
                        assessmentArea.assessmentId = responseDataList[i].assessmentId;
                        assessmentArea.assessmentArea = responseDataList[i].assessmentArea;
                        uniqueAssessmentList.push(assessmentArea);
                    }

                    // Uniquely Filter Category
                    if (uniqueCategory.indexOf(responseDataList[i].categoryId) == -1) {

                        uniqueCategory.push(responseDataList[i].categoryId);

                        var category = {
                            'accountId': '',
                            'accountName': '',
                            'businessUnitId': '',
                            'businessUnitName': '',
                            'applicationId': '',
                            'applicationName': '',
                            'assessmentId': '',
                            'assessmentArea': '',
                            'categoryId': '',
                            'category': ''
                        }

                        category.accountId = responseDataList[i].accountId;
                        category.accountName = responseDataList[i].accountName;
                        category.businessUnitId = responseDataList[i].businessUnitId;
                        category.businessUnitName = responseDataList[i].businessUnitName;
                        category.applicationId = responseDataList[i].applicationId;
                        category.applicationName = responseDataList[i].applicationName;
                        category.assessmentId = responseDataList[i].assessmentId;
                        category.assessmentArea = responseDataList[i].assessmentArea;
                        category.categoryId = responseDataList[i].categoryId;
                        category.category = responseDataList[i].category;
                        uniqueCategoryList.push(category);
                        for(var j=0;j<agileResponseDataList.length;j++){


                                if(agileResponseDataList[j].categoryId==26){
                                    if (uniqueCategory.indexOf(agileResponseDataList[j].categoryId) == -1) {

                                        uniqueCategory.push(agileResponseDataList[j].categoryId);

                                        var category = {
                                            'accountId': '',
                                            'accountName': '',
                                            'businessUnitId': '',
                                            'businessUnitName': '',
                                            'applicationId': '',
                                            'applicationName': '',
                                            'assessmentId': '',
                                            'assessmentArea': '',
                                            'categoryId': '',
                                            'category': ''
                                        }

                                        category.accountId = agileResponseDataList[j].accountId;
                                        category.accountName = agileResponseDataList[j].accountName;
                                        category.businessUnitId = agileResponseDataList[j].businessUnitId;
                                        category.businessUnitName = agileResponseDataList[j].businessUnitName;
                                        category.applicationId = agileResponseDataList[j].applicationId;
                                        category.applicationName = agileResponseDataList[j].applicationName;
                                        category.assessmentId = agileResponseDataList[j].assessmentId;
                                        category.assessmentArea = agileResponseDataList[j].assessmentArea;
                                        category.categoryId = agileResponseDataList[j].categoryId;
                                        category.category = agileResponseDataList[j].category;
                                        uniqueCategoryList.push(category);

                                    }
                                }



                        }
                    }



                    // Add Details Based on Unique Application ID
                    for (var j = 0; j < applicationWiseList.length; j++) {

                        if (applicationWiseList[j].applicationId == responseDataList[i].applicationId) {

                            var auditData = {
                                'accountId': '',
                                'accountName': '',
                                'applicationId': '',
                                'applicationName': '',
                                'assessmentArea': '',
                                'assessmentId': '',
                                'businessUnitId': '',
                                'businessUnitName': '',
                                'categoryId': '',
                                'category': '',
                                'scoreAdmin': '',
                                'scoreUser': '',
                                'subCategoryId': '',
                                'subCategory': ''
                            }

                            auditData.accountId = responseDataList[i].accountId;
                            auditData.accountName = responseDataList[i].accountName;
                            auditData.applicationId = responseDataList[i].applicationId;
                            auditData.applicationName = responseDataList[i].applicationName;
                            auditData.assessmentArea = responseDataList[i].assessmentArea;
                            auditData.assessmentId = responseDataList[i].assessmentId;
                            auditData.businessUnitId = responseDataList[i].businessUnitId;
                            auditData.businessUnitName = responseDataList[i].businessUnitName;
                            auditData.categoryId = responseDataList[i].categoryId;
                            auditData.category = responseDataList[i].category;
                            auditData.scoreAdmin = responseDataList[i].scoreAdmin;
                            auditData.scoreUser = responseDataList[i].scoreUser;
                            auditData.subCategoryId = responseDataList[i].subCategoryId;
                            auditData.subCategory = responseDataList[i].subCategory;

                            applicationWiseList[j].auditList.push(auditData);

                        }
                    }

                }

            for (var j = 0; j < agileResponseDataList.length; j++) {
                for (var k = 0; k < applicationWiseList.length; k++) {

                        if (applicationWiseList[k].applicationId == agileResponseDataList[j].applicationId) {
                            if (agileResponseDataList[j].categoryId == 26) {

                                for(var m = 0;m < agileResponseDataList.length; m++) {
                                var auditData = {
                                    'accountId': '',
                                    'accountName': '',
                                    'applicationId': '',
                                    'applicationName': '',
                                    'assessmentArea': '',
                                    'assessmentId': '',
                                    'businessUnitId': '',
                                    'businessUnitName': '',
                                    'categoryId': '',
                                    'category': '',
                                    'scoreAdmin': '',
                                    'scoreUser': '',
                                    'subCategoryId': '',
                                    'subCategory': ''
                                }


                                 if(agileResponseDataList[m].categoryId!=26) {
                                auditData.accountId = agileResponseDataList[j].accountId;
                                auditData.accountName = agileResponseDataList[j].accountName;
                                auditData.applicationId = agileResponseDataList[j].applicationId;
                                auditData.applicationName = agileResponseDataList[j].applicationName;
                                auditData.assessmentArea = agileResponseDataList[j].assessmentArea;
                                auditData.assessmentId = agileResponseDataList[j].assessmentId;
                                auditData.businessUnitId = agileResponseDataList[j].businessUnitId;
                                auditData.businessUnitName = agileResponseDataList[j].businessUnitName;
                                auditData.categoryId = agileResponseDataList[j].categoryId;
                                auditData.category = agileResponseDataList[j].category;
                                auditData.scoreAdmin = agileResponseDataList[j].scoreAdmin;
                                auditData.scoreUser = agileResponseDataList[j].scoreUser;

                                auditData.subCategoryId = agileResponseDataList[m].categoryId;
                                auditData.subCategory = agileResponseDataList[m].category;

                                applicationWiseList[k].auditList.push(auditData);
                                  }
                                }
                            }

                        }
                    }
                }


                $scope.userSelected = userSelected;
                $scope.applicationWiseList = applicationWiseList;
                $scope.uniqueAccountList = uniqueAccountList;
                $scope.uniqueBusinessUnitList = uniqueBusinessUnitList;
                $scope.uniqueApplicationList = uniqueApplicationList;
                $scope.uniqueAssessmentList = uniqueAssessmentList;
                $scope.uniqueCategoryList = uniqueCategoryList;
                $scope.agileResponseDataList=agileResponseDataList;
            var milliseconds2 = (new Date).getTime();
            console.log("Time "+ milliseconds2);


        }).error(function () {
            console.log("  Error Occurred While Fetching the Data !!! ");
        });
    }

    $scope.fetchBusinessUnitsList = function() {
        //$scope.userSelected.businessUnitId=$scope.userSelected.businessUnitId;
        console.log($scope.userSelected.businessUnitId);
        var userSelectedAccountId  = $scope.userSelected.accountId;
        var uniqueBusinessUnitList = $scope.uniqueBusinessUnitList;
        var  filteredBusinessList  = [];
        var  defaultBusinessUnit   = {'businessUnitId':'0','businessUnitName':'Please Select A Business Unit'};
        $scope.userSelected.businessUnitId=defaultBusinessUnit.businessUnitId;
        // Adding A Default Business Unit
        filteredBusinessList.push(defaultBusinessUnit);

        if(userSelectedAccountId !='0') {
            for (var i = 0; i<uniqueBusinessUnitList.length; i++) {

                if (parseInt(userSelectedAccountId) == parseInt(uniqueBusinessUnitList[i].accountId)) {

                    var businessUnit = {'businessUnitId': '', 'businessUnitName': ''}

                    businessUnit.businessUnitId = $scope.uniqueBusinessUnitList[i].businessUnitId;
                    businessUnit.businessUnitName = $scope.uniqueBusinessUnitList[i].businessUnitName;

                    filteredBusinessList.push(businessUnit);
                }
            }
            $scope.filteredBusinessList = filteredBusinessList;

        }
        console.log($scope.userSelected.businessUnitId);
    }
    $scope.fetchApplicationList = function() {

        var userSelectedBusinessUnitId     = $scope.userSelected.businessUnitId;
        var uniqueApplicationList          = $scope.uniqueApplicationList;
        var  filteredApplicationList       = [];
        var  defaultApplication            = {'applicationId':'0','applicationName':'Please Select An Application'};
        var allApplication                 = {'applicationId':'-1','applicationName':'Application level-Aggregated Score'};
        var allApplicationTogether         = {'applicationId':'-2','applicationName':'Application level-Score'};
        // Adding A Default Application
        $scope.userSelected.applicationId  = defaultApplication.applicationId;
        filteredApplicationList.push(defaultApplication);
        filteredApplicationList.push(allApplication);
        filteredApplicationList.push(allApplicationTogether);
        if(userSelectedBusinessUnitId !='0') {

            for (var i = 0; i<uniqueApplicationList.length; i++) {

                if (parseInt(userSelectedBusinessUnitId) == parseInt(uniqueApplicationList[i].businessUnitId)) {

                    var application = {'applicationId': '', 'applicationName': ''}

                    application.applicationId   = $scope.uniqueApplicationList[i].applicationId;
                    application.applicationName = $scope.uniqueApplicationList[i].applicationName;

                    filteredApplicationList.push(application);
                }
            }
            $scope.filteredApplicationList = filteredApplicationList;
        }
    }

    $scope.setGraphView = function(){

         if(parseInt($scope.graphLevel) == 1){
             $scope.showApplicationView();
         }
        if(parseInt($scope.graphLevel) == 2){
            $scope.showCategoryLevel();
        }
        if(parseInt($scope.graphLevel) == 3){
            $scope.showSubCategoryLevel();
        }
        if(parseInt($scope.graphLevel)==4){
            console.log("Inside 4");
            $scope.showAHISubCategories();
        }
    }
    $scope.previousGraph = function(){
        console.log($scope.graphLevel);
        console.log("Inside previous graph function");
        if(parseInt($scope.graphLevel)==3){
            console.log("Inside 3");
            $scope.showCategoryLevel();
        }
        else if(parseInt($scope.graphLevel)==2){
            console.log("Inside 2");
            $scope.showApplicationView();
        }
        else if(parseInt($scope.graphLevel)==1){
            return 0;
        }
        else if(parseInt($scope.graphLevel)==4){
            $scope.showSubCategoryLevel();
        }
    }

    $scope.showApplicationView = function() {
        $scope.selectedAssessmentId =0;
        $scope.userSelectedCategor=0;
        $scope.isUserOrAdmin = true;
        $scope.graphLevel = 1;

        var userSelectedApplicationId = $scope.userSelected.applicationId;
        var applicationWiseList = $scope.applicationWiseList;
        var uniqueAssessmentAreaId = [];
        var uniqueAssessmentAreaName = [];
        var uniqueApplications = [];
        var uniqueCategoryList = [];
        var uniqueCategoryScoreList = [];
        var uniqueSubCategoryList = [];
        // Below Code can be enhanced to Use One Single For Loop
        var assessmentLevelDataView = [];
        var userSelectedBusinessUnitId = $scope.userSelected.businessUnitId;
        var businessWiseList = [];
        var userSelectedApplication = [];
        var applicationName = '';
        var assessments = [];
        var totalAdminAverageScore = [0, 0, 0];
        var adminAverageScore = [];
        var userAverageScore = [];
        var totalUserAverageScore = [0, 0, 0];
        var uniqueAssessmentAreaAdminAverage = [];
        var uniqueAssessmentAreaUserAverage = [];
        var valueRangeDescription   = [];
        var uniqueValueRange = [];
        var uniqueValue0to3='';
        var uniqueValue3to3point5='';
        var uniqueValue3point5to5='';
        var graphRange=$scope.graphRange;
        // Setting User Selected Application List
        $scope.userSelectedApplication = userSelectedApplication;
        $scope.userSelectedApplicationName = applicationName;
        console.log(applicationWiseList);
        var isUserAdmin=$scope.userselection.isUserAdmin;
        var selectBusinessUnitApplications = [];
        if (userSelectedApplicationId == -1 || userSelectedApplicationId == -2) {
            for (var i = 0; i < applicationWiseList.length; i++) {
                if (userSelectedBusinessUnitId == applicationWiseList[i].businessUnitId) {
                    if(uniqueApplications.indexOf(applicationWiseList[i].applicationId)==-1) {
                        uniqueApplications.push(applicationWiseList[i].applicationId);
                        selectBusinessUnitApplications.push(applicationWiseList[i].auditList);

                    }
                }
            }
            if(userSelectedApplicationId==-1) {
                applicationName = "All Applications"
            }

        }

        if (userSelectedApplicationId > 0) {
            for (var i = 0; i < applicationWiseList.length; i++) {
                if (userSelectedApplicationId == applicationWiseList[i].applicationId) {
                    selectBusinessUnitApplications.push(applicationWiseList[i].auditList);
                    applicationName = applicationWiseList[i].applicationName;
                    i = applicationWiseList.length;
                }
            }
        }
        uniqueApplications=[];
        console.log(selectBusinessUnitApplications);
        //userSelectedApplication= selectBusinessUnitApplications[0];

        for (var i = 0; i < selectBusinessUnitApplications.length; i++) {
            console.log(uniqueCategoryScoreList);
            var uniqueAssessmentAreaAverageAdminScore = [];
            var uniqueAssessmentAreaAverageUserScore = [];
            userSelectedApplication = selectBusinessUnitApplications[i];
            console.log(userSelectedApplication);

            for (var j = 0; j < userSelectedApplication.length; j++) {
                if (uniqueAssessmentAreaId.indexOf(userSelectedApplication[j].assessmentId) == -1) {
                    uniqueAssessmentAreaId.push(userSelectedApplication[j].assessmentId);
                    uniqueAssessmentAreaName.push(userSelectedApplication[j].assessmentArea);
                    var assessmentData = {
                        'assessmentId': '',
                        'assessmentArea': '',
                        'assessmentAdminScore': [],
                        'assessmentUserScore': [],
                        'averageAdmin': '',
                        'averageUser': ''
                    }
                    assessmentData.assessmentId = userSelectedApplication[j].assessmentId;
                    assessmentData.assessmentArea = userSelectedApplication[j].assessmentArea;
                    assessmentLevelDataView.push(assessmentData);
                }
            }
            console.log(userSelectedApplication);
            for (var j = 0; j < userSelectedApplication.length; j++) {
                if (uniqueCategoryList.indexOf(userSelectedApplication[j].categoryId) == -1) {

                    var categoryData = {
                        'assessmentId': '',
                        'assessmentArea': '',
                        'categoryId': '',
                        'category': '',
                        'averageAdmin': '',
                        'averageUser': '',
                        'adminScore': [],
                        'userScore': []
                    }

                    categoryData.assessmentId = userSelectedApplication[j].assessmentId;
                    categoryData.assessmentArea = userSelectedApplication[j].assessmentArea;
                    categoryData.categoryId = userSelectedApplication[j].categoryId;
                    categoryData.category = userSelectedApplication[j].category;

                    uniqueCategoryScoreList.push(categoryData);
                    uniqueCategoryList.push(userSelectedApplication[j].categoryId);
                }
            }
            console.log(uniqueCategoryList);
            console.log(uniqueCategoryScoreList);
            uniqueCategoryList=[];
            for (var k = 0; k < userSelectedApplication.length; k++) {
                for (var l = 0; l < uniqueCategoryScoreList.length; l++) {
                    if (parseInt(userSelectedApplication[k].categoryId) == parseInt(uniqueCategoryScoreList[l].categoryId)) {
                        if(userSelectedApplication[k].scoreAdmin==undefined){
                            userSelectedApplication[k].scoreAdmin=userSelectedApplication[k].scoreUser;
                        }
                        uniqueCategoryScoreList[l].adminScore.push(userSelectedApplication[k].scoreAdmin);
                        uniqueCategoryScoreList[l].userScore.push(userSelectedApplication[k].scoreUser);
                    }
                }
            }

            for (var m = 0; m < uniqueCategoryScoreList.length; m++) {
                var tempAverageAdmin = 0;
                var tempAverageUser = 0;
                for (var n = 0; n < uniqueCategoryScoreList[m].adminScore.length; n++) {
                    tempAverageAdmin = tempAverageAdmin + uniqueCategoryScoreList[m].adminScore[n];
                    tempAverageUser = tempAverageUser + uniqueCategoryScoreList[m].userScore[n];
                }
                tempAverageAdmin = tempAverageAdmin / uniqueCategoryScoreList[m].adminScore.length;
                tempAverageUser = tempAverageUser / uniqueCategoryScoreList[m].userScore.length;
                uniqueCategoryScoreList[m].averageAdmin = tempAverageAdmin;
                uniqueCategoryScoreList[m].averageUser = tempAverageUser;
                //    uniqueCategoryScoreList.push(categoryData);
            }



            for (var l = 0; l < assessmentLevelDataView.length; l++) {
                for (var m = 0; m < uniqueCategoryScoreList.length; m++) {
                    if (assessmentLevelDataView[l].assessmentId == uniqueCategoryScoreList[m].assessmentId) {
                        assessmentLevelDataView[l].assessmentAdminScore.push(uniqueCategoryScoreList[m].averageAdmin);
                        assessmentLevelDataView[l].assessmentUserScore.push(uniqueCategoryScoreList[m].averageUser);
                    }
                }
            }
            uniqueCategoryScoreList=[];
            for (var l = 0; l < assessmentLevelDataView.length; l++) {
                var tempAverageAdmin = 0;
                var tempAverageUser = 0;
                for (var m = 0; m < assessmentLevelDataView[l].assessmentAdminScore.length; m++) {
                    tempAverageAdmin = tempAverageAdmin + assessmentLevelDataView[l].assessmentAdminScore[m];
                    tempAverageUser = tempAverageUser + assessmentLevelDataView[l].assessmentUserScore[m];
                }
                tempAverageAdmin = tempAverageAdmin / assessmentLevelDataView[l].assessmentAdminScore.length;
                tempAverageUser = tempAverageUser / assessmentLevelDataView[l].assessmentUserScore.length;

                assessmentLevelDataView[l].averageAdmin = tempAverageAdmin;
                assessmentLevelDataView[l].averageUser = tempAverageUser;
            }

            console.log(assessmentLevelDataView);
            for (m = 0; m < assessmentLevelDataView.length; m++) {
                console.log(assessmentLevelDataView[m]);
                uniqueAssessmentAreaAverageAdminScore.push(assessmentLevelDataView[m].averageAdmin);
                uniqueAssessmentAreaAverageUserScore.push(assessmentLevelDataView[m].averageUser);
            }
            uniqueAssessmentAreaAdminAverage.push(uniqueAssessmentAreaAverageAdminScore);
            uniqueAssessmentAreaUserAverage.push(uniqueAssessmentAreaAverageUserScore);
            for(var m=0;m<uniqueAssessmentAreaAverageAdminScore.length;m++){
                var value=Math.floor(uniqueAssessmentAreaAverageAdminScore[m]);
                console.log(value);
                if(value>=0&&value<3){
                    if(uniqueValueRange.indexOf(value)==-1&&uniqueValueRange.indexOf(uniqueValue0to3)==-1){
                        uniqueValue0to3=value;
                        uniqueValueRange.push(uniqueValue0to3);
                        valueRangeDescription.push(graphRange[0]);
                    }
                }else if(value>=3&&value<3.5){
                    if(uniqueValueRange.indexOf(value)==-1&&uniqueValueRange.indexOf(uniqueValue3to3point5)==-1){
                        uniqueValue3to3point5=value;
                        uniqueValueRange.push(uniqueValue3to3point5);
                        valueRangeDescription.push(graphRange[1]);
                    }
                }else if(value>=3.5&&value<=5){
                    if(uniqueValueRange.indexOf(value)==-1&&uniqueValueRange.indexOf(uniqueValue3point5to5)==-1){
                        uniqueValue3point5to5=value;
                        uniqueValueRange.push(uniqueValue3point5to5);
                        valueRangeDescription.push(graphRange[2]);
                    }
                }
            }
            console.log(uniqueAssessmentAreaAdminAverage);
            for(var m=0;m<assessmentLevelDataView.length;m++){
                assessmentLevelDataView[m].assessmentAdminScore=[];
                assessmentLevelDataView[m].assessmentUserScore=[];
            }
            if(userSelectedApplicationId == -2){
                for(var m=0;m<selectBusinessUnitApplications[i].length;m++) {
                    if(uniqueApplications.indexOf(selectBusinessUnitApplications[i][m].applicationId)==-1) {
                        uniqueApplications.push(selectBusinessUnitApplications[i][m].applicationId);
                        applicationName = selectBusinessUnitApplications[i][m].applicationName;
                    }
                }

                if (isUserAdmin == "isAdmin") {
                    var assessment = {
                        name: applicationName,
                        data: uniqueAssessmentAreaAverageAdminScore,
                        pointPlacement: 'on',
                        lineWidth:4
                    }
                    assessments.push(assessment);
                }
                else if (isUserAdmin == "isUser") {
                    var assessment = {
                        name: applicationName,
                        data: uniqueAssessmentAreaAverageUserScore,
                        pointPlacement: 'on',
                        lineWidth:4
                    }
                    assessments.push(assessment);
                }
            }
        }
        if(userSelectedApplicationId == -1 || userSelectedApplicationId > 0) {
            if (isUserAdmin == "isAdmin") {

                console.log(uniqueAssessmentAreaAdminAverage);
                for (i = 0; i < uniqueAssessmentAreaAdminAverage.length; i++) {
                    for (j = 0; j < uniqueAssessmentAreaAdminAverage[i].length; j++) {
                        adminAverageScore[j] = uniqueAssessmentAreaAdminAverage[i][j];
                        totalAdminAverageScore[j] = totalAdminAverageScore[j] + adminAverageScore[j];
                    }
                }
                console.log(totalAdminAverageScore);
                for (i = 0; i < totalAdminAverageScore.length; i++) {
                    totalAdminAverageScore[i] = totalAdminAverageScore[i] / uniqueAssessmentAreaAdminAverage.length;
                }
                console.log(totalAdminAverageScore);
                var assessment = {
                    name: applicationName,
                    data: totalAdminAverageScore,
                    pointPlacement: 'on',
                    lineWidth:4,
                    color:'#2e6da4'
                }
                assessments.push(assessment);
            }
            else if (isUserAdmin == "isUser") {

                console.log(uniqueAssessmentAreaUserAverage);
                for (i = 0; i < uniqueAssessmentAreaUserAverage.length; i++) {
                    for (j = 0; j < uniqueAssessmentAreaUserAverage[i].length; j++) {
                        userAverageScore[j] = uniqueAssessmentAreaUserAverage[i][j];
                        totalUserAverageScore[j] = totalUserAverageScore[j] + userAverageScore[j];
                    }
                }
                console.log(totalUserAverageScore);
                for (i = 0; i < totalUserAverageScore.length; i++) {
                    totalUserAverageScore[i] = totalUserAverageScore[i] / uniqueAssessmentAreaUserAverage.length;
                }

                console.log(totalUserAverageScore);
                var assessment = {
                    name: applicationName,
                    data: totalUserAverageScore,
                    pointPlacement: 'on',
                    lineWidth:4,
                    color:'#2e6da4'
                }
                assessments.push(assessment);
            }
        }
        console.log(valueRangeDescription);
        $scope.userSelectedApplication = userSelectedApplication;
        $scope.selectBusinessUnitApplications = selectBusinessUnitApplications;
        $scope.userSelectedApplicationName = applicationName;
        //$scope.showHighchart(assessments,uniqueAssessmentAreaName);
        Highcharts.chart('container', {

            chart: {
                polar: true,
                type: 'line',
                events: {
                    click: function (ev) {
                        // Not working as in Now
                        console.log(this);
                        //angular.element(document.getElementById('myText')).scope().showDetails();
                    }
                }
            },
            plotOptions: {
                series: {
                    cursor: 'pointer',
                    point: {
                        events: {
                            click: function () {
                                //angular.element(document.getElementById('myText')).scope().showCategoryLevel(this.category,2);
                                $scope.showCategoryLevel(this.category,2);
                            }
                        }
                    }
                }
            },
            title: {
                text: '',
                x: -80
            },

            pane: {
                size: '80%'
            },
            labels:{
                items:valueRangeDescription
            },
            credits:{
                enabled:false
            },
            xAxis: {
                categories: uniqueAssessmentAreaName,
                tickmarkPlacement: 'on',
                lineWidth: 0,
                labels: {
                    style: {
                        fontSize:'18px',
                        fontWeight:'bold'
                    }
                }
            },

            yAxis: {
                gridLineInterpolation: 'polygon',
                gridLineColor:'#C0C0C0',
                gridLineWidth:2,
                lineColor:'#C0C0C0',
                min: 0,
                max: 5,
                tickInterval: 1
            },

            tooltip: {
                shared: false,
                formatter: function () {
                    return ''+Highcharts.numberFormat(this.y,2)+'';
                }
            },

            legend: {
                align: 'right',
                verticalAlign: 'top',
                y: 70,
                layout: 'vertical'
            },

            series: assessments


        });


    }

    $scope.showCategoryLevel = function(selectedAssessmentArea,graphLevel) {
        if ($scope.userSelected.applicationId == -1 || $scope.userSelected.applicationId==-2) {
            return false;
        }
        $scope.userSelectedLevel = selectedAssessmentArea;
        $scope.graphLevel = 2;
console.log($scope.graphLevel);

        var isUserAdmin=$scope.userselection.isUserAdmin;
        var userSelectedApplication         = $scope.userSelectedApplication;
        var selectBusinessUnitApplications  = $scope.selectBusinessUnitApplications;
        var uniqueCategoryId                = [];
        var uniqueCategory                  = [];
        var uniqueCategoryAverageAdminScore = [];
        var uniqueCategoryAverageUserScore  = [];
        var categoryLevelDataView           = [];
        var selectedAssessmentId            = $scope.selectedAssessmentId;
        var agileResponseDataList           = $scope.agileResponseDataList;
        var uniqueSubCategory2List          = [];
        var uniqueSubCategoryList          = [];
        var categories=[];
        var uniqueAgileSubCategories        = [];
        var valueRangeDescription   = [];
        var uniqueValueRange = [];
        var graphRange=$scope.graphRange;
        var uniqueValue0to3='';
        var uniqueValue3to3point5='';
        var uniqueValue3point5to5='';


        for (var i = 0; i < $scope.uniqueAssessmentList.length; i++) {
                if (selectedAssessmentArea == $scope.uniqueAssessmentList[i].assessmentArea) {
                    selectedAssessmentId = $scope.uniqueAssessmentList[i].assessmentId
                    i = $scope.uniqueAssessmentList.length;
                }

            }
        $scope.selectedAssessmentId = selectedAssessmentId
        console.log(selectedAssessmentId);


        console.log(uniqueAgileSubCategories);
        for(var m=0;m<selectBusinessUnitApplications.length;m++) {
            var uniqueCategoryAverageScore = [];
            userSelectedApplication = selectBusinessUnitApplications[m];
            for (var j = 0; j < userSelectedApplication.length; j++) {
                if (selectedAssessmentId == userSelectedApplication[j].assessmentId) {
                    if (uniqueCategoryId.indexOf(userSelectedApplication[j].categoryId) == -1) {
                        uniqueCategoryId.push(userSelectedApplication[j].categoryId);

                        if (userSelectedApplication[j].categoryId == '-1') {
                            uniqueCategory.push("UnKnown");
                            console.log(userSelectedApplication[j]);
                        } else {
                            uniqueCategory.push(userSelectedApplication[j].category);
                        }
                        var categoryData = {'categoryId': '','category': '','averageAdminScore': '','averageUserScore': '','subCategoryList': []}

                        categoryData.categoryId = userSelectedApplication[j].categoryId;
                        if (userSelectedApplication[j].categoryId == '-1') {
                            categoryData.category = "UnKnown";
                        } else {
                            categoryData.category = userSelectedApplication[j].category;
                        }



                        categoryLevelDataView.push(categoryData);
                    }
                }
            }
            console.log(" :: 1 ::");
            console.log(userSelectedApplication);

            //console.log(categoryLevelDataView);
            for (var j = 0; j < userSelectedApplication.length; j++) {
                if (selectedAssessmentId == userSelectedApplication[j].assessmentId) {
                    for (var k = 0; k < categoryLevelDataView.length; k++) {
                        //console.log(categoryLevelDataView);
                        if (userSelectedApplication[j].categoryId == categoryLevelDataView[k].categoryId) {

                                if(categoryLevelDataView[k].categoryId==26){
                                    for(var l=0;l<agileResponseDataList.length;l++) {
                                        if(agileResponseDataList[l].categoryId!=26) {
                                            if (uniqueSubCategoryList.indexOf(agileResponseDataList[l].categoryId) == -1&&agileResponseDataList[l].applicationId==userSelectedApplication[j].applicationId) {
                                                uniqueSubCategoryList.push(agileResponseDataList[l].categoryId);
                                                console.log(uniqueSubCategoryList);
                                                var subCategory = {
                                                    'applicationId':'',
                                                    'subCategoryId': '',
                                                    'subCategory': '',
                                                    'averageSubAdmin': '',
                                                    'averageSubUser': '',
                                                    'subCategory2List': []
                                                };
                                                subCategory.subCategoryId = agileResponseDataList[l].categoryId;
                                                subCategory.subCategory = agileResponseDataList[l].category;
                                                subCategory.applicationId=agileResponseDataList[l].applicationId;
                                                //subCategory.averageSubAdmin = userSelectedApplication[j].scoreAdmin;
                                                //subCategory.averageSubUser = userSelectedApplication[j].scoreUser;
                                                categoryLevelDataView[k].subCategoryList.push(subCategory);
                                            }
                                        }
                                    }
                                }else {
                                    if(userSelectedApplication[j].scoreAdmin==undefined){
                                        userSelectedApplication.scoreAdmin=userSelectedApplication.scoreUser;
                                    }
                                    var subCategory = {
                                        'applicationId':'',
                                        subCategoryId: '',
                                        subCategory: '',
                                        'scoreAdmin': '',
                                        'scoreUser': ''
                                    };
                                    subCategory.subCategoryId = userSelectedApplication[j].subCategoryId;
                                    subCategory.applicationId=userSelectedApplication[j].applicationId;
                                    subCategory.subCategory = userSelectedApplication[j].subCategory;
                                    subCategory.scoreAdmin = userSelectedApplication[j].scoreAdmin;
                                    subCategory.scoreUser = userSelectedApplication[j].scoreUser;
                                    categoryLevelDataView[k].subCategoryList.push(subCategory);
                                }

                        }
                    }
                }
            }

                    for (var k = 0; k < categoryLevelDataView.length; k++) {
                        //console.log(categoryLevelDataView);
                        if (categoryLevelDataView[k].categoryId == 26) {
                            for (var l = 0; l < categoryLevelDataView[k].subCategoryList.length; l++) {
                                for (var j = 0; j < agileResponseDataList.length; j++) {
                                    if (selectedAssessmentId == agileResponseDataList[j].assessmentId) {
                                if(agileResponseDataList[j].categoryId!=26) {

                                    if(uniqueSubCategory2List.indexOf(agileResponseDataList[j].questionId) == -1) {

                                        if(agileResponseDataList[j].categoryId==categoryLevelDataView[k].subCategoryList[l].subCategoryId&&agileResponseDataList[j].applicationId==categoryLevelDataView[k].subCategoryList[l].applicationId)
                                        {

                                            uniqueSubCategory2List.push(agileResponseDataList[j].questionId);
                                            if (agileResponseDataList[j].scoreAdmin == undefined) {
                                                agileResponseDataList.scoreAdmin = agileResponseDataList.scoreUser;
                                            }

                                            var subCategory2 = {
                                                'subCategory2Id': '',
                                                'subCategory2': '',
                                                'scoreAdmin': '',
                                                'scoreUser': ''

                                            };
                                            //console.log(agileResponseDataList[j].scoreAdmin);
                                            subCategory2.subCategory2Id = agileResponseDataList[j].subCategoryId;
                                            subCategory2.subCategory2 = agileResponseDataList[j].subCategory;
                                            subCategory2.scoreAdmin = agileResponseDataList[j].scoreAdmin;
                                            subCategory2.scoreUser = agileResponseDataList[j].scoreUser;
                                            categoryLevelDataView[k].subCategoryList[l].subCategory2List.push(subCategory2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            console.log(" :: 2 ::");
            console.log(categoryLevelDataView);


            for (var i = 0; i < categoryLevelDataView.length; i++) {
                var tempAverageScoreAdmin = 0;
                var tempAverageScoreUser = 0;
                if(categoryLevelDataView[i].categoryId==26){
                    for(var j = 0; j < categoryLevelDataView[i].subCategoryList.length; j++){
                        var agileAverageAdminScore=0;
                        var agileAverageUserScore=0;
                        for(var k=0;k<categoryLevelDataView[i].subCategoryList[j].subCategory2List.length;k++){
                            agileAverageAdminScore=agileAverageAdminScore+parseInt(categoryLevelDataView[i].subCategoryList[j].subCategory2List[k].scoreAdmin);
                            agileAverageUserScore=agileAverageUserScore+parseInt(categoryLevelDataView[i].subCategoryList[j].subCategory2List[k].scoreUser);
                        }
                        agileAverageAdminScore=agileAverageAdminScore/categoryLevelDataView[i].subCategoryList[j].subCategory2List.length;
                        agileAverageUserScore=agileAverageUserScore/categoryLevelDataView[i].subCategoryList[j].subCategory2List.length;
                        tempAverageScoreAdmin=tempAverageScoreAdmin+agileAverageAdminScore;
                        tempAverageScoreUser=tempAverageScoreUser+agileAverageUserScore;
                        categoryLevelDataView[i].subCategoryList[j].averageSubAdmin=agileAverageAdminScore;
                        categoryLevelDataView[i].subCategoryList[j].averageSubUser=agileAverageUserScore;
                        //console.log(agileAverageAdminScore);
                    }
                    tempAverageScoreAdmin=tempAverageScoreAdmin/categoryLevelDataView[i].subCategoryList.length;
                    tempAverageScoreUser=tempAverageScoreUser/categoryLevelDataView[i].subCategoryList.length;
                    categoryLevelDataView[i].averageAdminScore = tempAverageScoreAdmin;
                    categoryLevelDataView[i].averageUserScore = tempAverageScoreUser;
                    uniqueCategoryAverageAdminScore.push(categoryLevelDataView[i].averageAdminScore);
                    uniqueCategoryAverageUserScore.push(categoryLevelDataView[i].averageUserScore);
                }
                else {
                    for (var j = 0; j < categoryLevelDataView[i].subCategoryList.length; j++) {

                        tempAverageScoreAdmin = tempAverageScoreAdmin + categoryLevelDataView[i].subCategoryList[j].scoreAdmin;
                        tempAverageScoreUser = tempAverageScoreUser + categoryLevelDataView[i].subCategoryList[j].scoreUser;

                    }
                    tempAverageScoreAdmin = tempAverageScoreAdmin / categoryLevelDataView[i].subCategoryList.length;
                    tempAverageScoreUser = tempAverageScoreUser / categoryLevelDataView[i].subCategoryList.length;

                    categoryLevelDataView[i].averageAdminScore = tempAverageScoreAdmin;
                    categoryLevelDataView[i].averageUserScore = tempAverageScoreUser;
                    uniqueCategoryAverageAdminScore.push(categoryLevelDataView[i].averageAdminScore);
                    uniqueCategoryAverageUserScore.push(categoryLevelDataView[i].averageUserScore);
                }
            }
            for(var m=0;m<uniqueCategoryAverageAdminScore.length;m++){
                var value=Math.floor(uniqueCategoryAverageAdminScore[m]);
                console.log(value);
                if(value>=0&&value<3){
                    console.log("inside 0-3");
                    if(uniqueValueRange.indexOf(value)==-1&&uniqueValueRange.indexOf(uniqueValue0to3)==-1){
                        uniqueValue0to3=value;
                        uniqueValueRange.push(uniqueValue0to3);
                        valueRangeDescription.push(graphRange[0]);
                    }
                }else if(value>=3&&value<3.5){
                    console.log("inside 3-3.5");
                    if(uniqueValueRange.indexOf(value)==-1&&uniqueValueRange.indexOf(uniqueValue3to3point5)==-1){
                        uniqueValue3to3point5=value;
                        uniqueValueRange.push(uniqueValue3to3point5);
                        valueRangeDescription.push(graphRange[1]);
                    }
                }else if(value>=3.5&&value<=5){
                    console.log("inside 3.5-5");
                    if(uniqueValueRange.indexOf(value)==-1&&uniqueValueRange.indexOf(uniqueValue3point5to5)==-1){
                        uniqueValue3point5to5=value;
                        uniqueValueRange.push(uniqueValue3point5to5);
                        valueRangeDescription.push(graphRange[2]);
                    }
                }
            }
            console.log(valueRangeDescription);
            console.log(categoryLevelDataView);
            if(isUserAdmin=="isAdmin") {
                var category = {
                    name: $scope.userSelectedApplicationName,
                    data: uniqueCategoryAverageAdminScore,
                    pointPlacement: 'on',
                    lineWidth:4,
                    color:'#2e6da4'
                }
                categories.push(category);
            }
            else if(isUserAdmin=="isUser"){
                var category = {
                    name: $scope.userSelectedApplicationName,
                    data: uniqueCategoryAverageUserScore,
                    pointPlacement: 'on',
                    lineWidth:4,
                    color:'#2e6da4'
                }
                categories.push(category);
            }
        }
        console.log(uniqueSubCategory2List);
        console.log(uniqueCategory);
        $scope.categoryLevelDataView = categoryLevelDataView;

        //$scope.showHighchart(categories,uniqueCategory);
        Highcharts.chart('container', {

            chart: {
                polar: true,
                type: 'line',
                events: {
                    click: function (ev) {
                        // Not working as in Now
                        console.log(this);
                        //angular.element(document.getElementById('myText')).scope().showDetails();
                    }
                }
            },
            plotOptions: {
                series: {
                    cursor: 'pointer',
                    point: {
                        events: {
                            click: function () {
                                //angular.element(document.getElementById('myText')).scope().showSubCategoryLevel(this.category,3);
                                $scope.showSubCategoryLevel(this.category,3);
                            }
                        }
                    }
                }
            },
            title: {
                text: '',
                x: -80
            },
            labels:{
                items:valueRangeDescription
            },
            pane: {
                size: '80%'
            },
            credits:{
                enabled:false
            },
            xAxis: {
                categories: uniqueCategory,
                tickmarkPlacement: 'on',
                lineWidth: 0,
                labels: {
                    style: {
                        fontSize:'18px',
                        fontWeight:'bold'
                    }
                }
            },

            yAxis: {
                gridLineInterpolation: 'polygon',
                gridLineColor:'#C0C0C0',
                gridLineWidth:2,
                lineColor:'#C0C0C0',
                min: 0,
                max: 5,
                tickInterval: 1
            },

            tooltip: {
                shared: false,
                formatter: function () {
                    return ''+Highcharts.numberFormat(this.y,2)+'';
                }
            },

            legend: {
                align: 'right',
                verticalAlign: 'top',
                y: 70,
                layout: 'vertical'
            },

            series: categories

        });
        //var charts = [];
        //$('.highchartContainer').each(function(i, e) {
        //    console.log("Inside loop");
        //    charts.push($(this).highcharts());
        //});
        //var normalState = new Object();
        //normalState.stroke_width = null;
        //normalState.stroke = 'white';
        //normalState.fill = 'white';
        ////normalState.padding = null;
        ////normalState.r = null;
        //normalState.width=100;
        //var hoverState = new Object();
        //hoverState = normalState;
        //hoverState.fill = 'white';
        //
        //var pressedState = new Object();
        //pressedState = normalState;
        //
        //for (var i = 0; i < charts.length; i++) {
        //    var custombutton = charts[i].renderer.button('<span style="font-size: 20px;color: #2e6da4;">Back</span>', 10, 10, $scope.previousGraph(), normalState,hoverState).add();
        //}
    }
    $scope.showSubCategoryLevel = function(userSelectedCategory,graphLevel) {

        // Blocking the Sub Category Level for the Business Complexity & Business Needs
        if(parseInt($scope.selectedAssessmentId)== 1  || parseInt($scope.selectedAssessmentId)== 2 ){
          return false;
        }

        $scope.graphLevel = 3;
        var isUserAdmin=$scope.userselection.isUserAdmin;
        var userSelectedApplication     = $scope.userSelectedApplication;
        var userSelectedApplicationName = $scope.userSelectedApplicationName;
        var selectBusinessUnitApplications  = $scope.selectBusinessUnitApplications;
        var uniqueSubCategoryId   = [];
        var uniqueSubCategory = [];
        var uniqueSubCategories=[];
        var uniqueAgileSubCategories=[];
        var uniqueSubCategoryAverageList = [];
        var subCategoryLevelDataView = [];
        var selectedCategoryId = 0;

        var subCategories=[];
        console.log(userSelectedCategory);
        if(userSelectedCategory == undefined){
            userSelectedCategory = $scope.userSelectedCategory
        }
        console.log($scope.uniqueCategoryList);
        for (var i=0;i<$scope.uniqueCategoryList.length;i++){

            if(userSelectedCategory == $scope.uniqueCategoryList[i].category){

                selectedCategoryId = $scope.uniqueCategoryList[i].categoryId;
                i = $scope.uniqueCategoryList.length;
            }
        }

        $scope.userSelectedCategory =  userSelectedCategory
        console.log(selectedCategoryId);
        console.log($scope.categoryLevelDataView);
        for(var m=0;m<selectBusinessUnitApplications.length;m++) {
            var uniqueSubCategoryAverageAdminScore = [];
            var uniqueSubCategoryAverageUserScore = [];
            // Don't Know Why this Below Line was Required
            //userSelectedApplication = selectBusinessUnitApplications[m];

            for (var i = 0; i < $scope.categoryLevelDataView.length; i++) {
                if (parseInt(selectedCategoryId) == parseInt($scope.categoryLevelDataView[i].categoryId)) {

                    subCategoryLevelDataView = $scope.categoryLevelDataView[i].subCategoryList;

                }
            }
            for(var i=0;i<subCategoryLevelDataView.length;i++){
                var k=0;

                if(!(uniqueSubCategories.indexOf(subCategoryLevelDataView[i].subCategoryId)!=-1)) {
                    console.log("helllooooooooooooooooooo");
                    var averageSubAdmin=0;
                    var averageSubUser=0;
                    for (var j = 0; j < subCategoryLevelDataView.length; j++) {
                        if (subCategoryLevelDataView[j].subCategoryId == subCategoryLevelDataView[i].subCategoryId) {
                            if (subCategoryLevelDataView[j].scoreAdmin == undefined) {
                                subCategoryLevelDataView[j].scoreAdmin = subCategoryLevelDataView[j].scoreUser;
                            }
                            averageSubAdmin = averageSubAdmin + subCategoryLevelDataView[j].scoreAdmin;
                            averageSubUser = averageSubUser + subCategoryLevelDataView[j].scoreUser;
                            k++;

                            if (uniqueSubCategories.indexOf(subCategoryLevelDataView[j].subCategoryId) == -1) {
                                uniqueSubCategories.push(subCategoryLevelDataView[j].subCategoryId);
                                uniqueSubCategory.push(subCategoryLevelDataView[j].subCategory);
                            }
                        }
                    }

                    averageSubAdmin = averageSubAdmin / k;
                    averageSubUser = averageSubUser / k;

                    var uniqueSubCategoryList = {'averageSubAdmin':'','averageSubUser':''};
                    uniqueSubCategoryList.averageSubAdmin=averageSubAdmin;
                    uniqueSubCategoryList.averageSubUser=averageSubUser;
                    uniqueSubCategoryAverageList.push(uniqueSubCategoryList);
                }
            }
            console.log(uniqueSubCategories);
            console.log(uniqueSubCategory);
            console.log(uniqueSubCategoryAverageList);
            console.log(subCategoryLevelDataView);
            console.log($scope.categoryLevelDataView);

                if(selectedCategoryId==26){
                    for (var i = 0; i < subCategoryLevelDataView.length; i++) {
                        if (uniqueAgileSubCategories.indexOf(subCategoryLevelDataView[i].subCategoryId) == -1) {
                            uniqueAgileSubCategories.push(subCategoryLevelDataView[i].subCategoryId);
                            uniqueSubCategory.push(subCategoryLevelDataView[i].subCategory);
                            if (subCategoryLevelDataView[i].averageSubAdmin == undefined) {
                                subCategoryLevelDataView[i].averageSubAdmin = subCategoryLevelDataView[i].averageSubUser;
                            }
                            uniqueSubCategoryAverageAdminScore.push(subCategoryLevelDataView[i].averageSubAdmin);
                            uniqueSubCategoryAverageUserScore.push(subCategoryLevelDataView[i].averageSubUser);
                        }
                    }
                }else {
                            for(var j=0;j<uniqueSubCategoryAverageList.length;j++) {
                                uniqueSubCategoryAverageAdminScore.push(uniqueSubCategoryAverageList[j].averageSubAdmin);
                                uniqueSubCategoryAverageUserScore.push(uniqueSubCategoryAverageList[j].averageSubUser);
                            }
                 }

            console.log(subCategoryLevelDataView);
            console.log(uniqueSubCategory.length);
            if(isUserAdmin=="isAdmin") {
                var subCategory = {
                    name: $scope.userSelectedApplicationName,
                    data: uniqueSubCategoryAverageAdminScore,
                    pointPlacement: 'on',
                    lineWidth:4,
                    color:'#2e6da4'
                }

                subCategories.push(subCategory);
            }
            else if(isUserAdmin=="isUser"){
                var subCategory = {
                    name: $scope.userSelectedApplicationName,
                    data: uniqueSubCategoryAverageUserScore,
                    pointPlacement: 'on',
                    lineWidth:4,
                    color:'#2e6da4'
                }

                subCategories.push(subCategory);
            }
        }
        $scope.userSelectedCategoryId=selectedCategoryId;
        $scope.subCategoryLevelDataView=subCategoryLevelDataView;
        //$scope.showHighchart(subCategories,uniqueSubCategory);
        Highcharts.chart('container', {

            chart: {
                polar: true,
                type: 'line',
                events: {
                    click: function (ev) {
                        // Not working as in Now
                        console.log(this);
                        //angular.element(document.getElementById('myText')).scope().showDetails();
                    }
                }
            },
            plotOptions: {
                series: {
                    cursor: 'pointer',
                    point: {
                        events: {
                            click: function () {
                                //angular.element(document.getElementById('myText')).scope().showAHISubCategories(this.category,4);
                                $scope.showAHISubCategories(this.category,4);
                            }
                        }
                    }
                }
            },
            title: {
                text: '',
                x: -80
            },

            pane: {
                size: '80%'
            },
            credits:{
                enabled:false
            },
            xAxis: {
                categories: uniqueSubCategory,
                tickmarkPlacement: 'on',
                lineWidth: 0,
                labels: {
                    style: {
                        fontSize:'18px',
                        fontWeight:'bold'
                    }
                }
            },

            yAxis: {
                gridLineInterpolation: 'polygon',
                gridLineColor:'#C0C0C0',
                gridLineWidth:2,
                lineColor:'#C0C0C0',
                min: 0,
                max: 5,
                tickInterval: 1
            },

            tooltip: {
                shared: false,
                formatter: function () {
                    return ''+Highcharts.numberFormat(this.y,2)+'';
                }
            },

            legend: {
                align: 'right',
                verticalAlign: 'top',
                y: 70,
                layout: 'vertical'
            },

            series: subCategories

        });

    }

    $scope.showAHISubCategories=function(userSelectedAHICategory,graphLevel){
        console.log($scope.userSelectedCategoryId);
        if(parseInt($scope.userSelectedCategoryId)!= 26 ){
            return false;
        }

        $scope.graphLevel = 4;
        var isUserAdmin=$scope.userselection.isUserAdmin;
        var selectBusinessUnitApplications  = $scope.selectBusinessUnitApplications;
        var uniqueSubCategoryId   = [];
        var uniqueAHISubCategory = [];
        var uniqueAHISubCategories=[];
        var uniqueAgileSubCategories=[];
        var uniqueSubCategoryAverageList = [];
        var subCategoryAHILevelDataView = [];
        var userSelectedAHICategoryId = 0;
        var averageSubAHIAdmin=0;
        var averageSubAHIUser=0;
        var k=0;
        var subCategoriesAHI=[];

        console.log(userSelectedAHICategory);
        if(userSelectedAHICategory == undefined){
            userSelectedAHICategory = $scope.userSelectedAHICategory;
        }
        $scope.userSelectedAHICategory=userSelectedAHICategory;
        //console.log($scope.uniqueCategoryList);
        for (var i=0;i<$scope.subCategoryLevelDataView.length;i++){

            if(userSelectedAHICategory == $scope.subCategoryLevelDataView[i].subCategory){

                userSelectedAHICategoryId = $scope.subCategoryLevelDataView[i].subCategoryId;
                i = $scope.subCategoryLevelDataView.length;
            }
        }
        //
        //$scope.userSelectedCategory =  userSelectedCategory
        //console.log(selectedCategoryId);
        console.log($scope.subCategoryLevelDataView);
        for(var m=0;m<selectBusinessUnitApplications.length;m++) {
            var uniqueSubCategoryAHIAverageAdminScore = [];
            var uniqueSubCategoryAHIAverageUserScore = [];
            // Don't Know Why this Below Line was Required
            //userSelectedApplication = selectBusinessUnitApplications[m];

            for (var i = 0; i < $scope.subCategoryLevelDataView.length; i++) {
                if (parseInt(userSelectedAHICategoryId) == parseInt($scope.subCategoryLevelDataView[i].subCategoryId)) {

                    subCategoryAHILevelDataView = $scope.subCategoryLevelDataView[i].subCategory2List;

                }
            }
            console.log(subCategoryAHILevelDataView);
            for(var i=0;i<subCategoryAHILevelDataView.length;i++){
                k=0;
                if(!(uniqueAHISubCategories.indexOf(subCategoryAHILevelDataView[i].subCategory2Id)!=-1)) {

                                var averageSubAHIAdmin=0;
                                var averageSubAHIUser=0;
                                for (var j = 0; j < subCategoryAHILevelDataView.length; j++) {
                                    if (subCategoryAHILevelDataView[j].subCategory2Id == subCategoryAHILevelDataView[i].subCategory2Id) {
                                        console.log("Inside if condition");
                                        if (subCategoryAHILevelDataView[j].scoreAdmin == undefined) {
                                            subCategoryAHILevelDataView[j].scoreAdmin = subCategoryAHILevelDataView[j].scoreUser;
                                        }
                                        averageSubAHIAdmin = averageSubAHIAdmin + subCategoryAHILevelDataView[j].scoreAdmin;
                                        averageSubAHIUser = averageSubAHIUser + subCategoryAHILevelDataView[j].scoreUser;
                                        k++;

                                        if (uniqueAHISubCategories.indexOf(subCategoryAHILevelDataView[j].subCategory2Id) == -1) {
                                            uniqueAHISubCategories.push(subCategoryAHILevelDataView[j].subCategory2Id);
                                            uniqueAHISubCategory.push(subCategoryAHILevelDataView[j].subCategory2);
                                        }
                                    }
                                }

                                averageSubAHIAdmin = averageSubAHIAdmin / k;
                                averageSubAHIUser = averageSubAHIUser / k;

                    uniqueSubCategoryAHIAverageAdminScore.push(averageSubAHIAdmin);
                    uniqueSubCategoryAHIAverageUserScore.push(averageSubAHIUser);
                }
            }
            if(isUserAdmin=="isAdmin") {
                        var subCategoryAHI = {
                            name: $scope.userSelectedApplicationName,
                            data: uniqueSubCategoryAHIAverageAdminScore,
                            pointPlacement: 'on',
                            lineWidth:4,
                            color:'#2e6da4'
                        }

                        subCategoriesAHI.push(subCategoryAHI);
            }
            else if(isUserAdmin=="isUser") {
                var subCategoryAHI = {
                    name: $scope.userSelectedApplicationName,
                    data: uniqueSubCategoryAHIAverageUserScore,
                    pointPlacement: 'on',
                    lineWidth: 4,
                    color: '#2e6da4'
                }

                subCategoriesAHI.push(subCategoryAHI);
            }
        }

        ////$scope.showHighchart(subCategories,uniqueSubCategory);
        Highcharts.chart('container', {

            chart: {
                polar: true,
                type: 'line',
                events: {
                    click: function (ev) {
                        // Not working as in Now
                        console.log(this);
                        //angular.element(document.getElementById('myText')).scope().showDetails();
                    }
                }
            },
            credits:{
                enabled:false
            },
            plotOptions: {
                series: {
                    cursor: 'pointer',
                    point: {
                        events: {
                            click: function () {
                                //angular.element(document.getElementById('myText')).scope().showLevelGraph(this.category);
                            }
                        }
                    }
                }
            },
            title: {
                text: '',
                x: -80
            },

            pane: {
                size: '80%'
            },

            xAxis: {
                categories: uniqueAHISubCategory,
                tickmarkPlacement: 'on',
                lineWidth: 0,
                labels: {
                    style: {
                        fontSize:'18px',
                        fontWeight:'bold'
                    }
                }
            },

            yAxis: {
                gridLineInterpolation: 'polygon',
                gridLineColor:'#C0C0C0',
                gridLineWidth:2,
                lineColor:'#C0C0C0',
                min: 0,
                max: 5,
                tickInterval: 1
            },

            tooltip: {
                shared: false,
                formatter: function () {
                    return ''+Highcharts.numberFormat(this.y,2)+'';
                }
            },

            legend: {
                align: 'right',
                verticalAlign: 'top',
                y: 70,
                layout: 'vertical'
            },

            series: subCategoriesAHI

        });

    }
    $scope.showHighchart = function(userSelectedView,userSelectedViewName){
        console.log("hello");
        Highcharts.chart('container', {

            chart: {
                polar: true,
                type: 'line',
                events: {
                    click: function (ev) {
                        // Not working as in Now
                        console.log(this);
                        //angular.element(document.getElementById('myText')).scope().showDetails();
                    }
                }
            },
            plotOptions: {
                series: {
                    cursor: 'pointer',
                    point: {
                        events: {
                            click: function () {
                                angular.element(document.getElementById('myText')).scope().showLevelGraph(this.category);
                            }
                        }
                    }
                }
            },
            title: {
                text: '',
                x: -80
            },

            pane: {
                size: '80%'
            },

            xAxis: {
                categories: userSelectedViewName,
                tickmarkPlacement: 'on',
                lineWidth: 0,
                labels: {
                    style: {
                        fontSize:'18px',
                        fontWeight:'bold'
                    }
                }
            },

            yAxis: {
                gridLineInterpolation: 'polygon',
                lineWidth: 0,
                min: 0,
                max: 5,
                tickInterval: 1
            },

            tooltip: {
                shared: false,
                formatter: function () {
                    return ''+Highcharts.numberFormat(this.y,2)+'';
                }
            },

            legend: {
                align: 'right',
                verticalAlign: 'top',
                y: 70,
                layout: 'vertical'
            },

            series: userSelectedView

        });
    }
    $scope.showLevelGraph=function(userSelected){
        if(parseInt($scope.graphLevel) == 1){
            console.log(userSelected);
            $scope.showCategoryLevel(userSelected,2);
        }
        if(parseInt($scope.graphLevel) == 2){
            console.log(userSelected);
            $scope.showSubCategoryLevel(userSelected,3);
        }
        if(parseInt($scope.graphLevel) == 3){
            return false;
        }
    }
});

