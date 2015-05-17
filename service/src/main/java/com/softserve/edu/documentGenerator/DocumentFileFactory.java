package com.softserve.edu.documentGenerator;

import com.softserve.edu.documentGenerator.DocumentCreator.DocxFileCreator;
import com.softserve.edu.documentGenerator.DocumentCreator.PdfFileCreator;
import com.softserve.edu.documentGenerator.documents.BaseDocument;
import com.softserve.edu.documentGenerator.utils.DocumentFormat;

import java.io.File;
import java.io.IOException;

/**
 * Factory for creating document files.
 */
public class DocumentFileFactory {

    /**
     * Builds a document.
     *
     * @param document with the information to build this file
     * @param documentFormat format of the resulting document
     * @return built document
     */
    public static File build(BaseDocument document, DocumentFormat documentFormat) {
        File builtFile;

        switch (documentFormat) {
            case DOCX:
                builtFile = buildDocx(document);
                break;
            case PDF:
                builtFile = buildPdf(document);
                break;
            default:
                throw new IllegalArgumentException(documentFormat.name() + "is not supported");
        }

        return builtFile;
    }

    /**
     * Build a pdf file
     *
     * @param document with the information to build this file
     * @return built pdf file
     */
    public static File buildPdf(BaseDocument document) {
        File pdfDocument;
        PdfFileCreator pdfCreator = new PdfFileCreator(document);

        try {
            pdfDocument = pdfCreator.createFile();
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }

        return pdfDocument;
    }

    /**
     * Build a docx file
     *
     * @param document with the information to build this file
     * @return built docx file
     */
    public static File buildDocx(BaseDocument document) {
        File docxDocument;
        DocxFileCreator docxCreator = new DocxFileCreator(document);

        try {
            docxDocument = docxCreator.createFile();
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }

        return docxDocument;
    }

}
