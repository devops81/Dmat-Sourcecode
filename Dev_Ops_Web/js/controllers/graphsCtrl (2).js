'use strict';
angular.module('genpactApp').controller('graphsCtrl', function($scope, $aside, $location, $localStorage,$rootScope,$http,appConfig) {


    $scope.init = function() {
        $scope.summaryList='';
        $scope.assessmentAreas='';
        var uniqueAssessmentArea=[];
        var uniqueApplicationName=[];
        var assessmentAreaList=[];
        var applicationList=[];

        var viewQuestionReport = "<?xml version='1.0' encoding='UTF-8'?><viewQuestionDetails><applicationId>-1</applicationId></viewQuestionDetails>";
        $http({
        	   method: 'POST',
               url: appConfig.viewQuestionResponse,
               data: viewQuestionReport,
               headers: { "Content-Type": 'application/xml'}
           /* method:'GET',
            url: './data/summaryChartData_2.json'*/
        }).success(function (data) {
            var responseDataList = data.response.detail.questionResponseDetails;
            for(var i=0;i<responseDataList.length;i++){

                // Uniquely Filter The Assessment Areas - For Heading

                if (uniqueAssessmentArea.indexOf(responseDataList[i].assessmentId) == -1) {

                    var assessmentArea={'assessmentId':'','assessmentArea':'','assessmentScore':''}
                    uniqueAssessmentArea.push(responseDataList[i].assessmentId);
                    assessmentArea.assessmentId   = responseDataList[i].assessmentId;
                    assessmentArea.assessmentArea = responseDataList[i].assessmentArea;
                    assessmentAreaList.push(assessmentArea);
                }

                // Uniquely Filter The applicationName For left Hand Heading On the page

                if (uniqueApplicationName.indexOf(responseDataList[i].applicationId) == -1) {

                    var application=[{"ID":"","reportId":"","applicationId":"","applicationName":"","assessmentAreaList":""}];
                    uniqueApplicationName.push(   responseDataList[i].applicationId);
                    application.applicationId   = responseDataList[i].applicationId;
                    application.applicationName = responseDataList[i].applicationName;
                    applicationList.push(application);
                }
            }


            for(var i=0;i<applicationList.length;i++){

                applicationList[i].assessmentAreaList=angular.copy(assessmentAreaList);
            }

            console.log(applicationList);

            // Trying to Build a Matrix to render the Data Using One ng-Repeat
            // First , It will iterate the Application List
            // It will then match the application ID and response data list
            // Once matching ID is found then it will find the matching assessment area and re iterate
            // for the complete assessmentAreaList


            for (var i =0;i<applicationList.length;i++){

                for(var j=0; j<responseDataList.length;j++){

                    if (applicationList[i].applicationId == responseDataList[j].applicationId) {

                        console.log("applicationList[i].assessmentAreaList.length"+applicationList[i].assessmentAreaList.length);

                        for(var k=0; k<applicationList[i].assessmentAreaList.length; k++){



                            if (applicationList[i].assessmentAreaList[k].assessmentId == responseDataList[j].assessmentId){


                                applicationList[i].assessmentAreaList[k].assessmentScore = responseDataList[j].scoreAdmin;

                            }
                        }
                    }
                }
            }

            $scope.summaryList=applicationList;
            $scope.assessmentAreas=assessmentAreaList;
            var assessmentAreaNameList=[];

            for (var i=0;i<$scope.assessmentAreas.length;i++) {

                assessmentAreaNameList.push($scope.assessmentAreas[i].assessmentArea);

            }

            var graphData=[];

            for(var i=0; i<applicationList.length;i++){

                var reportData={'name':'','data':[],'pointPlacement':'on'}

                reportData.name= applicationList[i].applicationName;
                var valData=[];
                for(var j=0;j<applicationList[i].assessmentAreaList.length;j++){

                    valData.push(applicationList[i].assessmentAreaList[j].assessmentScore);

                }
                reportData.data=valData;
                graphData.push(reportData);
            }

            Highcharts.chart('container', {
                chart: {
                    type: 'column'
                },
                title: {
                    text: ' DevOps Assessment System'
                },
                subtitle: {
                    text: 'Source - Genpact DevOps System'
                },
                xAxis: {
                    categories: assessmentAreaNameList,
                    crosshair: true
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: ' Genpact - DevOps'
                    }
                },
                tooltip: {
                    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                    '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
                    footerFormat: '</table>',
                    shared: true,
                    useHTML: true
                },
                plotOptions: {
                    column: {
                        pointPadding: 0.2,
                        borderWidth: 0
                    }
                },
                series: graphData
            });

        }).error(function () {
            console.log("  Error Occurred While Fetching the Data !!! ");
        });

    }


    /*  $(function () {

     $('#container').highcharts({

     chart: {
     polar: true,
     type: 'line'
     },

     title: {
     text: '',
     x: -80
     },

     pane: {
     size: '80%'
     },

     xAxis: {
     categories: ['Business and Enviroment Complexity', 'Business Needs', 'Delivery Maturity'],
     tickmarkPlacement: 'on',
     lineWidth: 0
     },

     yAxis: {
     gridLineInterpolation: 'polygon',
     lineWidth: 0,
     min: 0
     },

     tooltip: {
     shared: true,
     pointFormat: '<span style="color:{series.color}">{series.name}: <b>${point.y:,.0f}</b><br/>'
     },

     legend: {
     align: 'right',
     verticalAlign: 'top',
     y: 70,
     layout: 'vertical'
     },

     series: [{
     name: 'Alabama',
     data: [5.0,5.0,1.4],
     pointPlacement: 'on'
     }, {
     name: 'Alaska',
     data: [4.0,4.0,1.1],
     pointPlacement: 'on'
     }, {
     name: 'Arizona',
     data: [3.0,3.0,0.8],
     pointPlacement: 'on'
     }, {
     name: 'Arkansas',
     data: [2.0,2.0,0.5],
     pointPlacement: 'on'
     }]

     });
     });
     */

});