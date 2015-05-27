package com.softserve.edu.controller.catalogue;

import com.softserve.edu.dto.application.ClientApplicationFieldDTO;
import com.softserve.edu.controller.client.application.util.CatalogueDTOTransformer;
import com.softserve.edu.service.catalogue.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BuildingController {

    @Autowired
    private BuildingService buildingService;

    @RequestMapping(value = "application/buildings/{streetId}", method = RequestMethod.GET)
    public List<ClientApplicationFieldDTO> getBuildingsCorrespondingStreet(@PathVariable Long streetId) {
        return CatalogueDTOTransformer.toDto(buildingService.getBuildingsCorrespondingStreet(streetId));
    }
}
