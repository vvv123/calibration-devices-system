package com.softserve.edu.controller.admin;

import com.softserve.edu.dto.admin.OrganizationDTO;
import com.softserve.edu.entity.Organization;
import com.softserve.edu.repository.OrganizationRepository;
import com.softserve.edu.service.admin.OrganizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/admin/organization/")
public class OrganizationsController {

    @Autowired
    OrganizationsService organizationsService;

    @Autowired
    OrganizationRepository organizationRepository;

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void addOrganization(@RequestBody OrganizationDTO organizationDTO) {
        organizationsService.addOrganization(organizationDTO.getName(), organizationDTO.getName(),
                organizationDTO.getPhone(), organizationDTO.getType());
    }

    @RequestMapping(value = "page/{pageNumber}", method = RequestMethod.GET)
    public List<Organization> getOrganizationPage(@PathVariable Integer pageNumber) {
        return organizationRepository.findAll(new PageRequest(pageNumber, 5)).getContent();
    }
}
