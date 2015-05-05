package com.softserve.edu.service.catalogue;

import com.softserve.edu.entity.catalogue.Region;
import com.softserve.edu.dao.catalogue.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    @Transactional
    public void save(Region region) {
        regionRepository.save(region);
    }

    public Region findByName(String name) {
        return regionRepository.findByName(name);
    }
}
