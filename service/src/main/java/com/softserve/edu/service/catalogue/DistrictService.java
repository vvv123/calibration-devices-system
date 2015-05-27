package com.softserve.edu.service.catalogue;

import com.softserve.edu.entity.catalogue.District;
import com.softserve.edu.repository.catalogue.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    public List<District> getDistrictsCorrespondingRegion(Long regionId) {
        return districtRepository.findByRegionId(regionId);
    }
}
