angular
    .module('clientModule')
    .controller('AccountController', ['$scope', '$http', function ($scope, $http) {
        $scope.hello = "Hello Account A";
        $scope.click1 = function () {
            $http.post("client", $scope.click1);
        }
    }]);

