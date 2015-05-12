var welcomeModule = angular.module('welcomeModule', ['spring-security-csrf-token-interceptor',
    'duScroll', 'ui.bootstrap', 'pascalprecht.translate'])
    .config(['$translateProvider',
        function ($translateProvider) {
            $translateProvider.useSanitizeValueStrategy('escaped');
            $translateProvider
                .translations('eng', engProperites)
                .translations('ukr', ukrProperties);
            $translateProvider.preferredLanguage('eng');
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
    FIRST_NAME: "First name",
    LAST_NAME: "Last name",
    MIDDLE_NAME: "Middle name",
    EMAIL: "Email",
    PHONE_NUMBER: "Phone number",
    REGION: "\u041e\u0431\u043b\u0430\u0441\u0442\u044c",
    DISTRICT: "\u0420\u0430\u0439\u043e\u043d",
    LOCALITY: "\u041d\u0430\u0441\u0435\u043b\u0435\u043d\u0438\u0439 \u043f\u0443\u043d\u043a\u0442",
    STREET: "\u0412\u0443\u043b\u0438\u0446\u044f",
    BUILDING: "\u0411\u0443\u0434\u0438\u043d\u043e\u043a",
    FLAT: "\u041a\u0432\u0430\u0440\u0442\u0438\u0440\u0430",
    SEND_BTN: "\u043d\u0430\u0434\u0456\u0441\u043b\u0430\u0442\u0438",

    APP_SENT: "Thank you! We have received your application. Your code is: ",
    CHECK_APP_STATUS_TITLE: "Please, enter the code of your application",
    SEARCH_BTN: "search",
    APPLICATION_CODE: "Application code",
    APPLICATION_STATUS: "Application status"
};
