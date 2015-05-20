package com.softserve.edu.service;

import com.softserve.edu.entity.Provider;
import com.softserve.edu.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    public List<Provider> findByDistrictDesignation(String designation) {
        return providerRepository.findByAddressDistrict(designation);
    }
}
