 angular
    .module('adminModule')
    .controller('OrganizationController', ['$scope', '$http', 'OrganizationService', 'StatisticService',
        function ($scope, $http, organizationService, statisticService) {

            $scope.totalItems = 0;
            $scope.currentPage = 1;
            $scope.itemsPerPage = 5;
            $scope.pageContent = [];
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

            function saveOrganization() {
                organizationService
                    .saveOrganization($scope.organizationsFormData)
                    .then(function (data) {
                        $scope.organizationsFormData = null;
                        updatePage();
                    });
            }

            function updatePage() {
                organizationService
                    .getPage($scope.currentPage, $scope.itemsPerPage, $scope.searchData)
                    .then(function (data) {
                        $scope.pageContent = data.content;
                        $scope.totalItems = data.totalItems;
                    });
            }
    }]);
