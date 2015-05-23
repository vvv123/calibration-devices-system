package com.softserve.edu.service.catalogue;

import com.softserve.edu.entity.catalogue.Region;
import com.softserve.edu.repository.catalogue.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public Iterable<Region> getAll() {
        return regionRepository.findAll();
    }
}
