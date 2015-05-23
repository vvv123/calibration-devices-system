angular
    .module('providerModule')
    .controller('NewVerificationsController', ['$scope', 'VerificationService',
        function ($scope, verificationService) {
            $scope.totalItems = 0;
            $scope.currentPage = 1;
            $scope.itemsPerPage = 5;
            $scope.pageData = [];

            $scope.onTableHandling = function () {
                updatePage();
            };

            updatePage();

            function updatePage() {
                verificationService
                    .getPage('/provider/verifications/new/' + $scope.currentPage + '/' + $scope.itemsPerPage)
                    .success(function (verifications) {
                        $scope.pageData = verifications.content;
                        $scope.totalItems = verifications.totalItems;
                    });
            }
        }]);
