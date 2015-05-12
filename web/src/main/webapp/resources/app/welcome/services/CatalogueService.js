angular
    .module('welcomeModule')
    .service('CatalogueService', ['$http', function ($http) {
        this.sendDTO = function (catalogueDTO, url) {
            return $http.post(url, catalogueDTO)
                .success(function (data) {
                    return data;
                })
                .error(function (err) {
                    return err;
                });
        };
    }]);