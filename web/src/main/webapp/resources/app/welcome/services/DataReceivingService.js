welcomeModule
    .service('DataReceivingService', ['$http', function ($http) {
        this.getData = function (url) {

            return $http.get(url)
                .success(function (data) {
                    return data;
                })
                .error(function (err) {
                    return err;
                });
        };
    }]);
