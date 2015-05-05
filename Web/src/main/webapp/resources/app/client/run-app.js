require.config({
    paths: {
        angular: '../../assets/javascripts/angular',
        angularRoute: '../../assets/javascripts/angular-route',
        clientModule: 'module'
    },
    shim: {
        angular: {
            exports: "angular"
        },
        angularRoute: {
            deps: ['angular']
        },
        clientModule: {
            deps: [ 'angular', 'angularRoute']
        }
    }
});

require(['clientModule'], function () {

    angular.bootstrap(document.getElementById('clientModule'), ['clientModule']);


});