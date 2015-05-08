package com.softserve.edu.service.catalogue;

import com.softserve.edu.dto.RegionDTO;
import com.softserve.edu.repository.catalogue.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class RegionService {
    @Autowired
    private RegionRepository regionRepository;

    public List<RegionDTO> getAll() {
        return StreamSupport.stream(regionRepository.findAll().spliterator(), true)
                .map(region -> new RegionDTO(region.getId(), region.getName()))
                .collect(Collectors.toList());
    }
}
