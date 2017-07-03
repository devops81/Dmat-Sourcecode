//var appModule = angular.module('genpactApp',['ui.bootstrap', 'ngRoute','ngAside','ngAnimate','ngSanitize', 'ngTouch', 'uiSwitch','ngStorage','ng.httpLoader','ngTable','angularUtils.directives.dirPagination','720kb.tooltips']);
var appModule = angular.module('genpactApp',['ngMaterial','kendo.directives','ui.bootstrap', 'ngRoute','ngAside','ngAnimate','ngSanitize', 'ngTouch', 'uiSwitch','ngStorage','ng.httpLoader','angularUtils.directives.dirPagination','720kb.tooltips','ngJsonExportExcel']);
//var serviceURL = 'http://ec2-52-26-137-130.us-west-2.compute.amazonaws.com:8080/DevOppsServices';
var serviceURL = 'http://localhost:8080/DevOppsServices';

appModule.constant("appConfig", {

                                 // For Login Screen
                                 "fetchUserProfile"         :   serviceURL+'/displayOptions/userProfiles/1.0',

                                 // For Application Only
                                 "manageBusinessUnits"       :   serviceURL+'/system/manageBusinessUnits/1.0',
                                 "fetchApplications"        :   serviceURL+'/displayOptions/applications/1.0',
                                 "updateApplication"        :   serviceURL+'/system/saveApplicationDetails/1.0',
                                 "saveApplication"          :   serviceURL+'/system/saveApplicationDetails/1.0',
                                 "handleAccounts"			:   serviceURL+'/displayOptions/handleAccounts/1.0',
                                 "saveAssessmentAreas"		:   serviceURL+'/assessment/saveAssessmentAreas/1.0',
                                 "getAssessmentAreas"		:	serviceURL+'/assessment/getAssessmentAreas/false/1.0',
                                 "saveUpdateCategories"		:	serviceURL+'/categories/saveUpdateCategories/1.0',
                                 "getCategories"			:	serviceURL+'/categories/getCategories/1/0/',
                                 "saveUpdateProfile"		:	serviceURL+'/profile/saveUpdateProfile/1.0',
                                 "handleRoles"				:	serviceURL+'/displayOptions/handleRoles/1.0',
                                 "saveSubCategories"		:	serviceURL+'/subCategories/saveSubCategories/1.0',
                                 "getSubCategories"			:	serviceURL+'/subCategories/getSubCategories/1/0/',
                                 "saveQuestionnaire"		:	serviceURL+'/questionnaire/saveQuestionnaire/1.0',
                                 "viewQuestionResponse"		:	serviceURL+'/questionResponse/viewQuestionResponse/1.0',
                                 "saveQuestionScore"		:	serviceURL+'/questionResponse/saveQuestionScore/1.0',
                                 "viewQuestionnaire"		:	serviceURL+'/questionnaire/viewQuestionnaire/1/',
                                 "saveQuestionnaire"		:	serviceURL+'/questionnaire/saveQuestionnaire/1.0',
                                 "getAuditData"				:	serviceURL+'/system/manageAuditReports/1.0'

                                 // For Business Unit Only
});


