package com.softserve.edu.controller.catalogue;

import com.softserve.edu.dto.catalogue.CatalogueDTO;
import com.softserve.edu.dto.catalogue.util.CatalogueDTOTransformer;
import com.softserve.edu.service.catalogue.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @RequestMapping(value = "application/districts/{regionId}", method = RequestMethod.GET)
    public List<CatalogueDTO> getDistrictsCorrespondingRegion(@PathVariable Long regionId) {
        return CatalogueDTOTransformer.toDto(districtService.getDistrictsCorrespondingRegion(regionId));
    }
}
