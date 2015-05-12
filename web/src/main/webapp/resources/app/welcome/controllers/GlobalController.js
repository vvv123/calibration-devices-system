welcomeModule
    .controller('GlobalController', ['$scope', '$http', function ($scope, $http) {

        $scope.getUser = function () {
            var response = $http.get('/getuser');
            response.success(function (data) {
                console.log("success get user");
                console.dir(data);
            });
            response.error(function (data) {
                console.log("error get user");
                console.dir(data);
            });
        };
    }]);