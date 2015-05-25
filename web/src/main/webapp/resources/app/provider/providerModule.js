(function () {
    angular.module('providerModule', ['spring-security-csrf-token-interceptor',
        'ui.bootstrap', 'ui.router'])
        .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise('/');
            $stateProvider
                .state('main-panel', {
                    url: '/',
                    templateUrl: '/resources/app/provider/views/main-panel.html'
                })
                .state("new-verifications", {
                    url: '/verifications/new',
                    templateUrl: '/resources/app/provider/views/new-verifications.html',
                    controller: 'NewVerificationsController'
                })
                .state("adding-verifications", {
                    url: '/verifications/add',
                    templateUrl: '/resources/app/provider/views/adding-verifications.html',
                    controller: 'AddingVerificationsController'
                })
                .state("verifications-archive", {
                    url: '/verifications/archive',
                    templateUrl: '/resources/app/provider/views/archival-verifications.html',
                    controller: 'ArchivalVerificationsController'
                });

        }]);

    angular.module('providerModule').run(function (paginationConfig) {
        paginationConfig.firstText = 'Перша';
        paginationConfig.previousText = 'Попередня';
        paginationConfig.nextText = 'Наступна';
        paginationConfig.lastText = 'Остання';
    });

    define([
        'controllers/TopNavBarController',
        'controllers/MainPanelController',
        'controllers/ArchivalVerificationsController',
        'controllers/NewVerificationsController',
        'controllers/AddingVerificationsController',
        'controllers/ModalController',
        'services/DataReceivingService',
        'services/DataUpdatingService'
    ], function () {});
})();
