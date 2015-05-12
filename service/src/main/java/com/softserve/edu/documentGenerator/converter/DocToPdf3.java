package com.softserve.edu.documentGenerator.converter;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import com.softserve.edu.documentGenerator.utils.DocumentUtils;
import com.softserve.edu.documentGenerator.utils.StandardPath;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;

/**
 * Convert Doc document into Pdf document
 */
public class DocToPdf3 implements Converter {

    /**
     * {inherit}
     */
    @Override
    public void convertFile(File readyTemplate, File outputFileName) {
//
//            Document document = null;
//            POIFSFileSystem fs = null;
//            try {
//                String fontPath = new DocumentUtils().getFilePath(StandardPath.FONTS +
//                        "/arialbd.ttf");
//                BaseFont bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, false);
//                Font f = new Font(bf);
//
//                System.out.println("Starting the test");
//                //fs = new POIFSFileSystem(new FileInputStream("documents/573857.doc"));
//
//                HWPFDocument doc = new HWPFDocument(fs);
//                WordExtractor we = new WordExtractor(doc);
//
//                OutputStream file = new FileOutputStream(new File(
//                        "documents/test.pdf"));
//                document = new Document();
//                PdfWriter writer = PdfWriter.getInstance(document, file);
//
//                document.open();
//                writer.setPageEmpty(true);
//                document.newPage();
//                writer.setPageEmpty(true);
//
//                String[] paragraphs = we.getParagraphText();
//                for (int i = 0; i < paragraphs.length; i++) {
//                    paragraphs[i] = paragraphs[i].replaceAll("\\cM?\r?\n", "");
//
//                    // add the paragraph to the document
//                    document.add(new Paragraph(paragraphs[i]));
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                // close the document
//                document.close();
//            }
        }
    }