appModule.config(['$routeProvider', 'httpMethodInterceptorProvider', function($routeProvider, httpMethodInterceptorProvider) {

    $routeProvider.when('/', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl'
    }).when('/dashboard', {
        templateUrl: 'views/dashboard.html',
        controller: 'dashboardCtrl'
    }).when('/assessmentQuestionnaire', {
        templateUrl: 'views/assessmentQuestionnaire.html',
        controller: 'assessmentQuestionnaireCtrl'
    }).when('/agileQuestionnaire', {
        templateUrl: 'views/agileQuestionnaire.html',
        controller: 'assessmentQuestionnaireCtrl'
    }).when('/addAssessmentCategory', {
        templateUrl: 'views/addAssessmentCategory.html',
        controller: 'addCategoryCtrl'
    }).when('/addAgileCategory', {
        templateUrl: 'views/addAgileCategory.html',
        controller: 'addCategoryCtrl'
    }).when('/addAssessmentSubCategory', {
        templateUrl: 'views/addAssessmentSubCategory.html',
        controller: 'addSubCategoryCtrl'
    }).when('/addAgileSubCategory', {
        templateUrl: 'views/addAgileSubCategory.html',
        controller: 'addSubCategoryCtrl'
    }).when('/addAssessmentArea', {
        templateUrl: 'views/addAssessmentArea.html',
        controller: 'addAssessmentAreaCtrl'
    }).when('/addApplication', {
        templateUrl: 'views/addApplication.html',
        controller: 'addApplicationCtrl'
    }).when('/addBusinessUnits', {
        templateUrl: 'views/addBusinessUnits.html',
        controller: 'addBusinessUnitCtrl'
    }).when('/viewAssessmentQuestionnaire', {
        templateUrl: 'views/viewAssessmentQuestionnaire.html',
        controller: 'viewQuestionnaireCtrl'
    }).when('/viewAgileQuestionnaire', {
        templateUrl: 'views/viewAgileQuestionnaire.html',
        controller: 'viewQuestionnaireCtrl'
    }).when('/addProfile', {
        templateUrl: 'views/addProfile.html',
        controller: 'addProfileCtrl'
    }).when('/userAssessmentQuestionnaire', {
        templateUrl: 'views/userAssessmentQuestionnaire.html',
        controller: 'userAssessmentQuestionnaireCtrl'
    }).when('/userAgileQuestionnaire', {
        templateUrl: 'views/userAgileQuestionnaire.html',
        controller: 'userAssessmentQuestionnaireCtrl'
    }).when('/viewNotifications', {
        templateUrl: 'views/viewNotifications.html',
        controller: 'viewNotificationsCtrl'
    }).when('/assessmentReports', {
        templateUrl: 'views/assessmentReport.html',
        controller: 'submittedQuestionnaire'
    }).when('/agileFeedback', {
        templateUrl: 'views/agileFeedback.html',
        controller: 'submittedQuestionnaire'
    }).when('/resetPassword', {
        templateUrl: 'views/resetPassword.html',
        controller: 'resetPasswordCtrl'
    }).when('/viewFeedbackForm', {
        templateUrl: 'views/viewFeedbackForm.html',
        controller: 'viewFeedbackFormCtrl'
    }).when('/addRole', {
        templateUrl: 'views/addRole.html',
        controller: 'addRoleCtrl'
    }).when('/addAccount', {
        templateUrl: 'views/addAccount.html',
        controller: 'addAccountCtrl'
    }).when('/viewGraphs', {
        templateUrl: 'views/viewGraphs.html',
        controller: ''
    }).when('/viewSummaryChart', {
        templateUrl: 'views/viewSummaryChart.html',
        controller: 'viewSummaryChart'
    }).when('/viewSpiderGraph', {
        templateUrl: 'views/viewSpiderGraph.html',
        controller: 'viewSpiderGraphCtrl'
    }).when('/manageAuditReports', {
        templateUrl: 'views/manageAuditReports.html',
        controller: 'manageAuditReportsCtrl'
    }).when('/manageUserProfiles', {
        templateUrl: 'views/manageUserProfiles.html',
        controller: 'manageUserProfilesCtrl'
    }).when('/userApplication', {
        templateUrl: 'views/userApplication.html',
        controller: 'userApplication'
    })
        .otherwise({
        redirectTo: '/'
    });

    httpMethodInterceptorProvider.whitelistDomain('http://127.0.0.1');
    httpMethodInterceptorProvider.whitelistDomain('http://localhost');
    httpMethodInterceptorProvider.whitelistDomain('http://35.167.167.173');

}]);


appModule.filter('unique', function() {
   return function(collection, keyname) {
     var output = [], 
          keys = [];
      angular.forEach(collection, function(item) {
          var key = item[keyname];
          if(keys.indexOf(key) === -1) {
              keys.push(key); 
              output.push(item);
          }
      });
      return output;
   };
});

appModule.factory('Service', function() {
    var factory = {};
    // Change Route Method 
    factory.changeRoute = function(url, forceReload, $scope) {
        $scope = $scope || angular.element(document).scope();
        if (forceReload || $scope.$$phase) {
            window.location = url;
        } else {
            $location.path(url);
            $scope.$apply();
        }
    };
    return factory;
});

