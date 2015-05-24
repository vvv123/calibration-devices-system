angular
    .module('providerModule')
    .controller('NewVerificationsController', ['$scope', '$modal', '$log', 'DataReceivingService',
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
                    .getData('/provider/verifications/new/' + $scope.currentPage + '/' + $scope.itemsPerPage)
                    .success(function (verifications) {
                        $scope.pageData = verifications.content;
                        $scope.totalItems = verifications.totalItems;
                    });
            }

            $scope.open = function ($index) {
                $modal.open({
                    animation: true,
                    templateUrl: '/resources/app/provider/views/new-verification-details.html',
                    controller: 'ModalController',
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
        }]);
