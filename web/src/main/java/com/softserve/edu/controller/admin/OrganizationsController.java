package com.softserve.edu.controller.admin;

import com.softserve.edu.dto.PageDTO;
import com.softserve.edu.dto.SearchDTO;
import com.softserve.edu.dto.admin.OrganizationPageItem;
import com.softserve.edu.dto.admin.OrganizationDTO;
import com.softserve.edu.entity.user.ProviderEmployee;
import com.softserve.edu.entity.user.User;
import com.softserve.edu.repository.UserRepository;
import com.softserve.edu.service.admin.OrganizationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/admin/organization/")
public class OrganizationsController {

    @Autowired
    private OrganizationsService organizationsService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public void addOrganization(@RequestBody OrganizationDTO organizationDTO) {

        organizationsService.addOrganizationWithAdmin(
                organizationDTO.getName(), organizationDTO.getEmail(),
                organizationDTO.getPhone(), organizationDTO.getType(),
                organizationDTO.getUsername(), organizationDTO.getPassword()
        );
    }

    @RequestMapping(value = "page/{pageNumber}/{itemsPerPage}", method = RequestMethod.GET)
    public PageDTO<OrganizationPageItem> getOrganizationsPage(@PathVariable Integer pageNumber,
                                                              @PathVariable Integer itemsPerPage) {
        return pageOrganizationsWithSearch(pageNumber, itemsPerPage, null);
    }

    @RequestMapping(value = "page/{pageNumber}/{itemsPerPage}/{search}", method = RequestMethod.GET)
    public PageDTO<OrganizationPageItem> pageOrganizationsWithSearch(
            @PathVariable Integer pageNumber,
            @PathVariable Integer itemsPerPage,
            @PathVariable String search) {

        Page<OrganizationPageItem> page = organizationsService
                .getOrganizationsBySearchAndPagination(pageNumber, itemsPerPage, search)
                .map(organization ->
                        new OrganizationPageItem(
                                organization.getId(), organization.getName(),
                                organization.getEmail(), organization.getPhone(),
                                organizationsService.getType(organization))
                );

        return new PageDTO<>(page.getTotalElements(), page.getContent());
    }
}
