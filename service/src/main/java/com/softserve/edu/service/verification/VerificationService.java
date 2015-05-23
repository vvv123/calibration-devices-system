package com.softserve.edu.service.verification;

import com.softserve.edu.entity.Verification;
import com.softserve.edu.repository.VerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    /**
     * Returns requested number(page) of Verification entities(itemsPerPage parameter) that belongs to specific organization.
     * Note: pagination starts from 1 at client side, but Spring Data JPA from 0.
     *
     * @param pageNumber   Number of partial data that will be returned.
     * @param itemsPerPage Number of Verification-s that will be present in one page(unit of partial data).
     * @return Requested page of Verification-s that belong to specific organization.
     */
    public Page<Verification> findPageOfVerificationsByProvider(Long providerId, int pageNumber, int itemsPerPage) {
        Pageable pageRequest = new PageRequest(pageNumber - 1, itemsPerPage);
        return verificationRepository.findPageByProviderId(providerId, pageRequest);
    }
}
