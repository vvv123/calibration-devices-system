angular
    .module('adminModule')
    .controller('CalibrationTestController', ['$scope', '$http', 'CalibrationTestService', 'StatisticService',
        function ($scope, $http, сalibrationTestService, statisticService) {

            $scope.calibrationTests = [];

            $scope.onCalibrationTestAddFormSubmit = function () {
                saveCalibrationTest();
                getCalibrationTests();
            };

            getCalibrationTests();

            function getCalibrationTests(){
                сalibrationTestService
                    .getCalibrationTests()
                    .then(function(data){
                        console.dir(data);
                        $scope.calibrationTests = data.calibrationTests;
                    })
            }

            function saveCalibrationTest() {
                сalibrationTestService
                    .saveCalibrationTest($scope.addFormData)
                    .then(function (data) {
                        $scope.addFormData = null;
                    });
            }


        }]);
