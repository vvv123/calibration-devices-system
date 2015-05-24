angular
    .module('adminModule')
    .factory('AddressService', function ($http) {

        function findAll(type) {
            return $http.get('/application/' + type)
                .then(function (result) {
                    return result.data;
                });
        }

        return {
            findAllRegions: function () {
                return findAll('regions');
            },
            findDistrictsByRegionId: function (id) {
                return findAll('districts/' + id);
            },
            findLocalitiesByDistrictId: function (id) {
                return findAll('localities/' + id);
            },
            findStreetsByLocalityId: function (id) {
                return findAll('streets/' + id);
            },
            findBuildingsByStreetId: function (id) {
                return findAll('buildings/' + id);
            }
        }
    });