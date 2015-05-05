package com.softserve.edu.service;

import com.softserve.edu.dto.AddressDTO;
import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.catalogue.*;
import com.softserve.edu.repository.AddressRepository;
import com.softserve.edu.dao.catalogue.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AddressService {

    @Autowired
    private BuildingRepository buildingRepository;

    public Address makeAddress(AddressDTO addressDTO) {
        Building building = buildingRepository.findOne(addressDTO.getBuildingId());
        Street street = building.getStreet();
        Locality locality = street.getLocality();
        District district = locality.getDistrict();
        Region region = district.getRegion();
        return new Address(
                addressDTO.getFlatNumber(), building,
                street, locality, district, region
        );
    }

}
