appModule.factory('commonServices', function() {     
    var factory = {}; 
    
    // Change Route Method 
    factory.changeRoute = function(url, forceReload, $scope) {
        $scope = $scope || angular.element(document).scope();
        if(forceReload || $scope.$$phase) {
            window.location = url;
        } else {
            $location.path(url);
            $scope.$apply();
        }
    }; 
    
     // Check LoggedInUser
    factory.checkUserLogin = function($localStorage,$location) {
        if($localStorage.patient_name === null){
             $location.url('/');
        }
    };      
    
     factory.isMobile = function(){
             var isMobile = {
            Android: function() {
                return navigator.userAgent.match(/Android/i);
            },
            BlackBerry: function() {
                return navigator.userAgent.match(/BlackBerry/i);
            },
            iOS: function() {
                return navigator.userAgent.match(/iPhone/i);
            },
            Opera: function() {
                return navigator.userAgent.match(/Opera Mini/i);
            },
            Windows: function() {
                return navigator.userAgent.match(/IEMobile/i);
            }
        };

        if (isMobile.iOS()) {
            return true;
        }
        else
        {
            return false;
        }
    };
    
    factory.setGrayedOut = function(){
         var parent = $(window.frameElement).parent().closest('body');
            $(window.frameElement).css({
                "z-index": "1002",
                "position": "relative",
                "border":"none"
            });
            $(parent).append("<div id='parentmodel' style='z-index:100;height:100%;width:100%;position:fixed;background-color:#000000;filter:alpha(opacity=50); opacity: 0.5;top:0'></div>");
    }


    // Function to open and close side menu    
    factory.openAside = function($scope,$aside,$localStorage,$location,position, backdrop) {
         $scope.asideState = {
             open: true,
             position: position
         };

         function postClose() {
             $scope.asideState.open = false;
         }

        $aside.open({
             templateUrl: 'views/userAside.html',
             placement: position,
             size: 'sm',
             backdrop: backdrop,
             controller: function($scope, $modalInstance) {
                 $scope.patientName = $localStorage.patientName;
                 $scope.professionalRole = $localStorage.professional_role;
                 $scope.ok = function(e) {
                     $modalInstance.close();
                     e.stopPropagation();
                 };
                 $scope.navigateTo = function(path) {
                     $localStorage.appointment_Query_Date = null;
                     $location.url(path);
                     $scope.cancel();
                 };
                 $scope.cancel = function(e) {
                     $modalInstance.dismiss();
                     $('.fade.modal-backdrop.in').css('display','none');
                     try {
                         e.stopPropagation();
                     } catch (e) {

                     }
                 };
             }
         }).result.then(postClose, postClose);
     };    
    return factory;
});