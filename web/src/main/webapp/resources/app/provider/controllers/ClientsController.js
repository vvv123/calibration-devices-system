angular
    .module('providerModule')
    .controller('ClientsController', ['$scope', '$http', function ($scope, $http) {
        $scope.hello = "Hello Clients";
    }]);

