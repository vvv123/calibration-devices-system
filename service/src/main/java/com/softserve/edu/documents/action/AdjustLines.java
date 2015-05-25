package com.softserve.edu.documents.action;

import com.lowagie.text.Chunk;
import com.lowagie.text.Font;
import com.softserve.edu.documents.document.Document;
import com.softserve.edu.documents.options.DocumentFont;
import com.softserve.edu.documents.options.DocumentFontFactory;
import com.softserve.edu.documents.options.FileParameters;
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

public class AdjustLines implements Action {
    @Override
    public void process(FileObject fileObject, FileParameters fileParameters) throws IOException {
        InputStream inputStream = fileObject.getContent().getInputStream(); // FileInputStream?
        XWPFDocument templateDocument = new XWPFDocument(inputStream);
        inputStream.close();

        XWPFDocument newDocument = new XWPFDocument(templateDocument.getPackage());

        List<XWPFParagraph> paragraphs = newDocument.getParagraphs();

        double width = getWidth2(newDocument);
        System.out.println("wdith: " + SizeUnitConverter.convert(width, SizeUnit.TWIP, SizeUnit.PT));

        paragraphs.
                stream().
                filter(paragraph -> !paragraph.getParagraphText().isEmpty()).
                forEach(this::setCorrectText);

        newDocument.write(fileObject.getContent().getOutputStream());
    }

    /**
     * Set the correct data for each run in the supplied paragraph
     *
     * @param sourceParagraph paragraph to copy runs from
     */
    private void setCorrectText(XWPFParagraph sourceParagraph) {
        int position = 0;

        List<XWPFRun> runs = sourceParagraph.getRuns();

        String paragraphText = sourceParagraph.getParagraphText();
        float paragraphWidthResult = 0;
        float paragraphWidthSource = 0;

        for (int i = 0; i < runs.size(); i++) {
            XWPFRun sourceRun = runs.get(i);
            String textInRun = sourceRun.getText(position);

            if (textInRun == null || textInRun.isEmpty()) {
                continue;
            }

            try {
                Font font = DocumentFontFactory.buildFont(DocumentFont.FREE_SERIF, sourceRun.getFontSize());
                Chunk chunk = new Chunk(textInRun, font);
                paragraphWidthSource += chunk.getWidthPoint();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

            if (textInRun.contains("$")) {
                textInRun = textInRun.replaceAll("$", "123");
            }

            try {
                Font font = DocumentFontFactory.buildFont(DocumentFont.FREE_SERIF, sourceRun.getFontSize());
                Chunk chunk = new Chunk(textInRun, font);
                paragraphWidthResult += chunk.getWidthPoint();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

            sourceRun.setText(textInRun, 0);
        }

        System.out.println(paragraphWidthSource + ": " + paragraphText);
        System.out.println(paragraphWidthResult + ": " + sourceParagraph.getParagraphText());
    }

    public double getWidth(XWPFDocument doc) {
        CTSectPr sectPr = doc.getDocument().getBody().getSectPr();
        if (sectPr == null) return -1;
        CTPageSz pageSize = sectPr.getPgSz();
        if (pageSize == null) return -1;

        CTPageMar pgMar = sectPr.getPgMar();
        double i = pgMar.xgetLeft().getBigDecimalValue().doubleValue() + pgMar.xgetRight().getBigDecimalValue().doubleValue();

        double width_cm = Math.round(pageSize.getW().doubleValue()/20d/72d*2.54d*100d)/100d;
        double height_cm = Math.round(pageSize.getH().doubleValue()/20d/72d*2.54d*100d)/100d;

        // System.out.println("width: "+width_cm+" cm; height: "+height_cm+" cm");
        return pageSize.getW().doubleValue();
    }

    public double getWidth2(XWPFDocument document) {
        CTBody body = document.getDocument().getBody();
        CTSectPr docSp = body.getSectPr();

        //CTPageSz pageSize = docSp.getPgSz();
        CTSectPr sectPr = document.getDocument().getBody().getSectPr();
        if (sectPr == null) return -1;
        CTPageSz pageSize = sectPr.getPgSz();

        CTPageMar margin = docSp.getPgMar();

        BigInteger pageWidth = pageSize.getW();
        pageWidth = pageWidth.add(BigInteger.ONE);
        BigInteger totalMargins = margin.getLeft().add(margin.getRight());
        BigInteger contentWidth = pageWidth.subtract(totalMargins);

        // XWPFTable table = document.createTable(totalRows, totalColumns);

        return contentWidth.doubleValue();
    }
}
