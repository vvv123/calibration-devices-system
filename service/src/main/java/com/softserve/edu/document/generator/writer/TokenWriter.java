package com.softserve.edu.document.generator.writer;

import com.softserve.edu.document.generator.utils.DocumentUtils;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Class for writing tokens into a file
 */
public class TokenWriter {
    private File fileToWrite;

    public TokenWriter(File fileToWrite) {
        this.fileToWrite = fileToWrite;
    }

    /**
     * Replaces token
     *
     * @param token      to be replaced
     * @param newText    text to be inserted
     * @throws IOException if file couldn't be found
     */
    public void replaceToken(String token, String newText)
            throws IOException {
        InputStream is = null;

        is = new FileInputStream(fileToWrite);
        XWPFDocument doc = new XWPFDocument(is);

        replaceTextInDocx(doc, token, newText);

        DocumentUtils.saveMSWordDocument(fileToWrite, doc);
    }

    /**
     * Replaces strings in a .docx document.
     *
     * @param document      document to replace strings in
     * @param textToReplace string to replace
     * @param newText       text to be inserted
     */
    private void replaceTextInDocx(XWPFDocument document, String textToReplace, String newText) {
        replaceTextInParagraphs(document, textToReplace, newText);
        replaceTextInTables(document, textToReplace, newText);
    }

    /**
     * Replaces strings in a .docx document's paragraphs.
     *
     * @param document      document to replace strings in
     * @param textToReplace string to replace
     * @param newText       text to be inserted
     */
    private void replaceTextInParagraphs(XWPFDocument document, String textToReplace, String newText) {
        int position = 0;

        for (XWPFParagraph p : document.getParagraphs()) {
            List<XWPFRun> runs = p.getRuns();

            for (XWPFRun run : runs) {
                String text = run.getText(position);
                if (text != null) {
                    if (text.contains(textToReplace)) {
                        text = text.replace(textToReplace, newText);
                        run.setText(text, position);
                    }
                }
            }
        }
    }

    /**
     * Replaces strings in a .docx document's tables.
     *
     * @param document      document to replace strings in
     * @param textToReplace string to replace
     * @param newText       text to be inserted
     */
    private void replaceTextInTables(XWPFDocument document, String textToReplace, String newText) {
        int position = 0;

        // document's tables
        for (XWPFTable table : document.getTables()) {
            // rows
            for (XWPFTableRow row : table.getRows()) {
                // cells
                for (XWPFTableCell cell : row.getTableCells()) {
                    // paragraphs
                    for (XWPFParagraph paragraph : cell.getParagraphs()) {
                        // runs
                        for (XWPFRun run : paragraph.getRuns()) {
                            // replace text
                            String text = run.getText(position);
                            if (text.contains(textToReplace)) {
                                text = text.replace(textToReplace, newText);
                                run.setText(text);
                            }
                        }
                    }
                }
            }
        }
    }

}
