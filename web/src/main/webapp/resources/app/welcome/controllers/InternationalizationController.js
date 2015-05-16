welcomeModule
    .controller('InternationalizationController', ['$scope','$translate',
    function ($scope, $translate) {

        $scope.languages = ["eng", "ukr"];
        $scope.selectedLang = $translate.use();
        $scope.changeLanguage = function (selectedLang) {
            $translate.use(selectedLang);
        };
    }]);
