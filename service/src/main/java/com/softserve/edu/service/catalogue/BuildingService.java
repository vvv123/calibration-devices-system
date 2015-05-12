package com.softserve.edu.service.catalogue;

import com.softserve.edu.dto.CatalogueDTO;
import com.softserve.edu.dto.util.CatalogueDTOTransformer;
import com.softserve.edu.entity.catalogue.Street;
import com.softserve.edu.repository.catalogue.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private StreetService streetService;

    public List<CatalogueDTO> receiveBuildingsCorrespondingStreet(Long streetId) {
        Street street = streetService.findById(streetId);
        return CatalogueDTOTransformer.toDto(buildingRepository.findByStreet(street));
    }
}
