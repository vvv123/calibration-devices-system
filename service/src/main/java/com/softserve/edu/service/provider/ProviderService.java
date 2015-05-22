package com.softserve.edu.service.provider;

import com.softserve.edu.entity.Provider;
import com.softserve.edu.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> findByDistrictDesignation(String designation) {
        return providerRepository.findByAddressDistrict(designation);
    }

    public Provider findById(Long id) {
        return providerRepository.findOne(id);
    }
}
