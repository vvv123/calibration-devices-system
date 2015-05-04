angular.module('clientModule', ['ngRoute'])
    .config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                when('/account', {
                    controller: "AccountController",
                    templateUrl: "views/AccountView.html"
                }).
                when('/devices', {
                    controller: "DevicesController",
                    templateUrl: "views/DevicesView.html"
                }).
                when('/add-application', {
                    controller: "AddApplicationsController",
                    templateUrl: "views/AddApplicationsView.html"
                }).
                otherwise({
                    redirectTo: '/'
                });
        }]);
define([
    'controllers/AccountController',
    'controllers/DevicesController',
    'controllers/AddApplicationsController'
], function () {});
