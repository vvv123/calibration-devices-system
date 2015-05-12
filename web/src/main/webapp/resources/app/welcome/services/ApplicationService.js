welcomeModule
    .service('ApplicationService', ['$http', function ($http) {
        this.sendApplication = function (url, applicationData) {
            return $http.post(url, applicationData)
                .success(function (applicationCode) {
                    return applicationCode;
                })
                .error(function (err) {
                    return err;
                });
        };
    }]);
