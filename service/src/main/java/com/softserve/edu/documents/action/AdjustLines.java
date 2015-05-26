package com.softserve.edu.documents.action;

import com.lowagie.text.Chunk;
import com.lowagie.text.Font;
import com.softserve.edu.documents.parameter.DocumentFont;
import com.softserve.edu.documents.parameter.DocumentFontFactory;
import com.softserve.edu.documents.parameter.FileParameters;
import com.softserve.edu.documents.size.SizeUnit;
import com.softserve.edu.documents.size.SizeUnitConverter;
import org.apache.commons.vfs2.FileObject;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageSz;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class AdjustLines implements Action {
    @Override
    public FileObject process(FileObject fileObject, FileParameters fileParameters) throws IOException {
        InputStream inputStream = fileObject.getContent().getInputStream(); // FileInputStream?
        XWPFDocument templateDocument = new XWPFDocument(inputStream);
        inputStream.close();

        XWPFDocument newDocument = new XWPFDocument(templateDocument.getPackage());

        List<XWPFParagraph> paragraphs = newDocument.getParagraphs();

        double contentWidth = getContentWidth(newDocument);
        contentWidth = SizeUnitConverter.convert(contentWidth, SizeUnit.TWIP, SizeUnit.PT);
        System.out.println("wdith: " + contentWidth);

        List<XWPFParagraph> paragraphList = paragraphs.
                stream().
                filter(paragraph -> !paragraph.getParagraphText().isEmpty()).
                collect(Collectors.toList());

        for (XWPFParagraph paragraph : paragraphList) {
            setCorrectText(paragraph, contentWidth);
        }

        newDocument.write(fileObject.getContent().getOutputStream());

        return fileObject;
    }

    /**
     * Set the correct data for each run in the supplied paragraph
     *
     * @param sourceParagraph paragraph to copy runs from
     */
    private void setCorrectText(XWPFParagraph sourceParagraph, double contentWidth) throws IOException {
        int position = 0;

        List<XWPFRun> runs = sourceParagraph.getRuns();
        double paragraphWidthSource = 0;

        for (int i = 0; i < runs.size(); i++) {
            XWPFRun sourceRun = runs.get(i);
            String textInRun = sourceRun.getText(position);

            if (textInRun == null || textInRun.isEmpty()) {
                continue;
            }

            Font font = DocumentFontFactory.buildFont(DocumentFont.FREE_SERIF, sourceRun.getFontSize());

            int indexOfRight = textInRun.lastIndexOf("#");

            if (indexOfRight != -1) {
                textInRun = align(new StringBuilder(textInRun), font, paragraphWidthSource, contentWidth);
            }

            sourceRun.setText(textInRun, position);
        }
    }

    private String align(StringBuilder textInRun, Font font, double paragraphWidth, double contentWidth) {
        paragraphWidth = getStringWidth(textInRun.toString(), font);
        int index = textInRun.lastIndexOf("#");

        while ((int)paragraphWidth < (int)contentWidth) {
            textInRun.insert(index, ' ');
            paragraphWidth = getStringWidth(textInRun.toString(), font) + 10;
        }

        return textInRun.toString();
    }

    public double getStringWidth(String string, Font font) {
        Chunk chunk = new Chunk(string, font);
        return chunk.getWidthPoint();
    }

    public double getContentWidth(XWPFDocument document) {
        CTBody body = document.getDocument().getBody();
        CTSectPr docSp = body.getSectPr();

        CTSectPr sectPr = document.getDocument().getBody().getSectPr();
        if (sectPr == null) return -1;
        CTPageSz pageSize = sectPr.getPgSz();

        CTPageMar margin = docSp.getPgMar();

        BigInteger pageWidth = pageSize.getW();
        pageWidth = pageWidth.add(BigInteger.ONE);
        BigInteger totalMargins = margin.getLeft().add(margin.getRight());
        BigInteger contentWidth = pageWidth.subtract(totalMargins);

        return contentWidth.doubleValue();
    }
}
