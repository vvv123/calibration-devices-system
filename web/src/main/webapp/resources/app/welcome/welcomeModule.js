var welcomeModule = angular.module('welcomeModule', ['spring-security-csrf-token-interceptor',
    'duScroll', 'ui.bootstrap', 'pascalprecht.translate'])
    .config(['$translateProvider',
        function ($translateProvider) {
            $translateProvider.useSanitizeValueStrategy('escaped');
            $translateProvider
                .translations('eng', engProperites)
                .translations('ukr', ukrProperties);
            $translateProvider.preferredLanguage('ukr');
        }]);
define([
    'controllers/LoginController',
    'controllers/AddApplicationsController',
    'controllers/CheckApplicationController',
    'services/CatalogueService',
    'services/ApplicationService'
], function () {
});

var engProperites = {
    SEND_APP_TITLE: 'Please enter the fields below so we can start calibration process',
    FIRST_NAME: "First name",
    LAST_NAME: "Last name",
    MIDDLE_NAME: "Middle name",
    EMAIL: "Email",
    PHONE_NUMBER: "Phone number",
    REGION: "Region",
    DISTRICT: "District",
    LOCALITY: "Locality",
    STREET: "Street",
    BUILDING: "Building",
    FLAT: "Flat",
    SEND_BTN: "send",

    APP_SENT: "Thank you! We have received your application. Your code is: ",
    CHECK_APP_STATUS_TITLE: "Please enter the code of your application",
    SEARCH_BTN: "search",
    APPLICATION_CODE: "Application code",
    APPLICATION_STATUS: "Application status"
};

var ukrProperties = {
    SEND_APP_TITLE: "\u0411\u0443\u0434\u044c \u043b\u0430\u0441\u043a\u0430, \u0437\u0430\u043f\u043e\u0432\u043d\u0456\u0442\u044c \u043d\u0430\u0441\u0442\u0443\u043f\u043d\u0456 \u043f\u043e\u043b\u044f, \u0449\u043e\u0431 \u043c\u0438 \u0437\u043c\u043e\u0433\u043b\u0438 \u043f\u043e\u0447\u0430\u0442\u0438 \u043f\u0440\u043e\u0446\u0435\u0441 \u043f\u043e\u0432\u0456\u0440\u043a\u0438",
    FIRST_NAME: "\u0406\u043c'\u044f",
    LAST_NAME: "\u041f\u0440\u0456\u0437\u0432\u0438\u0449\u0435",
    MIDDLE_NAME: "\u041f\u043e \u0431\u0430\u0442\u044c\u043a\u043e\u0432\u0456",
    EMAIL: "Email",
    PHONE_NUMBER: "\u041d\u043e\u043c\u0435\u0440 \u0442\u0435\u043b\u0435\u0444\u043e\u043d\u0443",
    REGION: "\u041e\u0431\u043b\u0430\u0441\u0442\u044c",
    DISTRICT: "\u0420\u0430\u0439\u043e\u043d",
    LOCALITY: "\u041d\u0430\u0441\u0435\u043b\u0435\u043d\u0438\u0439 \u043f\u0443\u043d\u043a\u0442",
    STREET: "\u0412\u0443\u043b\u0438\u0446\u044f",
    BUILDING: "\u0411\u0443\u0434\u0438\u043d\u043e\u043a",
    FLAT: "\u041a\u0432\u0430\u0440\u0442\u0438\u0440\u0430",
    SEND_BTN: "\u043d\u0430\u0434\u0456\u0441\u043b\u0430\u0442\u0438",

    APP_SENT: "\u0414\u044f\u043a\u0443\u0454\u043c\u043e! \u041c\u0438 \u043e\u0442\u0440\u0438\u043c\u0430\u043b\u0438 \u0432\u0430\u0448\u0443 \u0437\u0430\u044f\u0432\u043a\u0443. \u0412\u0430\u0448 \u043a\u043e\u0434: ",
    CHECK_APP_STATUS_TITLE: "\u0411\u0443\u0434\u044c \u043b\u0430\u0441\u043a\u0430, \u0432\u0432\u0435\u0434\u0456\u0442\u044c \u043a\u043e\u0434 \u0432\u0430\u0448\u043e\u0457 \u0437\u0430\u044f\u0432\u043a\u0438",
    SEARCH_BTN: "\u043f\u043e\u0448\u0443\u043a",
    APPLICATION_CODE: "\u041a\u043e\u0434 \u0437\u0430\u044f\u0432\u043a\u0438",
    APPLICATION_STATUS: "\u0421\u0442\u0430\u0442\u0443\u0441 \u0437\u0430\u044f\u0432\u043a\u0438"
};
