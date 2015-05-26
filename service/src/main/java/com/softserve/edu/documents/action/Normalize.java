package com.softserve.edu.documents.action;

import com.softserve.edu.documents.parameter.FileParameters;
import org.apache.commons.vfs2.FileObject;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Normalize implements Action {

    @Override
    public FileObject process(FileObject fileObject, FileParameters fileParameters) throws IOException {
        InputStream inputStream = fileObject.getContent().getInputStream();
        XWPFDocument templateDocument = new XWPFDocument(inputStream);
        inputStream.close();

        XWPFDocument newDocument = new XWPFDocument(templateDocument.getPackage());

        List<XWPFParagraph> paragraphs = newDocument.getParagraphs();

        paragraphs.
                stream().
                filter(paragraph -> !paragraph.getParagraphText().isEmpty()).
                forEach(this::normalize);

        newDocument.write(fileObject.getContent().getOutputStream());

        return fileObject;
    }

    private void normalize(XWPFParagraph sourceParagraph) {
        String text = sourceParagraph.getText();

        List<XWPFRun> runs = sourceParagraph.getRuns();

        boolean isBold = runs.get(0).isBold();
        boolean isItalic = runs.get(0).isItalic();
        int fontSize = 0;

        int size = runs.size();
        for (int i = 0; i < size; i++) {
            int runFontSize = runs.get(0).getFontSize();

            if (runFontSize > fontSize) {
                fontSize = runFontSize;
            }

            sourceParagraph.removeRun(0);
        }

        XWPFRun run2 = sourceParagraph.createRun();
        run2.setText(text);
        run2.setBold(isBold);
        run2.setFontSize(fontSize);
        run2.setItalic(isItalic);

        sourceParagraph.addRun(run2);
    }
}
