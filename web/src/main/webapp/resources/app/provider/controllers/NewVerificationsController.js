angular
    .module('providerModule')
    .controller('NewVerificationsController', ['$scope', 'VerificationService', 'AllVerificationsController',
        function ($scope, verificationService) {
            console.log("HERE!");
        }]);
