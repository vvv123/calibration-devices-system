package com.softserve.edu.controller.application;

import com.softserve.edu.dto.application.ApplicationDTO;
import com.softserve.edu.dto.application.ClientCodeDTO;
import com.softserve.edu.dto.application.ClientMessageDTO;
import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.ClientData;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.util.Status;
import com.softserve.edu.service.MailService;
import com.softserve.edu.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * This is plain MVC controller.
 * Use this controller to render yours .jsp views.
 * Other controllers annotated as @RestControllers maintain RESTful API,
 * so that's why we recommend you to implement rendering .jsp methods below.
 */
@RestController
@PropertySource("classpath:/properties/mail.properties")
public class ApplicationController {

    @Autowired
    private VerificationService verificationService;

    @Autowired
    private MailService mailService;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/application/add", method = RequestMethod.POST)
    public ClientCodeDTO saveApplication(@RequestBody ApplicationDTO applicationDTO) {

        Verification verification = new Verification(parseApplicationDTOtoClientData((applicationDTO)), Status.SENT);
        verificationService.saveVerification(verification);
        return new ClientCodeDTO(verification.getId());
    }

    @RequestMapping(value = "/application/check/{clientCode}", method = RequestMethod.GET)
    public ClientMessageDTO getClientCode(@PathVariable String code) {
        return new ClientMessageDTO(verificationService.findByCode(code).getStatus().name());
    }

    private ClientData parseApplicationDTOtoClientData(ApplicationDTO applicationDTO) {
        return new ClientData(applicationDTO.getFirstName(), applicationDTO.getLastName(), applicationDTO.getMiddleName(),
                applicationDTO.getEmail(), applicationDTO.getPhone(), parseApplicationDTOToClientAddress(applicationDTO));
    }

    private Address parseApplicationDTOToClientAddress(ApplicationDTO applicationDTO) {
        return new Address(applicationDTO.getRegion(), applicationDTO.getDistrict(), applicationDTO.getLocality(),
                applicationDTO.getStreet(), applicationDTO.getBuilding(), applicationDTO.getFlat(),
                applicationDTO.getIndex());
    }

    private void setEmailSendingConfig(String firstName, String lastName, String clientCode) {
        Map<String, Object> tempVars = new HashMap<>();
        tempVars.put("name", firstName + " " + lastName);
        tempVars.put("protocol", env.getProperty("site.protocol"));
        tempVars.put("domain", env.getProperty("site.domain"));
        tempVars.put("applicationId", clientCode);
    }
}
