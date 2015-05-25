angular
    .module('providerModule')
    .controller('NewVerificationsController', ['$scope', '$modal', '$log', 'DataReceivingService','DataUpdatingService',
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


            $scope.array = [];
            $scope.saveInfo = function(verification){
                console.log(verification);
                $scope.array.push(verification);
                console.log($scope.array,toString());
            }
            $scope.send = function sendVerification() {
                dataUpdatingService
                    .updateData('/provider/verifications/new/update', $scope.array )
                    .success(function (verifications) {
                    });
                console.log($scope.array,toString());
                updatePage();
            }

        }]);
