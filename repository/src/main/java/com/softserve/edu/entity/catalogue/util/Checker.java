package com.softserve.edu.entity.catalogue.util;

import com.softserve.edu.entity.catalogue.AbstractCatalogue;
import org.springframework.util.Assert;

public class Checker {
    public static void checkForEmptyText(String designation) {
        Assert.hasText(designation, "Designation can not be empty.");
    }

    public static void checkForNull(AbstractCatalogue catalogue){
        Assert.notNull(catalogue, catalogue.toString());
    }
}
