angular
    .module('adminModule')
    .controller('OrganizationsTableController', ['$scope', 'OrganizationsTableService', 'StatisticService',
        function ($scope, organizationsTableService, statisticService) {
            $scope.totalItems = 0;
            $scope.currentPage = 1;
            $scope.itemsPerPage = 5;
            $scope.pageData = [];

            statisticService.organizations().then(function (data) {
                $scope.totalItems = data.count;
            });

            $scope.pageChanged = function () {
                organizationsTableService
                    .getByNumberAndPage($scope.currentPage, $scope.itemsPerPage)
                    .then(function (data) {
                        console.dir(data);
                        $scope.pageData = data;
                    });
                console.log("changed to " + $scope.currentPage);
            };

            $scope.pageChanged();

            $scope.typeData = [
                {type: 'PROVIDER', name: 'Виконавець'},
                {type: 'CALIBRATOR', name: 'Повірочна організація'},
                {type: 'STATE_VERIFICATION', name: 'Державний повірник'}
            ];

            $scope.niceType = function (type) {
                var result = typeData(type);
                if (result == null || result == undefined)
                    result = "Організація";
                return result;
            }
    }]);