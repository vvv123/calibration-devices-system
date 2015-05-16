welcomeModule
    .controller('ApplicationStatusController', ['$scope', '$http', function ($scope, $http) {

        $scope.isShownForm = true;

        $scope.findCode = function () {
            var response = $http.post('/application/check/', $scope.codeInfo);
            response.success(function (data) {
                $scope.status = JSON.stringify(data.name);
            });
            response.error(function (data, status, headers, config) {
                console.dir(data);
            });
            $scope.isShownForm = false;
        };

        $scope.closeAlert = function () {
            $scope.isShownForm = true;
        }
    }]);
