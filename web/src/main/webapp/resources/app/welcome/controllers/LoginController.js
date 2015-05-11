angular
    .module('mainModule')
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
                if (data == "SYS_ADMIN")
                    window.location.replace('/resources/app/admin/index.html');
            });
            response.error(function (data) {
                console.dir("OCCURRED ERROR");
                console.dir(data);
            })
        };

    }]);

