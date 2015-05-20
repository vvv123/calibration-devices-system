angular.module('providerModule')
    .service('DataReceivingService', ['$http', function ($http) {
        this.getData = function (url) {
            return $http.get(url)
                .then(function (result) {
                    return result.data;
                })
        };
    }]);
