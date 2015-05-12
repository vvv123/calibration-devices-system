package com.softserve.edu.documentGenerator.converter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;


import com.softserve.edu.documentGenerator.utils.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.DocumentUtils;
import com.softserve.edu.documentGenerator.utils.PathBuilder;
import com.softserve.edu.documentGenerator.utils.StandardPath;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

/**
 * Convert Doc document into Pdf document
 */
public class DocToPdf implements Converter {

    /**
     * {inherit}
     */
    @Override
    public File getConvertedFile(File readyTemplate, String outputFileName) {
        POIFSFileSystem fs = null;
        Document document = new Document();
        File file = null;

        try {
            System.out.println("Starting the test");
            fs = new POIFSFileSystem(new FileInputStream(readyTemplate));

            HWPFDocument doc = new HWPFDocument(fs);
            WordExtractor we = new WordExtractor(doc);

            file = new File(outputFileName);
            OutputStream fileStream = new FileOutputStream(file);

            PdfWriter writer = PdfWriter.getInstance(document, fileStream);

            Range range = doc.getRange();
            document.open();
            writer.setPageEmpty(true);
            document.newPage();
            writer.setPageEmpty(true);

            String[] paragraphs = we.getParagraphText();
            for (int i = 0; i < paragraphs.length; i++) {

                org.apache.poi.hwpf.usermodel.Paragraph pr = range.getParagraph(i);
                // CharacterRun run = pr.getCharacterRun(i);
                // run.setBold(true);
                // run.setCapitalized(true);
                // run.setItalic(true);
                paragraphs[i] = paragraphs[i].replaceAll("\\cM?\r?\n", " ");
                System.out.println("Length:" + paragraphs[i].length());
                String fontPath = new DocumentUtils().getFilePath(StandardPath.FONTS +
                        "/arialbd.ttf");
                BaseFont bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, false);
                Font f = new Font(bf);
                System.out.println("Paragraph" + i + ": " + paragraphs[i].toString());

                // add the paragraph to the document
                document.add(new Paragraph(paragraphs[i], f));
            }

            System.out.println("BaseDocument testing completed");
        } catch (Exception e) {
            System.out.println("Exception during test");
            e.printStackTrace();
        } finally {
            // close the document
            document.close();
        }

        return file;
    }
}