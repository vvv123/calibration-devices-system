angular.module('providerModule', ['spring-security-csrf-token-interceptor',
    'ui.bootstrap', 'ui.router'])
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            $urlRouterProvider.otherwise('/');
            $stateProvider
                .state('main-panel', {
                    url: '/',
                    templateUrl: '/resources/app/provider/views/main-panel.html'
                })
                .state('verifications-panel', {
                    url: '/verifications',
                    templateUrl: '/resources/app/provider/views/verifications-panel.html'
                })
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
    'controllers/AllVerificationController',
    'services/VerificationService'
], function () {});
