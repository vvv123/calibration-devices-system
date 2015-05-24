package com.softserve.edu.repository;

import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.util.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VerificationRepository extends PagingAndSortingRepository<Verification, String> {
    Page<Verification> findByProviderId(Long providerId, Pageable pageable);

    Page<Verification> findByProviderIdAndStatus(Long providerId, Status status, Pageable pageable);

    /**
     * This method serves for security purpose. When provider employee(or admin) makes GET request
     * for any verification he can only get it if id of organization and provider employee matches.
     * Otherwise(if returned null) AccessDeniedException will be thrown.
     *
     * @param id         Id of verification.
     * @param providerId Provider organization id.
     * @return Verification object that match provided query or null if no matches found.
     */
    Verification findByIdAndProviderId(String id, Long providerId);
}
