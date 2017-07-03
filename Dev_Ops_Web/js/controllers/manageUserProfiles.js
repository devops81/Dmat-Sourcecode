'use strict';
angular.module('genpactApp').controller('manageUserProfilesCtrl', function($scope,$http,appConfig,commonDataFactory) {

$scope.init = function() {

    $http({method: 'POST',url: appConfig.fetchUserProfile, headers: { "Content-Type": 'application/xml'}
    }).success(function(data) {
        commonDataFactory.setUserProfileList(data.response.details.userProfileDetails);

        var userProfileList = commonDataFactory.getUserProfileList();

        var userProfileDataList=[];
        // roleName="Assessor:true:true:false";

        for(var i=0;i<userProfileList.length;i++){

           if(userProfileList[i].roleId !='2' && userProfileList[i].roleId !='3'){
            var userProfileData={'employeeId':'','userId':'','name':'','accountId':'','accountName':'','businessNeedActive':'','businessEnvNeedActive':'','deliveryMaturityActive':'','roleName':'Assessor:0:1:1'}

            userProfileData.employeeId  = userProfileList[i].employeeId;
               userProfileData.userId   = userProfileList[i].userId;
            userProfileData.accountId   = userProfileList[i].accountId;
            userProfileData.accountName = userProfileList[i].accountName;
            userProfileData.name        = userProfileList[i].name;
            userProfileData.roleName    = userProfileList[i].roleName;
            userProfileData.roleId      = userProfileList[i].roleId;
            userProfileData.password    = userProfileList[i].password;

            console.log(userProfileList[i]);

            // 0 means Off & 1 means On

           if(userProfileData.password.includes(":")){

                userProfileData.businessNeedActive     = parseInt(userProfileData.password.split(":")[1]);
                userProfileData.businessEnvNeedActive  = parseInt(userProfileData.password.split(":")[2]);
                userProfileData.deliveryMaturityActive = parseInt(userProfileData.password.split(":")[3]);
           }else{

                userProfileData.businessNeedActive     = 0;
                userProfileData.businessEnvNeedActive  = 0;
                userProfileData.deliveryMaturityActive = 0;
                userProfileData.password=userProfileData.password+":"+userProfileData.businessNeedActive+":"+userProfileData.businessEnvNeedActive+":"+userProfileData.deliveryMaturityActive;
           }
            userProfileDataList.push(userProfileData);
          //  console.log(userProfileData);
        }

        $scope.userProfileDataList = userProfileDataList;
        /*console.log(userProfileList);
        console.log(userProfileDataList);
*/
            }
    }).error(function () {
        console.log("  System Exception While Fetching The Application !!! ");
    });
}

    $scope.updateUserProfile = function(userProfileDataList,userData,assessmentId) {


        for (var i=0;i<userProfileDataList.length;i++){
                console.log(userProfileDataList[i].password);
        }

        var businessNeedActive     = parseInt(userData.password.split(":")[1]);
        var businessEnvNeedActive  = parseInt(userData.password.split(":")[2]);
        var deliveryMaturityActive = parseInt(userData.password.split(":")[3]);

        if(parseInt(assessmentId) == 1){

            if(parseInt(userData.password.split(":")[1])== 0){
                businessNeedActive=1;
            }else{
                businessNeedActive=0;
            }
        }
        if(parseInt(assessmentId) == 2){
            if(parseInt(userData.password.split(":")[2])== 0){
                businessEnvNeedActive=1;
            }else{
                businessEnvNeedActive=0;
            }
        }
        if(parseInt(assessmentId) == 3){
            if(parseInt(userData.password.split(":")[3])== 0){
                deliveryMaturityActive=1;
            }else{
                deliveryMaturityActive=0;
            }
        }



        userData.password = userData.password.split(":")[0]+":"+businessNeedActive+":"+businessEnvNeedActive+":"+deliveryMaturityActive;
        userData.employeeId=userData.employeeId.toString();
        var editProfileDetail="<?xml version='1.0' encoding='UTF-8'?><saveUpdateProfile><saveOrUpdate>0</saveOrUpdate><employeeId>"+userData.employeeId+"</employeeId><name>" + userData.accountName +"</name><roleId>"+ userData.roleId+"</roleId><accountId>"+ userData.accountId+"</accountId><password>"+userData.password+"</password><isActive>true</isActive></saveUpdateProfile>";
        console.log(editProfileDetail);
        for (var i=0;i<userProfileDataList.length;i++){

            if( userProfileDataList[i].employeeId == parseInt(userData.employeeId)  ){
                userProfileDataList[i].password   =  userData.password;
                $scope.userProfileDataList        =  userProfileDataList;
            }
        }

        $http({method: 'POST',url: appConfig.saveUpdateProfile,data: editProfileDetail,headers: { "Content-Type": 'application/xml'}}).success(function(data) {
            console.log("Success");
            window.localStorage.accessLevel = userData.password;
        }).error(function () {
            console.log("System Exception !!! ");
        });

    }
});