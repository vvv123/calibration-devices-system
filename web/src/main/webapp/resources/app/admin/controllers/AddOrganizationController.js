angular
    .module('adminModule')
    .controller('AddOrganizationController', ['$scope', '$http', function ($scope, $http) {

        $scope.typeData = [
            {type: 'PROVIDER', name: 'Виконавець'},
            {type: 'CALIBRATOR', name: 'Повірочна організація'},
            {type: 'STATE_VERIFICATION', name: 'Державний повірник'}
        ];

        $scope.addOrganization = function () {
            var response = $http.post("/admin/organization/add", $scope.addFormData);
            response.success(function () {
                console.log('success + Організація додана успішно');
                $scope.addFormData = null;
            });
            response.error(function () {
                console.log('success + Виникла помилка на сервері. Запит не оброблено');
            });
        };


    }]);
