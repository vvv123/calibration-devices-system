angular
    .module('providerModule')
    .controller('AccountController', ['$scope', '$http', function ($scope, $http) {
        $scope.hello = "Hello Account";
    }]);

