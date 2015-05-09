package com.softserve.edu.documentGenerator.generator;

import com.softserve.edu.documentGenerator.utils.DocumentUtils;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FormFiller {
    private FormFiller() {
    }

    /**
     * Replace token in a file and save changes
     */
    public static File replaceTokenAndSave(String token, String newText, File file, String newFileName) {
        //String filePath = new DocumentUtils().getFilePath(fileName);
        POIFSFileSystem documentFileStream = null;

        try {
            documentFileStream = new POIFSFileSystem(new FileInputStream(file));
            HWPFDocument doc = new HWPFDocument(documentFileStream);
            DocumentUtils.replaceText(doc, token, newText);
            DocumentUtils.saveMSWordDocument(newFileName, doc);
        } catch(IOException e){
            e.printStackTrace();
        }

        return new File(newFileName);
    }

    public static File getReadyTemplate(File template, int verificationID, String outputFileName) {
        return replaceTokenAndSave("$USER", "Олег", template, outputFileName);
    }
}
