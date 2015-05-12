package com.softserve.edu.controller.admin;

import com.softserve.edu.dto.admin.OrganizationDTO;
import com.softserve.edu.service.admin.OrganizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrganizationsController {

    @Autowired
    OrganizationsService organizationsService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/admin/organization/add", method = RequestMethod.POST)
    public void addOrganization(@RequestBody OrganizationDTO organizationDTO) {
        organizationsService.addOrganization(organizationDTO.getName(), organizationDTO.getName(),
                organizationDTO.getPhone(), organizationDTO.getType());
    }

}
