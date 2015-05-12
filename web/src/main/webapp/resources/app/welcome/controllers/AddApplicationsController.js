angular
    .module('welcomeModule')
    .controller('AddApplicationsController', ['$scope', 'CatalogueService', 'ApplicationService',
        function ($scope, catalogueService, applicationService) {

            //receiving all possible regions
            $scope.regions = [];
            catalogueService.sendApplication("/application/regions").success(function (regions) {
                $scope.regions = regions;
            });

            //on-select handler in region input form element
            $scope.receiveDistricts = function (selectedRegion) {
                $scope.districts = [];
                catalogueService.sendApplication("/application/districts/" + selectedRegion.id)
                    .success(function (districts) {
                        $scope.districts = districts;
                    });
            };

            //on-select handler in district input form element
            $scope.receiveLocalities = function (selectedDistrict) {
                $scope.localities = [];
                catalogueService.sendApplication("/application/localities/" + selectedDistrict.id)
                    .success(function (localities) {
                        $scope.localities = localities;
                    });
            };

            //on-select handler in locality input form element
            $scope.receiveStreets = function (selectedLocality) {
                $scope.streets = [];
                catalogueService.sendApplication("/application/streets/" + selectedLocality.id)
                    .success(function (streets) {
                        $scope.streets = streets;
                    });
            };

            //on-select handler in street input form element
            $scope.receiveBuildings = function (selectedStreet) {
                $scope.buildings = [];
                catalogueService.sendApplication("/application/buildings/" + selectedStreet.id)
                    .success(function (buildings) {
                        $scope.buildings = buildings;
                    });
            };

            //on-click handler in send button
            $scope.sendApplicationData = function () {
                $scope.formData.region = $scope.selectedRegion.designation;
                $scope.formData.district = $scope.selectedDistrict.designation;
                $scope.formData.locality = $scope.selectedLocality.designation;
                $scope.formData.district = $scope.selectedDistrict.designation;
                $scope.formData.street = $scope.selectedStreet.designation;
                $scope.formData.building = $scope.selectedBuilding.designation;
                console.log($scope.formData);
                applicationService.sendApplication("/application/add", $scope.formData)
                    .success(function (applicationCode) {
                        $scope.applicationCode = applicationCode;
                    }).error(function (err) {
                        console.log(err);
                    });
                $scope.formData = null;
                $scope.hideApplication=true;
                $scope.showApplication=true;
            };
        }]);
