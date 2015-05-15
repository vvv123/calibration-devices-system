welcomeModule
    .controller('i18nCtrl', ['$scope','$translate',
    function ($scope, $translate) {
        //i18n
        $scope.languages = ["eng", "ukr"];
        $scope.selectedLang = "ukr";
        $scope.changeLanguage = function (selectedLang) {
            $translate.use(selectedLang);
        };
    }]);
