package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.utils.DocumentUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TokenWriter {
    /**
     * Replaces token in a file
     * @param sourceFile file to replace token in
     * @param token to be replaced
     * @param newText text to be inserted
     * @throws InvalidFormatException if file is of invalid format
     * @throws IOException if file couldn't be found
     */
    public void replaceToken(File sourceFile, String token, String newText)
            throws InvalidFormatException, IOException {
        InputStream is = null;

        is = new FileInputStream(sourceFile);
        XWPFDocument doc = new XWPFDocument(is);

        try {
            DocumentUtils.replaceText(doc, token, newText);
        } catch (InvalidFormatException exception) {
            exception.printStackTrace();
            throw exception;
        }

        DocumentUtils.saveMSWordDocument(sourceFile, doc);
    }
}
