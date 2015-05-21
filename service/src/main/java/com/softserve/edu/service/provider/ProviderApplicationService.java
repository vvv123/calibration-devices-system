package com.softserve.edu.service.provider;

import com.softserve.edu.entity.Verification;
import com.softserve.edu.repository.VerificationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@Transactional
public class ProviderApplicationService {
    @Autowired
    private VerificationRepository verificationRepository;

   public Page<Verification> getVerificationsBySearchAndPagination(int pageNumber, int itemsPerPage, String search) {
        // pagination starts from 1 at client side, but Spring Data JPA from 0
        PageRequest pageRequest = new PageRequest(pageNumber - 1, itemsPerPage);
        return search == null ?
                verificationRepository.findAll(pageRequest) : null
                /*verificationRepository.findByNameLikeIgnoreCase("%" + search + "%", pageRequest)*/;
    }
}
