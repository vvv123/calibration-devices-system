welcomeModule
    .service('CatalogueService', ['$http', function ($http) {
        this.getCatalogue = function (url) {

            return $http.get(url)
                .success(function (catalogue) {
                    return catalogue;
                })
                .error(function (err) {
                    return err;
                });
        };
    }]);
