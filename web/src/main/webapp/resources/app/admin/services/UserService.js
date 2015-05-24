angular
    .module('adminModule')
    .factory('UserService', function ($http) {
        return {
            isUsernameAvailable: function (username) {
                var url = '/admin/users/available/' + username;
                return $http.get(url)
                    .then(function(result) {
                        return result.data;
                    });
            }
        }
    });