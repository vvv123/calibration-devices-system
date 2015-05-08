angular
    .module('loginModule')
    .controller('Controller', ['$scope', '$http', function ($scope, $http) {
        $scope.welcome = "Welcome";

        $scope.signIn = function () {
            var response = $http.post('/login/authenticate', {
                username: $scope.login.email,
                password: $scope.login.password
            });
            //response.success;
        };

    }]);

