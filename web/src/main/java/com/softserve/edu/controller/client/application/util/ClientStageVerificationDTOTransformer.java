package com.softserve.edu.controller.client.application.util;

import com.softserve.edu.dto.application.ClientStageVerificationDTO;
import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.ClientData;

public class ClientStageVerificationDTOTransformer {
    public static ClientData parseApplicationDTOToClientData(ClientStageVerificationDTO clientStageVerificationDTO) {
        return new ClientData(clientStageVerificationDTO.getFirstName(), clientStageVerificationDTO.getLastName(),
                clientStageVerificationDTO.getMiddleName(), clientStageVerificationDTO.getEmail(),
                clientStageVerificationDTO.getPhone(), parseApplicationDTOToClientAddress(clientStageVerificationDTO));
    }

    private static Address parseApplicationDTOToClientAddress(ClientStageVerificationDTO clientStageVerificationDTO) {
        return new Address(clientStageVerificationDTO.getRegion(), clientStageVerificationDTO.getDistrict(),
                clientStageVerificationDTO.getLocality(), clientStageVerificationDTO.getStreet(),
                clientStageVerificationDTO.getBuilding(), clientStageVerificationDTO.getFlat());
    }
}
