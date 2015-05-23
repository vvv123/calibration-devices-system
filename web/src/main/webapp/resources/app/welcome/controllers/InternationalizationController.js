angular
    .module('welcomeModule')
    .controller('InternationalizationController', ['$scope', '$translate', '$log',
        function ($scope, $translate, $log) {

            $scope.languages = [
                {
                    key: 'eng',
                    name: "English"
                },
                {
                    key: 'ukr',
                    name: "Українська"
                }];
            $scope.changeLanguage = function (key) {
                $translate.use(key);
            };
        }]);
