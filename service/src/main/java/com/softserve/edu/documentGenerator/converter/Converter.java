package com.softserve.edu.documentGenerator.converter;

import java.io.File;

/**
 * Created by oleg on 5/9/15.
 */
public interface Converter {
    File getConvertedFile(File readyTemplate);
}
