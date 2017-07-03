'use strict';
angular.module('genpactApp').controller('userApplication', function($scope, $rootScope,$http,appConfig) {

    $scope.init = function () {
        $scope.uniqueAccountList='';
        var uniqueAccountList = [];
        var uniqueAccounts    = [];
        var uniqueUserList = [];
        var uniqueAccountList = [];
        var uniqueApplicationList = [];


        $http({ method: 'GET',url: './data/userApplication.json',data: ''}).success(function(data){
           var userApplicationList = data.response.detail.accountDetails;
            for(var i=0;i<userApplicationList.length;i++){
                var  uniqueAccount = {'accountId':'0','accountName':''};
                if( uniqueAccounts.indexOf(userApplicationList[i].accountId)==-1){
                    uniqueAccount.accountId = userApplicationList[i].accountId;
                    uniqueAccount.accountName = userApplicationList[i].accountName;
                    uniqueAccountList.push(uniqueAccount);
                    uniqueAccounts.push(userApplicationList[i].accountId);
                }
            }
            $scope.userApplicationList=userApplicationList;
        })

        $scope.uniqueAccountList= uniqueAccountList;
    }

    $scope.fetchApplicationList = function () {
            var userSelectedAccount=$scope.uniqueAccountList.accountId;
       var userApplicationList= $scope.userApplicationList;
    })
    }

})