angular.module('providerModule', ['ngRoute'])
    .config(['$routeProvider',
        function($routeProvider) {
            $routeProvider.
                when('/account', {
                    controller: "AccountController",
                    templateUrl: "/resources/app/provider/views/AccountView.html"
                }).
                when('/clients', {
                    controller: "ClientsController",
                    templateUrl: "/resources/app/provider/views/ClientsView.html"
                }).
                when('/applications', {
                    controller: "ApplicationsController",
                    templateUrl: "/resources/app/provider/views/ApplicationsView.html"
                }).
                otherwise({
                    redirectTo: '/'
                });
        }]);
define([
    'controllers/AccountController',
    'controllers/ClientsController',
    'controllers/ApplicationsController'
], function () {});
