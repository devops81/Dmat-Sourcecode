'use strict';
angular.module('genpactApp').controller('manageAuditReportsCtrl', function($scope,$http,appConfig) {

$scope.init = function() {

     var manageAuditRequest="<manageAuditMapping><isViewOnly>true</isViewOnly><accountId></accountId><businessUnitId></businessUnitId><assessmentId></assessmentId><isAssessmentActive></isAssessmentActive></manageAuditMapping>";
     
     $http({method: 'POST',url: appConfig.getAuditData,data: manageAuditRequest,headers: { "Content-Type": 'application/xml'}}).success(function (data) {
    	 
    	 var tempReportData = data.response.manageAuditMappingResponseBody.auditMappingDetails;
         var tempAuditData =[]; 
         
         /*tempReportData.sort(function (obj1,obj2){
        	 obj1.businessUnitId - obj2.businessUnitId;
         })       	 */
         var k=0;//tempReportData[i].assessmentId;
         for(var i = 0;i < tempReportData.length; i++){
        	 // Create Object only when all three Assessment Areas Data is populated in tempReportObj
   			 var tempReportObj = {'accountId':0,'assessmentId':0,'accountName': '','businessUnitId':0,'businessUnitName':'','businessNeedActive':false,'businessEnvNeedActive':false,'deliveryMaturityActive':false}

   			 tempReportObj.accountId              = tempReportData[i].accountId;
		     tempReportObj.accountName            = tempReportData[i].accountName;
		     tempReportObj.businessUnitId         = tempReportData[i].businessUnitId
		     tempReportObj.businessUnitName       = tempReportData[i].businessUnitName;
		     
		    // tempReportObj.assessmentId           = tempReportData[i].; 
		     
			 for(var j = 0;j < tempReportData.length; j++){
		    	 
		    	 if(tempReportObj.accountId == tempReportData[i].accountId  && tempReportObj.businessUnitId == tempReportData[j].businessUnitId){
			 
		    		 tempReportObj.businessNeedActive     = tempReportData[j].assessmentId == 1 ? tempReportData[j].assessmentIdActive : tempReportObj.businessNeedActive;
			    	 tempReportObj.businessEnvNeedActive  = tempReportData[j].assessmentId == 2 ? tempReportData[j].assessmentIdActive : tempReportObj.businessEnvNeedActive;
			    	 tempReportObj.deliveryMaturityActive = tempReportData[j].assessmentId == 3 ? tempReportData[j].assessmentIdActive : tempReportObj.deliveryMaturityActive;
			    	 
		    	 }
		     }
			 
			 tempAuditData.push(tempReportObj);
         }
         $scope.accountReportsList = tempAuditData;
         console.log($scope.accountReportsList);
     }).error(function () {
         console.log("  Error Occurred While Fetching the Data !!! ");
     });
 }
	$scope.updateReportData = function(reportdata,currentState,assessmentId) {

		 //console.log(reportdata);
		 console.log(currentState);
		 if (currentState == true) {
			 $scope.isCurrentStateActive = 1;
		 } else {
			 $scope.isCurrentStateActive = 0;
		 }
		var manageAuditRequest = "<manageAuditMapping><isViewOnly>false</isViewOnly><accountId>"+reportdata.accountId+"</accountId><businessUnitId>"+reportdata.businessUnitId+"</businessUnitId><assessmentId>"+assessmentId+"</assessmentId><isAssessmentActive>"+ $scope.isCurrentStateActive +"</isAssessmentActive></manageAuditMapping>";
		console.log(manageAuditRequest);
		$http({method: 'POST',url: appConfig.getAuditData,data: manageAuditRequest,headers: { "Content-Type": 'application/xml'}}).success(function (data) {
             // No handling is required in this case.
		}).error(function () {
			console.log("  Error Occurred While Fetching the Data !!! ");
		});

	}

});