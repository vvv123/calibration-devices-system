angular
    .module('welcomeModule')
    .service('RegionService', ['$http', function ($http) {
        this.receiveRegions = function () {
            return $http.get('/regions')
                .success(function (regions) {
                    return regions;
                })
                .error(function (err) {
                    return err;
                });
        };
    }]);