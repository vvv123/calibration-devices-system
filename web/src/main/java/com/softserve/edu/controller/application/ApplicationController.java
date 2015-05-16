package com.softserve.edu.controller.application;

import com.softserve.edu.controller.application.util.EmailSendingUtil;
import com.softserve.edu.dto.application.ApplicationDTO;
import com.softserve.edu.dto.application.ClientCodeDTO;
import com.softserve.edu.dto.application.ClientMessageDTO;
import com.softserve.edu.entity.ClientData;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.util.Status;
import com.softserve.edu.service.MailService;
import com.softserve.edu.service.VerificationService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import static com.softserve.edu.controller.application.util.ApplicationDTOTransformer.parseApplicationDTOtoClientData;

/**
 * This is plain MVC controller.
 * Use this controller to render yours .jsp views.
 * Other controllers annotated as @RestControllers maintain RESTful API,
 * so that's why we recommend you to implement rendering .jsp methods below.
 */
@RestController
@PropertySource("classpath:/properties/mail.properties")
public class ApplicationController {
    Logger logger = LogManager.getLogger(ApplicationController.class);

    @Autowired
    private VerificationService verificationService;

    @Autowired
    private MailService mailService;

    @Autowired
    private Environment env;

    @RequestMapping(value = "/application/add", method = RequestMethod.POST)
    public ClientCodeDTO saveApplication(@RequestBody ApplicationDTO applicationDTO) {
        ClientData clientData = parseApplicationDTOtoClientData((applicationDTO));
        Verification verification = new Verification(clientData, Status.SENT);
        verificationService.saveVerification(verification);
        EmailSendingUtil.setEmailSendingConfig(clientData.getFirstName(), clientData.getLastName(), verification.getId(), env);
        return new ClientCodeDTO(verification.getId());
    }

    @RequestMapping(value = "/application/check/{clientCode}", method = RequestMethod.GET)
    public ClientMessageDTO getClientCode(@PathVariable String code) {
        logger.debug(code);
        return new ClientMessageDTO(verificationService.findByCode(code).getStatus().name());
    }
}