appModule.factory('commonDataFactory', function() {
    return {
        commonFactoryData : {'userProfileList':'','accountList' :'','businessUnitList':'','loggedInUserProfile':''},

        setUserProfileList: function (userProfileList) {
            this.commonFactoryData.userProfileList = userProfileList;
        },

        setAccountList: function (accountList) {
            this.commonFactoryData.accountList = accountList;
        },

        setBusinessUnits: function (businessUnitList) {
            this.commonFactoryData.businessUnitList = businessUnitList;
        },
        setLoggedInUserProfile: function (loggedInUserProfile) {
            this.commonFactoryData.loggedInUserProfile = loggedInUserProfile;
        },
        getUserProfileList: function () {
            return this.commonFactoryData.userProfileList;
        },
        getAccountList: function () {
            return this.commonFactoryData.accountList;
        },
        getBusinessUnitList: function () {
            return this.commonFactoryData.businessUnitList;
        },
        getLoggedInUserProfile: function () {
            return this.commonFactoryData.loggedInUserProfile;
        }
    }
});
appModule.factory('graphDataFactory', function() {

  // Two ways to add the Factory in the file.
  /*  var graphData = {};
    graphData.setGraphData= function (responseList, applicationList,graphLevel) {
        graphData.responseList= responseList;
        graphData.applicationList= applicationList;
        graphData.graphLevel= graphLevel;
    },
        graphData.getGraphData= function () {
            console.log("Inside Get Data ");
            console.log(graphData.responseList);
            return graphData;
        }

    return graphData;*/

    return {

        graphData : {'appList' :'' , 'responseDataList':'','categoriesList':'','subCategoriesList':'' },
        setGraphData: function (scope,graphLevel) {
            this.graphData.responseDataList= scope.responseDataList;
            this.graphData.appList= scope.summaryList;
            this.graphData.assessmentAreasList= scope.assessmentAreas
            this.graphData.categoriesList= scope.categories;
            this.graphData.subCategoriesList= scope.subCategories;

        },
        setGraphLevel: function (graphLevel) {
            this.graphData.graphLevel= graphLevel;
        },
        getGraphData: function () {
            return this.graphData;
        }
    }
});


appModule.directive('onlyDigits', function() {
    return {
        require: 'ngModel',
        restrict: 'A',
        link: function(scope, element, attr, ctrl) {
            function inputValue(val) {
                if (val) {
                    var digits = val.replace(/[^0-9]/g, '');

                    if (digits !== val) {
                        ctrl.$setViewValue(digits);
                        ctrl.$render();
                    }
                    return parseInt(digits, 10);
                }
                return undefined;
            }
            ctrl.$parsers.push(inputValue);
        }
    };
});

