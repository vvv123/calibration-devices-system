 angular
    .module('providerModule')
    .controller('AllVerificationController', ['$scope', '$http', 'VerificationService', 'StatisticService',
        function ($scope, $http, verificationService, statisticService) {

            $scope.totalItems = 0;
            $scope.currentPage = 1;
            $scope.itemsPerPage = 5;
            $scope.pageData = [];

            $scope.onTableHandling = function() {
                updatePage();
            };

            $scope.onOrganizationAddFormSubmit = function () {
                saveOrganization();
            };


            updatePage();

            function updateTotalItems() {
                statisticService.organizations().then(function (data) {
                    $scope.totalItems = data.count;
                });
            }

            function saveOrganization() {
                verificationService
                    .saveOrganization($scope.addFormData)
                    .then(function (data) {
                        $scope.addFormData = null;
                        updatePage();
                    });
            }

            function updatePage() {
                verificationService
                    .getPage($scope.currentPage, $scope.itemsPerPage, $scope.searchData)
                    .then(function (data) {
                        $scope.pageData = data;
                    });
                updateTotalItems();
            }
    }]);
