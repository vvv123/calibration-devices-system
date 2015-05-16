package com.softserve.edu.documentGenerator.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

/**
 * Utility functions for documents
 */
public class DocumentUtils {
    /**
     * Saves document in the specified path
     */
    static public void saveMSWordDocument(File file, XWPFDocument documentToSave) throws IOException {
        try (FileOutputStream outStream = new FileOutputStream(file)) {
            documentToSave.write(outStream);
        }
    }

    /**
     * Create file at the specified path
     *
     * @param path where the file must be created
     * @return newly created file
     * @throws FileNotFoundException if the path is impossible to reach
     */
    public static File createFile(String path) throws FileNotFoundException {

        try (PrintWriter writer = new PrintWriter(path)) {
        }

        return new File(path);
    }

    /**
     * @param sourceFile
     * @param destPath
     * @return
     * @throws IOException if the path is impossible to reach
     */
    public static File createCopy(File sourceFile, String destPath) throws IOException {
        File file = null;

        file = DocumentUtils.createFile(destPath);
        FileUtils.copyFile(sourceFile, file);

        return file;
    }

    public byte[] fileToBytes(File reportFile) throws IOException {
        byte[] reportBytes;

        try (InputStream reportInputStream = new FileInputStream(reportFile)) {
            reportBytes = IOUtils.toByteArray(reportInputStream);
        }

        return reportBytes;
    }
}
