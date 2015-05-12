package com.softserve.edu.service.catalogue;

import com.softserve.edu.dto.CatalogueDTO;
import com.softserve.edu.dto.CatalogueIdDTO;
import com.softserve.edu.dto.util.CatalogueDTOTransformer;
import com.softserve.edu.entity.catalogue.District;
import com.softserve.edu.entity.catalogue.Region;
import com.softserve.edu.repository.catalogue.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private RegionService regionService;

    public List<CatalogueDTO> receiveDistrictsCorrespondingRegion(CatalogueIdDTO regionIdDTO) {
        Region region = regionService.findById(regionIdDTO.getId());
        return CatalogueDTOTransformer.toDto(districtRepository.findByRegion(region));
    }

    public District findById(Long id) {
        return districtRepository.findOne(id);
    }
}
