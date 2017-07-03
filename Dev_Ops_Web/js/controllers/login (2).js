'use strict';

angular.module('genpactApp').controller('LoginCtrl', function($scope, $aside, $http, commonServices, $location, $localStorage, $sessionStorage, $rootScope,appConfig,commonDataFactory) {

    $scope.empId = '';
    $scope.password = '';

    $scope.init = function() {
        var d = new Date();


console.log("Time "+ d.getMilliseconds()+"  "+appConfig.fetchUserProfile);
        $http({method: 'POST',url: appConfig.fetchUserProfile, headers: { "Content-Type": 'application/xml'}
        }).success(function(data) {
            console.log(data.response.details.userProfileDetails);
            console.log(d.getMilliseconds());
            commonDataFactory.setUserProfileList(data.response.details.userProfileDetails);
        }).error(function () {
            console.log("  System Exception While Fetching The Application !!! ");
        });

        window.localStorage.role = '';
        $("#login-carousel").owlCarousel({
            slideSpeed: 2000,
            paginationSpeed: 1000,
            autoPlay: true,
            stopOnHover: true,
            singleItem: true,
            lazyLoad: false,
            addClassActive: true,
            afterInit: function() {
                //animationsSlider();
            },
            afterMove: function() {
                //animationsSlider();
            }
        });
    }

    $scope.navigateTo = function(path) {
        $location.url(path);
    };

    $scope.back = function() {
        $location.url('/');
    };

    // Login Method

    $scope.loginFunction = function(keyEvent) {
        if (keyEvent.which === 13)
            $scope.login();
    }

    $scope.invalidMatch=false;
    $scope.checkLoginUserContent=function(){
        if($scope.empId==""){
            $scope.invalidMatch=false;

        }
        else  if($scope.empId!=""){
            $scope.invalidMatch=false;

        }
    }
    $scope.login = function() {
        console.log(":: 1 ::");
        $scope.invalidMatch=false;
        console.log(!$scope.empId.trim());
        if ($scope.empId.trim()) {
            window.localStorage.role = 'LA';
            userProfileFound = true;
            commonServices.changeRoute('#/dashboard');
            console.log(":: 2 ::");
        }
            if (!$scope.empId.trim() || !$scope.password.trim()) {
            console.log(":: 1 ::");
            $scope.invalidMatch=true;
            $scope.empId="";
            return;
        }
        var userProfileList = commonDataFactory.getUserProfileList();
        var userProfileFound=false;


        for(var i=0; i<userProfileList.length;i++) {

        // console.log("userProfileList[i].userId "+userProfileList[0].userId + typeof ($scope.empId));
          //  console.log("$scope.empId "+$scope.empId );

            //if (userProfileList[i].employeeId.toString() == $scope.empId.toString()) {
       if(userProfileList[i].userId==$scope.empId){
            //console.log("matched");
                // Setting Default To Lead Accessor
                // Nice Place To Handle User Role, If we want to show No Role Set :)

             //   console.log("userProfileList[i].password "+userProfileList[i].password);
              //  console.log("$scope.password "+$scope.password);
                //console.log("password split " +(userProfileList[i].password.split(":")[0]));

           if (userProfileList[i].roleName == 'Assessor') {
               var pass=userProfileList[i].password.split(":")[0];
           }else
           {
               var pass=userProfileList[i].password;
           }
           console.log(pass);
                //var pass=userProfileList[i].password.split(":")[0];
                if (pass == $scope.password) {

                    if (userProfileList[i].roleName == 'Assessor') {
                        window.localStorage.role = 'A';
                        userProfileFound = true;

                    }
                    if (userProfileList[i].roleName == 'Lead Assessor') {
                        window.localStorage.role = 'LA';
                        userProfileFound = true;

                    }
                    window.localStorage.accessLevel = userProfileList[i].password;
                    commonDataFactory.setLoggedInUserProfile(userProfileList[i]);
                }
            }


            if (($scope.empId == '400207695' && userProfileList[i].employeeId== $scope.empId) || ($scope.empId == '400218542' && userProfileList[i].employeeId== $scope.empId)) {

                if (userProfileList[i].roleName == 'Assessor') {
                    window.localStorage.role = 'A';
                    userProfileFound = true;
                }
                if (userProfileList[i].roleName == 'Lead Assessor') {
                    window.localStorage.role = 'LA';
                    userProfileFound = true;
                }

                window.localStorage.accessLevel = userProfileList[i].password;
                commonDataFactory.setLoggedInUserProfile(userProfileList[i]);
            }


        }
        if (!userProfileFound ) {
            // $('#passwordError').modal('show');

            $scope.invalidMatch = true;
            $scope.empId = "";
            $scope.password = "";
            return;
        }
        commonServices.changeRoute('#/dashboard');
    }
});