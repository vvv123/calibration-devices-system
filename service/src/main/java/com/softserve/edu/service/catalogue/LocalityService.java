package com.softserve.edu.service.catalogue;

import com.softserve.edu.entity.catalogue.Locality;
import com.softserve.edu.repository.catalogue.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalityService {

    @Autowired
    private LocalityRepository localityRepository;

    public List<Locality> getLocalitiesCorrespondingDistrict(Long districtId) {
        return localityRepository.findByDistrictId(districtId);
    }
}
