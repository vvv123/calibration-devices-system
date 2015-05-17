welcomeModule
    .controller('InternationalizationController', ['$scope', '$translate', '$log',
        function ($scope, $translate, $log) {

            $scope.languages = ["eng", "ukr"];
            $scope.selectedLang = $translate.use();
            $scope.changeLanguage = function (selectedLang) {
                $translate.use(selectedLang);
            };
        }]);
