package com.softserve.edu.controller.admin;

import com.softserve.edu.dto.PageDTO;
import com.softserve.edu.dto.SearchDTO;
import com.softserve.edu.dto.admin.OrganizationPageItem;
import com.softserve.edu.dto.admin.OrganizationDTO;
import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.user.ProviderEmployee;
import com.softserve.edu.entity.user.User;
import com.softserve.edu.repository.UserRepository;
import com.softserve.edu.service.admin.OrganizationsService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.security.Principal;

@RestController
@RequestMapping(value = "/admin/organization/")
public class OrganizationsController {

    @Autowired
    private OrganizationsService organizationsService;

    private final Logger logger = Logger.getLogger(OrganizationsController.class);

    /**
     * Saves organization and its administrator employee in database
     *
     * @param organizationDTO object with organization and employee admin data
     * @return a response body with http status {@literal CREATED} if everything
     * organization and employee admin successfully created or else http status {@literal CONFLICT}
     */
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public ResponseEntity addOrganization(@RequestBody OrganizationDTO organizationDTO) {
        HttpStatus httpStatus = HttpStatus.CREATED;
        Address address = new Address(
                organizationDTO.getRegion(), organizationDTO.getDistrict(),
                organizationDTO.getLocality(), organizationDTO.getStreet(),
                organizationDTO.getBuilding(), organizationDTO.getFlat());
        try {
            organizationsService.addOrganizationWithAdmin(
                    organizationDTO.getName(), organizationDTO.getEmail(),
                    organizationDTO.getPhone(), organizationDTO.getType(),
                    organizationDTO.getUsername(), organizationDTO.getPassword(),
                    address);
        } catch (Exception e) {
            // TODO
            logger.error("GOT EXCEPTION " + e.getMessage());
            httpStatus = HttpStatus.CONFLICT;
        }
        return new ResponseEntity(httpStatus);
    }

    /**
     * Responds a page according to input data and search value
     *
     * @param pageNumber current page number
     * @param itemsPerPage count of elements per one page
     * @param search keyword for looking entities by Organization.name
     * @return a page of organizations with their total amount
     */
    @RequestMapping(value = "{pageNumber}/{itemsPerPage}/{search}", method = RequestMethod.GET)
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
                                        organizationsService.getType(organization)
                                )
                );

        return new PageDTO<>(page.getTotalElements(), page.getContent());
    }

    /**
     * Responds a page according to input data.
     *
     * <p>Note that this uses method {@code pageOrganizationsWithSearch},
     * whereas search values is {@literal null}
     *
     * @param pageNumber current page number
     * @param itemsPerPage count of elements per one page
     * @return a page of organizations with their total amount
     */
    @RequestMapping(value = "{pageNumber}/{itemsPerPage}", method = RequestMethod.GET)
    public PageDTO<OrganizationPageItem> getOrganizationsPage(@PathVariable Integer pageNumber,
                                                              @PathVariable Integer itemsPerPage) {
        return pageOrganizationsWithSearch(pageNumber, itemsPerPage, null);
    }
}
