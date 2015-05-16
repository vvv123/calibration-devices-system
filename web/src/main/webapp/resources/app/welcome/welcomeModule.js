var welcomeModule = angular.module('welcomeModule', ['spring-security-csrf-token-interceptor',
    'duScroll', 'ui.bootstrap', 'pascalprecht.translate', 'ui.router'])
    .config(['$translateProvider', '$stateProvider', '$urlRouterProvider',

        function ($translateProvider, $stateProvider, $urlRouterProvider) {
            /**
             *
             *  i18n configuration.
             *
             */
            $translateProvider.preferredLanguage('ukr');
            $translateProvider.useSanitizeValueStrategy('escaped');
            $translateProvider.useStaticFilesLoader({
                prefix: '/resources/assets/i18n/welcome-',
                suffix: '.json'
            });

            /**
             * Routing configuration.
             */
            $urlRouterProvider.otherwise('/');

            $stateProvider
                .state('welcome', {
                    url: "/",
                    views: {
                        navigation: {
                            templateUrl: '/resources/app/welcome/views/navigation.html'
                        },
                        welcome: {
                            templateUrl: '/resources/app/welcome/views/welcome.html'
                        },
                        about: {
                            templateUrl: '/resources/app/welcome/views/about.html'
                        },
                        login: {
                            templateUrl: '/resources/app/welcome/views/login.html',
                            controller: 'LoginController'
                        },
                        applicationSending: {
                            templateUrl: '/resources/app/welcome/views/application-sending.html',
                            controller: 'ApplicationSendingController'
                        },
                        applicationStatus: {
                            templateUrl: '/resources/app/welcome/views/application-status.html',
                            controller: 'ApplicationStatusController'
                        }
                    }
                });
        }]);

define([
    'controllers/LoginController',
    'controllers/ApplicationSendingController',
    'controllers/ApplicationStatusController',
    'controllers/InternationalizationController',
    'services/CatalogueService',
    'services/ApplicationService'
], function () {
});
