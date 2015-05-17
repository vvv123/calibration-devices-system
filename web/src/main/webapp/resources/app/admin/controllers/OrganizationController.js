 angular
    .module('adminModule')
    .controller('OrganizationController', ['$scope', '$http', 'OrganizationService', 'StatisticService',
        function ($scope, $http, organizationService, statisticService) {

            $scope.totalItems = 0;
            $scope.currentPage = 1;
            $scope.itemsPerPage = 5;
            $scope.pageData = [];
            $scope.typeData = [
                {type: 'PROVIDER', name: 'Постачальник послуг'},
                {type: 'CALIBRATOR', name: 'Повірочна організація'},
                {type: 'STATE_VERIFICATION', name: 'Державний повірник'}
            ];

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
                organizationService
                    .saveOrganization($scope.addFormData)
                    .then(function (data) {
                        $scope.addFormData = null;
                        updatePage();
                    });
            }

            function updatePage() {
                organizationService
                    .getPage($scope.currentPage, $scope.itemsPerPage, $scope.searchData)
                    .then(function (data) {
                        $scope.pageData = data;
                    });
                updateTotalItems();
            }
    }]);
