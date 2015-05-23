package com.softserve.edu.repository;

import com.softserve.edu.entity.Verification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VerificationRepository extends PagingAndSortingRepository<Verification, String> {
    Page<Verification> findPageByProviderId(Long providerId, Pageable pageable);
}
