angular
    .module('providerModule')
    .factory('StatisticService', function ($http) {
        var getData = function (type) {
            return $http.get('/provider/statistics/' + type)
                .then(function(result) {
                    return result.data;
                });
        };
        return {
            organizations: function() { return getData('organizations'); },
            users: function() { return getData('users'); },
            devices: function() { return getData('devices'); },
            verifications: function() { return getData('verifications'); }
        }
    });