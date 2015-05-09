package com.softserve.edu.documentGenerator.converter;

import com.softserve.edu.documentGenerator.utils.DocumentFormat;

/**
 * Created by oleg on 5/9/15.
 */
public class Converters {

    public static Converter get(DocumentFormat documentFormat) {
        return new DocToPdf();
    }

}
