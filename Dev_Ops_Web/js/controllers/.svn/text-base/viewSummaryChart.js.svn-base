'use strict';
angular.module('genpactApp').controller('viewSummaryChart', function($scope, $aside, $location, $localStorage,$rootScope,$http,userService,appConfig) {

    $scope.init = function() {


        $scope.summaryList='';
        $scope.assessmentAreas='';

        var uniqueSubCategory=[];
        var uniqueCategory=[];
        var uniqueAssessmentArea=[];
        var uniqueApplicationName=[];
        var subCategoryList=[];
        var categoryList=[];
        var assessmentAreaList=[];
        var applicationList=[];

        var viewQuestionReport = "<?xml version='1.0' encoding='UTF-8'?><viewQuestionDetails><applicationId>-1</applicationId></viewQuestionDetails>";
        $http({
            method: 'POST',
            url: appConfig.viewQuestionResponse,
            data: viewQuestionReport,
            headers: { "Content-Type": 'application/xml'}

            /* $http({
             method: 'GET',
             url: './data/summaryChartData_2.json',
             data: ''*/
        }).success(function (data) {
            var responseDataList = data.response.detail.questionResponseDetails;

            for(var i=0;i<responseDataList.length;i++){

                // Uniquely Filter The Sub Category

                if (uniqueSubCategory.indexOf(responseDataList[i].subCategoryId) == -1) {

                    var subCategory={'subCategoryId':'','subCategory':'','subCategoryScore':''}
                    uniqueSubCategory.push(responseDataList[i].subCategoryId);
                    subCategory.subCategoryId   = responseDataList[i].subCategoryId;
                    subCategory.subCategory = responseDataList[i].subCategory;

                    subCategoryList.push(subCategory);
                }

                // Uniquely Filter The Category

                if (uniqueCategory.indexOf(responseDataList[i].categoryId) == -1) {

                    var category={'categoryId':'','category':'','categoryScore':''}
                    uniqueCategory.push(responseDataList[i].categoryId);
                    category.categoryId   = responseDataList[i].categoryId;
                    category.category = responseDataList[i].category;

                    categoryList.push(category);
                }

                // Uniquely Filter The Assessment Areas - For Heading

                if (uniqueAssessmentArea.indexOf(responseDataList[i].assessmentId) == -1) {

                    var assessmentArea={'assessmentId':'','assessmentArea':'','assessmentScore':[]}
                    uniqueAssessmentArea.push(responseDataList[i].assessmentId);
                    assessmentArea.assessmentId   = responseDataList[i].assessmentId;
                    assessmentArea.assessmentArea = responseDataList[i].assessmentArea;
                    assessmentAreaList.push(assessmentArea);
                }

                // Uniquely Filter The applicationName For left Hand Heading On the page

                if (uniqueApplicationName.indexOf(responseDataList[i].applicationId) == -1) {

                    var application=[{"ID":"","reportId":"","applicationId":"","applicationName":"","assessmentAreaList":"","categoryList":"","subCategoryList":""}];
                    uniqueApplicationName.push(   responseDataList[i].applicationId);
                    application.applicationId   = responseDataList[i].applicationId;
                    application.applicationName = responseDataList[i].applicationName;
                    applicationList.push(application);
                }
            }

            //console.log(responseDataList);

            for(var i=0;i<applicationList.length;i++){

                applicationList[i].assessmentAreaList=angular.copy(assessmentAreaList);
                applicationList[i].categoryList=angular.copy(categoryList);
                applicationList[i].subCategoryList=angular.copy(subCategoryList);
            }

            // Trying to Build a Matrix to render the Data Using One ng-Repeat
            // First , It will iterate the Application List
            // It will then match the application ID and response data list
            // Once matching ID is found then it will find the matching assessment area and re iterate
            // for the complete assessmentAreaList

            for (var i =0;i<applicationList.length;i++){

                for(var j=0; j<responseDataList.length;j++){

                    if (applicationList[i].applicationId == responseDataList[j].applicationId) {

                        for(var k=0; k<applicationList[i].assessmentAreaList.length; k++){

                            if (applicationList[i].assessmentAreaList[k].assessmentId == responseDataList[j].assessmentId){

                                applicationList[i].assessmentAreaList[k].assessmentScore = responseDataList[j].scoreAdmin;
                            }
                        }
                        for(var m=0; m<applicationList[i].categoryList.length; m++){

                            if (applicationList[i].categoryList[m].categoryId == responseDataList[j].categoryId){


                                applicationList[i].categoryList[m].categoryScore = responseDataList[j].scoreAdmin;
                            }
                        }
                        for(var n=0; n<applicationList[i].subCategoryList.length; n++){

                            if (applicationList[i].subCategoryList[n].subCategoryId == responseDataList[j].subCategoryId){

                                applicationList[i].subCategoryList[n].subCategoryScore = responseDataList[j].scoreAdmin;
                            }
                        }
                    }
                }
            }

            $scope.summaryList=applicationList;
            $scope.assessmentAreas=assessmentAreaList;
            $scope.categories=categoryList;
            $scope.subCategories=subCategoryList;


        }).error(function () {
            console.log("  Error Occurred While Fetching the Data !!! ");
        });
    }

    $scope.showDetails = function(graphLevel) {

        if(graphLevel == '0') {
            $("#assessmentDiv").show();
            $("#categoryDiv").hide();
            $("#subCategoryDiv").hide();
        }

        if(graphLevel == '1') {
            $("#assessmentDiv").hide();
            $("#categoryDiv").show();
            $("#subCategoryDiv").hide();
        }

        if(graphLevel == '2') {
            $("#assessmentDiv").hide();
            $("#categoryDiv").hide();
            $("#subCategoryDiv").show();
        }
    }

});
