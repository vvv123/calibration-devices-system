welcomeModule
    .controller('ApplicationStatusController', ['$scope', '$http', '$translate', '$state', '$log', 'DataReceivingService',
        function ($scope, $http, $translate, $state, $log, dataSendingService) {

            $scope.isShownForm = true;

            $scope.findCode = function () {
                dataSendingService.getData('/application/check/' + $scope.code)
                    .success(function (status) {
                        $log.debug(status);
                        $scope.status = resolveStatus(status, $translate.use());
                    });
                $scope.isShownForm = false;
            };

            $scope.closeAlert = function () {
                $state.go($state.current, {}, {reload: true});
            }
        }]);

var resolveStatus = function (status, lang) {
    var translations = getTranslations(lang);
    switch (status) {
        case 'NOT_FOUND':
            return translations.notFound;
        case 'SENT':
            return translations.sent;
        case 'RECEIVED':
            return translations.received;
        case 'IN_PROGRESS':
            return translations.inProgress;
        case 'COMPLETED':
            return translations.completed;
    }
};

var getTranslations = function (lang) {
    var translations;
    if (lang === 'ukr') {
        translations = {
            notFound: 'Заявки з таким кодом не знайдено.',
            sent: 'Ваша заявка відправлена.',
            received: "Ваша заявка отримана. Ми зв'яжемось з вами найближчим часом.",
            inProgress: 'Ваша заявка в процесі обробки.',
            completed: 'Ваша заявка успішно виконана.'
        }
    } else if (lang === 'eng') {
        translations = {
            notFound: 'Application not found.',
            sent: 'Application sent.',
            received: "We have received your application and will contact you soon.",
            inProgress: 'Application in progress.',
            completed: 'Application completed.'
        }
    } else {
        console.error(lang);
    }
    return translations;
};