appModule.directive('header', function() {
    return {
        restrict: 'A',
        replace: true,
        scope: {
            user: '='
        },
        templateUrl: "js/directives/header.html",
        controller: ['$scope', '$location', function($scope, $location,$localStorage) {
            $scope.first=false;
            $scope.second=false;
            $scope.third=false;
            $scope.logout = function() {
                $scope.navigateTo("/");
            }
            $scope.applicationMaster = function() {
                $scope.navigateTo("/applicationMaster");
            }
            $scope.home = function() {
                $scope.navigateTo("/dashboard");
            }
            $scope.assessmentQuestionnaire = function() {
                $scope.navigateTo("/assessmentQuestionnaire");
            }
            $scope.agileQuestionnaire = function() {
                $scope.navigateTo("/agileQuestionnaire");
            }
            $scope.addAssessmentCategory = function() {
                $scope.navigateTo("/addAssessmentCategory");
            }
            $scope.addAgileCategory = function() {
                $scope.navigateTo("/addAgileCategory");
            }
            $scope.addAssessmentSubCategory = function() {
                $scope.navigateTo("/addAssessmentSubCategory");
            }
            $scope.addAgileSubCategory = function() {
                $scope.navigateTo("/addAgileSubCategory");
            }
            $scope.addAssessmentArea = function() {
                $scope.navigateTo("/addAssessmentArea");
            }
            $scope.addApplication = function() {
                $scope.navigateTo("/addApplication");
            }
            $scope.addBusinessUnits = function() {
            	 $scope.navigateTo("/addBusinessUnits");
            }
            $scope.addAccounts = function() {
                $scope.navigateTo("/addAccount");
            }
            $scope.addProfile = function() {
                $scope.navigateTo("/addProfile");
            }
            $scope.viewAssessmentQuestionnaire = function() {
                $scope.navigateTo("/viewAssessmentQuestionnaire");
            }
            $scope.viewAgileQuestionnaire = function() {
                $scope.navigateTo("/viewAgileQuestionnaire");
            }
            $scope.openNotifications=function(){
                $scope.navigateTo("/viewNotifications");
            }
            $scope.navigateTo = function(path) {
                $location.url(path);
            }
            $scope.userAssessmentQuestionnaire = function() {
                $scope.navigateTo("/userAssessmentQuestionnaire");
            }
            $scope.userAgileQuestionnaire = function() {
            	$scope.navigateTo("/userAgileQuestionnaire");
            }
            $scope.assessmentReports=function(){
                $scope.navigateTo("/assessmentReports");
            }
            $scope.agileFeedback=function(){
                $scope.navigateTo("/agileFeedback");
            }
            $scope.resetPassword=function(){
                $scope.navigateTo("/resetPassword");
            }
            $scope.viewFeedbackForm=function(){
                $scope.navigateTo("/viewFeedbackForm");
            }
            $scope.viewAddRole=function(){
                $scope.navigateTo("/addRole");
            }
            $scope.viewAddAccount=function(){
                $scope.navigateTo("/addAccount");
            }
            $scope.viewGraphs=function(){
                $scope.navigateTo("/viewGraphs");
            }
            $scope.viewSummaryChart=function(){
                $scope.navigateTo("/viewSummaryChart");
            }
            $scope.viewSpiderGraph=function(){
                $scope.navigateTo("/viewSpiderGraph");
            }
            $scope.manageAuditReports=function(){
                $scope.navigateTo("/manageAuditReports");
            }
            $scope.manageUserProfiles=function(){
                $scope.navigateTo("/manageUserProfiles");
            }
            $scope.userApplication=function(){
                $scope.navigateTo("/userApplication");
            }
            $scope.role = window.localStorage.role;
            
            if($scope.role=='A'){
                $scope.assessment = "margin-right33per";
            }else{
                $scope.assessment = "";
            }

			/* Code for NavBar Dropdown */
            $scope.test=function(val){
                if( /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent) ) {
                    document.getElementById("testQuestion").className="dropdown";
                    document.getElementById("testQuestion").className="use-yamm";
                    document.getElementById("testQuestion").className="yamm-fw";
                    document.getElementById("testQuestion").className="open";

                }


                $scope.second=val;
            }
            $scope.test1=function(val){
                $scope.first=val;

            }
            $scope.test2=function(val){
                $scope.third=val;

            }
            $('body').click(function () {
                $scope.first=false;
                $scope.second= false;
                $scope.third=false;

            });

        }]
    }
});

appModule.directive('footer', function() {
    return {
        restrict: 'A',
        replace: false,
        scope: {
            user: '='
        },
        templateUrl: "js/directives/footer.html",
        controller: ['$scope', '$location', function($scope, $location) {}]
    }
});

appModule.directive('editCategoryDialog', [function() {
    return {
        restrict: 'E',
        scope: {
            model: '=',
        },
        link: function(scope, element, attributes) {
            scope.$watch('model.visible', function(newValue) {
                var modalElement = element.find('.modal');
                modalElement.modal(newValue ? 'show' : 'hide');
            });
            element.on('shown.bs.modal', function() {
                scope.$apply(function() {
                    scope.model.visible = true;
                });
            });
            element.on('hidden.bs.modal', function() {
                scope.$apply(function() {
                    scope.model.visible = false;
                });
            });
        },
        templateUrl: 'js/directives/editCategoryDialog.html',
    };
}]);

appModule.directive('editSubCategoryDialog', [function() {
    return {
        restrict: 'E',
        scope: {
            model: '=',
        },
        link: function(scope, element, attributes) {
            scope.$watch('model.visible', function(newValue) {
                var modalElement = element.find('.modal');
                modalElement.modal(newValue ? 'show' : 'hide');
            });
            element.on('shown.bs.modal', function() {
                scope.$apply(function() {
                    scope.model.visible = true;
                });
            });
            element.on('hidden.bs.modal', function() {
                scope.$apply(function() {
                    scope.model.visible = false;
                });
            });
        },
        templateUrl: 'js/directives/editSubCategoryDialog.html',
    };
}]);

