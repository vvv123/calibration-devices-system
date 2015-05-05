package com.softserve.edu.service.catalogue;

import com.softserve.edu.entity.catalogue.District;
import com.softserve.edu.repository.catalogue.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Transactional
    public void save(District district) {
        districtRepository.save(district);
    }

    public District findByName(String name) {
        return districtRepository.findByName(name);
    }
}
