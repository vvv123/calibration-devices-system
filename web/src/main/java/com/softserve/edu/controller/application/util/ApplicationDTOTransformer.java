package com.softserve.edu.controller.application.util;

import com.softserve.edu.dto.application.ApplicationDTO;
import com.softserve.edu.entity.Address;
import com.softserve.edu.entity.ClientData;

public class ApplicationDTOTransformer {
    public static ClientData parseApplicationDTOtoClientData(ApplicationDTO applicationDTO) {
        return new ClientData(applicationDTO.getFirstName(), applicationDTO.getLastName(), applicationDTO.getMiddleName(),
                applicationDTO.getEmail(), applicationDTO.getPhone(), parseApplicationDTOToClientAddress(applicationDTO));
    }

    private static Address parseApplicationDTOToClientAddress(ApplicationDTO applicationDTO) {
        return new Address(applicationDTO.getRegion(), applicationDTO.getDistrict(), applicationDTO.getLocality(),
                applicationDTO.getStreet(), applicationDTO.getBuilding(), applicationDTO.getFlat(),
                applicationDTO.getIndex());
    }
}
