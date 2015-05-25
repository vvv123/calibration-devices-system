package com.softserve.edu.controller.provider.util;

import com.softserve.edu.dto.provider.VerificationDTO;
import com.softserve.edu.dto.provider.VerificationPageDTO;
import com.softserve.edu.entity.Verification;
import org.springframework.data.domain.Page;

import java.util.List;

public class VerificationPageDTOTransformer {
    public static Page<VerificationPageDTO> toDTO(Page<Verification> verificationPage) {
        return verificationPage
                .map(verification -> new VerificationPageDTO(verification.getId(), verification.getInitialDate(),
                        verification.getClientData().getLastName(),
                        verification.getClientData().getClientAddress().getStreet(), verification.getStatus()));
    }
    public static Verification fromVerificationDTOtoVerification(VerificationPageDTO verificationDTO){
        Verification verification = new Verification();
        verification.setId(verificationDTO.getId());
        verification.setStatus(verificationDTO.getStatus());
        System.out.println(verificationDTO.toString());
        return verification;

    }
}
