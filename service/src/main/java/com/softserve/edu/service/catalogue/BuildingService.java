package com.softserve.edu.service.catalogue;

import com.softserve.edu.dto.CatalogueDTO;
import com.softserve.edu.dto.CatalogueIdDTO;
import com.softserve.edu.dto.util.CatalogueDTOTransformer;
import com.softserve.edu.entity.catalogue.Locality;
import com.softserve.edu.entity.catalogue.Street;
import com.softserve.edu.repository.catalogue.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BuildingService {

    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private StreetService streetService;

    public List<CatalogueDTO> receiveBuildingsCorrespondingStreet(CatalogueIdDTO streetIdDTO) {
        Street street = streetService.findById(streetIdDTO.getId());
        return CatalogueDTOTransformer.toDto(buildingRepository.findByStreet(street));
    }
}
