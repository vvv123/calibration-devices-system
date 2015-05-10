package com.softserve.edu.repository;

import com.softserve.edu.entity.ClientData;
import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.catalogue.Locality;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Oles Onyshchak on 5/8/2015.
 */
public interface VerificationRepository extends CrudRepository<Verification,Long> {
    List<Verification> findByCode(Long code);
}
