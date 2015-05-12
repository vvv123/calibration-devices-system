package com.softserve.edu.service;

/**
 * Created by Oles Onyshchak on 5/8/2015.
 */

import com.softserve.edu.dto.ApplicationDTO;
import com.softserve.edu.dto.ClientCodeDTO;
import com.softserve.edu.dto.ClientMessageDTO;
import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.ClientData;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.util.Status;
import com.softserve.edu.repository.VerificationRepository;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;

@Service
@Transactional
public class ClientService {
    @Autowired
    private VerificationRepository verificationRepository;

    public Long transferApplication(ApplicationDTO applicationDTO) {
        Verification verification = new Verification();
        ClientData clientData = new ClientData();
        clientData.setClientAddress(parseApplicationDTOtoClientAddress(new Address(), applicationDTO));
        verification.setClientData(parseApplicationDTOtoClientData(clientData, applicationDTO));
        verification.setCode(generateCode(clientData));
        verification.setStatus(Status.IN_PROGRESS);
        verificationRepository.save(verification);
        return verification.getCode();
    }

    public ClientMessageDTO transferClientCode(ClientCodeDTO clientCodeDTO) {
        return  new ClientMessageDTO().setName(findCode(clientCodeDTO));
    }

    public String findCode(ClientCodeDTO clientCodeDTO) {
        try {
            return verificationRepository.findByCode(clientCodeDTO.getCode()).get(0).getStatus().name();
        } catch (RuntimeException e) {
            System.out.println("verification not found!!!");
            return "?????? ?? ????????";
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

    public Long generateCode(ClientData clientData) {
        return (long) Math.abs(
                new HashCodeBuilder(17, 37)
                        .append(clientData.getFirstName())
                        .append(clientData.getLastName())
                        .append(clientData.getMiddleName())
                        .append(clientData.getEmail())
                        .append(clientData.getPhone())
                        .append(clientData.getClientAddress())
                        .toHashCode()
        );
    }
}

