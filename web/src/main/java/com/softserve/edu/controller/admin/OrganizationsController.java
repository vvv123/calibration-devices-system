package com.softserve.edu.controller.admin;

import com.softserve.edu.dto.admin.OrganizationPageItem;
import com.softserve.edu.dto.admin.OrganizationToSaveDTO;
import com.softserve.edu.service.admin.OrganizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
        return pageOrganizationsWithSearch(pageNumber, itemsPerPage, null);
    }

    @RequestMapping(value = "page/{pageNumber}/{itemsPerPage}/{searchName}", method = RequestMethod.GET)
    public List<OrganizationPageItem> pageOrganizationsWithSearch(@PathVariable Integer pageNumber, @PathVariable Integer itemsPerPage, @PathVariable String search) {
        return organizationsService.getOrganizationsBySearchAndPagination(pageNumber, itemsPerPage, search)
                .map(organization ->
                                new OrganizationPageItem(
                                        organization.getId(),
                                        organization.getName(),
                                        organization.getEmail(),
                                        organization.getPhone(),
                                        organizationsService.getType(organization)
                                )
                ).getContent();
    }
}
