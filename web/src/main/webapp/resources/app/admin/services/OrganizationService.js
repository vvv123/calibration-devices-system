angular
    .module('adminModule')
    .factory('OrganizationService', function ($http) {
        return {
            getByNumberAndPage: function (pageNumber, itemsPerPage) {
                return $http.get('/admin/organization/page/' + pageNumber + '/' + itemsPerPage)
                    .then(function(result) {
                        return result.data;
                    });
            }
        }
    });