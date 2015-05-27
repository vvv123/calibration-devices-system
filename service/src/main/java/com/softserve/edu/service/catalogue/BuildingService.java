package com.softserve.edu.service.catalogue;

import com.softserve.edu.entity.catalogue.Building;
import com.softserve.edu.repository.catalogue.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    public List<Building> getBuildingsCorrespondingStreet(Long streetId) {
        return buildingRepository.findByStreetId(streetId);
    }
}
