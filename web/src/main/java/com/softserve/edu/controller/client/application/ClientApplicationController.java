package com.softserve.edu.controller.client.application;

import com.softserve.edu.controller.client.application.util.ClientStageVerificationDTOTransformer;
import com.softserve.edu.controller.client.application.util.EmailSendingUtil;
import com.softserve.edu.dto.application.ClientApplicationFieldDTO;
import com.softserve.edu.dto.application.ClientStageVerificationDTO;
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
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ClientApplicationController {

    private Logger logger = Logger.getLogger(ClientApplicationController.class);

    @Autowired
    private VerificationService verificationService;

    @Autowired
    private ProviderService providerService;

    @Autowired
    private MailService mail;

    @RequestMapping(value = "/application/add", method = RequestMethod.POST)
    public String saveApplication(@RequestBody ClientStageVerificationDTO clientStageVerificationDTO) {

        ClientData clientData = ClientStageVerificationDTOTransformer.parseApplicationDTOToClientData(clientStageVerificationDTO);
        Verification verification = new Verification(new Date(), clientData,
                providerService.findById(clientStageVerificationDTO.getProviderId()), Status.SENT);

        verificationService.saveVerification(verification);
        String name = clientData.getFirstName() + clientData.getLastName();
        mail.sendMail(clientData.getEmail(), name, verification.getId());
        return verification.getId();
    }

    @RequestMapping(value = "/application/check/{verificationId}", method = RequestMethod.GET)
    public String getClientCode(@PathVariable String verificationId) {
        Verification verification = verificationService.findById(verificationId);
        return verification == null ? "NOT_FOUND" : verification.getStatus().name();
    }

    @RequestMapping(value = "/application/providers/{district}", method = RequestMethod.GET)
    public List<ClientApplicationFieldDTO> getProvidersCorrespondingDistrict(@PathVariable String district)
            throws UnsupportedEncodingException {

        return providerService.findByDistrictDesignation(district)
                .stream()
                .map(provider -> new ClientApplicationFieldDTO(provider.getId(), provider.getName()))
                .collect(Collectors.toList());
    }
}
