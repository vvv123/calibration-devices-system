package com.softserve.edu.controller.client.application;

import com.softserve.edu.controller.client.application.util.ClientApplicationDTOTransformer;
import com.softserve.edu.controller.client.application.util.EmailSendingUtil;
import com.softserve.edu.dto.application.ClientApplicationDTO;
import com.softserve.edu.dto.application.ClientApplicationFieldDTO;
import com.softserve.edu.entity.ClientData;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.util.Status;
import com.softserve.edu.service.MailService;
import com.softserve.edu.service.provider.ProviderService;
import com.softserve.edu.service.verification.VerificationService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@PropertySource("classpath:/properties/mail.properties")
public class ClientApplicationController {

    private Logger logger = Logger.getLogger(ClientApplicationController.class);

    @Autowired
    private VerificationService verificationService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private MailService mailService;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/application/add", method = RequestMethod.POST)
    public String saveApplication(@RequestBody ClientApplicationDTO clientApplicationDTO) {
        ClientData clientData = ClientApplicationDTOTransformer.parseApplicationDTOToClientData((clientApplicationDTO));
        Verification verification = new Verification(clientData,
                providerService.findById(clientApplicationDTO.getProviderId()), Status.SENT);
        verificationService.saveVerification(verification);
        EmailSendingUtil.setEmailSendingConfig(clientData.getFirstName(), clientData.getLastName(), verification.getId(), env);
        return verification.getId();
    }

    @RequestMapping(value = "/application/check/{clientCode}", method = RequestMethod.GET)
    public String getClientCode(@PathVariable String clientCode) {
        Verification verification = verificationService.findByCode(clientCode);
        return verification == null ? "NOT_FOUND" : verification.getStatus().name();
    }

    @RequestMapping(value = "/application/providers/{district}", method = RequestMethod.GET)
    public List<ClientApplicationFieldDTO> getProvidersCorrespondingDistrict(@PathVariable String district)
            throws UnsupportedEncodingException {
        logger.info(district);
        return providerService.findByDistrictDesignation(district)
                .stream()
                .map(provider -> new ClientApplicationFieldDTO(provider.getId(), provider.getName()))
                .collect(Collectors.toList());
    }
}
