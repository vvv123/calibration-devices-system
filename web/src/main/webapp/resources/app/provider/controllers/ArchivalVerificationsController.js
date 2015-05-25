angular
    .module('providerModule')
    .controller('ArchivalVerificationsController', ['$scope', '$modal', '$log', 'DataReceivingService',
        function ($scope, $modal, $log, dataReceivingService) {

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
                    .getData('/provider/verifications/archive/' + $scope.currentPage + '/' + $scope.itemsPerPage)
                    .success(function (verifications) {
                        $scope.pageData = verifications.content;
                        $scope.totalItems = verifications.totalItems;
                    });
            }

            $scope.open = function ($index) {
                $modal.open({
                    animation: true,
                    templateUrl: '/resources/app/provider/views/archival-verification-details.html',
                    controller: 'ModalController',
                    size: 'lg',
                    resolve: {
                        verification: function () {
                            return dataReceivingService.getData('/provider/verifications/archive/' + $scope.pageData[$index].id)
                                .success(function (verification) {
                                    return verification;
                                });
                        }
                    }
                });
            };

        }]);
