package com.softserve.edu.dto.application.util;

import com.softserve.edu.dto.application.ClientApplicationFieldDTO;
import com.softserve.edu.entity.catalogue.AbstractCatalogue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CatalogueDTOTransformer {
        public static List<ClientApplicationFieldDTO> toDto(Iterable<? extends AbstractCatalogue> catalogues) {
        return StreamSupport.stream(catalogues.spliterator(), true)
                .map(catalogue -> new ClientApplicationFieldDTO(catalogue.getId(), catalogue.getDesignation()))
                .collect(Collectors.toList());
    }
}
