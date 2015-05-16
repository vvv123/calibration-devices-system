require.config({
    paths: {
        angular: '../../assets/bower_components/angular/angular.min',
        angularScroll: '../../assets/bower_components/angular-scroll/angular-scroll.min',
        angularBootstrap: '../../assets/bower_components/angular-bootstrap/ui-bootstrap-tpls.min',
        csrfInterceptor: '../../assets/bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
        angularTranslate: '../../assets/bower_components/angular-translate/angular-translate.min',
        angularTranslateLoaderStaticFiles: '../../assets/bower_components/angular-translate-loader-static-files/angular-translate-loader-static-files.min',
        angularUIRouter: '../../assets/bower_components/angular-ui-router/release/angular-ui-router.min',
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
        angularTranslateLoaderStaticFiles: {
            deps: ['angular', 'angularTranslate']
        },
        angularUIRouter: {
            deps: ['angular']
        },
        welcomeModule: {
            deps: ['angular', 'angularScroll', 'csrfInterceptor', 'angularBootstrap',
                'angularTranslate', 'angularTranslateLoaderStaticFiles', 'angularUIRouter']
        }
    }
});

require(['welcomeModule'], function () {
    angular.bootstrap(document.getElementById('welcomeModule'), ['welcomeModule']);
});
