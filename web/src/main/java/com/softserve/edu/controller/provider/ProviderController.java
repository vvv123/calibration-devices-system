package com.softserve.edu.controller.provider;

import com.softserve.edu.controller.provider.util.VerificationPageDTOTransformer;
import com.softserve.edu.dto.PageDTO;
import com.softserve.edu.dto.provider.VerificationPageDTO;
import com.softserve.edu.service.SecurityUserDetailsService;
import com.softserve.edu.service.verification.VerificationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    VerificationService verificationService;

    private final Logger logger = Logger.getLogger(ProviderController.class);

    @RequestMapping(value = "/provider/verifications/all/{pageNumber}/{itemsPerPage}", method = RequestMethod.GET)
    public PageDTO<VerificationPageDTO> getPageOfAllVerificationsByProviderId(
            @PathVariable Integer pageNumber,
            @PathVariable Integer itemsPerPage,
            @AuthenticationPrincipal SecurityUserDetailsService.EmployeeUser employeeUser
    ) {
        logger.info(employeeUser.getUsername());
        logger.info(employeeUser.getOrganizationId());

        Page<VerificationPageDTO> page = VerificationPageDTOTransformer.toDTO(verificationService
                .findPageOfAllVerificationsByProviderId(employeeUser.getOrganizationId(), pageNumber, itemsPerPage));

        return new PageDTO<>(page.getTotalElements(), page.getContent());
    }

    @RequestMapping(value = "/provider/verifications/new/{pageNumber}/{itemsPerPage}", method = RequestMethod.GET)
    public PageDTO<VerificationPageDTO> getPageOfAllSentVerificationsByProviderId(
            @PathVariable Integer pageNumber,
            @PathVariable Integer itemsPerPage,
            @AuthenticationPrincipal SecurityUserDetailsService.EmployeeUser employeeUser
    ) {
        logger.info(employeeUser.getUsername());
        logger.info(employeeUser.getOrganizationId());

        Page<VerificationPageDTO> page = VerificationPageDTOTransformer.toDTO(verificationService
                .findPageOfSentVerificationsByProviderId(employeeUser.getOrganizationId(), pageNumber, itemsPerPage));

        return new PageDTO<>(page.getTotalElements(), page.getContent());
    }
}
