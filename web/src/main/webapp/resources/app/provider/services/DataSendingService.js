angular.module('providerModule')
    .service('DataSendingService', ['$http', function ($http) {
        this.sendData = function (url, data) {
            return $http.post(url, data)
                .success(function (responseData) {
                    return responseData;
                })
                .error(function (err) {
                    return err;
                });
        };
    }]);
