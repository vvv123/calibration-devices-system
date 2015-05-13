package com.softserve.edu.documentGenerator.utils;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.List;

public class DocumentUtils {
    /**
     * Gets file's path from resources folder
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

    /**
     * Saves document in the specified path
     */
    static public void saveMSWordDocument(File file, XWPFDocument documentToSave) throws IOException {
        try (FileOutputStream outStream = new FileOutputStream(file)) {
            documentToSave.write(outStream);
        }
    }

    public static File createFile(String path) throws FileNotFoundException {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter(path);
        } finally {
            writer.close();
        }

        return new File(path);
    }

    public static File getTemplate(File sourceFile, String destPath) throws IOException {
        File file = null;

        file = DocumentUtils.createFile(destPath);
        FileUtils.copyFile(sourceFile, file);

        return file;
    }
}
