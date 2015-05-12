package com.softserve.edu.controller.catalogue;

import com.softserve.edu.dto.CatalogueDTO;
import com.softserve.edu.dto.CatalogueIdDTO;
import com.softserve.edu.service.catalogue.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StreetController {

    @Autowired
    private StreetService streetService;

    @RequestMapping(value = "/streets", method = RequestMethod.POST)
    public List<CatalogueDTO> getStreetsCorrespondingLocality(CatalogueIdDTO localityId) {
        return streetService.getStreetsCorrespondingLocality(localityId);
    }
}
