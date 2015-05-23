angular
    .module('adminModule')
    .factory('OrganizationService', function ($http) {
        return {
            getPage: function (pageNumber, itemsPerPage, search) {
                var path = '/admin/organization/page/' + pageNumber + '/' + itemsPerPage;
                if (search != null && search != undefined && search != "")
                    path += '/' + search;

                return $http.get(path)
                    .then(function(result) {
                        return result.data;
                    });
            },
            saveOrganization: function(formData) {
                return $http.post("/admin/organization/add", formData)
                    .then(function(result) {
                        return result.data;
                    });
            }
        }
    });