package com.softserve.edu.repository;

import com.softserve.edu.entity.Verification;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Oles Onyshchak on 5/8/2015.
 */
public interface VerificationRepository extends CrudRepository<Verification,Long> {
    Verification save(Verification verification);
}
