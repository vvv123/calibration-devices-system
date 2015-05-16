package com.softserve.edu.service.catalogue;

import com.softserve.edu.entity.catalogue.Street;
import com.softserve.edu.repository.catalogue.StreetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService {

    @Autowired
    private StreetRepository streetRepository;

    public List<Street> getStreetsCorrespondingLocality(Long localityId) {
        return streetRepository.findByLocalityId(localityId);
    }
}
