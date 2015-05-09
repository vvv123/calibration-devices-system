angular.module('clientModule', ['ngRoute'])
    .config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                when('/account', {
                    controller: "AccountController",
                    templateUrl: "/resources/app/client/views/AccountView.html"
                }).
                when('/devices', {
                    controller: "DevicesController",
                    templateUrl: "/resources/app/client/views/DevicesView.html"
                }).
                when('/add-application', {
                    controller: "AddApplicationsController",
                    templateUrl: "/resources/app/client/views/AddApplicationsView.html"
                }).
                when('/check-application', {
                    controller: "CheckApplicationController",
                    templateUrl: "/resources/app/client/views/CheckApplication.html"
                }).
                otherwise({
                    redirectTo: '/'
                });
        }]);
define([
    'controllers/AccountController',
    'controllers/DevicesController',
    'controllers/AddApplicationsController',
    'controllers/CheckApplicationController'
], function () {});
