package com.softserve.edu.repository;

import com.softserve.edu.entity.Verification;
import com.softserve.edu.entity.util.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VerificationRepository extends PagingAndSortingRepository<Verification, String> {
    Page<Verification> findByProviderId(Long providerId, Pageable pageable);

    Page<Verification> findByProviderIdAndStatus(Long providerId, Status status, Pageable pageable);
}
