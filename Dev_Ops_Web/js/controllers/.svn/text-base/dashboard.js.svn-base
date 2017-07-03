    'use strict';

    angular.module('genpactApp').controller('dashboardCtrl', function(commonDataFactory,$scope, $aside, $location, $rootScope, commonServices, $localStorage) {


        $rootScope.isHealthChat = false;
        $rootScope.isMyAppointment = false;
        $rootScope.isMyMedications = false;
        $rootScope.isMyVitals = false;
        $rootScope.isMobile = commonServices.isMobile();
        window.localStorage.ispopup = false;


        $scope.init = function() {

            if(commonDataFactory.getLoggedInUserProfile()==''){
                console.log(JSON.parse(window.localStorage.getItem("userProfile")));
                $scope.userProfile=JSON.parse(window.localStorage.getItem("userProfile"));
            }
            else {
                $scope.userProfile = commonDataFactory.getLoggedInUserProfile();
                window.localStorage.setItem("userProfile",JSON.stringify($scope.userProfile));
                console.log(JSON.parse(window.localStorage.getItem("userProfile")));
            }

            //commonDataFactory.setUserProfileList($scope.userProfile);
            console.log($scope.userProfile);
            $("#homepage").owlCarousel({
                navigation: false, // Show next and prev buttons
                navigationText: ["<i class='fa fa-angle-left'></i>", "<i class='fa fa-angle-right'></i>"],
                slideSpeed: 1000,
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
                }
            });

        }

        $scope.logout = function() {
            $scope.navigateTo("/");
        }

        $scope.navigateTo = function(path) {
            $location.url(path);
        };

        $scope.asideState = {
            open: false
        };

        $scope.openAside = function(position, backdrop) {
            $scope.asideState = {
                open: true,
                position: position
            };

            function postClose() {
                $scope.asideState.open = false;
            }

            $aside.open({
                templateUrl: 'views/aside.html',
                placement: position,
                size: 'sm',
                backdrop: 'static',
                controller: function($scope, $modalInstance) {
                    $scope.ok = function(e) {
                        $modalInstance.close();
                        e.stopPropagation();
                    };
                    $scope.navigateTo = function(path) {
                        $location.url(path);
                        $scope.cancel();
                    };
                    $scope.cancel = function(e) {
                        $modalInstance.dismiss();
                        try {
                            e.stopPropagation();
                        } catch (e) {

                        }
                    };
                }
            }).result.then(postClose, postClose);
        }


    });