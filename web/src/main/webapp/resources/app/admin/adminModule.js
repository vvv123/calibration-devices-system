angular.module('adminModule', [ 'ngRoute', 'spring-security-csrf-token-interceptor', 'ui.bootstrap'], function($httpProvider){
    $httpProvider.defaults.headers.post['Content-Type'] = 'application/json;charset=utf-8';
})
    .config(['$routeProvider',
        function($routeProvider) {
            console.log("ROUTING STARTED");
            $routeProvider.
                when('/', {
                    templateUrl: "/resources/app/admin/views/MainPanelView.html"
                }).
                when('/graphs', {
                    templateUrl: "/resources/app/admin/views/GraphsView.html"
                }).
                when('/organizations', {
                    templateUrl: "/resources/app/admin/views/OrganizationsView.html"
                }).
                when('/users', {
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
angular.module('adminModule').run(function(paginationConfig){
    paginationConfig.firstText = 'Перша';
    paginationConfig.previousText = 'Попередня';
    paginationConfig.nextText = 'Наступна';
    paginationConfig.lastText = 'Остання';
});
define([
    'controllers/TopNavBarController',
    'controllers/MainPanelController',
    'controllers/UsersController',
    'controllers/OrganizationController',
    'services/OrganizationService',
    'services/StatisticService'
], function () {});
