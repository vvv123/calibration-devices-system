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

            $scope.verificationIds = [];
            checkedItems = [];


            $scope.resolveVerificationId = function (id, $index) {
                console.log(checkedItems[$index]);
                if (!checkedItems[$index]) {
                    $log.info("checked");
                    $scope.verificationIds[$index] = id;
                    $log.info($scope.verificationIds);
                    checkedItems[$index] = true;
                } else {
                    $log.info("unchecked");
                    $scope.verificationIds[$index] = undefined;
                    checkedItems[$index] = false;
                }
            };

            function sendVerification(calibratorId) {
                var dataToSend = {
                    verificationIds: $scope.verificationIds,
                    calibrator: calibratorId
                };
                dataUpdatingService
                    .updateData('/provider/verifications/new/update', dataToSend)
                    .success(function () {
                    });
                $scope.verificationIds = [];
            }

            $scope.openSending = function () {
                var moduleInstance = $modal.open({
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
                    $log.info(calibrator);
                    try{
                        if(calibrator.id!=='undefined' && calibrator.name!=='undefined') {
                            sendVerification(calibrator);
                            checkedItems = [];
                            console.log(calibrator);
                        }
                    }
                    catch(err){
                        $scope.verificationIds = [];
                        checkedItems = [];
                        console.log(calibrator);
                    }
                    updatePage();
                });
            }
        }]);
