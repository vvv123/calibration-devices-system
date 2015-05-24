package com.softserve.edu.service.verification;

import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.util.Status;
import com.softserve.edu.repository.VerificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VerificationService {

    @Autowired
    private VerificationRepository verificationRepository;

    @Transactional
    public void saveVerification(Verification verification) {
        verificationRepository.save(verification);
    }

    @Transactional(readOnly = true)
    public Verification findById(String code) {
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
    @Transactional(readOnly = true)
    public Page<Verification> findPageOfAllVerificationsByProviderId(Long providerId, int pageNumber, int itemsPerPage) {
        Pageable pageRequest = new PageRequest(pageNumber - 1, itemsPerPage);
        return verificationRepository.findByProviderId(providerId, pageRequest);
    }

    @Transactional(readOnly = true)
    public Page<Verification> findPageOfSentVerificationsByProviderId(Long providerId, int pageNumber, int itemsPerPage) {
        Pageable pageRequest = new PageRequest(pageNumber - 1, itemsPerPage);
        return verificationRepository.findByProviderIdAndStatus(providerId, Status.SENT, pageRequest);
    }

    @Transactional(readOnly = true)
    public Verification findByIdAndProviderId(String id, Long providerId) {
        Verification verification = verificationRepository.findByIdAndProviderId(id, providerId);
        if (verification == null) {
            throw new AccessDeniedException("Id of user organization differs from requested verification object organization id.");
        }
        return verification;
    }
}
