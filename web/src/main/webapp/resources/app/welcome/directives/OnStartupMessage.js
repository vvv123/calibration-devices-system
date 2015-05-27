angular
    .module('welcomeModule')
    .directive('OnStartupMessage', function () {
        return {
            restrict: 'E',
            link: function (scope, element, attributes) {
                element.remove();
            }
        };
    });