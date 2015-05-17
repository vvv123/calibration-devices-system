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

            updatePage();

            $scope.onTableHandling = function () {
                updatePage($scope.currentPage, $scope.itemsPerPage, $scope.searchData)
            };

            function updateTotalItems() {
                statisticService.organizations().then(function (data) {
                    $scope.totalItems = data.count;
                });
            }

            function saveOrganization (formData) {
                organizationService
                    .saveOrganization(formData)
                    .then(function (data) {
                        $scope.addFormData = null;
                        updateTotalItems();
                    });
            }

            function updatePage(currentPage, itemsPerPage, search) {
                organizationService
                    .getPage(currentPage, itemsPerPage, search)
                    .then(function (data) {
                        $scope.pageData = data;
                    });
                updateTotalItems();
            }
    }]);
