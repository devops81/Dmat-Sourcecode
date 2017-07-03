'use strict';
angular.module('genpactApp').controller('addSubCategoryCtrl', function($scope, $aside, $location, $localStorage, commonServices, $rootScope, $http,appConfig) {

    //Adding Comment here for testing.
    // this represents the state of the dialog: a visible flag and the subCategory being edited
    var EditCategoryDialogModel = function() {
        this.visible = false;
    };
    EditCategoryDialogModel.prototype.open = function(subCategory,list,originalWeightage,subCategoryName,category,x,questionnaireType) {
        this.modelSubcategoryName=subCategory.subCategoryName;
        this.modelWeightage=subCategory.weightage
        this.modelSubCategoryId=subCategory.subcategoryId;
        this.subCategory = subCategory;

        this.modelCategoryID=subCategory.categoryId.toString();
        this.modelCategoryName=subCategory.categoryName;
        this.questionnaireType = questionnaireType;
        this.list= list;
        this.visible = true;

        var tempList= [ ];
        $http.post(appConfig.getCategories+questionnaireType).success(function(data,status){
            $scope.tempList=data.response.detail.categoryDetails;
            for(var i=0;i<data.response.detail.categoryDetails.length;i++) {
                var categoryData = {
                    "active": data.response.detail.categoryDetails[i].active,
                    "assessmentAreaName": data.response.detail.categoryDetails[i].assessmentAreaName,
                    "assessmentId": data.response.detail.categoryDetails[i].assessmentId,
                    "categoryId": data.response.detail.categoryDetails[i].categoryId,
                    "categoryName": data.response.detail.categoryDetails[i].categoryName,
                    "weightage": data.response.detail.categoryDetails[i].weightage
                }
                tempList.push(categoryData);
            }
            angular.forEach($scope.tempList,function(list,index) {
	        	if (list.categoryId == -1) {
	        	  $scope.tempList.splice (index,1);
	          }
	        });
        }).error(function(){
            console.log("Failed to access");
        })
        this.modelCategoryList=tempList;

    };

    EditCategoryDialogModel.prototype.save = function() {

        var totalweight=parseInt($scope.model.modelWeightage);

        for(var i=0;i<$scope.model.list.length;i++){
            if(($scope.model.list[i].category==$scope.model.modelCategoryName)&&($scope.model.list[i].subCategoryName==$scope.model.modelSubcategoryName)){

                continue;
            }
            totalweight=totalweight + parseInt($scope.model.list[i].weightage);

        }

        /*if(totalweight>100){
            $scope.model.error=true;
        }
        else{*/

            var assementDetailRequest="<saveSubCategoriesRequest><subCategoryId>"+$scope.model.modelSubCategoryId+"</subCategoryId><subCategoryName>"+$scope.model.modelSubcategoryName+"</subCategoryName><categoryId>"+$scope.model.modelCategoryID+"</categoryId><weightage>"+$scope.model.modelWeightage+"</weightage><isActive>true</isActive>" +
            		" <questionnaireType>"+$scope.model.questionnaireType+"</questionnaireType></saveSubCategoriesRequest>";

            $http({
                method: 'POST',
                url: appConfig.saveSubCategories,
                data: assementDetailRequest,
                headers: { "Content-Type": 'application/xml'}

            }).success(function(data) {

                if(data.response.header.statusCode===0){
                    $('#noDuplicate').modal('show');

                }else {

                    for(var i=0;i<$scope.model.list.length;i++){

                        if($scope.model.list[i].subcategoryId== $scope.model.modelSubCategoryId){

                            $scope.model.list[i].categoryName= $scope.model.modelCategoryName;
                            $scope.model.list[i].subCategoryName = $scope.model.modelSubcategoryName;
                            $scope.model.list[i].weightage = $scope.model.modelWeightage;

                            for(var j =0; j<$scope.model.modelCategoryList.length;j++){

                                if($scope.model.modelCategoryID == $scope.model.modelCategoryList[j].categoryId) {

                                    $scope.model.list[i].categoryName = $scope.model.modelCategoryList[j].categoryName;

                                    j = $scope.model.modelCategoryList.length;
                                    i = $scope.model.list.length;
                                }
                            }
                        }
                        $scope.flag=false;
                        $scope.model.error=false;
                        $scope.model.visible = false;
                    }
                }
            }).error(function () {
                console.log("  System Exception !!! ");
            });
       /* }*/
    };

    $scope.editCategoryDialog = new EditCategoryDialogModel();

    $scope.init = function(questionnaireType) {

        $scope.catSelected = false;
        $scope.subCategoryToDelete = "";
        $scope.subCategoryName = "";
        $scope.sortType = 'subCategoryName'; // set the default sort type
        $scope.sortReverse = false;

        $http({
            method: 'POST',
            url: appConfig.getSubCategories+questionnaireType,
            data: '',
            headers: { "Content-Type": 'application/xml'}

        }).success(function(data) {
            console.log(data);
            if(data.response.header.statusCode===0){
                $scope.model.error=true;
                //$('#noDuplicate').modal('show');
            }else {
                console.log(data.response.detail.subCategoryDetails);
                $scope.subCategoryList=data.response.detail.subCategoryDetails;
                angular.forEach($scope.subCategoryList,function(list,index) {
    	        	if (list.subcategoryId == -1) {
    	        	  $scope.subCategoryList.splice (index,1);
    	          }
    	        });
            }
        }).error(function () {
            console.log("  System Exception !!! ");
        });

        /*$scope.subCategoryList = [{
         "subCategoryName": "Monitoring",
         "category": "Monitor",
         "weightage": "20"
         },{
         "subCategoryName": "UI/UX Design",
         "category": "Design",
         "weightage": "10"
         }]*/

        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
        });

    }

    $scope.selectCategoryPopup = function(questionnaireType) {
        $('#categoryModal').modal('show');
        $scope.catSelected = true;
        $http({
            method: 'POST',
            url: appConfig.getCategories+questionnaireType,
            data:'',
            headers: { "Content-Type": 'application/xml'}

        }).success(function(data) {
            if(data.response.header.statusCode===0){
                $scope.model.error=true;
                //$('#noDuplicate').modal('show');
            }else {
                $scope.categories=data.response.detail.categoryDetails;
                angular.forEach($scope.categories,function(list,index) {
    	        	if (list.categoryId == -1) {
    	        	  $scope.categories.splice (index,1);
    	          }
    	        });
            }
        }).error(function () {
            console.log("  System Exception !!! ");
        });

    }
    /*$scope.categories = [{
     "categoryName": "Business Crticality"
     }, {
     "categoryName": "Monitor"
     }, {
     "categoryName": "Test"
     }
     ]*/

    $scope.currentCategory = '';

    $scope.showSelectedCategory = function(data) {
        var selectedCategory = {
            "name": "","ID":"0"
        };
        for(var i =0; i< $scope.categories.length; i++){
            if(data == $scope.categories[i].categoryId){
                selectedCategory.name=$scope.categories[i].categoryName;
                selectedCategory.ID=data;
                console.log($scope.categories[i].categoryName);
            }
        }
        $scope.selectedCategory = selectedCategory;
    }
    $scope.addSubCategory = function(questionnaireType) {
        var addSubCategory = {
            "subCategoryName": $scope.subCategoryName,
            "categoryId": $scope.selectedCategory.ID,
            "weightage":$scope.weight,
            "categoryName":$scope.selectedCategory.name,
            "subcategoryId":""
        };



        var weightage = 0;
        for(var i =0; i< $scope.subCategoryList.length; i++){
            if($scope.selectedCategory == $scope.subCategoryList[i].category){

                weightage = weightage + parseInt($scope.subCategoryList[i].weightage);
            }
        }
        weightage = weightage + parseInt($scope.weight);
       /* if (weightage >100) {
            // error modal
            $('#errorModal').modal('show');
        }
        else {*/

            var assementDetailRequest="<saveSubCategoriesRequest><subCategoryId>-1</subCategoryId><subCategoryName>"+$scope.subCategoryName+"</subCategoryName><categoryId>"+$scope.selectedCategory.ID+"</categoryId><weightage>"+$scope.weight+"</weightage><isActive>true</isActive>}<questionnaireType>"+questionnaireType+"</questionnaireType></saveSubCategoriesRequest>";
            $http({
                method: 'POST',
                url: appConfig.saveSubCategories,
                data: assementDetailRequest,
                headers: { "Content-Type": 'application/xml'}

            }).success(function(data) {

                if(data.response.header.statusCode===0){
                    $('#noDuplicate').modal('show');

                }else {
                    console.log("data.response.detail.subCategoryId");
                    console.log(data.response.detail.subCategoryId);
                    addSubCategory.subcategoryId=data.response.detail.subCategoryId;
                }
            }).error(function () {
                console.log("  System Exception !!! ");
            });

            $scope.subCategoryList.push(addSubCategory);
            $scope.subCategoryName = "";
            $scope.selectedCategory = "";
            $scope.weight = "";
        /*}*/
    };

    $scope.deleteSubCategory = function(subCategory,questionnaireType) {
        subCategory.toggledColor=!subCategory.toggledColor;
        if(subCategory.active == true){
            subCategory.active=false;
            subCategory.isClickable=!subCategory.isClickable;
        }else if(subCategory.active==false){
            subCategory.active=true;
            subCategory.isClickable=!subCategory.isClickable;
        }
        console.log("checking changed value of activeFlag"+subCategory.active)
        subCategory.isClickable=!subCategory.isClickable;
        $scope.deactivateColorChange=true;


        var assementDetailRequest="<saveSubCategoriesRequest><subCategoryId>"+subCategory.subcategoryId+"</subCategoryId><subCategoryName>"+subCategory.subCategoryName+"</subCategoryName><categoryId>"+subCategory.categoryId+"</categoryId><weightage>"+subCategory.weightage+"</weightage><isActive>"+subCategory.active+"</isActive><questionnaireType>"+questionnaireType+"</questionnaireType></saveSubCategoriesRequest>";

        $http({
            method: 'POST',
            url: appConfig.saveSubCategories,
            data: assementDetailRequest,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
            console.log(data);
            if(data.response.header.statusCode==0){
                $scope.model.error=true;
            }else {
                console.log("data.response.detail.subCategoryId");
                console.log(data.response.detail.subCategoryId);
                addSubCategory.subcategoryId=data.response.detail.subcategoryId;
            }
        }).error(function () {
            console.log("  System Exception While Fetching The Application !!! ");
        });


    /*    console.log("Checking subcategory in deactivation");
        console.log(subCategory);
        $scope.subCategoryToDelete = subCategory;
        $('#confirmDelete').modal('show');*/
    };

    $scope.confirmDelete = function() {

        var index = $scope.subCategoryList.indexOf($scope.subCategoryToDelete);
        if (index > -1) {
            $scope.subCategoryList.splice(index, 1);
        }
        console.log($scope.subCategoryToDelete.subCategoryName);
    };
    $scope.back = function() {
        history.back();
    };
    $scope.navigateTo = function(path) {
        $location.url(path);
    };

});