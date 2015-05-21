angular
    .module('providerModule')
    .controller('AllVerificationController', ['$scope', 'VerificationService',
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
                    .getPage($scope.currentPage, $scope.itemsPerPage)
                    .then(function (data) {
                        $scope.pageData = data.content;
                        $scope.totalItems = data.totalItems;
                    });
            }
        }]);
