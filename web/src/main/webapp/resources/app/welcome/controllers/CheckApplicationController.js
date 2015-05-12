angular
    .module('welcomeModule')
    .controller('CheckApplicationController',[ '$scope', '$http',  function($scope, $http) {
        $scope.search = function() {
            var response = $http.post('/application/check', $scope.codeInfo);
            response.success(function(data, status, headers, config) {
                $scope.status =JSON.stringify(data);
            });
            response.error(function(data, status, headers, config) {
                console.dir(data);
            });
            //Empty list data after process
            /* $location.path( "/check-application" );*/
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
            /*console.log(JSON.stringify($scope.formInfo));*/
        };
    }]);
