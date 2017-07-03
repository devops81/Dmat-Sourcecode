'use strict';
angular.module('genpactApp').controller('viewNotificationsCtrl', function($scope, $aside, $location, $localStorage, commonServices, $rootScope, $http) {

    $("[name='ncna']").bootstrapSwitch();
    $("[name='ncnla']").bootstrapSwitch();
    $("[name='nsana']").bootstrapSwitch();
    $("[name='nsanla']").bootstrapSwitch();
    $("[name='ncana']").bootstrapSwitch();
    $("[name='ncanla']").bootstrapSwitch();
    $("[name='nscna']").bootstrapSwitch();
    $("[name='nscnla']").bootstrapSwitch();


});