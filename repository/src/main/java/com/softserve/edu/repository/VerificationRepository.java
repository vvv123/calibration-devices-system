package com.softserve.edu.repository;

import com.softserve.edu.entity.Verification;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VerificationRepository extends CrudRepository<Verification,Long> {
    List<Verification> findByCode(String code);
}
