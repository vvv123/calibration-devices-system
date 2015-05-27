angular
    .module('adminModule')
    .controller('OrganizationFormController', ['$rootScope', '$scope', '$modal', 'OrganizationService', 'UserService',
        function ($rootScope, $scope, $modal, organizationService, userService) {

            $scope.addressMessage = "";

            $rootScope.addressForm = {
                region: null,
                district: null,
                locality: null,
                street: null,
                building: null,
                flat: null
            };

            $rootScope.updateAddressMessage = function () {
                var message = '';
                if ($rootScope.addressForm.region != null) {
                    message += $rootScope.addressForm.region.designation + ' область';
                }
                if ($rootScope.addressForm.district != null) {
                    message += ', ' + $rootScope.addressForm.district.designation + ' район';
                }
                if ($rootScope.addressForm.locality != null) {
                    message += ',\n ' + $rootScope.addressForm.locality.designation;
                }
                if ($rootScope.addressForm.street != null) {
                    message += ', ' + $rootScope.addressForm.street.designation;
                }
                if ($rootScope.addressForm.building != null) {
                    message += ', буд. ' + $rootScope.addressForm.building.designation;
                }
                if ($rootScope.addressForm.flat != null) {
                    message += ', кв. ' + $rootScope.addressForm.flat;
                }
                $scope.addressMessage = message;
            };


            $scope.checkUsername = function () {
                var username = $scope.organizationsFormData.username;
                /^[a-z0-9_-]{3,16}$/.test(username) ?
                    isUsernameAvailable(username) :
                    validateUsername(false, 'does not correspond the standard');
            };

            $scope.onOrganizationFormSubmit = function () {
                $scope.$broadcast('show-errors-check-validity');
                if ($scope.organizationForm.$valid && $scope.usernameValidation.isValid) {
                    $scope.organizationsFormData.region = $rootScope.addressForm.region.designation;
                    $scope.organizationsFormData.district = $rootScope.addressForm.district.designation;
                    $scope.organizationsFormData.locality = $rootScope.addressForm.locality.designation;
                    $scope.organizationsFormData.street = $rootScope.addressForm.street.designation;
                    $scope.organizationsFormData.building = $rootScope.addressForm.building.designation;
                    $scope.organizationsFormData.flat = $rootScope.addressForm.flat;
                    saveOrganization();
                }
            };

            $scope.resetOrganizationForm = function () {
                $scope.$broadcast('show-errors-reset');
                $scope.usernameValidation = null;
                $scope.organizationsFormData = null;

            };

            $scope.openAddressModal = function () {
                var addressModal = $modal.open({
                    animation: true,
                    controller: 'OrganizationModalAddressController',
                    templateUrl: '/resources/app/admin/views/organization-modal-address.html',
                    size: 'lg'
                });

                addressModal.result.then(function () {
                    $rootScope.updateAddressMessage();
                });
            };

            function saveOrganization() {
                organizationService
                    .saveOrganization($scope.organizationsFormData)
                    .then(function (data) {
                        if (data == 201) {
                            $scope.resetOrganizationForm();
                            $scope.onTableHandling();
                        }
                    });
            }

            function validateUsername(isValid, message) {
                $scope.usernameValidation = {
                    isValid: isValid,
                    css: isValid ? 'has-success' : 'has-error',
                    message: isValid ? undefined : message
                }
            }

            function isUsernameAvailable(username) {
                userService
                    .isUsernameAvailable(username)
                    .then(function (data) {
                        validateUsername(data, 'already exists');
                    })
            }

        }]);
