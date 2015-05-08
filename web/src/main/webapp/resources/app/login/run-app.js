require.config({
    paths: {
        angular: '../../assets/bower_components/angular/angular.min',
        angularRoute: '../../assets/bower_components/angular-route/angular-route.min',
        csrfInterceptor: '../../assets/bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
        loginModule: 'module'
    },
    shim: {
        angular: {
            exports: "angular"
        },
        csrfInterceptor: {
            deps: ['angular']
        },
        angularRoute: {
            deps: ['angular']
        },
        loginModule: {
            deps: [ 'angular', 'angularRoute', 'csrfInterceptor']
        }
    }
});

require(['loginModule'], function () {

    angular.bootstrap(document.getElementById('loginModule'), ['loginModule']);

});