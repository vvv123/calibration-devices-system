angular
    .module('providerModule')
    .service('VerificationService', ['$http', function ($http) {
        return {
            getPage: function (url) {
                return $http.get(url)
                    .success(function (result) {
                        return result.data;
                    });
            }
        }
    }]);
