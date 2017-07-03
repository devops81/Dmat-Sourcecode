'use strict';
angular.module('genpactApp').controller('resetPasswordCtrl', function($scope, $aside, $location, $localStorage, commonServices, $rootScope, $http) {


    $scope.navigateTo = function(path) {
        $location.url(path);
    };

    $scope.typePassword="password";
    $scope.showPassIcon = true;
    $scope.hidePassIcon = false;

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
    
    $scope.resetPasswordLightBox = function(){
        $("#resetPasswordLightBox").modal("show");
    }
    
    $scope.selectedUser=function(value){
        $scope.addSelectedUser=value;
        console.log(value)
    }
    
    $scope.profileList = [{
        "EmpId": "400220000",
        "Name": "Alex",
        "Role": "Assessor",
        "Account": "Morgan Stanley"
    }, {
        "EmpId": "400220001",
        "Name": "Chris",
        "Role": "End User",
        "Account": "Morgan Stanley"
    }, {
        "EmpId": "400220002",
        "Name": "Joey",
        "Role": "Assessor",
        "Account": "Morgan Stanley"
    }, {
        "EmpId": "400220003",
        "Name": "Rachel",
        "Role": "Assessor",
        "Account": "Morgan Stanley"
    }, {
        "EmpId": "400220004",
        "Name": "James",
        "Role": "Assessor",
        "Account": "CVS Caremark"
    }, {
        "EmpId": "400220005",
        "Name": "Donald",
        "Role": "Lead Assessor",
        "Account": "Morgan Stanley"
    }, {
        "EmpId": "400210000",
        "Name": "Richard",
        "Role": "End User",
        "Account": "CVS Caremark"
    }]
});