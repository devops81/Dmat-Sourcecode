'use strict';
angular.module('genpactApp').controller('addRoleCtrl', function($scope, $aside, $location, $localStorage, commonServices, $rootScope, $http,appConfig) {
$scope.swapRole="";
$scope.roleList=[{"roleName":"Lead Assessor"},{"roleName":"Assessor" },{"roleName":"End User"}]

    $scope.addRole=function(){
        var roleTemp={"roleName":$scope.roleName}

        $scope.roleList.push(roleTemp);
        $scope.roleName="";
    }
    $scope.openRoleModel=function(role){
        $scope.swapRole=role.roleName;
        $scope.editRoleModel=role.roleName;

        $('#editRole').modal('show');
    }
$scope.saveRole=function(roleNamePassed){
    for(var i=0;i<$scope.roleList.length;i++){
        if($scope.swapRole==$scope.roleList[i].roleName){
            $scope.roleList[i].roleName=roleNamePassed;
        }
    }
}
});