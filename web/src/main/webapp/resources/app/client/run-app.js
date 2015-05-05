require.config({
    paths: {
        angular: '../../assets/bower_components/angular/angular.min',
        angularRoute: '../../assets/bower_components/angular-route/angular-route.min',
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