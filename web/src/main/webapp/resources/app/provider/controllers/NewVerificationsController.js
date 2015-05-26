angular
    .module('providerModule')
    .controller('NewVerificationsController', ['$scope', '$modal', '$log', 'DataReceivingService', 'DataUpdatingService',
        function ($scope, $modal, $log, dataReceivingService, dataUpdatingService) {

            $scope.totalItems = 0;
            $scope.currentPage = 1;
            $scope.itemsPerPage = 5;
            $scope.pageData = [];

            $scope.onTableHandling = function () {
                updatePage();
            };

            updatePage();

            function updatePage() {
                dataReceivingService
                    .getData('/provider/verifications/new/' + $scope.currentPage + '/' + $scope.itemsPerPage)
                    .success(function (verifications) {
                        $scope.pageData = verifications.content;
                        $scope.totalItems = verifications.totalItems;
                    });
            }

            $scope.openDetails = function ($index) {
                $modal.open({
                    animation: true,
                    templateUrl: '/resources/app/provider/views/new-verification-details.html',
                    controller: 'DetailsModalController',
                    size: 'lg',
                    resolve: {
                        verification: function () {
                            return dataReceivingService.getData('/provider/verifications/new/' + $scope.pageData[$index].id)
                                .success(function (verification) {
                                    verification.id = $scope.pageData[$index].id;
                                    verification.initialDate = $scope.pageData[$index].initialDate;
                                    return verification;
                                });
                        }
                    }
                });
            };

            $scope.array = [];
            $scope.saveInfo = function (id) {
                $scope.array.push(id);
            };
            function sendVerification(calibratorId) {
                var dataToSend = {
                    verificationIds: $scope.array,
                    calibrator: calibratorId
                };
                dataUpdatingService
                    .updateData('/provider/verifications/new/update', dataToSend)
                    .success(function () {
                    });
                updatePage();
            };

            $scope.openSending = function () {
              var moduleInstance =  $modal.open({
                    animation: true,
                    templateUrl: '/resources/app/provider/views/verification-sending.html',
                    controller: 'SendingModalController',
                    size: 'sm',
                    resolve: {
                        calibrators: function () {
                            return dataReceivingService.getData('/provider/verifications/new/calibrators')
                             .success(function (calibrators) {
                             return calibrators;
                             });
                        }
                    }
                });
                 moduleInstance.result.then(function (calibrator) {
                     sendVerification(calibrator);
                     updatePage();
                 });
            }
        }]);
