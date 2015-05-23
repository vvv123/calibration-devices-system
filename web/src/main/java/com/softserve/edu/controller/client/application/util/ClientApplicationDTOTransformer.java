package com.softserve.edu.controller.client.application.util;

import com.softserve.edu.dto.application.ClientApplicationDTO;
import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.ClientData;

public class ClientApplicationDTOTransformer {
    public static ClientData parseApplicationDTOToClientData(ClientApplicationDTO clientApplicationDTO) {
        return new ClientData(clientApplicationDTO.getFirstName(), clientApplicationDTO.getLastName(), clientApplicationDTO.getMiddleName(),
                clientApplicationDTO.getEmail(), clientApplicationDTO.getPhone(), parseApplicationDTOToClientAddress(clientApplicationDTO));
    }

    private static Address parseApplicationDTOToClientAddress(ClientApplicationDTO clientApplicationDTO) {
        return new Address(clientApplicationDTO.getRegion(), clientApplicationDTO.getDistrict(), clientApplicationDTO.getLocality(),
                clientApplicationDTO.getStreet(), clientApplicationDTO.getBuilding(), clientApplicationDTO.getFlat());
    }
}
