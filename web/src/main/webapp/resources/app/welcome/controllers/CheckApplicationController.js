angular
    .module('welcomeModule')
    .controller('CheckApplicationController',['$scope', '$http',  function($scope, $http) {
        $scope.search = function() {
            var response = $http.post('/application/check/', $scope.codeInfo);
            response.success(function(data) {
                $scope.status = JSON.stringify(data);
            });
            response.error(function(data) {
                console.dir(data);
            });

        };
    }]);
