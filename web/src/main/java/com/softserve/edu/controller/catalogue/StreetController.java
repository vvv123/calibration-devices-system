package com.softserve.edu.controller.catalogue;

import com.softserve.edu.dto.application.ClientApplicationFieldDTO;
import com.softserve.edu.controller.client.application.util.CatalogueDTOTransformer;
import com.softserve.edu.service.catalogue.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StreetController {

    @Autowired
    private StreetService streetService;

    @RequestMapping(value = "application/streets/{localityId}", method = RequestMethod.GET)
    public List<ClientApplicationFieldDTO> getStreetsCorrespondingLocality(@PathVariable Long localityId) {
        return CatalogueDTOTransformer.toDto(streetService.getStreetsCorrespondingLocality(localityId));
    }
}
