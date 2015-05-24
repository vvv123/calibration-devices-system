angular
    .module('welcomeModule')
    .service('DataReceivingService', ['$http','$log', function ($http, $log) {
        this.getData = function (url) {
            $log.log(url);
            return $http.get(url)
                .success(function (data) {
                    return data;
                })
                .error(function (err) {
                    return err;
                });
        };
    }]);
