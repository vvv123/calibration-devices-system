package com.softserve.edu.service;

import com.softserve.edu.entity.Verification;
import com.softserve.edu.repository.VerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VerificationService {
    @Autowired
    VerificationRepository verificationRepository;

    /**
     * Find verification by it's id
     *
     * @param id of the verification to find
     * @return the verification with the given id or null if none found
     */
    public Verification findVerification(Long id) {
        return verificationRepository.findOne(id);
    }
}
