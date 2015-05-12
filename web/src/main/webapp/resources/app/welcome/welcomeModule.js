angular.module('welcomeModule', ['spring-security-csrf-token-interceptor',
    'duScroll', 'ngRoute', 'ui.bootstrap'])
    .config(['$routeProvider',
        function($routeProvider) {
            //$locationProvider.html5Mode(true);
            $routeProvider.
                when('/', {
                    controller: "AddApplicationsController",
                    templateUrl: "/resources/app/welcome/views/AddApplicationsView.html"
                }).
                when('/check-app', {
                    controller: "CheckApplicationController",
                    templateUrl: "/resources/app/welcome/views/CheckApplication.html"
                }).
                otherwise({
                    redirectTo: '/'
                });
        }]);
define([
    'controllers/GlobalController',
    'controllers/LoginController',
    'controllers/AddApplicationsController',
    'controllers/CheckApplicationController',
    'services/CatalogueService',
    'services/ApplicationService'
], function () {});
