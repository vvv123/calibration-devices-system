angular.module('providerModule')
    .controller('FindAllApplication', ['$scope', '$http', '$state', 'DataReceivingService',
        function ($scope, $http, $state, dataReceivingService) {

            $scope.getAllAvailableApplication = function () {
                dataReceivingService.getData('/provider/application/update')
                    .then(function (data) {
                        console.dir(data);
                        console.log(data);
                        $scope.dataData = data;
                    });
            };

            $scope.getAllAvailableApplication();
        }]);

