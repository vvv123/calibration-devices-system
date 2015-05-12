require.config({
    paths: {
        angular: '../../assets/bower_components/angular/angular.min',
        csrfInterceptor: '../../assets/bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
        angularBootstrap: '../../assets/bower_components/angular-bootstrap/ui-bootstrap.min',
        angularRoute: '../../assets/bower_components/angular-route/angular-route.min',
        adminModule: 'adminModule'
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
        adminModule: {
            deps: [ 'angular', 'csrfInterceptor', 'angularBootstrap', 'angularRoute' ]
        }
    }
});

require(['adminModule'], function () {
    angular.bootstrap(document.getElementById('adminModule'), ['adminModule']);
});