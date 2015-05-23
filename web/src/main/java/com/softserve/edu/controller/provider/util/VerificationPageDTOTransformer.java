package com.softserve.edu.controller.provider.util;

import com.softserve.edu.dto.provider.VerificationPageDTO;
import com.softserve.edu.entity.Verification;
import org.springframework.data.domain.Page;

public class VerificationPageDTOTransformer {
    public static Page<VerificationPageDTO> toDTO(Page<Verification> verificationPage) {
        return verificationPage
                .map(verification -> new VerificationPageDTO(verification.getId(), verification.getVerificationFinishedDate(),
                        verification.getClientData().getLastName(),
                        verification.getClientData().getClientAddress().getStreet()));
    }
}
