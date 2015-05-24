angular
    .module('providerModule')
    .service('DataReceivingService', ['$http', '$log', function ($http, $log) {
        return {
            getData: function (url) {
                $log.info(url);
                return $http.get(url)
                    .success(function (result) {
                        return result.data;
                    });
            }
        }
    }]);
