angular
    .module('adminModule')
    .controller('OrganizationModalAddressController', ['$rootScope', '$scope', '$modalInstance', 'AddressService',
        function ($rootScope, $scope, $modalInstance, addressService) {

            $scope.regions = [];

            /**
             * Receiving all regions
             */
            addressService.findAllRegions().then(function (data) {
                $scope.regions = data;
                console.log("hello")
            });

            /**
             * Receives districts in a given region
             *
             * @param regionId to identify region
             */
            $scope.receiveDistricts = function (regionId) {
                addressService
                    .findDistrictsByRegionId(regionId)
                    .then(function (data) {
                        $scope.districts = data;
                    });
                $rootScope.updateAddressMessage();
            };

            /**
             * Receives localities in a given district
             *
             * @param districtId to identify district
             */
            $scope.receiveLocalities = function (districtId) {
                addressService
                    .findLocalitiesByDistrictId(districtId)
                    .then(function (data) {
                        $scope.localities = data;
                    });
                $rootScope.updateAddressMessage();
            };

            /**
             * Receives streets in a given locality
             *
             * @param localityId to identify locality
             */
            $scope.receiveStreets = function (localityId) {
                addressService
                    .findStreetsByLocalityId(localityId)
                    .then(function (data) {
                        $scope.streets = data;
                    });
                $rootScope.updateAddressMessage();
            };

            /**
             * Receives buildings in a given street
             *
             * @param streetId to identify street
             */
            $scope.receiveBuildings = function (streetId) {
                addressService
                    .findBuildingsByStreetId(streetId)
                    .then(function (data) {
                        $scope.buildings = data;
                    });
                $rootScope.updateAddressMessage();
            };


            $scope.closeModal = function () {
                $modalInstance.close();
                $rootScope.updateAddressMessage();
            };
        }]);
