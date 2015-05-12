package com.softserve.edu.documentGenerator.converter;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.softserve.edu.documentGenerator.utils.DocumentUtils;
import com.softserve.edu.documentGenerator.utils.StandardPath;
import fr.opensagres.xdocreport.converter.*;
import fr.opensagres.xdocreport.core.document.DocumentKind;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.List;

/**
 * Convert Doc document into Pdf document
 */
public class DocToPdfXWPF implements Converter {
    @Override
    public void convertFile(File readyTemplate, File outputFileName) {
        Document document = new Document();

        try {
            InputStream is = new FileInputStream(readyTemplate);

            XWPFDocument doc = new XWPFDocument(is);

            XWPFWordExtractor we = new XWPFWordExtractor(doc);

            OutputStream fileStream = new FileOutputStream(outputFileName);

            PdfWriter writer = PdfWriter.getInstance(document, fileStream);
            document.open();
            writer.setPageEmpty(true);
            document.newPage();
            writer.setPageEmpty(true);

            List<XWPFParagraph> paragraphs = doc.getParagraphs();

            String boldFontPath = new DocumentUtils().getFilePath(StandardPath.FONTS + "/arialbd.ttf");
            String standardFontPath = new DocumentUtils().getFilePath(StandardPath.FONTS + "/FreeSerif.ttf");
            String italicFontPath = new DocumentUtils().getFilePath(StandardPath.FONTS + "/DejaVuSerif-Italic.ttf");

            final int defaultSize = 12;
            final int headerSize = 14;
            final int smallSize = 7;

            BaseFont bf = BaseFont.createFont(boldFontPath, BaseFont.IDENTITY_H, false);
            Font boldFont = new Font(bf, defaultSize);

            BaseFont bf2 = BaseFont.createFont(standardFontPath, BaseFont.IDENTITY_H, false);
            Font standardFont = new Font(bf2, defaultSize);

            BaseFont bf3 = BaseFont.createFont(italicFontPath, BaseFont.IDENTITY_H, false);
            Font italicFont = new Font(bf3, 7f, Font.ITALIC);

            Font undersoreFont = new Font(bf2, defaultSize, Font.UNDERLINE);

            for (int i = 0; i < paragraphs.size(); i++) {
                XWPFParagraph paragraph = paragraphs.get(i);

                Paragraph paragraph1 = null;

                if (paragraph.getAlignment() == ParagraphAlignment.CENTER) {
                    paragraph1 = new Paragraph(paragraph.getText(), boldFont);

                    for (XWPFRun xwpfRun : paragraph.getRuns()) {
                        if (xwpfRun.isItalic()) {
                            paragraph1 = new Paragraph(paragraph.getText(), italicFont);
                        }
                    }

                    paragraph1.setAlignment("CENTER");

                } else if (paragraph.getText().contains("ДСТУ")) {
                    paragraph1 = new Paragraph(paragraph.getText(), undersoreFont);
                } else if (paragraph.getText().contains("Чинне до")) {
                    paragraph1 = new Paragraph(paragraph.getText(), standardFont);
                    //paragraph1.setAlignment("RIGHT");
                } else {
                    paragraph1 = new Paragraph(paragraph.getText(), standardFont);
                    paragraph1.setKeepTogether(true);
                }

                document.add(paragraph1);
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