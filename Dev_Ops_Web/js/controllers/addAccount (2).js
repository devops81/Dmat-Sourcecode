'use strict';

angular.module('genpactApp').controller('addAccountCtrl', function($scope, $aside, $location, $localStorage, commonServices, $rootScope, $http,appConfig) {
    
	 $scope.init = function() {
         $scope.accountExist=false;
	        $scope.accountToDelete = "";
	        $scope.accountId = '';
	       //For displaying the accounts
	        var accountRequest = "<account><isViewOnly>true</isViewOnly><saveOrUpdate></saveOrUpdate><accountId></accountId><accountName></accountName>" +
	        		"<isActive></isActive></account>";

	        $http({
	            method: 'POST',
	            url: appConfig.handleAccounts,
	            data:accountRequest,
	            headers: { "Content-Type": 'application/xml'}
	        }).success(function(data) {
	            if(data.response.header.statusCode==0){
	                $scope.model.error=true;
	            }else {
	                $scope.accountList=data.response.details.accountDetails;
		              angular.forEach($scope.accountList,function(list,index) {
		    	        	if (list.accountId == -1) {
		    	        	  $scope.accountList.splice (index,1);
		    	          }

		    	        });
	            }
	        }).error(function () {
	            console.log("  System Exception While Fetching The Accounts !!! ");
	        });
	        
	
	    }

    $scope.resetValues=function(){
        $scope.accountExist=false;
        $scope.accountAlreadyExist=false;
    }

    $scope.addAccount=function(){
    	 var addAccount = {
    	            "account": $scope.accountName,
    	            "accountId":""
    	        };

        for(var i=0;i<$scope.accountList.length;i++) {
            if($scope.accountList[i].account.toLowerCase() == addAccount.account.toLowerCase()){
                $scope.accountExist=true;
            }
        }
            if($scope.accountExist!=true) {

                var accountSaveRequest = "<account><isViewOnly>false</isViewOnly><saveOrUpdate>1</saveOrUpdate><accountId>-1</accountId>" +
                    "<accountName>" + $scope.accountName + "</accountName>" +
                    "<isActive>true</isActive></account>";

                $http({
                    method: 'POST',
                    url: appConfig.handleAccounts,
                    data: accountSaveRequest,
                    headers: {"Content-Type": 'application/xml'}
                }).success(function (data) {
                    console.log(data);
                    if (data.response.header.statusCode == 0) {
                        $scope.model.error = true;
                    } else {
                        addAccount.accountId = data.response.details.accountId;

                    }
                    $scope.accountList.push(addAccount);
                    $scope.accountName = "";
                }).error(function () {
                    console.log("  System Exception While Saving The Account !!! ");
                });

        }
    }
    
    $scope.editAccountStatus = function(account) {
    	
        if(account.active == true){
        	account.active=false;
        	account.isClickable=!account.isClickable;
         }else if(account.active==false){
        	 account.active=true;
        	 account.isClickable=!account.isClickable;
         }
         console.log("checking changed value of activeFlag"+account.active)
         account.isClickable=!account.isClickable;
         $scope.deactivateColorChange=true;
         var accountRequest="<account><isViewOnly>false</isViewOnly>" +
         "<saveOrUpdate>0</saveOrUpdate>" +
         "<accountId>"+account.accountId+"</accountId>" +
         "<accountName>"+account.account+"</accountName><isActive>"+account.active+"</isActive>" +
         "</account>"

         console.log (accountRequest);
         $http({
             method: 'POST',
             url: appConfig.handleAccounts,
             data:accountRequest,
             headers: { "Content-Type": 'application/xml'}
         }).success(function(data) {
             console.log(data);
         }).error(function () {
             console.log("  System Exception While Updating Accounts !!! ");
         });

     }
    
    $scope.openAccountModel=function(account){
    	$scope.swapAccount=account.account;
        $scope.editAccountModel=account.account;
        $scope.accountId = account.accountId;
        $('#editAccount').modal('show');
        $scope.oldAccount=account.account;
    }
    $scope.accountAlreadyExistFunc=function(accountName){
        $scope.accountAlreadyExist=false;
        for(var i=0;i<$scope.accountList.length;i++){
            if($scope.accountList[i].account.toLowerCase()==accountName.toLowerCase()&&accountName.toLowerCase()!=$scope.oldAccount.toLowerCase()){
                $scope.accountAlreadyExist=true;
            }
        }
    }
    $scope.updateAccount=function(accountName){

    	var addAccount = {
	            "account": accountName,
	            "accountId": $scope.accountId
	        };

        if($scope.accountAlreadyExist!=true) {

            var accountSaveRequest = "<account><isViewOnly>false</isViewOnly><saveOrUpdate>0</saveOrUpdate><accountId>" + $scope.accountId + "</accountId>" +
                "<accountName>" + accountName + "</accountName>" +
                "<isActive>true</isActive></account>";

            $http({
                method: 'POST',
                url: appConfig.handleAccounts,
                data: accountSaveRequest,
                headers: {"Content-Type": 'application/xml'}
            }).success(function (data) {
                console.log(data);
                if (data.response.header.statusCode == 0) {
                    $scope.model.error = true;
                } else {
                    var accountRequest = "<account><isViewOnly>true</isViewOnly><saveOrUpdate></saveOrUpdate><accountId></accountId><accountName></accountName>" +
                        "<isActive></isActive></account>";
                    $http({
                        method: 'POST',
                        url: appConfig.handleAccounts,
                        data: accountRequest,
                        headers: {"Content-Type": 'application/xml'}
                    }).success(function (data) {
                        if (data.response.header.statusCode == 0) {
                            $scope.model.error = true;
                        } else {
                            $scope.accountList = data.response.details.accountDetails;
                            console.log($scope.accountList);
                        }
                    }).error(function () {
                        console.log("  System Exception While Fetching The Accounts !!! ");
                    });

                }

            }).error(function () {
                console.log("  System Exception While Saving The Account !!! ");
            });
        }
    }
});