angular
    .module('providerModule')
    .controller('ApplicationsController', ['$scope', '$http', function ($scope, $http) {
        $scope.hello = "Hello Applications";
    }]);

