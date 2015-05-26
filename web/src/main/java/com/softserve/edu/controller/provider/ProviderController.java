package com.softserve.edu.controller.provider;

import com.softserve.edu.controller.provider.util.VerificationsAndCalibrationIdsDTO;
import com.softserve.edu.controller.provider.util.VerificationPageDTOTransformer;
import com.softserve.edu.dto.PageDTO;
import com.softserve.edu.dto.application.ClientStageVerificationDTO;
import com.softserve.edu.dto.provider.VerificationDTO;
import com.softserve.edu.dto.provider.VerificationPageDTO;
import com.softserve.edu.entity.Calibrator;
import com.softserve.edu.entity.ClientData;
import com.softserve.edu.entity.Provider;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.service.CalibratorService;
import com.softserve.edu.service.SecurityUserDetailsService;
import com.softserve.edu.service.provider.ProviderService;
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

    @Autowired
    ProviderService providerService;

    @Autowired
    CalibratorService calibratorService;

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

    @RequestMapping(value = "/provider/verifications/new/calibrators", method = RequestMethod.GET)
    public List<Calibrator> updateVerification(
            @AuthenticationPrincipal SecurityUserDetailsService.CustomUserDetails employeeUser) {

        return calibratorService.findByDistrict(
                providerService.findById(employeeUser.getOrganizationId()).getAddress().getDistrict());
    }


    @RequestMapping(value = "/provider/verifications/new/update", method = RequestMethod.PUT)
    public void updateVerification(@RequestBody VerificationsAndCalibrationIdsDTO verificationsAndCalibrationIdsDTO) {

        for (String verificationId : verificationsAndCalibrationIdsDTO.getVerificationIds()) {
            verificationService.updateVerification(verificationId, verificationsAndCalibrationIdsDTO.getCalibrator());
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
