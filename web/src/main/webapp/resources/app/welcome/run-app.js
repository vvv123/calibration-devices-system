require.config({
    paths: {
        angular: '../../assets/bower_components/angular/angular.min',
        angularScroll: '../../assets/bower_components/angular-scroll/angular-scroll.min',
        csrfInterceptor: '../../assets/bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
        mainModule: 'module'
    },
    shim: {
        angular: {
            exports: "angular"
        },
        angularScroll: {
            deps: ['angular']
        },
        csrfInterceptor: {
            deps: [ 'angular' ]
        },
        mainModule: {
            deps: [ 'angular', 'angularScroll', 'csrfInterceptor']
        }
    }
});

require(['mainModule'], function () {
    angular.bootstrap(document.getElementById('mainModule'), ['mainModule']);
});