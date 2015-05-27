angular
    .module('providerModule')
    .controller('TopNavBarController', ['$scope', '$http', function ($scope, $http) {
        $scope.logout = function () {
            $http({
                method: 'POST',
                url: '/logout'
            }).then(function () {
                window.location.replace("/");
            });
        };
    }]);
