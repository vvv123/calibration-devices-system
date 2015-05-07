angular
    .module('clientModule')
    .controller('AddApplicationsController', ['$scope', function($scope) {
        $scope.formInfo = {};
        $scope.saveData = function() {


           /* if (!$scope.formInfo.name) {
                $scope.nameRequired = 'name is required';
            }

            if (!$scope.formInfo.lastName) {
                $scope.emailRequired = 'last name is required';
            }

            if (!$scope.formInfo.middleName) {
                $scope.passwordRequired = 'middle name is required';
            }
            if (!$scope.formInfo.region) {
                $scope.passwordRequired = 'region is required';
            }
            if (!$scope.formInfo.locality) {
                $scope.passwordRequired = 'locality is required';
            }
            if (!$scope.formInfo.district) {
                $scope.passwordRequired = 'district is required';
            }
            if (!$scope.formInfo.street) {
                $scope.passwordRequired = 'street is required';
            }
            if (!$scope.formInfo.building) {
                $scope.passwordRequired = 'building is required';
            }
            if (!$scope.formInfo.email) {
                $scope.passwordRequired = 'email is required';
            }
            if (!$scope.formInfo.phone) {
                $scope.passwordRequired = 'phone is required';
            }
*/
            console.log(JSON.stringify($scope.formInfo));
        };
    }]);

