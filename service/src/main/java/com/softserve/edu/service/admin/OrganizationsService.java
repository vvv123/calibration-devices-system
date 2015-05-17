package com.softserve.edu.service.admin;

import com.softserve.edu.entity.Calibrator;
import com.softserve.edu.entity.Organization;
import com.softserve.edu.entity.Provider;
import com.softserve.edu.entity.StateVerificator;
import com.softserve.edu.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
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

    public Page<Organization> getOrganizationsBySearchAndPagination(int pageNumber, int itemsPerPage, String search) {
        /* pagination starts from 1 at client side, but Spring Data JPA from 0 */
        PageRequest pageRequest = new PageRequest(pageNumber - 1, itemsPerPage);
        return (search == null) ?
                organizationRepository.findAll(pageRequest) :
                organizationRepository.findByNameLike("%" + search + "%", pageRequest);
    }

    public String getType(Organization organization) {
        if (organization instanceof Provider)
            return "PROVIDER";
        if (organization instanceof Calibrator)
            return "CALIBRATOR";
        if (organization instanceof StateVerificator)
            return "STATE_VERIFICATION";
        return "NO_TYPE";
    }
}
