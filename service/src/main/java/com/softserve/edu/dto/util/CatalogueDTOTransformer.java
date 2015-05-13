package com.softserve.edu.dto.util;

import com.softserve.edu.dto.CatalogueDTO;
import com.softserve.edu.entity.catalogue.AbstractCatalogue;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class CatalogueDTOTransformer {
        public static List<CatalogueDTO> toDto(Iterable<? extends AbstractCatalogue> catalogues) {
        return StreamSupport.stream(catalogues.spliterator(), true)
                .map(catalogue -> new CatalogueDTO(catalogue.getId(), catalogue.getDesignation()))
                .collect(Collectors.toList());
    }
}
