angular
    .module('providerModule')
    .factory('VerificationService', function ($http) {
        return {
            getPage: function (pageNumber, itemsPerPage) {
                var path = '/provider/applications/' + pageNumber + '/' + itemsPerPage;

                return $http.get(path)
                    .then(function(result) {
                        return result.data;
                    });
            }
        }
    });

