package com.softserve.edu.service.catalogue;

import com.softserve.edu.dto.CatalogueDTO;
import com.softserve.edu.dto.CatalogueIdDTO;
import com.softserve.edu.dto.util.CatalogueDTOTransformer;
import com.softserve.edu.entity.catalogue.Locality;
import com.softserve.edu.entity.catalogue.Street;
import com.softserve.edu.repository.catalogue.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    @Autowired
    private LocalityService localityService;

    public List<CatalogueDTO> getStreetsCorrespondingLocality(CatalogueIdDTO localityId) {
        Locality locality = localityService.findById(localityId.getId());
        return CatalogueDTOTransformer.toDto(streetRepository.findByLocality(locality));
    }

    public Street findById(Long id) {
        return streetRepository.findOne(id);
    }
}
