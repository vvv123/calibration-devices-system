angular
    .module('adminModule')
    .controller('OrganizationController', ['$scope', '$http', 'OrganizationService', 'StatisticService',
        function ($scope, $http, organizationService, statisticService) {

            $scope.totalItems = 0;
            $scope.currentPage = 1;
            $scope.itemsPerPage = 5;
            $scope.pageData = [];

            /**
             * Loads total count of organizations
             */
            statisticService.organizations().then(function (data) {
                $scope.totalItems = data.count;
            });

            /**
             * Loads new data when currentPage or itemsPerPage changes
             */
            $scope.loadPage = function () {
                organizationService
                    .getByNumberAndPage($scope.currentPage, $scope.itemsPerPage)
                    .then(function (data) {
                        console.dir(data);
                        $scope.pageData = data;
                    });
                console.log("changed to " + $scope.currentPage);
            };

            /**
             * Loads first page for organizations table
             */
            $scope.loadPage();


            $scope.typeData = [
                {type: 'PROVIDER', name: 'Виконавець'},
                {type: 'CALIBRATOR', name: 'Повірочна організація'},
                {type: 'STATE_VERIFICATION', name: 'Державний повірник'}
            ];

            /**
             * Sends organization form data to save it in database
             */
            $scope.addOrganization = function () {
                var response = $http.post("/admin/organization/add", $scope.addFormData);
                response.success(function () {
                    console.log('success + Організація додана успішно');
                    $scope.addFormData = null;
                    $scope.loadPage();
                });
                response.error(function () {
                    console.log('success + Виникла помилка на сервері. Запит не оброблено');
                });
            };

            $scope.niceType = function (type) {
                var result = "Організація";
                $scope.typeData.forEach(function(data){
                    if (data.type == type)
                        result = data.name;
                });
                return result;
            }


    }]);
