package com.softserve.edu.documentGenerator.converter;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.softserve.edu.documentGenerator.utils.DocumentUtils;
import com.softserve.edu.documentGenerator.utils.StandardPath;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import javax.persistence.Convert;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Convert Doc document into Pdf document
 */
public class DocToPdf implements Converter {

    /**
     * {inherit}
     */
    @Override
    public void convertFile(File readyTemplate, File outputFileName) {
        POIFSFileSystem fs = null;
        Document document = new Document();

        try {
            fs = new POIFSFileSystem(new FileInputStream(readyTemplate));

            HWPFDocument doc = new HWPFDocument(fs);
            WordExtractor we = new WordExtractor(doc);

            OutputStream fileStream = new FileOutputStream(outputFileName);

            PdfWriter writer = PdfWriter.getInstance(document, fileStream);

            Range range = doc.getRange();
            document.open();
            writer.setPageEmpty(true);
            document.newPage();
            writer.setPageEmpty(true);

            String[] paragraphs = we.getParagraphText();
            for (int i = 0; i < paragraphs.length; i++) {

                org.apache.poi.hwpf.usermodel.Paragraph pr = range.getParagraph(i);
                paragraphs[i] = paragraphs[i].replaceAll("\\cM?\r?\n", " ");
                String fontPath = new DocumentUtils().getFilePath(StandardPath.FONTS +
                        "/arialbd.ttf");
                BaseFont bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, false);
                Font f = new Font(bf);

                // add the paragraph to the document
                document.add(new Paragraph(paragraphs[i], f));
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            document.close();
        }
    }
}