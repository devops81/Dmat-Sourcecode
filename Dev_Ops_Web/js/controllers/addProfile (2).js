'use strict';
angular.module('genpactApp').controller('addProfileCtrl', function($scope, $aside, $location, $localStorage, commonServices, $rootScope, $http,appConfig) {


    // this represents the state of the dialog: a visible flag and the category being edited
    var EditCategoryDialogModel = function() {
        this.visible = false;
    };
    EditCategoryDialogModel.prototype.open = function(category) {
        this.category = category;

        this.visible = true;
    };
    EditCategoryDialogModel.prototype.close = function() {
        this.visible = false;
    };
    $(document).ready(function(){
        $('[data-toggle="tooltip"]').tooltip();
    });

    $(document).ready(function(){
        $('[data-toggle="popover"]').popover();
    });

    $scope.editCategoryDialog = new EditCategoryDialogModel();
    $scope.profileIndex = "";
    $scope.init = function() {
        $scope.categoryToDelete = "";
        $scope.categoryName = "";

    }
    $scope.sortType = 'categoryName'; // set the default sort type
    $scope.sortReverse = false;


    $scope.typePassword="password";
    $scope.addRoleId = "";
    $scope.addAccountId = "";

    $scope.showPassIcon = true;
    $scope.hidePassIcon = false;
    
    $scope.showPassword = function(){
        $scope.typePassword ="text";
        $scope.showPassIcon = false;
        $scope.hidePassIcon = true;
    }
    
     $scope.hidePassword = function(){
        $scope.typePassword ="password";
        $scope.showPassIcon = true;
        $scope.hidePassIcon = false;
    }


    $scope.typeNewPassword="password";
    $scope.showPaswrdIcon = true;
    $scope.hidePaswrdIcon = false;

    $scope.showNewPassword = function(){
        $scope.typeNewPassword ="text";
        $scope.showPaswrdIcon = false;
        $scope.hidePaswrdIcon = true;
    }

    $scope.hideNewPassword = function(){
        $scope.typeNewPassword ="password";
        $scope.showPaswrdIcon = true;
        $scope.hidePaswrdIcon = false;
    }

    $scope.showHidePassword=function(checkboxPassword){
        console.log(checkboxPassword);
        if(checkboxPassword=="Hide"){
            $scope.typePassword="password";
            $scope.showHide="Show";
        }
        else{
            $scope.typePassword="text";
            $scope.showHide="Hide";
        }
    }

    $scope.profileList="";
    $scope.profileExist=false;
    $http.post(appConfig.fetchUserProfile).success(function(data,status){

             if(typeof data=='object'){
            	 $scope.profileList=data.response.details.userProfileDetails;
            	  angular.forEach($scope.profileList,function(list,index) {
   	     	        	if (list.employeeId == -1) {
   	     	        	  $scope.profileList.splice (index,1);
   	     	          }
   	     	        });
             }
         }).error(function(){
             console.log("Failed to access");
         })



 /*   $scope.profileList = [{
        "employeeId": "400220000",
        "name": "Alex",
        "roleName": "Assessor",
        "accountName": "Morgan Stanley"
    }, {
        "employeeId": "400210000",
        "name": "Richard",
        "roleName": "End User",
        "accountName": "CVS Caremark"
    }]*/
    
    $scope.resetValues=function(){
        $scope.profileExist=false;
    }
    $scope.addProfile = function() {
        $scope.myForm.addEmpGuestId.$dirty=false;
        $scope.myForm.addProfileName.$dirty=false;
        $scope.myForm.addpassword.$dirty=false;
        $scope.myForm.rePassword.$dirty=false;
        $scope.rePassword='';
        if($scope.addRoleId==1)
        {
            $scope.addPassword=$scope.addPassword+":"+0+":"+0+":"+0;
            console.log($scope.addPassword);
        }

        var addProfile = {
            "name": $scope.addProfileName,
            "roleName":$scope.addProfileRole,
            "roleId":$scope.addRoleId,
            "accountName":$scope.addProfileAccount,
            "accountId":$scope.addAccountId,
            "employeeId": $scope.addEmpGuestId,
            "password": $scope.addPassword,
            "userId":$scope.addEmpGuestId,
            "activeFlag":1
        };
        for(var i=0;i<$scope.profileList.length;i++){
            console.log($scope.profileList[i].userId);
            if($scope.profileList[i].userId == addProfile.employeeId||$scope.profileList[i].userId.toString().toLowerCase()==addProfile.employeeId.toLowerCase()){
                console.log("Counter-->"+i);
                $scope.profileExist=true;
                break;
            }
        }

        if($scope.profileExist!=true) {

            var profileDetail = "<?xml version='1.0' encoding='UTF-8'?><saveUpdateProfile><saveOrUpdate>1</saveOrUpdate><employeeId>" + $scope.addEmpGuestId + "</employeeId><name>" + $scope.addProfileName + "</name><roleId>" + $scope.addRoleId + "</roleId><accountId>" + $scope.addAccountId + "</accountId><password>" + $scope.addPassword + "</password><isActive>true</isActive></saveUpdateProfile>";
            console.log($scope.profileList);
            $http({
                method: 'POST',
                url: appConfig.saveUpdateProfile,
                data: profileDetail,
                headers: {"Content-Type": 'application/xml'}
            }).success(function (data) {
                $http.post(appConfig.fetchUserProfile).success(function (data, status) {

                    console.log(data);
                    for (var i = 0; i < data.response.details.userProfileDetails.length; i++) {

                        if (data.response.details.userProfileDetails[i].userId == addProfile.employeeId) {
                            console.log("yesss");
                            $scope.profileList.push(addProfile);
                            $scope.flag = false;
                            i = data.response.details.userProfileDetails.length;
                        }
                        $("#userSavedModal").modal("show");
                    }

                    angular.forEach($scope.profileList, function (list, index) {
                        if (list.employeeId == -1) {
                            $scope.profileList.splice(index, 1);
                        }
                    });

                }).error(function () {
                    console.log("Failed to access");
                })
            }).error(function () {
                console.log("  System Exception !!! ");
            });
        }
        $scope.addProfileName = "";
        $scope.addProfileRole = "";
        $scope.addProfileAccount = "";
        $scope.addEmpGuestId = "";
        $scope.addPassword = "";

    };

    $scope.editProfile = function(value, index) {
        console.log(index);
        $scope.profileIndex = index;
        $scope.profileName = value.Name;
        $scope.profileRole = value.Role;
        $scope.profileAccount = value.Account;
    }

    $scope.saveProfile = function() {

        $scope.profileList[$scope.profileIndex].Name = $scope.profileName;
        $scope.profileList[$scope.profileIndex].Role = $scope.profileRole;
        $scope.profileList[$scope.profileIndex].Account = $scope.profileAccount;
    }

    $scope.deleteProfile = function(editProfile,profileList,activeFlag) {
        var activeFlag='';

        if(editProfile.activeFlag=='0'){
            activeFlag = 'true'
        }
        if(editProfile.activeFlag=='1'){
            activeFlag = 'false'
        }

        var editProfileDetail="<?xml version='1.0' encoding='UTF-8'?><saveUpdateProfile><saveOrUpdate>0</saveOrUpdate><employeeId>"+editProfile.employeeId+"</employeeId><name>" + editProfile.name +"</name><roleId>"+ editProfile.roleId+"</roleId><accountId>"+ editProfile.accountId+"</accountId><password></password><isActive>"+activeFlag+"</isActive></saveUpdateProfile>";

        $http({
            method: 'POST',
            url: appConfig.saveUpdateProfile,
            data: editProfileDetail,
            headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
            $http.post(appConfig.fetchUserProfile).success(function(data,status){

                for(var i=0;i<data.response.details.userProfileDetails.length;i++) {

                    $scope.profileList= data.response.details.userProfileDetails;

                    if(data.response.details.userProfileDetails[i].employeeId == editProfile.employeeId ){

                        for(var j=0;j<$scope.profileList.length;j++) {

                            if($scope.profileList.employeeId == editProfile.employeeId ) {

                                $scope.profileList.employeeId = data.response.details.userProfileDetails[i].employeeId;
                                $scope.profileList.name = data.response.details.userProfileDetails[i].name;
                                $scope.profileList.roleName = data.response.details.userProfileDetails[i].roleName;
                                $scope.profileList.roleId = data.response.details.userProfileDetails[i].roleId;
                                $scope.profileList.accountid = data.response.details.userProfileDetails[i].accountId;
                                $scope.profileList.accountName = data.response.details.userProfileDetails[i].accountName;
                                $scope.profileList.activeFlag = data.response.details.userProfileDetails[i].activeFlag;
                                console.log(data.response.details.userProfileDetails[i].activeFlag);
                                i = data.response.details.userProfileDetails.length;


                            }
                        }
                    }
                }
                
	                angular.forEach($scope.profileList,function(list,index) {
	     	        if (list.employeeId == -1) {
	     	        	  $scope.profileList.splice (index,1);
	     	          }
	     	        });
            }).error(function(){
                console.log("Failed to access");
            })
        }).error(function () {
            console.log("System Exception !!! ");
        });

    };
    // Below code is to Open the Pop Up and then remove the same from the list
    /*$scope.deleteProfile = function(profile) {
        $scope.profileToDelete = profile;
        $('#confirmDelete').modal('show');
    };

    $scope.confirmDelete = function() {
        console.log($scope.profileToDelete)
        var index = $scope.profileList.indexOf($scope.profileToDelete);
        if (index > -1) {
            $scope.profileList.splice(index, 1);
        }
    };*/


    $scope.back = function() {
        history.back();
    };

    $scope.navigateTo = function(path) {
        $location.url(path);
    };
    $scope.addRole=function(){
        $("#addRoleModal").modal("show");
    }
   /* $scope.roleList=[
        {"role":"Assessor"},
        {"role":"Lead Assessor"},
        {"role":"End User"}
    ]*/

    $scope.roleList=""; 
    var roleDetail="<?xml version='1.0' encoding='UTF-8'?><role><isViewOnly>1</isViewOnly><saveOrUpdate></saveOrUpdate><roleId></roleId><roleName></roleName><isActive>true</isActive></role>";
    $http({
        method: 'POST',
        url: appConfig.handleRoles,
        data: roleDetail,
        headers: { "Content-Type": 'application/xml'}
    }).success(function(data,status){

             if(typeof data=='object'){

                 $scope.roleList=data.response.details.roleDetails;

             }
         }).error(function(){
             console.log("Failed to access");
         })
         
         
    $scope.selectedRole=function(value){
    	for(var i=0;i<$scope.roleList.length;i++){
    		
    		if($scope.roleList[i].roleId== value){
    			
    			$scope.addProfileRole=$scope.roleList[i].role;
    			$scope.addRoleId=value;
    		
    		}
    	}
    	
        
    }
    $scope.addAccount=function(){
        $("#addAccountModal").modal("show");
    }

    $scope.currentaccount = '';

    $scope.currentrole = '';

    /*$scope.accountList=[
        {"account":"Morgan Stanley"},
        {"account":"CVS Caremark"},
        {"account":"Otsuka"},
        {"account":"CACIB"}
    ]*/
    
    $scope.accountList=""; 
    var accountDetail="<?xml version='1.0' encoding='UTF-8'?><account><isViewOnly>1</isViewOnly><saveOrUpdate></saveOrUpdate><accountId></accountId><accountName></accountName><isActive>true</isActive></account>";
    $http({
        method: 'POST',
        url: appConfig.handleAccounts,
        data: accountDetail,
        headers: { "Content-Type": 'application/xml'}
    }).success(function(data,status){

             if(typeof data=='object'){

                 $scope.accountList=data.response.details.accountDetails;

             }
         }).error(function(){
             console.log("Failed to access");
         })
         


    $scope.selectedAccount=function(value){
    	for(var i=0;i<$scope.accountList.length;i++){
    		console.log("value "+value);
    		console.log("$scope.accountList[i].accountId "+ $scope.accountList[i].accountId);
    		if($scope.accountList[i].accountId == value){
    			console.log("value matched");
    			$scope.addProfileAccount=$scope.accountList[i].account;
    			$scope.addAccountId=value;
    			console.log('accountId'+ $scope.addAccountId);
    		}
    	}
    }

    var EditProfileDialogModel = function() {

        this.visible = false;
    };
    var isVarOneActive;
    var isVarTwoActive;
    var isVarThreeActive;

    EditProfileDialogModel.prototype.open = function(profile,profileList) {

        console.log(profileList);
      //  console.log(this.modelProfilePassword);
        this.accountList=$scope.accountList;
        this.roleList = $scope.roleList;
        this.profile=profile;

        this.modelAddEmpGuestId=profile.userId;
        this.modelProfileName=profile.name;
        this.modelProfileRole=profile.roleName;
        this.modelProfileRoleId=profile.roleId.toString();
        this.modelProfileAccountId=profile.accountId.toString();
        this.modelProfileAccount=profile.accountName;

        if(profile.roleName=='Assessor') {
            var pass = profile.password;
            console.log(pass);
            this.modelProfilePassword = pass.split(":")[0];
            isVarOneActive = pass.split(":")[1];
            isVarTwoActive = pass.split(":")[2];
            isVarThreeActive = pass.split(":")[3];
            console.log(typeof(isVarOneActive));
            console.log(isVarOneActive + isVarTwoActive +isVarThreeActive);
        }else
        {
            this.modelProfilePassword=profile.password;
        }

        this.originalAddEmpGuestId=profile.employeeId;
        this.originalProfileName=profile.name;
        this.originalProfileRole=profile.roleName;
        this.originalProfileAccount=profile.accountName;
        this.originalProfilePassword=profile.password;

        this.list=profileList;
        this.visible = true;




    };
    
  EditProfileDialogModel.prototype.close = function() {
      var employeeId=0;
      var profileList=[];
      for(var i=0;i<$scope.profileList.length;i++) {
          if($scope.profileList[i].userId==$scope.model.modelAddEmpGuestId) {
              console.log("hellooooooooooo");
              employeeId = $scope.profileList[i].employeeId;
              i=$scope.profileList.length;
          }
      }
      console.log(employeeId);
      var editProfile = {
              "name": $scope.model.modelProfileName,
              "roleName": $scope.model.modelProfileRole,
              "roleId":$scope.model.modelProfileRoleId,
              "accountId":$scope.model.modelProfileAccountId,
              "accountName": $scope.model.modelProfileAccount,
              "employeeId": employeeId,
                "password":$scope.model.modelProfilePassword,
                "userId":$scope.model.modelAddEmpGuestId
          };
        console.log($scope.profileList);


      console.log((isVarOneActive));
      for(var i=0;i<$scope.profileList.length;i++){

        //  console.log("$scope.accountList[i].password "+ $scope.profileList[i].password);
          if($scope.profileList[i].userId ==$scope.model.modelAddEmpGuestId ){
              console.log("ID Mached");
              if($scope.profileList[i].roleName=='Assessor'){
                  isVarOneActive =$scope.profileList[i].password.split(":")[1];
                  isVarTwoActive = $scope.profileList[i].password.split(":")[2];
                  isVarThreeActive = $scope.profileList[i].password.split(":")[3];
              editProfile.password=$scope.model.modelProfilePassword+":"+isVarOneActive+":"+isVarTwoActive+":"+isVarThreeActive;
              }
              else{
                  editProfile.password=$scope.model.modelProfilePassword;
              }
             console.log("passwordi is"+editProfile.password);
          }
      }

      console.log("$scope.model.modelAddEmpGuestId "+$scope.model.modelAddEmpGuestId);
      var editProfileDetail="<?xml version='1.0' encoding='UTF-8'?><saveUpdateProfile><saveOrUpdate>0</saveOrUpdate><employeeId>"+editProfile.employeeId+"</employeeId><name>" + editProfile.name +"</name><roleId>"+ editProfile.roleId+"</roleId><accountId>"+ editProfile.accountId+"</accountId><password>"+editProfile.password+"</password><isActive>true</isActive></saveUpdateProfile>";
    console.log(editProfileDetail);
      console.log(appConfig.saveUpdateProfile);
      $http({
          method: 'POST',
          url: appConfig.saveUpdateProfile,
          data: editProfileDetail,
          headers: { "Content-Type": 'application/xml'}
      }).success(function(updateData) {
          console.log(updateData);
           $http.post(appConfig.fetchUserProfile).success(function(data,status){
                      console.log('Display saved profiles');

               for(var i=0;i<data.response.details.userProfileDetails.length;i++) {
                   console.log(data);

                   console.log('data.response.details.userProfileDetails[i].employeeId'+data.response.details.userProfileDetails[i].employeeId);
                   profileList.push(data.response.details.userProfileDetails[i]);

                  if(data.response.details.userProfileDetails[i].userId == editProfile.userId ){
console.log("Checking if condition");

                      for(var j=0;j<$scope.model.list.length;j++) {

                          if($scope.model.list[j].employeeId == editProfile.employeeId ) {

                              $scope.model.list[j].employeeId = data.response.details.userProfileDetails[i].userId;
                              $scope.model.list[j].name = data.response.details.userProfileDetails[i].name;
                              $scope.model.list[j].roleName = data.response.details.userProfileDetails[i].roleName;
                              $scope.model.list[j].roleId = data.response.details.userProfileDetails[i].roleId;
                              $scope.model.list[j].accountid = data.response.details.userProfileDetails[i].accountId;
                              $scope.model.list[j].accountName = data.response.details.userProfileDetails[i].accountName;
                              $scope.flag = false;
                              $scope.model.error = false;
                              //$scope.model.visible = false;
                              i = data.response.details.userProfileDetails.length;
                              console.log("i" + i)
                              //break;
                          }
                      }
                   }
               }

               $scope.model.visible = false;
               $("#userUpdateModal").modal("show");
      }).error(function(){
          console.log("Failed to access");
      })
      }).error(function () {
          console.log("System Exception !!! ");
      });

      $scope.profileList=profileList;
      };
    $scope.editProfileDialog = new EditProfileDialogModel();
});