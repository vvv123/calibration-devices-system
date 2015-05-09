package com.softserve.edu.documentGenerator.core;

import com.softserve.edu.documentGenerator.DocumentGenerator;
import com.softserve.edu.documentGenerator.utils.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.Template;

import java.io.File;

/**
 * class for testing purposes, not for production
 */
public class DemoMain {

    public static void main(String[] args) {
        int verificationID = -1;

        File generatedDoc =
                DocumentGenerator.generate(Template.DEVICE_CHECK, verificationID, DocumentFormat.PDF);
    }

}
