'use strict';
angular.module('genpactApp').controller('viewFeedbackFormCtrl', function($scope, $aside, $location, $localStorage, commonServices, $rootScope, $http) {

    // this represents the state of the dialog: a visible flag and the category being edited
    $scope.searchApplicationPopup =function(){
        $('#applicationModal').modal('show');
    }

        $(document).ready(function(){
            $('[data-toggle="tooltip"]').tooltip();
        });

    $scope.applicationList =   [
        {
            "applicationName": "Alabama"
        },
        {
            "applicationName": "Alaska"
        },
        {
            "applicationName": "Arizona"
        },
        {
            "applicationName": "Arkansas"
        },
        {
            "applicationName": "California"
        },
        {
            "applicationName": "Colorado"
        },
        {
            "applicationName": "Connecticut"
        },
        {
            "applicationName": "Delaware"
        },
        {
            "applicationName": "Florida"
        }
    ]

    $scope.addAccount=function(){
        $("#addAccountModal").modal("show");
    }

    $scope.addRole=function(){
        $("#addRoleModal").modal("show");
    }

    $scope.roleList=[
        {"role":"Assessor"},
        {"role":"Lead Assessor"},
        {"role":"End User"}
    ]

    $scope.accountList=[
        {"account":"Morgan Stanley"},
        {"account":"CVS Caremark"},
        {"account":"Otsuka"},
        {"account":"CACIB"}
    ]

    $scope.showSelectedApplication=function(value){
        $scope.addApplication=value;
    }

    $scope.selectedRole=function(value){
        $scope.addRoleModel=value;
    }

    $scope.selectedAccount=function(value){
        $scope.addProfileAccount=value;
        console.log(value)
    }

    $scope.uploadFile = function(){
        var file = $scope.myFile;

        console.log('file is ' );
        console.dir(file);

        var uploadUrl = "/fileUpload";
        fileUpload.uploadFileToUrl(file, uploadUrl);
    };

})

.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}])

.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function(file, uploadUrl){
        var fd = new FormData();
        fd.append('file', file);

        $http.post(uploadUrl, fd, {
                transformRequest: angular.identity,
                headers: {'Content-Type': undefined}
            })

            .success(function(){
            })

            .error(function(){
            });
    }
}]);