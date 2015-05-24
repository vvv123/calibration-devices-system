angular
    .module('providerModule')
    .controller('ModalController', ['$scope', '$modalInstance', '$log', 'verification',
        function ($scope, $modalInstance, $log, verification) {

            $scope.verificationData = verification.data;
            $log.info($scope.verificationData);

            $scope.close = function () {
                $modalInstance.close();
            };
        }]);
