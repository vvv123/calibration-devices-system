package com.softserve.edu.documentGenerator.generator.documentWriter;

import com.softserve.edu.documentGenerator.utils.DocumentUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Writer {
    /**
     * Replace token in a file and save changes
     */
    public void replaceTokenAndSave(File outputFile, String token, String newText) {
        POIFSFileSystem documentFileStream = null;

        try {
            documentFileStream = new POIFSFileSystem(new FileInputStream(outputFile));
            HWPFDocument doc = new HWPFDocument(documentFileStream);
            DocumentUtils.replaceText(doc, token, newText);
            DocumentUtils.saveMSWordDocument(outputFile, doc);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
