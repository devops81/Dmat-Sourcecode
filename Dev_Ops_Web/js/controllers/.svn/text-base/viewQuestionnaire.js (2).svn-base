'use strict';
angular.module('genpactApp').controller('viewQuestionnaireCtrl', function($scope,$parse, $aside, $location, $localStorage, commonServices, $rootScope, $http,appConfig) {

    var EditQuestionDialogModel = function() {
        this.visible = false;
    };
    EditQuestionDialogModel.prototype.open = function(question,list) {

        this.questionnaireType = $scope.questionnaireType
        this.question = question;
        this.modelQuestion=question.questionName;
        this.indicativeValues=question.indicativeValues;
        this.modelAssessmentId=question.assessmentId.toString();
        this.modelCategoryId=question.categoryId.toString();
        this.modelsubcategoryId=question.subcategoryId.toString();
        this.modelQuestionId=question.questionId.toString();


        this.modelIndiValue1="";
        this.modelIndiValue2="";
        this.modelIndiValue3="";
        this.modelIndiValue4="";
        this.modelIndiValue5="";

        for(var i=0;i<this.indicativeValues.length;i++){

                var tempScoreString   = "modelScore"    +(i+1);
                var tempCheckedString = "modelCheck"    +(i+1);
                var tempValueString   = "modelIndiValue"+(i+1);

                this[tempScoreString]=(i+1);
                this[tempCheckedString]=true;
                this[tempValueString]=question.indicativeValues[i].value;
        }

        this.questionList=list;
        this.assessmentAreaList = $scope.assessmentAreaList;
        this.categoryList = $scope.categoryList;
        this.subCategoryList = $scope.subCategoryList;
        this.visible = true;
    };


    EditQuestionDialogModel.prototype.close = function(questionnaireType) {
        $scope.model.newIndiValueList=[];
        $scope.questionList=[];

        for(var i=1;i<6;i++){
            var the_string1="modelScore"+i ;
            var the_string2="modelCheck"+i ;
            var the_string3="modelIndiValue"+i;
            var tepmObj= {"score":$scope.model[the_string1],"checkedStatus":$scope.model[the_string2],"value":$scope.model[the_string3]};
            /*if(($scope.model[the_string3]=="")||($scope.model[the_string2]==false)){
                continue;
            }*/
            $scope.model.newIndiValueList.push(tepmObj)
        }
        var questionRequest="<?xml version='1.0' encoding='UTF-8'?><saveUpdateQuestion><questionnaireType>"+questionnaireType+"</questionnaireType>" +
            "<assessmentId>"+$scope.model.modelAssessmentId+"</assessmentId><categoryId>"+$scope.model.modelCategoryId+"</categoryId>" +
            "<subCategoryId>"+$scope.model.modelsubcategoryId+"</subCategoryId><questionId>"+$scope.model.modelQuestionId+"</questionId>" +
            "<questionText>"+$scope.model.modelQuestion+"</questionText><optionOne>"+$scope.model.modelIndiValue1+"</optionOne><optionTwo>"+$scope.model.modelIndiValue2+"</optionTwo>" +
            "<optionThree>"+$scope.model.modelIndiValue3+"</optionThree><optionFour>"+$scope.model.modelIndiValue4+"</optionFour><optionFive>"+$scope.model.modelIndiValue5+"</optionFive>" +
            "<isActive>true</isActive>" +
            "</saveUpdateQuestion>";

        $http({method: 'POST',url: appConfig.saveQuestionnaire,data: questionRequest,headers: { "Content-Type": 'application/xml'}}).success(function(data) {

            // To Update Indicative Values

            for(var i=0;i<$scope.model.questionList.length;i++){

                if($scope.model.questionList[i].questionId == $scope.model.modelQuestionId){

                    $scope.model.questionList[i].indicativeValues = $scope.model.newIndiValueList
                    $scope.model.questionList[i].questionName = $scope.model.modelQuestion
                    $scope.model.questionList[i].assessmentId = $scope.model.modelAssessmentId

                    for(var k = 0; k<$scope.model.assessmentAreaList.length;k++){
                        if($scope.model.modelAssessmentId == $scope.model.assessmentAreaList[k].assessmentId){
                            $scope.model.questionList[i].assessmentArea = $scope.model.assessmentAreaList[k].assessmentAreaName;
                        }
                    }


                    $scope.model.questionList[i].categoryId = $scope.model.modelCategoryId
                    for(var j = 0; j<$scope.model.categoryList.length;j++){
                        if($scope.model.modelCategoryId == $scope.model.categoryList[j].categoryId){
                            $scope.model.questionList[i].category   =   $scope.model.categoryList[j].categoryName
                        }
                    }

                    $scope.model.questionList[i].subcategoryId = $scope.model.modelsubcategoryId

                    for(var l = 0; l<$scope.model.subCategoryList.length;l++){
                        if($scope.model.modelsubcategoryId == $scope.model.subCategoryList[l].subcategoryId){
                            $scope.model.questionList[i].subCategory = $scope.model.subCategoryList[l].subCategoryName
                        }
                    }
                }
            }
        }).error(function () {
            console.log("  System Exception While Submitting the Querstion !!! ");
        });

        $scope.model.visible = false;
        this.visible = false;
    };

    $scope.editQuestionDialog = new EditQuestionDialogModel();

    $scope.init = function(questionnaireType) {
        $scope.questionnaireType= questionnaireType;
        $http.post(appConfig.getAssessmentAreas).success(function(data,status){

            if(typeof data=='object'){
                $scope.assessmentAreaList=data.response.detail.assessmentAreaList;
            }
        }).error(function(){
            console.log(" !!! Unable To Fetch Assessment Area !!!");
        })

        $http.post(appConfig.getCategories+questionnaireType).success(function(data,status){
            console.log("hey");
            if(typeof data=='object'){
                $scope.categoryList=data.response.detail.categoryDetails;
                console.log($scope.categoryList);
            }
        }).error(function(){
            console.log(" !!! Unable To Fetch Category !!!");
        })
        $http.post(appConfig.getSubCategories+questionnaireType).success(function(data,status){

            if(typeof data=='object'){
                $scope.subCategoryList=data.response.detail.subCategoryDetails;
                console.log($scope.subCategoryList);
            }
        }).error(function(){
            console.log(" !!! Unable To Fetch Sub Category Area !!!");
        })


        $scope.questionList=[];
        var questionDetail={  "questionId":"",
                              "questionName": "",
                              "assessmentId": "",
                              "assessmentArea": "",
                              "categoryId": "",
                              "category": "",
                              "subcategoryId": "",
                              "subCategory": "",
                              "indicativeValues":[{"value":"","score":""},{"value":"","score":""},{"value":"","score":""},{"value":"","score":""},{"value":"","score":""}],
                              "active":""}
        console.log(appConfig.viewQuestionnaire+questionnaireType);
        $http({
            method: 'POST',
            url: appConfig.viewQuestionnaire+questionnaireType,
            data:'',
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {

            if(data.response.header.statusCode==0){
                $scope.model.error=true;
            }else {
                    console.log(data.response.detail.questionDetails.length);
               for (var i=0;i<data.response.detail.questionDetails.length;i++){
                   var questionDetail={  "questionId":"",
                       "questionName": "",
                       "assessmentId": "",
                       "assessmentArea": "",
                       "categoryId": "",
                       "category": "",
                       "subcategoryId": "",
                       "subCategory": "",
                       "indicativeValues":[{"value":"","score":""},{"value":"","score":""},{"value":"","score":""},{"value":"","score":""},{"value":"","score":""}],
                       "active":""}

                    questionDetail.questionId=data.response.detail.questionDetails[i].questionId;
                    questionDetail.questionName=data.response.detail.questionDetails[i].questionName;
                    questionDetail.assessmentId=data.response.detail.questionDetails[i].assessmentId;
                    questionDetail.assessmentArea=data.response.detail.questionDetails[i].assessmentArea;
                    questionDetail.categoryId=data.response.detail.questionDetails[i].categoryId;
                    questionDetail.category=data.response.detail.questionDetails[i].category;
                    questionDetail.subcategoryId=data.response.detail.questionDetails[i].subcategoryId;
                    questionDetail.subCategory=data.response.detail.questionDetails[i].subCategory;
                    questionDetail.active=data.response.detail.questionDetails[i].active;

                    questionDetail.indicativeValues[0].score=1
                    questionDetail.indicativeValues[1].score=2
                    questionDetail.indicativeValues[2].score=3
                    questionDetail.indicativeValues[3].score=4
                    questionDetail.indicativeValues[4].score=5

                    questionDetail.indicativeValues[0].value=data.response.detail.questionDetails[i].optionOneVal
                    questionDetail.indicativeValues[1].value=data.response.detail.questionDetails[i].optionTwoVal
                    questionDetail.indicativeValues[2].value=data.response.detail.questionDetails[i].optionThreeVal
                    questionDetail.indicativeValues[3].value=data.response.detail.questionDetails[i].optionFourVal
                    questionDetail.indicativeValues[4].value=data.response.detail.questionDetails[i].optionFiveVal

                   $scope.questionList.push(questionDetail);

               }
               
               angular.forEach($scope.questionList,function(list,index) {
   	        	if (list.questionId == -1) {
   	        	  $scope.questionList.splice (index,1);
   	        	}

               });
                console.log($scope.questionList);
            }
        }).error(function () {
            console.log("  System Exception While Fetching The Application !!! ");
        });
        $scope.questionToDelete = "";
        $scope.searchQuestion = "";
        $scope.sortType = 'questionName'; // set the default sort type
        $scope.sortReverse = false;
    }



    $scope.confirmDelete = function() {
        var index = $scope.questionList.indexOf($scope.questionToDelete);
        if (index > -1) {
            $scope.questionList.splice(index, 1);
        }
    };

    $scope.back = function() {
        history.back();
    };

    $scope.navigateTo = function(path) {
        $location.url(path);
    };

});