angular.module('adminModule', [ 'ngRoute', 'spring-security-csrf-token-interceptor', 'ui.bootstrap'])
    .config(['$routeProvider',
        function($routeProvider) {
            console.log("ROUTING STARTED");
            $routeProvider.
                when('/', {
                    controller: "MainPanelController",
                    templateUrl: "/resources/app/admin/views/MainPanelView.html"
                }).
                when('/graphs', {
                    templateUrl: "/resources/app/admin/views/GraphsView.html"
                }).
                when('/organizations', {
                    templateUrl: "/resources/app/admin/views/OrganizationsView.html"
                }).
                when('/users', {
                    controller: "UsersController",
                    templateUrl: "/resources/app/admin/views/UsersView.html"
                }).
                when('/devices', {
                    templateUrl: "/resources/app/admin/views/DevicesView.html"
                }).
                when('/settings', {
                    templateUrl: "/resources/app/admin/views/SettingsView.html"
                }).
                otherwise({
                    redirectTo: '/'
                });
        }]);
define([
    'controllers/TopNavBarController',
    'controllers/MainPanelController',
    'controllers/UsersController',
    'controllers/AddOrganizationController'
], function () {});
