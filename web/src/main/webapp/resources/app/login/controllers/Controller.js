angular
    .module('loginModule')
    .controller('Controller', ['$scope', '$http', function ($scope, $http) {
        $scope.login = function () {
            var response = $http.post("/login/authorize", $scope.loginForm);
            response.success(function (data) {
                console.dir(data);
            });
            response.error(function (data) {
                console.dir(data);
            });
        }
    }]);

