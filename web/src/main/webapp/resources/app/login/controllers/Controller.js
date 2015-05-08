angular
    .module('loginModule')
    .controller('Controller', ['$scope', '$http', function ($scope, $http) {
        $scope.login = function () {
            var response = $http.post("/login/authorize", {
                username: $scope.loginForm.username,
                password: $scope.loginForm.password
            });
            response.success(function (data) {
                console.dir(data);
            });
            response.error(function (data) {
                console.dir(data);
            });
        }
    }]);

