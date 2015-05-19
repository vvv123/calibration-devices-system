require.config({
    paths: {
        angular: '../../assets/bower_components/angular/angular.min',
        angularBootstrap: '../../assets/bower_components/angular-bootstrap/ui-bootstrap-tpls.min',
        csrfInterceptor: '../../assets/bower_components/spring-security-csrf-token-interceptor/dist/spring-security-csrf-token-interceptor.min',
        angularTranslate: '../../assets/bower_components/angular-translate/angular-translate.min',
        angularTranslateLoaderStaticFiles: '../../assets/bower_components/angular-translate-loader-static-files/angular-translate-loader-static-files.min',
        angularUIRouter: '../../assets/bower_components/angular-ui-router/release/angular-ui-router.min',
        angularCookie: '../../assets/bower_components/angular-cookies/angular-cookies.min',
        angularTranslateStorageLocal: '../../assets/bower_components/angular-translate-storage-local/angular-translate-storage-local.min',
        angularTranslateStorageCookie: '../../assets/bower_components/angular-translate-storage-cookie/angular-translate-storage-cookie.min',
        showErrors: '../../assets/bower_components/angular-bootstrap-show-errors/src/showErrors.min',
        welcomeModule: 'welcomeModule'
    },
    shim: {
        angular: {
            exports: "angular"
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
        angularCookie: {
            deps: ['angular']
        },
        angularTranslateStorageCookie: {
            deps: ['angular', 'angularTranslate', 'angularCookie']
        },
        angularTranslateStorageLocal: {
            deps: ['angular', 'angularTranslate', 'angularTranslateStorageCookie']
        },
        angularTranslateLoaderStaticFiles: {
            deps: ['angular', 'angularTranslate']
        },
        angularUIRouter: {
            deps: ['angular']
        },
        showErrors: {
            deps: ['angular']
        },
        welcomeModule: {
            deps: ['angular', 'csrfInterceptor', 'angularBootstrap',
                'angularTranslate', 'angularCookie', 'angularTranslateStorageCookie',
                'angularTranslateStorageLocal', 'angularTranslateLoaderStaticFiles', 'angularUIRouter',
                'showErrors']
        }
    }
});

require(['welcomeModule'], function () {
    angular.bootstrap(document.getElementById('welcomeModule'), ['welcomeModule']);
});
