package com.softserve.edu.documentGenerator.utils;

import java.io.File;

/**
 * Created by oleg on 5/9/15.
 */
public enum Template {
    DEVICE_CHECK {
        @Override
        public String toString() {
            return "device_check.doc";
        }
    };

    public File getFile() {
        String path = PathBuilder.build(StandardPath.DOCUMENTS_TEMPLATES, this);
        return new File(path);
    }
}
