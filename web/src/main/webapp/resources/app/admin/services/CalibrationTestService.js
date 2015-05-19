angular
    .module('adminModule')
    .factory('CalibrationTestService', function ($http) {
        return {
            getCalibrationTests: function () {
                var path = '/calibrationTests';

                return $http.get(path)
                    .then(function(result) {
                        return result.data;
                    });
            },
            saveCalibrationTest: function(formData) {
                return $http.post("/calibrationTests", formData)
                    .then(function(result) {
                        return result.data;
                    });
            }
        }
    });