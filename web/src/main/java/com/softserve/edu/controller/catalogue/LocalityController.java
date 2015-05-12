package com.softserve.edu.controller.catalogue;

import com.softserve.edu.dto.CatalogueDTO;
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
        System.out.println("-------------------------------");
        System.out.println(districtId);
        System.out.println("-------------------------------");
        return localityService.receiveLocalitiesCorrespondingDistrict(districtId);
    }
}
