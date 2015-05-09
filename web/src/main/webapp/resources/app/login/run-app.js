require.config({
    paths: {
        angular: '../../assets/bower_components/angular/angular.min',
        loginModule: 'module'
    },
    shim: {
        angular: {
            exports: "angular"
        },
        loginModule: {
            deps: [ 'angular']
        }
    }
});

require(['loginModule'], function () {

    angular.bootstrap(document.getElementById('loginModule'), ['loginModule']);


});