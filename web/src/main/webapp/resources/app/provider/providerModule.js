angular.module('providerModule', ['spring-security-csrf-token-interceptor',
    'ui.bootstrap', 'ui.router'])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise('/');
            $stateProvider
                .state('main-panel', {
                    url: '/',
                    templateUrl: '/resources/app/provider/views/main-panel.html'
                })
                .state('organizations-panel', {
                    url: '/organizations',
                    templateUrl: '/resources/app/provider/views/organizations-panel.html'
                })
                .state('application-available', {
                    url: '/users',
                    templateUrl: '/resources/app/provider/views/application-available.html'
                })
                .state('devices-panel', {
                    url: '/devices',
                    templateUrl: '/resources/app/admin/views/devices-panel.html'
                })
                .state('settings-panel', {
                    url: '/settings',
                    templateUrl: '/resources/app/admin/views/settings-panel.html'
                });
            }]);

angular.module('providerModule').run(function(paginationConfig){
    paginationConfig.firstText = 'Перша';
    paginationConfig.previousText = 'Попередня';
    paginationConfig.nextText = 'Наступна';
    paginationConfig.lastText = 'Остання';
});

define([
    'controllers/FindAllApplications',
    'controllers/TopNavBarController',
    'controllers/MainPanelController',
    'controllers/UsersController',
    'controllers/OrganizationController',
    'services/OrganizationService',
    'services/StatisticService',
    'services/DataReceivingService',
    'services/DataSendingService'
], function () {});
