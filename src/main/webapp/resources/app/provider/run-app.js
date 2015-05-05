require.config({
    paths: {
        angular: '../../assets/javascripts/angular',
        angularRoute: '../../assets/javascripts/angular-route',
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