package com.softserve.edu.controller.provider;/*package com.softserve.edu.controller.provider;

import com.softserve.edu.dto.PageDTO;
import com.softserve.edu.dto.admin.OrganizationPageItem;
import com.softserve.edu.dto.provider.VerificationPageItem;
import com.softserve.edu.service.ProviderService;
import com.softserve.edu.service.admin.OrganizationsService;
import com.softserve.edu.service.provider.ProviderApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Oles Onyshchak on 5/20/2015.
 */

import com.softserve.edu.dto.PageDTO;
import com.softserve.edu.dto.provider.VerificationPageItem;
import com.softserve.edu.service.provider.ProviderApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderApplicationController {
    @Autowired
    ProviderApplicationService providerApplicationService;

    @RequestMapping(value = "/provider/applications/{pageNumber}/{itemsPerPage}", method = RequestMethod.GET)
    public PageDTO<VerificationPageItem> pageVerificationsWithSearch(
            @PathVariable Integer pageNumber,
            @PathVariable Integer itemsPerPage
            ) {
        Page<VerificationPageItem> page = providerApplicationService
                .getVerificationsBySearchAndPagination(pageNumber, itemsPerPage)
                .map(verification -> new VerificationPageItem(
                                        verification.getId(),verification.getVerificationFinishedDate(),
                                        verification.getClientData().getLastName(),
                                        verification.getClientData().getClientAddress().getStreet())
                );

        return new PageDTO<>(page.getTotalElements(), page.getContent());
    }
}
