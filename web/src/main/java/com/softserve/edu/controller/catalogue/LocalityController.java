package com.softserve.edu.controller.catalogue;

import com.softserve.edu.dto.catalogue.CatalogueDTO;
import com.softserve.edu.dto.catalogue.util.CatalogueDTOTransformer;
import com.softserve.edu.service.catalogue.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocalityController {

    @Autowired
    private LocalityService localityService;

    @RequestMapping(value = "application/localities/{districtId}", method = RequestMethod.GET)
    public List<CatalogueDTO> getLocalitiesCorrespondingDistrict(@PathVariable Long districtId) {
        return CatalogueDTOTransformer.toDto(localityService.getLocalitiesCorrespondingDistrict(districtId));
    }
}
