welcomeModule
    .controller('ApplicationSendingController', ['$scope', '$state', '$http', '$log', 'DataReceivingService',
        'DataSendingService',

        function ($scope, $state, $http, $log, dataReceivingService, dataSendingService) {

            $scope.isShownForm = true;
            /**
             * Receives all possible regions.
             */
            $scope.regions = [];
            dataReceivingService.getData("/application/regions").success(function (regions) {
                $scope.regions = regions;
            });
            /**
             * Receives all possible districts.
             * On-select handler in region input form element.
             */
            $scope.receiveDistricts = function (selectedRegion) {
                $scope.districts = [];
                dataReceivingService.getData("/application/districts/" + selectedRegion.id)
                    .success(function (districts) {
                        $scope.districts = districts;
                        $scope.selectedDistrict = "";
                        $scope.selectedLocality = "";
                        $scope.selectedStreet = "";
                    });
            };
            /**
             * Receives all possible localities.
             * On-select handler in district input form element.
             */
            $scope.receiveLocalities = function (selectedDistrict) {
                $scope.localities = [];
                dataReceivingService.getData("/application/localities/" + selectedDistrict.id)
                    .success(function (localities) {
                        $scope.localities = localities;
                        $scope.selectedLocality = "";
                        $scope.selectedStreet = "";
                    });
                //Receives providers corresponding this district
                $scope.providers = ["ЛКП \"Львівводоканал\"", "Львівгаз", "Львівобленерго"];

                $log.log(selectedDistrict.designation);

                var req = {
                    method: 'GET',
                    url: '/application/providers/' + selectedDistrict.designation,
                    headers: {
                        "Accept-Charset": "ISO-8859-1,utf-8;q=0.7,*;q=0.7",
                        "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8"
                    }
                };
                $http(req)
                    .success(function (providers) {
                        $log.log(providers);
                    });
            };
            /**
             * Receives all possible streets.
             * On-select handler in locality input form element
             */
            $scope.receiveStreets = function (selectedLocality) {
                $scope.streets = [];
                dataReceivingService.getData("/application/streets/" + selectedLocality.id)
                    .success(function (streets) {
                        $scope.streets = streets;
                        $scope.selectedStreet = "";
                    });
            };

            /**
             * Receives all possible buildings.
             * On-select handler in street input form element.
             */
            $scope.receiveBuildings = function (selectedStreet) {
                $scope.buildings = [];
                dataReceivingService.getData("/application/buildings/" + selectedStreet.id)
                    .success(function (buildings) {
                        $scope.buildings = buildings;
                    });
            };

            /**
             * Sends data to the server where Verification entity will be created.
             * On-click handler in send button.
             */
            $scope.sendApplicationData = function () {
                $scope.$broadcast('show-errors-check-validity');

                if ($scope.clientForm.$valid) {

                    $scope.formData.region = $scope.selectedRegion.designation;
                    $scope.formData.district = $scope.selectedDistrict.designation;
                    $scope.formData.locality = $scope.selectedLocality.designation;
                    $scope.formData.street = $scope.selectedStreet.designation;
                    $scope.formData.building = $scope.selectedBuilding.designation || $scope.selectedBuilding;

                    dataSendingService.sendData("/application/add", $scope.formData)
                        .success(function (applicationCode) {
                            $scope.applicationCode = applicationCode
                        });
                    $scope.isShownForm = false;
                }
            };

            $scope.closeAlert = function () {
                $state.go($state.current, {}, {reload: true});
            }
        }])
;
