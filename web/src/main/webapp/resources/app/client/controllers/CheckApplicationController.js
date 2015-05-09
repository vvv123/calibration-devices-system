angular
    .module('clientModule')
    .controller('CheckApplicationController', ['$scope', '$http', function ($scope, $http) {
        $scope.check = "Hello Check";
    }]);
