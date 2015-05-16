welcomeModule
    .controller('ApplicationStatusController', ['$scope', '$http', 'DataReceivingService',
        function ($scope, $http, dataSendingService) {

            $scope.isShownForm = true;

            $scope.findCode = function () {
                dataSendingService.getData('/application/check/' +  $scope.codeInfo)
                    .success(function (status) {
                        console.log(status)
                    });
                $scope.isShownForm = false;
            };

            $scope.closeAlert = function () {
                $scope.isShownForm = true;
            }
        }]);
