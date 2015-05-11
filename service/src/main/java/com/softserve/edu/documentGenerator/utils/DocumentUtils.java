package com.softserve.edu.documentGenerator.utils;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.CharacterRun;
import org.apache.poi.hwpf.usermodel.Paragraph;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Section;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocumentUtils {
    /**
     * Get file's path from resources folder
     */
    public String getFilePath(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());

        return file.getAbsolutePath();
    }

    /**
     * Replace text in a document
     */
    static public void replaceText(HWPFDocument document, String textToReplace, String newText){
        Range textRange = document.getRange();

        for (int rangeIndex = 0; rangeIndex < textRange.numSections(); rangeIndex++ ) {
            Section sectionOfRange = textRange.getSection(rangeIndex);

            for (int paragraphIndex = 0; paragraphIndex < sectionOfRange.numParagraphs(); paragraphIndex++) {
                Paragraph textParagraph = sectionOfRange.getParagraph(paragraphIndex);

                for (int charRunIndex = 0; charRunIndex < textParagraph.numCharacterRuns(); charRunIndex++) {
                    CharacterRun charRun = textParagraph.getCharacterRun(charRunIndex);
                    String textFromDocument = charRun.text();

                    if(textFromDocument.contains(textToReplace)) {
                        charRun.replaceText(textToReplace, newText);
                    }
                }
            }
        }
    }

    /**
     * Save document in the specified path
     */
    static public void saveMSWordDocument(File file, HWPFDocument documentToSave) throws IOException {
        try (FileOutputStream outStream = new FileOutputStream(file)) {
            documentToSave.write(outStream);
        }
    }
}
