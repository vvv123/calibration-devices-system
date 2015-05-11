angular.module('providerModule', [ 'ngRoute', 'spring-security-csrf-token-interceptor', 'ui.bootstrap'])
    .config(['$routeProvider',
        function($routeProvider) {
            console.log("ROUTING STARTED");
            $routeProvider.
                when('/', {
                    controller: "MainPanelController",
                    templateUrl: "/resources/app/provider/views/MainPanelView.html"
                }).
                when('/graphs', {
                    templateUrl: "/resources/app/provider/views/GraphsView.html"
                }).
                when('/organizations', {
                    templateUrl: "/resources/app/provider/views/OrganizationsView.html"
                }).
                when('/users', {
                    templateUrl: "/resources/app/provider/views/UsersView.html"
                }).
                when('/devices', {
                    templateUrl: "/resources/app/provider/views/DevicesView.html"
                }).
                when('/settings', {
                    templateUrl: "/resources/app/provider/views/SettingsView.html"
                }).
                otherwise({
                    redirectTo: '/'
                });
        }]);
define([
    'controllers/MainPanelController'
], function () {});
