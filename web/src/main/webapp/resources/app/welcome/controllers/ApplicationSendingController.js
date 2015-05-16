welcomeModule
    .controller('ApplicationSendingController', ['$scope', 'CatalogueService',
        'ApplicationService',

        function ($scope, catalogueService, applicationService) {

            console.log("In AddApplicationsController.");

            $scope.isShownForm = true;
            /**
             * Receives all possible regions.
             */
            $scope.regions = [];
            catalogueService.sendApplication("/application/regions").success(function (regions) {
                $scope.regions = regions;
            });
            /**
             * Receives all possible districts.
             * On-select handler in region input form element.
             */
            $scope.receiveDistricts = function (selectedRegion) {
                $scope.districts = [];
                catalogueService.sendApplication("/application/districts/" + selectedRegion.id)
                    .success(function (districts) {
                        $scope.districts = districts;
                    });
            };
            /**
             * Receives all possible localities.
             * On-select handler in district input form element.
             */
            $scope.receiveLocalities = function (selectedDistrict) {
                $scope.localities = [];
                catalogueService.sendApplication("/application/localities/" + selectedDistrict.id)
                    .success(function (localities) {
                        $scope.localities = localities;
                    });
            };
            /**
             * Receives all possible streets.
             * On-select handler in locality input form element
             */
            $scope.receiveStreets = function (selectedLocality) {
                $scope.streets = [];
                catalogueService.sendApplication("/application/streets/" + selectedLocality.id)
                    .success(function (streets) {
                        $scope.streets = streets;
                    });
            };

            /**
             * Receives all possible buildings.
             * On-select handler in street input form element.
             */
            $scope.receiveBuildings = function (selectedStreet) {
                $scope.buildings = [];
                catalogueService.sendApplication("/application/buildings/" + selectedStreet.id)
                    .success(function (buildings) {
                        $scope.buildings = buildings;
                    });
            };

            /**
             * Sends data to the server where Verification entity will be created.
             * On-click handler in send button.
             */
            $scope.sendApplicationData = function () {
                $scope.formData.region = $scope.selectedRegion.designation;
                $scope.formData.district = $scope.selectedDistrict.designation;
                $scope.formData.locality = $scope.selectedLocality.designation;
                $scope.formData.district = $scope.selectedDistrict.designation;
                $scope.formData.street = $scope.selectedStreet.designation;
                $scope.formData.building = $scope.selectedBuilding.designation;

                applicationService.sendApplication("/application/add", $scope.formData)
                    .success(function (applicationCode) {
                        $scope.applicationCode = applicationCode.code;
                    }).error(function (err) {
                        console.log(err);
                    });
                $scope.formData = null;
                $scope.isShownForm = false;
            };

            $scope.closeAlert = function () {
                $scope.isShownForm = true;
            }
        }]);
