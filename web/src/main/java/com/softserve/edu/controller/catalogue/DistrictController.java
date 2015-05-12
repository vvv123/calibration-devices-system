package com.softserve.edu.controller.catalogue;

import com.softserve.edu.dto.CatalogueDTO;
import com.softserve.edu.dto.CatalogueIdDTO;
import com.softserve.edu.service.catalogue.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping(value = "/districts", method = RequestMethod.POST)
    public List<CatalogueDTO> sendDistrictsCorrespondingRegion(@RequestBody CatalogueIdDTO regionIdDTO) {
        return districtService.receiveDistrictsCorrespondingRegion(regionIdDTO);
    }
}
