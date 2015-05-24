angular
    .module('welcomeModule')
    .controller('LoginController', ['$scope', '$http', function ($scope, $http) {
        $scope.login = function () {

            var loginData = 'username=' + $scope.loginForm.username
                + '&password=' + $scope.loginForm.password;

            var request = {
                method: 'POST',
                url: '/authenticate',
                data: loginData,
                headers: {
                    'Content-Type': "application/x-www-form-urlencoded",
                    'X-Login-Ajax-call': 'true'
                }
            };

            var response = $http(request);
            response.success(function (data) {
                var path = redirectByRole(data);
                $scope.loginForm.password = null;
                if (path)
                    window.location.replace(path);
            });
            response.error(function (data) {
                console.dir(data);
            });

            function redirectByRole(role) {
                var path = undefined;
                if (role == "SYS_ADMIN")
                    path = '/admin';
                else if (role == 'CALIBRATOR_EMPLOYEE' || role == 'CALIBRATOR_ADMIN')
                    path = '/calibrator';
                else if (role == 'PROVIDER_EMPLOYEE' || role == 'PROVIDER_ADMIN')
                    path = '/provider';
                else if (role == 'STATE_VERIFICATOR_EMPLOYEE' || role == 'STATE_VERIFICATOR_ADMIN')
                    path = '/verification';
                return path;
            }
        };

    }]);
