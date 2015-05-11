angular
    .module('adminModule')
    .controller('GlobalController', ['$scope', '$http', function ($scope, $http) {
        $scope.logout = function () {
            $http({
                method: 'POST',
                url: '/logout'
            }).then(function (data) {
                window.location.replace("/");
            });

        };
    }]);