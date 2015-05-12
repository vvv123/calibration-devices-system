angular
    .module('welcomeModule')
    .controller('CheckApplicationController',[ '$scope', '$http',  function($scope, $http) {
        $scope.myAlert = true;
        $scope.search = function() {
            var response = $http.post('/application/check/', $scope.codeInfo);
            response.success(function(data) {
                $scope.status =JSON.stringify(data.name);
                $scope.myAlert = false;
            });
            response.error(function(data, status, headers, config) {
                console.dir(data);
            });
        };
    }]);
