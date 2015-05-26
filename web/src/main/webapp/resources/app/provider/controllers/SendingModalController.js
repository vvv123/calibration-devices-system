angular
    .module('providerModule')
    .controller('SendingModalController', ['$scope', '$modalInstance', '$log', 'calibrators',
        function ($scope, $modalInstance, $log, calibrators) {

            $scope.calibrators = calibrators.data;
            $log.info($scope.calibrators);

            $scope.close = function () {
                $modalInstance.close();
            };
            $scope.ok = function (calibrator) {
                $modalInstance.close(calibrator);
            }
        }]);


