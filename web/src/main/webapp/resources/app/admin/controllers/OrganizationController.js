 angular
    .module('adminModule')
    .controller('OrganizationController', ['$scope', '$http', 'OrganizationService', 'UserService',
        function ($scope, $http, organizationService, userService) {

            $scope.totalItems = 0;
            $scope.currentPage = 1;
            $scope.itemsPerPage = 5;
            $scope.pageContent = [];
            $scope.typeData = [
                {type: 'PROVIDER', name: 'Постачальник послуг'},
                {type: 'CALIBRATOR', name: 'Повірочна організація'},
                {type: 'STATE_VERIFICATION', name: 'Державний повірник'}
            ];

            $scope.onTableHandling = function () {
                updatePage();
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
                    saveOrganization();
                    updatePage();
                }
            };

            $scope.resetOrganizationForm = function () {
                $scope.$broadcast('show-errors-reset');
                $scope.usernameValidation = null;
                $scope.organizationsFormData = null;

            };

            updatePage();

            function saveOrganization() {
                organizationService
                    .saveOrganization($scope.organizationsFormData)
                    .then(function (data) {
                        if (data == 201) {
                            $scope.resetOrganizationForm();
                        }
                        updatePage();
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

            function updatePage() {
                organizationService
                    .getPage($scope.currentPage, $scope.itemsPerPage, $scope.searchData)
                    .then(function (data) {
                        $scope.pageContent = data.content;
                        $scope.totalItems = data.totalItems;
                    });
            }
    }]);
