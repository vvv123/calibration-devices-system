require.config({
    paths: {
        angular: '../../assets/bower_components/angular/angular.min',
        csrfInterceptor: '../../assets/bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
        angularBootstrap: '../../assets/bower_components/angular-bootstrap/ui-bootstrap.min',
        angularRoute: '../../assets/bower_components/angular-route/angular-route.min',
        providerModule: 'providerModule'
    },
    shim: {
        angular: {
            exports: "angular"
        },
        csrfInterceptor: {
            deps: [ 'angular' ]
        },
        angularBootstrap: {
            deps: [ 'angular' ]
        },
        angularRoute: {
            deps: [ 'angular' ]
        },
        providerModule: {
            deps: [ 'angular', 'csrfInterceptor', 'angularBootstrap', 'angularRoute' ]
        }
    }
});

require(['providerModule'], function () {
    angular.bootstrap(document.getElementById('providerModule'), ['providerModule']);
});