appModule.directive('editAssessmentDialog', [function() {
    return {
        restrict: 'E',
        scope: {
            model: '=',
        },
        link: function(scope, element, attributes) {
            scope.$watch('model.visible', function(newValue) {
                var modalElement = element.find('.modal');
                modalElement.modal(newValue ? 'show' : 'hide');
            });
            element.on('shown.bs.modal', function() {
                scope.$apply(function() {
                    scope.model.visible = true;
                });
            });
            element.on('hidden.bs.modal', function() {
                scope.$apply(function() {
                    scope.model.visible = false;
                });
            });
        },
        templateUrl: 'js/directives/editAssessmentAreaDialog.html',
    };
}]);

appModule.directive('editQuestionDialog', [function() {
    return {
        restrict: 'E',
        scope: {
            model: '=',
        },
        link: function(scope, element, attributes) {
            scope.$watch('model.visible', function(newValue) {
                var modalElement = element.find('.modal');
                modalElement.modal(newValue ? 'show' : 'hide');
            });

            element.on('shown.bs.modal', function() {
                scope.$apply(function() {
                    scope.model.visible = true;
                });
            });

            element.on('hidden.bs.modal', function() {
                scope.$apply(function() {
                    scope.model.visible = false;
                });
            });

        },
        templateUrl: 'js/directives/editQuestionDialog.html',
    };
}]);


appModule.directive('editProfileDialog', [function() {
    return {
        restrict: 'E',
        scope: {
            model: '=',
        },
        link: function(scope, element, attributes) {
            scope.$watch('model.visible', function(newValue) {
                var modalElement = element.find('.modal');
                modalElement.modal(newValue ? 'show' : 'hide');
            });

            element.on('shown.bs.modal', function() {
                scope.$apply(function() {
                    scope.model.visible = true;
                });
            });

            element.on('hidden.bs.modal', function() {
                scope.$apply(function() {
                    scope.model.visible = false;
                });
            });

        },
        templateUrl: 'js/directives/editProfileDialog.html',
    };
}]);


appModule.directive('editApplicationDialog', [function() {
    return {
        restrict: 'E',
        scope: {
            model: '&',
        },
        link: function(scope, element, attributes) {
            scope.$watch('model.visible', function(newValue) {
                var modalElement = element.find('.modal');
                modalElement.modal(newValue ? 'show' : 'hide');
            });
            element.on('shown.bs.modal', function() {
                scope.$apply(function() {
                    scope.model.visible = true;
                });
            });
            element.on('hidden.bs.modal', function() {
                scope.$apply(function() {
                    scope.model.visible = false;
                });
            });
        },
        templateUrl: 'js/directives/editApplicationDialog.html',
    };
}]);
// Solution 1 -  To Upload the File only, More Code is needed to convert to JSON
// Start of File Upload
/*
 A directive  demoFileModel to enable two way binding of file field
 Need to define an Object in the Controller Class
 $scope.myCustomFile={myFileObject:""};
 */
appModule.directive('demoFileModel', function ($parse) {
    return {
        restrict: 'A', //the directive can be used as an attribute only

        /*
         link is a function that defines functionality of directive
         scope: scope associated with the element
         element: element on which this directive used
         attrs: key value pair of element attributes
         */
        link: function (scope, element, attrs) {
            var model = $parse(attrs.demoFileModel),
                modelSetter = model.assign; //define a setter for demoFileModel

            //Bind change event on the element
            element.bind('change', function () {
                //Call apply on scope, it checks for value changes and reflect them on UI
                scope.$apply(function () {
                    console.log(scope);
                    // SomeWhat this is not working instead using $scope.myCustomFile={myFileObject:""}; to set the Object
                    // Basically , trying to access the Parent scope from the directive
                    //set the model value
                    modelSetter(scope, element[0].files[0]);
                    //console.log(element[0].files[0]);
                    scope.myCustomFile.myFileObject=element[0].files[0];
                });
            });
        }
    };
});

appModule.service('fileUploadService', function ($http, $q) {

    this.uploadFileToUrl = function (file, uploadUrl) {
        //FormData, object of key/value pair for form fields and values
        var fileFormData = new FormData();
        fileFormData.append('file', file);

        var deffered = $q.defer();
        $http.post(uploadUrl, fileFormData, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}

        }).success(function (response) {
            deffered.resolve(response);

        }).error(function (response) {
            deffered.reject(response);
        });
        return deffered.promise;
    }
});

/*    $scope.uploadFile = function () {

 console.log($scope.myCustomFile.myFileObject);
 };*/
