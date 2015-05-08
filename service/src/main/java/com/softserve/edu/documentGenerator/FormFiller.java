package com.softserve.edu.documentGenerator;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.FileInputStream;
import java.io.IOException;

public class FormFiller {
    /**
     * Replace token in a file and save changes
     */
    public void replaceTokenAndSave(String token, String newText, String fileName) {
        String filePath = new Utils().getFilePath(fileName);
        POIFSFileSystem documentFileStream = null;

        try {
            documentFileStream = new POIFSFileSystem(new FileInputStream(filePath));
            HWPFDocument doc = new HWPFDocument(documentFileStream);
            DocumentUtils.replaceText(doc, token, newText);
            DocumentUtils.saveMSWordDocument(filePath, doc);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

}
