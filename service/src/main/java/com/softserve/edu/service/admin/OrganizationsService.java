package com.softserve.edu.service.admin;

import com.softserve.edu.entity.Calibrator;
import com.softserve.edu.entity.Organization;
import com.softserve.edu.entity.Provider;
import com.softserve.edu.entity.StateVerificator;
import com.softserve.edu.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class OrganizationsService {

    @Autowired
    private OrganizationRepository organizationRepository;

    public void addOrganization(String name, String email, String phone, String type) {
        Organization organization;
        switch (type) {
            case "PROVIDER":
                organization = new Provider(name, email, phone);
                break;
            case "CALIBRATOR":
                organization = new Calibrator(name, email, phone);
                break;
            case "STATE_VERIFICATION":
                organization = new StateVerificator(name, email, phone);
                break;
            default:
                throw new NoSuchElementException();
        }
        organizationRepository.save(organization);
    }

}
