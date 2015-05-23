angular
    .module('adminModule')
    .factory('OrganizationService', function ($http) {
        return {
            getPage: function (pageNumber, itemsPerPage, search) {
                var url = '/admin/organization/' + pageNumber + '/' + itemsPerPage;
                if (search != null && search != undefined && search != "")
                    url += '/' + search;

                return $http.get(url)
                    .then(function (result) {
                        return result.data;
                    });
            },
            saveOrganization: function (formData) {
                return $http.post("/admin/organization/add", formData)
                    .then(function (result) {
                        return result.status;
                    });
            }
        }
    });