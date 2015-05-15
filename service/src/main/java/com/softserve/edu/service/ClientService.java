package com.softserve.edu.service;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.edu.dto.ApplicationDTO;
import com.softserve.edu.dto.ClientCodeDTO;
import com.softserve.edu.dto.ClientMessageDTO;
import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.ClientData;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.util.Status;
import com.softserve.edu.repository.VerificationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.UUID;

@Service
@Transactional
@PropertySource("classpath:/properties/mail.properties")
public class ClientService {
    @Autowired
    private VerificationRepository verificationRepository;
    
    @Autowired
    private MailService mailService;
    
    @Autowired
    private Environment env;

    public ClientCodeDTO transferApplication(ApplicationDTO applicationDTO) {
        Verification verification = new Verification();
        ClientData clientData = new ClientData();
        clientData.setClientAddress(parseApplicationDTOtoClientAddress(new Address(), applicationDTO));
        verification.setClientData(parseApplicationDTOtoClientData(clientData, applicationDTO));
        String applicationId = generateCode();
        verification.setCode(applicationId);
        verification.setStatus(Status.IN_PROGRESS);
        verificationRepository.save(verification);
        
        Map<String, Object> tempVars = new HashMap<String, Object>();
        tempVars.put("name", applicationDTO.getFirstName() + " " + applicationDTO.getLastName());
        tempVars.put("protocol", env.getProperty("site.protocol"));
        tempVars.put("domain", env.getProperty("site.domain"));
        tempVars.put("applicationId", applicationId);
        
        return new ClientCodeDTO().setCode(verification.getCode());
    }

    public ClientMessageDTO transferClientCode(ClientCodeDTO clientCodeDTO) {
        return  new ClientMessageDTO().setName(getStatusMessage(clientCodeDTO));
    }


    public String getStatusMessage(ClientCodeDTO clientCodeDTO) {
        try {
            return verificationRepository.findByCode(clientCodeDTO.getCode()).get(0).getStatus().toString();
        } catch (RuntimeException e) {
            System.out.println("verification not found!!!");
            return Status.NOT_FOUND.toString();
        }
    }

    private ClientData parseApplicationDTOtoClientData(ClientData clientData, ApplicationDTO applicationDTO) {
        clientData.setFirstName(applicationDTO.getFirstName());
        clientData.setLastName(applicationDTO.getLastName());
        clientData.setMiddleName(applicationDTO.getMiddleName());
        clientData.setEmail(applicationDTO.getEmail());
        clientData.setPhone(applicationDTO.getPhone());
        return clientData;
    }

    private Address parseApplicationDTOtoClientAddress(Address address, ApplicationDTO applicationDTO) {
        address.setRegion(applicationDTO.getRegion());
        address.setLocality(applicationDTO.getLocality());
        address.setDistrict(applicationDTO.getDistrict());
        address.setStreet(applicationDTO.getStreet());
        address.setBuilding(applicationDTO.getBuilding());
        address.setFlat(applicationDTO.getFlat());
        return address;
    }

    public String generateCode() {
        return UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d").randomUUID().toString();
    }
}

