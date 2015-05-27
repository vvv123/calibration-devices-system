angular
    .module('providerModule')
    .controller('DetailsModalController', ['$scope', '$modalInstance', '$log', 'verification',
        function ($scope, $modalInstance, $log, verification) {

            $scope.verificationData = verification.data;
            $log.info($scope.verificationData);

            $scope.close = function () {
                $modalInstance.close();
            };
        }]);
