package com.softserve.edu.service;

/**
 * Created by Oles Onyshchak on 5/8/2015.
 */

import com.softserve.edu.dto.ApplicationDTO;
import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.ClientData;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.repository.VerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientService {
    @Autowired
    private VerificationRepository verificationRepository;
    public int transferApplicationDTO(ApplicationDTO applicationDTO) {
        Verification verification = new Verification();
        verification.setClientData(parseApplicationDTOtoClientData(new ClientData(), applicationDTO));
        verification.setClientAddress(parseApplicationDTOtoClientAddress(new Address(), applicationDTO));
        verificationRepository.save(verification);
        return 555;
    }

    private ClientData parseApplicationDTOtoClientData(ClientData clientData, ApplicationDTO applicationDTO) {
        clientData.setName(applicationDTO.getFirstName());
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
        return address;
    }

   /* @Autowired
    private UserDateRepository userDateRepository;
    public int transferDTO(ApplicationDTO applicationDTO) {
       UserDate userDate = addDataFromDTOtoEntity(new UserDate(), applicationDTO);
        userDateRepository.save(userDate);
        return 555;
    }

    private UserDate addDataFromDTOtoEntity(UserDate userDate, ApplicationDTO applicationDTO) {
        userDate.setName(applicationDTO.getFirstName());
        userDate.setLastName(applicationDTO.getLastName());
        userDate.setMiddleName(applicationDTO.getMiddleName());
        userDate.setRegion(applicationDTO.getRegion());
        userDate.setLocality(applicationDTO.getLocality());
        userDate.setDistrict(applicationDTO.getDistrict());
        userDate.setBuilding(applicationDTO.getBuilding());

        return userDate;
    }*/

    public int count(String str) {
        return str.length();
    }
}

