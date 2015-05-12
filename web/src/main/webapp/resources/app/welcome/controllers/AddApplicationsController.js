angular
    .module('welcomeModule')
    .controller('AddApplicationsController',[ '$scope', '$http', 'RegionService', 'CatalogueService',
        function($scope, $http, regionService, catalogueService) {
            //receiving all possible regions
            $scope.selectedRegion = undefined;
            $scope.regions = [];
            regionService.receiveRegions().success(function (regions) {
                $scope.regions = regions;
            });

            //on-select handler in region input form element
            $scope.receiveDistricts = function (selectedRegion) {
                $scope.formInfo.district = undefined;
                $scope.districts = [];
                var regionDTO = {
                    id: selectedRegion.id
                };
                catalogueService.sendDTO(regionDTO, "/application/districts").success(function (districts) {
                    $scope.districts = districts;
                });
            };

            //on-select handler in district input form element
            $scope.receiveLocalities = function (selectedDistrict) {
                $scope.formInfo.locality = undefined;
                $scope.localities = [];
                var districtDTO = {
                    id: selectedDistrict.id
                };
                catalogueService.sendDTO(districtDTO, "/application/localities").success(function (localities) {
                    $scope.localities = localities;
                });
            };
    
            //on-select handler in locality input form element
            $scope.receiveStreets = function (selectedLocality) {
                $scope.formInfo.street = undefined;
                $scope.streets = [];
                var localityDTO = {
                    id: selectedLocality.id
                };
                localityDTO.id = selectedLocality.id;
                catalogueService.sendDTO(localityDTO, "/application/streets").success(function (streets) {
                    $scope.streets = streets;
                });
            };

            //on-select handler in street input form element
            $scope.receiveBuildings = function (selectedStreet) {
                $scope.formInfo.building = undefined;
                $scope.buildings = [];
                var streetDTO = {
                    id: selectedStreet.id
                };
                catalogueService.sendDTO(streetDTO, "/application/buildings").success(function (buildings) {
                    $scope.buildings = buildings;
                });
            };

            //on-change handler in flat input form element
            $scope.saveSelected = function (selectedFlat) {
                $scope.formInfo.flat = selectedFlat;
            };

            $scope.saveData = function() {
                var response = $http.post('/application/add', $scope.formInfo);
                response.success(function(data) {
                    $scope.code = JSON.stringify(data);
                });
                response.error(function(data) {
                    console.dir(data);
                });
                $scope.myVar = true;

            };
    }]);