// End of File Upload

// Solution 2 -  To Upload the File & Convert the Same in to JSON
appModule.directive("fileread", [function () {
    return {
        scope: {
            opts: '='
        },
        link: function ($scope, $elm, $attrs) {
            $elm.on('change', function (changeEvent) {
                var reader = new FileReader();

                reader.onload = function (evt) {
                    $scope.$apply(function () {
                        var data = evt.target.result;

                        var workbook = XLSX.read(data, {type: 'binary'});

                        var headerNames = XLSX.utils.sheet_to_json(workbook.Sheets[workbook.SheetNames[0]], {header: 1})[0];

                        var data = XLSX.utils.sheet_to_json(workbook.Sheets[workbook.SheetNames[0]]);

                        $scope.opts.columnDefs = [];
                        headerNames.forEach(function (h) {
                            $scope.opts.columnDefs.push({field: h});
                        });

                        $scope.opts.data = data;

                        $elm.val(null);
                    });
                };

                reader.readAsBinaryString(changeEvent.target.files[0]);
            });
        }
    }
}]);
// End of Solution 2


appModule.directive('inputStars', [function () {
        var directive = {
            restrict: 'EA',
            replace: true,
            template: '<ul ng-class="listClass">' +
            '<li ng-touch="paintStars($index)" ng-repeat="item in items track by $index">' +
            '<i  ng-class="getClass($index)"></i>' +
            '</li>' +
            '</ul>',
            require: 'ngModel',
            scope: {
                ngModel: '='
            },
            link: link
        };

        return directive;

        function link(scope, element, attrs, ngModelCtrl) {
            var computed = {
                get readonly() {
                    return attrs.readonly != 'false' && (attrs.readonly || attrs.readonly === '');
                },
                get fullIcon() {
                    return attrs.iconFull || 'fa-star';
                },
                get emptyIcon() {
                    return attrs.iconEmpty || 'fa-star-o';
                },
                get iconBase() {
                    return attrs.iconBase || 'fa fa-fw-custom';
                },
                get iconHover() {
                    return attrs.iconHover || 'angular-input-stars-hover';
                }
            };

            scope.items = new Array(+attrs.max);
            scope.listClass = attrs.listClass || 'angular-input-stars';

            ngModelCtrl.$render = function () {
                scope.lastValue = ngModelCtrl.$viewValue || 0;
            };

            scope.getClass = function (index) {
                var icon = index >= scope.lastValue ? computed.iconBase + ' ' + computed.emptyIcon : computed.iconBase + ' ' + computed.fullIcon + ' active ';
                return computed.readonly ? icon + ' readonly' : icon;
            };

            scope.unpaintStars = function ($index, hover) {
                scope.paintStars(scope.lastValue - 1, hover);
            };

            scope.paintStars = function ($index, hover) {
                // ignore painting if readonly
                if (computed.readonly) {
                    return;
                }

                var items = element.find('li').find('i');

                for (var index = 0; index < items.length; index++) {
                    var $star = angular.element(items[index]);

                    if ($index >= index) {
                        $star.removeClass(computed.emptyIcon);
                        $star.addClass(computed.fullIcon);
                        $star.addClass('active');
                        $star.addClass(computed.iconHover);
                    } else {
                        $star.removeClass(computed.fullIcon);
                        $star.removeClass('active');
                        $star.removeClass(computed.iconHover);
                        $star.addClass(computed.emptyIcon);

                    }
                }

                if (! hover) {
                    items.removeClass(computed.iconHover);
                }
            };

            scope.setValue = function (index, e) {
                // ignore setting value if readonly

                if (computed.readonly) {
                    return;
                }

                var star = e.target,
                    newValue;

                if (e.pageX < star.getBoundingClientRect().left + star.offsetWidth / 2) {
                    newValue = index + 1;
                } else {
                    newValue = index + 1;
                }

                // sets to 0 if the user clicks twice on the first "star"
                // the user should be allowed to give a 0 score
                if (newValue === scope.lastValue && newValue === 1) {
                    newValue = 0;
                }

                scope.lastValue = newValue;


                ngModelCtrl.$setViewValue(newValue);
                ngModelCtrl.$render();

                //Execute custom trigger function if there is one
                if(attrs.onStarClick){
                    scope.$eval(attrs.onStarClick);
                }

            };

        }
    }]);