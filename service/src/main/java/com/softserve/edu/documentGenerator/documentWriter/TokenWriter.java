package com.softserve.edu.documentGenerator.documentWriter;

import com.softserve.edu.documentGenerator.utils.DocumentUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TokenWriter {
    /**
     * Replace token in a file and save changes
     */
    public void replaceTokenAndSave(File outputFile, String token, String newText) {
        POIFSFileSystem documentFileStream = null;
        InputStream is = null;

        try {
           // documentFileStream = new POIFSFileSystem(new FileInputStream(outputFile));
            is = new FileInputStream(outputFile);
            XWPFDocument doc = new XWPFDocument(is);
            try {
                DocumentUtils.replaceText(doc, token, newText);
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }
            DocumentUtils.saveMSWordDocument(outputFile, doc);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
