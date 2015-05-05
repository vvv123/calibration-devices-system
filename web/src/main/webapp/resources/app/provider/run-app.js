require.config({
    paths: {
        angular: '../../assets/bower_components/angular/angular.min',
        angularRoute: '../../assets/bower_components/angular-route/angular-route.min',
        providerModule: 'module'
    },
    shim: {
        angular: {
            exports: "angular"
        },
        angularRoute: {
            deps: ['angular']
        },
        providerModule: {
            deps: [ 'angular', 'angularRoute']
        }
    }
});

require(['providerModule'], function () {

    angular.bootstrap(document.getElementById('providerModule'), ['providerModule']);

});