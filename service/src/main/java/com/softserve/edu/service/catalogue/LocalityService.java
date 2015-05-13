package com.softserve.edu.service.catalogue;

import com.softserve.edu.dto.CatalogueDTO;
import com.softserve.edu.dto.util.CatalogueDTOTransformer;
import com.softserve.edu.entity.catalogue.District;
import com.softserve.edu.entity.catalogue.Locality;
import com.softserve.edu.repository.catalogue.LocalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalityService {

    @Autowired
    private LocalityRepository localityRepository;

    @Autowired
    private DistrictService districtService;

    public List<CatalogueDTO> receiveLocalitiesCorrespondingDistrict(Long districtId) {
        return CatalogueDTOTransformer.toDto(localityRepository.findByDistrictId(districtId));
    }

    public Locality findById(Long id) {
        return localityRepository.findOne(id);
    }
}
