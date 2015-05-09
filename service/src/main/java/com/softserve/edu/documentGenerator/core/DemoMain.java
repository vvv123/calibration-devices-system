package com.softserve.edu.documentGenerator.core;

import com.softserve.edu.documentGenerator.converter.DocToPdf;
import com.softserve.edu.documentGenerator.generator.FormFiller;

/**
 * class for testing purposes, not for production
 */
public class DemoMain {

    public static void main(String[] args) {
        String inputFileName = "documentsTemplates/form.doc";
        String outputFileName = "documents/form.pdf";

        FormFiller formFiller = new FormFiller();
        formFiller.replaceTokenAndSave("$NAME", "\n Олег Чернигевич \n", inputFileName,
                "documents/ttt.doc");
        DocToPdf docToPdf = new DocToPdf();
        docToPdf.generate("documents/ttt.doc", outputFileName);
    }

}
