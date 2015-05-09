package com.softserve.edu.documentGenerator.core;

import com.softserve.edu.documentGenerator.converter.DocToPdf;
import com.softserve.edu.documentGenerator.generator.FormFiller;
import com.softserve.edu.documentGenerator.utils.StandardPaths;

/**
 * class for testing purposes, not for production
 */
public class DemoMain {

    public static void main(String[] args) {
        String inputFileName = StandardPaths.DOCUMENTS_TEMPLATES + "/form.doc";
        String outputFileName = StandardPaths.DOCUMENTS_GENERATED + "/form.pdf";

        FormFiller formFiller = new FormFiller();
        formFiller.replaceTokenAndSave("$NAME", "\n Олег Чернигевич \n", inputFileName,
                StandardPaths.DOCUMENTS_GENERATED + "/ttt.doc");
        DocToPdf docToPdf = new DocToPdf();
        docToPdf.generate(StandardPaths.DOCUMENTS_GENERATED + "/ttt.doc", outputFileName);
    }

}
