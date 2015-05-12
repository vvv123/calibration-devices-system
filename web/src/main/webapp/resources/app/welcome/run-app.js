require.config({
    paths: {
        angular: '../../assets/bower_components/angular/angular.min',
        angularScroll: '../../assets/bower_components/angular-scroll/angular-scroll.min',
        //angularRoute: '../../assets/bower_components/angular-route/angular-route.min',
        angularBootstrap: '../../assets/bower_components/angular-bootstrap/ui-bootstrap-tpls.min',
        csrfInterceptor: '../../assets/bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
        angularTranslate: '../../assets/bower_components/angular-translate/angular-translate.min',
        welcomeModule: 'welcomeModule'
    },
    shim: {
        angular: {
            exports: "angular"
        },
        angularScroll: {
            deps: ['angular']
        },
        /*angularRoute: {
            deps: ['angular']
        },*/
        angularBootstrap: {
            deps: ['angular']
        },
        csrfInterceptor: {
            deps: ['angular']
        },
        angularTranslate: {
            deps: ['angular']
        },
        welcomeModule: {
            deps: ['angular', 'angularScroll', 'csrfInterceptor', 'angularBootstrap', 'angularTranslate']
        }
    }
});

require(['welcomeModule'], function () {
    angular.bootstrap(document.getElementById('welcomeModule'), ['welcomeModule']);
});
