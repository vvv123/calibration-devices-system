angular.module('adminModule', ['spring-security-csrf-token-interceptor',
    'ui.bootstrap', 'ui.router', 'ui.bootstrap.showErrors'])
    .config(['$stateProvider', '$urlRouterProvider', 'showErrorsConfigProvider',
        function ($stateProvider, $urlRouterProvider, showErrorsConfigProvider) {
            showErrorsConfigProvider.showSuccess(true);
            $urlRouterProvider.otherwise('/');
            $stateProvider
                .state('main', {
                    url: '/',
                    templateUrl: '/resources/app/admin/views/main-panel.html'
                })
                .state('organizations', {
                    url: '/organizations',
                    templateUrl: '/resources/app/admin/views/organizations-panel.html'
                })
                .state('address', {
                    url: '/address',
                    templateUrl: '/resources/app/admin/views/address-panel.html'
                })
                .state('devices', {
                    url: '/devices',
                    templateUrl: '/resources/app/admin/views/devices-panel.html'
                })
                .state('settings', {
                    url: '/settings',
                    templateUrl: '/resources/app/admin/views/settings-panel.html'
                })
        }]);

angular.module('adminModule').run(function (paginationConfig) {
    paginationConfig.firstText = 'Перша';
    paginationConfig.previousText = 'Попередня';
    paginationConfig.nextText = 'Наступна';
    paginationConfig.lastText = 'Остання';
});

define([
    'controllers/TopNavBarController',
    'controllers/MainPanelController',
    'controllers/OrganizationController',
    'controllers/OrganizationFormController',
    'controllers/OrganizationModalAddressController',
    'services/OrganizationService',
    'services/StatisticService',
    'services/UserService',
    'services/AddressService'
], function () {});