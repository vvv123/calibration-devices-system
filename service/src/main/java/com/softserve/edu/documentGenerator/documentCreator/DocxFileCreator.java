package com.softserve.edu.documentGenerator.documentCreator;

import com.softserve.edu.documentGenerator.documents.BaseDocument;
import com.softserve.edu.documentGenerator.utils.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.PathBuilder;
import com.softserve.edu.documentGenerator.utils.StandardPath;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.List;

/**
 * Class for creating a document with the .docx format.
 */
public class DocxFileCreator implements FileCreator {
    /**
     * Document with information needed for creating a docx file
     */
    BaseDocument document;

    /**
     * Constructor
     *
     * @param document document with the data to be used for file generation.
     */
    public DocxFileCreator(BaseDocument document) {
        this.setDocument(document);
    }

    /**
     * {inherit}
     */
    @Override
    public ByteArrayOutputStream createFile() throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        InputStream inputStream = new FileInputStream(document.getDocumentType().getTemplate());
        XWPFDocument templateDocument = new XWPFDocument(inputStream);
        inputStream.close();

        XWPFDocument newDocument = new XWPFDocument(templateDocument.getPackage());
        List<XWPFParagraph> paragraphs = newDocument.getParagraphs();

        paragraphs.
                stream().
                filter(paragraph -> !paragraph.getParagraphText().isEmpty()).
                forEach(this::setCorrectText);

        newDocument.write(outputStream);

        return outputStream;
    }

    /**
     * Set the correct data for each run in the supplied paragraph
     *
     * @param sourceParagraph paragraph to copy runs from
     */
    private void setCorrectText(XWPFParagraph sourceParagraph) {
        com.softserve.edu.documentGenerator.documentWriter.Writer writer = document.getWriter();
        int position = 0;

        List<XWPFRun> runs = sourceParagraph.getRuns();
        for (int i = 0; i < runs.size(); i++) {
            XWPFRun sourceRun = runs.get(i);
            String textInRun = sourceRun.getText(position);

            if (textInRun == null || textInRun.isEmpty()) {
                continue;
            }

            textInRun = writer.replaceTokens(textInRun);
            sourceRun.setText(textInRun, 0);
        }
    }

    public BaseDocument getDocument() {
        return document;
    }

    public void setDocument(BaseDocument document) {
        this.document = document;
    }
}
