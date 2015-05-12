angular.module('welcomeModule', ['spring-security-csrf-token-interceptor', 'duScroll']);
define([
    'controllers/GlobalController',
    'controllers/LoginController'
], function () {});
