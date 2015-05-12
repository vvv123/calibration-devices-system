package com.softserve.edu.documentGenerator.utils;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Section;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class DocumentUtils {
    /**
     * Get file's path from resources folder
     */
    public String getFilePath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        return file.getAbsolutePath();
    }

    static public void replaceText(XWPFDocument document, String textToReplace, String newText) throws InvalidFormatException, IOException {
        XWPFDocument doc = document;
        for (XWPFParagraph p : doc.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();
            if (runs != null) {
                for (XWPFRun r : runs) {
                    String text = r.getText(0);
                    if (text != null && text.contains(textToReplace)) {
                        text = text.replace(textToReplace, newText);
                        r.setText(text, 0);
                    }
                }
            }
        }
        for (XWPFTable tbl : doc.getTables()) {
            for (XWPFTableRow row : tbl.getRows()) {
                for (XWPFTableCell cell : row.getTableCells()) {
                    for (XWPFParagraph p : cell.getParagraphs()) {
                        for (XWPFRun r : p.getRuns()) {
                            String text = r.getText(0);
                            if (text.contains(textToReplace)) {
                                text = text.replace(textToReplace, newText);
                                r.setText(text);
                            }
                        }
                    }
                }
            }
        }
        doc.write(new FileOutputStream("output.docx"));
    }


//    /**
//     * Replace text in a document
//     */
//    static public void replaceText(HWPFDocument document, String textToReplace, String newText){
//        Range textRange = document.getRange();
//
//        for (int rangeIndex = 0; rangeIndex < textRange.numSections(); rangeIndex++ ) {
//            Section sectionOfRange = textRange.getSection(rangeIndex);
//
//            for (int paragraphIndex = 0; paragraphIndex < sectionOfRange.numParagraphs(); paragraphIndex++) {
//                Paragraph textParagraph = sectionOfRange.getParagraph(paragraphIndex);
//
//                for (int charRunIndex = 0; charRunIndex < textParagraph.numCharacterRuns(); charRunIndex++) {
//                    CharacterRun charRun = textParagraph.getCharacterRun(charRunIndex);
//                    String textFromDocument = charRun.text();
//
//                    if(textFromDocument.contains(textToReplace)) {
//                        charRun.replaceText(textToReplace, newText);
//                    }
//                }
//            }
//        }
//    }

    /**
     * Save document in the specified path
     */
//    static public void saveMSWordDocument(File file, HWPFDocument documentToSave) throws IOException {
//        try (FileOutputStream outStream = new FileOutputStream(file)) {
//            documentToSave.write(outStream);
//        }
//    }

    static public void saveMSWordDocument(File file, XWPFDocument documentToSave) throws IOException {
        try (FileOutputStream outStream = new FileOutputStream(file)) {
            documentToSave.write(outStream);
        }
    }
}
