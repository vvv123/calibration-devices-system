require.config({
    paths: {
        angular: '../../assets/bower_components/angular/angular.min',
        angularScroll: '../../assets/bower_components/angular-scroll/angular-scroll.min',
        angularBootstrap: '../../assets/bower_components/angular-bootstrap/ui-bootstrap-tpls.min',
        csrfInterceptor: '../../assets/bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
        angularTranslate: '../../assets/bower_components/angular-translate/angular-translate.min',
        angularUIRouter: "../../assets/bower_components/angular-ui-router/release/angular-ui-router",
        welcomeModule: 'welcomeModule'
    },
    shim: {
        angular: {
            exports: "angular"
        },
        angularScroll: {
            deps: ['angular']
        },
        angularBootstrap: {
            deps: ['angular']
        },
        csrfInterceptor: {
            deps: ['angular']
        },
        angularTranslate: {
            deps: ['angular']
        },
        angularUIRouter: {
            deps: ['angular']
        },
        welcomeModule: {
            deps: ['angular', 'angularScroll', 'csrfInterceptor', 'angularBootstrap',
                'angularTranslate', 'angularUIRouter']
        }
    }
});

require(['welcomeModule'], function () {
    angular.bootstrap(document.getElementById('welcomeModule'), ['welcomeModule']);
});
