require.config({
    paths: {
        angular: '../../assets/bower_components/angular/angular.min',
        csrfInterceptor: '../../assets/bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
        angularBootstrap: '../../assets/bower_components/angular-bootstrap/ui-bootstrap-tpls.min',
        angularUIRouter: '../../assets/bower_components/angular-ui-router/release/angular-ui-router.min',
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
        angularUIRouter: {
            deps: [ 'angular' ]
        },
        adminModule: {
            deps: [ 'angular', 'csrfInterceptor', 'angularBootstrap', 'angularUIRouter' ]
        }
    }
});

require(['adminModule'], function () {
    angular.bootstrap(document.getElementById('adminModule'), ['adminModule']);
});