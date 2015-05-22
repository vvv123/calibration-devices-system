package com.softserve.edu.service;

import com.softserve.edu.entity.Verification;
import com.softserve.edu.repository.VerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class VerificationService {

    @Autowired
    private VerificationRepository verificationRepository;

    public void saveVerification(Verification verification) {
        verificationRepository.save(verification);
    }

    public Verification findByCode(String code) {
        return verificationRepository.findOne(code);
    }
}
