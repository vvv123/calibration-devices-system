package com.softserve.edu.controller.admin;

import com.softserve.edu.dto.admin.OrganizationToPage;
import com.softserve.edu.dto.admin.OrganizationToSaveDTO;
import com.softserve.edu.entity.Organization;
import com.softserve.edu.repository.OrganizationRepository;
import com.softserve.edu.service.admin.OrganizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/admin/organization/")
public class OrganizationsController {

    @Autowired
    OrganizationsService organizationsService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void addOrganization(@RequestBody OrganizationToSaveDTO organizationToSaveDTO) {
        organizationsService.addOrganization(organizationToSaveDTO.getName(), organizationToSaveDTO.getEmail(),
                organizationToSaveDTO.getPhone(), organizationToSaveDTO.getType());
    }

    @RequestMapping(value = "page/{pageNumber}/{itemsPerPage}", method = RequestMethod.GET)
    public List<?> getOrganizationsPage(@PathVariable Integer pageNumber, @PathVariable Integer itemsPerPage) {
        return organizationsService.getOrganizationsByPagination(pageNumber, itemsPerPage)
            .stream().map(organization ->
                new OrganizationToPage(
                        organization.getId(),
                        organization.getName(),
                        organization.getEmail(),
                        organization.getPhone(),
                        organizationsService.getType(organization)
                )
            ).collect(Collectors.toList());
    }
}
