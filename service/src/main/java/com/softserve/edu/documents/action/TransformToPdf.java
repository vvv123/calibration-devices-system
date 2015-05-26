package com.softserve.edu.documents.action;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import com.softserve.edu.documents.parameter.DocumentFont;
import com.softserve.edu.documents.parameter.DocumentFontFactory;
import com.softserve.edu.documents.parameter.FileParameters;
import com.softserve.edu.documents.utils.FileLocator;
import org.apache.commons.vfs2.FileObject;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TransformToPdf implements Action {
    @Override
    public FileObject process(FileObject fileObject, FileParameters fileParameters) throws IOException {
        FileObject filePdf = FileLocator.getFile(fileParameters.getFileSystem(),
                fileParameters.getFileName() + "_pdf");

        createPdfFile(fileObject, filePdf);

        return filePdf;
    }

    public void createPdfFile(FileObject fileObject, FileObject outputFile) throws IOException {
        Document resultPdfDocument;
        PdfWriter writer;

        resultPdfDocument = new Document();

        try {
            OutputStream outputStream = outputFile.getContent().getOutputStream();
            writer = PdfWriter.getInstance(resultPdfDocument, outputStream);
        } catch (DocumentException e) {
            resultPdfDocument.close();
            throw new IOException("The output file couldn't be reached.");
        }

        resultPdfDocument.open();
        writer.setPageEmpty(true);
        resultPdfDocument.newPage();
        writer.setPageEmpty(true);

        InputStream inputStream = fileObject.getContent().getInputStream();
        XWPFDocument doc = new XWPFDocument(inputStream);
        inputStream.close();


        writeDocument(doc, resultPdfDocument);

        resultPdfDocument.close();
    }

    /**
     * Writes pdf document using paragraphs from a source docx document.
     *
     * @param sourceDocxDocument source document
     * @param resultPdfDocument  target document
     * @throws IOException
     */
    private void writeDocument(XWPFDocument sourceDocxDocument, Document resultPdfDocument) throws IOException {
        java.util.List<XWPFParagraph> docxParagraphs = sourceDocxDocument.getParagraphs();
        Paragraph pdfParagraph;

        try {
            for (XWPFParagraph docxParagraph : docxParagraphs) {
                pdfParagraph = createPdfParagraph(docxParagraph);
                resultPdfDocument.add(pdfParagraph);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException("The output file couldn't be reached.");
        }
    }

    private Paragraph createParagraph(String text, int fontStyle, int size, DocumentFont documentFont,
                                     int alignment) throws IOException {
        Font font = DocumentFontFactory.buildFont(documentFont, size, fontStyle);

        Paragraph paragraph = new Paragraph(text, font);
        paragraph.setAlignment(alignment);

        return paragraph;
    }

    /**
     * Creates a pdf paragraph.
     *
     * @param docxParagraph MSDocx paragraph with text for the new pdf paragraph
     * @return created header paragraph
     * @throws IOException if font file is invalid
     */
    public Paragraph createPdfParagraph(XWPFParagraph docxParagraph) throws IOException, InvalidFormatException {
        String text = docxParagraph.getText();

        XWPFRun run = docxParagraph.getRuns().get(0);

        int fontSize = run.getFontSize();
        int align = docxParagraph.getAlignment() == ParagraphAlignment.CENTER ? Element.ALIGN_CENTER : Element.ALIGN_LEFT;

        int style = !run.isBold() ? 0 : Font.BOLD;
        style = !run.isItalic() ? style : Font.ITALIC;

        return createParagraph(text, style, fontSize, DocumentFont.FREE_SERIF, align);
    }
}
