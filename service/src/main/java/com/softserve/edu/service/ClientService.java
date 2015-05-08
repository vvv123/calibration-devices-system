package com.softserve.edu.service;

/**
 * Created by Oles Onyshchak on 5/8/2015.
 */

import com.softserve.edu.dto.ApplicationDTO;
import com.softserve.edu.entity.UserDate;
import com.softserve.edu.repository.UserDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientService {
    @Autowired
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
    }

    public int count(String str) {
        return str.length();
    }
}

