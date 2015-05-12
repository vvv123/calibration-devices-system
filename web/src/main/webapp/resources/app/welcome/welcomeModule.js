angular.module('welcomeModule', ['spring-security-csrf-token-interceptor',
    'duScroll', 'ui.bootstrap']);
define([
    'controllers/GlobalController',
    'controllers/LoginController',
    'controllers/AddApplicationsController',
    'controllers/CheckApplicationController',
    'services/CatalogueService',
    'services/ApplicationService'
], function () {});
