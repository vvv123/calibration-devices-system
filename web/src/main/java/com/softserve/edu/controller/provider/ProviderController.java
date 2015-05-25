package com.softserve.edu.controller.provider;

import com.softserve.edu.controller.provider.util.VerificationPageDTOTransformer;
import com.softserve.edu.dto.PageDTO;
import com.softserve.edu.dto.application.ClientStageVerificationDTO;
import com.softserve.edu.dto.provider.VerificationDTO;
import com.softserve.edu.dto.provider.VerificationPageDTO;
import com.softserve.edu.entity.ClientData;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.service.SecurityUserDetailsService;
import com.softserve.edu.service.verification.VerificationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProviderController {

    @Autowired
    VerificationService verificationService;

    private final Logger logger = Logger.getLogger(ProviderController.class);

    @RequestMapping(value = "/provider/verifications/archive/{pageNumber}/{itemsPerPage}", method = RequestMethod.GET)
    public PageDTO<VerificationPageDTO> getPageOfAllVerificationsByProviderId(
            @PathVariable Integer pageNumber,
            @PathVariable Integer itemsPerPage,
            @AuthenticationPrincipal SecurityUserDetailsService.CustomUserDetails employeeUser) {

        Page<VerificationPageDTO> page = VerificationPageDTOTransformer.toDTO(verificationService
                .findPageOfAllVerificationsByProviderId(employeeUser.getOrganizationId(), pageNumber, itemsPerPage));
        return new PageDTO<>(page.getTotalElements(), page.getContent());
    }

    @RequestMapping(value = "/provider/verifications/new/{pageNumber}/{itemsPerPage}", method = RequestMethod.GET)
    public PageDTO<VerificationPageDTO> getPageOfAllSentVerificationsByProviderId(
            @PathVariable Integer pageNumber,
            @PathVariable Integer itemsPerPage,
            @AuthenticationPrincipal SecurityUserDetailsService.CustomUserDetails employeeUser) {

        Page<VerificationPageDTO> page = VerificationPageDTOTransformer.toDTO(verificationService
                .findPageOfSentVerificationsByProviderId(employeeUser.getOrganizationId(), pageNumber, itemsPerPage));
        return new PageDTO<>(page.getTotalElements(), page.getContent());
    }


    @RequestMapping(value = "/provider/verifications/new/update", method = RequestMethod.PUT)
    public void updateVerification(@RequestBody List<VerificationPageDTO> verifications,
                                   @AuthenticationPrincipal SecurityUserDetailsService.CustomUserDetails employeeUser) {
     for(int i=0;i<verifications.size();i++){
     verificationService.updateVerification(
             VerificationPageDTOTransformer.fromVerificationDTOtoVerification(verifications.get(i)),employeeUser.getOrganizationId());
     }
    }

    @RequestMapping(value = "/provider/verifications/new/{verificationId}", method = RequestMethod.GET)
    public ClientStageVerificationDTO getNewVerificationDetailsById(
            @PathVariable String verificationId,
            @AuthenticationPrincipal SecurityUserDetailsService.CustomUserDetails employeeUser) {

        Verification verification = verificationService.findByIdAndProviderId(verificationId, employeeUser.getOrganizationId());
        ClientData clientData = verification.getClientData();
        return new ClientStageVerificationDTO(clientData, clientData.getClientAddress(), null);
    }

    @RequestMapping(value = "/provider/verifications/archive/{verificationId}", method = RequestMethod.GET)
    public VerificationDTO getArchivalVerificationDetailsById(
            @PathVariable String verificationId,
            @AuthenticationPrincipal SecurityUserDetailsService.CustomUserDetails employeeUser) {

        Verification verification = verificationService.findByIdAndProviderId(verificationId, employeeUser.getOrganizationId());

        return new VerificationDTO(verification.getClientData(), verification.getId(), verification.getInitialDate(),
                verification.getExpirationDate(), verification.getStatus(), verification.getCalibrator(),
                verification.getCalibratorEmployee(), verification.getDevice(), verification.getProvider(),
                verification.getProviderEmployee(), verification.getStateVerificator(), verification.getStateVerificatorEmployee());
    }
}
