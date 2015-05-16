package com.softserve.edu.document.generator.converter;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;
import java.util.List;

/**
 * Converts a Docx document into a Pdf document
 */
public class DocxToPdf implements Converter {
    private int defaultSize = 12;
    private int headerSize = 14;
    private int descriptionSize = 7;

    /**
     * Default constructor.
     * Default values will be used for font sizes.
     */
    public DocxToPdf() {
    }

    /**
     * Creates a converter with the specified sizes
     *
     * @param defaultSize     used for simple text
     * @param headerSize      used for headers
     * @param descriptionSize used for small description text fields
     */
    public DocxToPdf(int defaultSize, int headerSize, int descriptionSize) {
        this.defaultSize = defaultSize;
        this.headerSize = headerSize;
        this.descriptionSize = descriptionSize;
    }

    /**
     * Creates a base font that can be used for creation of a font
     *
     * @param font to create
     * @return created font
     * @throws IOException if font is invalid or the font's file couldn't be found
     */
    private BaseFont createBaseFont(DocumentFont font) throws IOException {
        String path = font.getFontFile().getPath();

        BaseFont bf = null;

        try {
            bf = BaseFont.createFont(path, BaseFont.IDENTITY_H, false);
        } catch (DocumentException exception) {
            exception.printStackTrace();
            throw new IOException("couldn't read font");
        }

        return bf;
    }

    /**
     * Creates a font
     *
     * @param font to create
     * @param size needed font size
     * @return created font
     * @throws IOException if font is invalid or the font's file couldn't be found
     */
    private Font createFont(DocumentFont font, int size) throws IOException {
        BaseFont bf = createBaseFont(font);
        return new Font(bf, size);
    }

    /**
     * Creates a font
     *
     * @param font  to create
     * @param size  needed font size
     * @param style needed font style
     * @return created font
     * @throws IOException if font is invalid or the font's file couldn't be found
     */
    private Font createFont(DocumentFont font, int size, int style) throws IOException {
        BaseFont bf = createBaseFont(font);
        return new Font(bf, size, style);
    }

    /**
     * Creates a paragraph that represents a header.
     *
     * @param docxParagraph MSDocx paragraph with text for header
     * @return created header paragraph
     * @throws IOException if font file is invalid
     */
    private Paragraph createHeaderParagraph(XWPFParagraph docxParagraph) throws IOException {
        Font boldFont = createFont(DocumentFont.ARIAL_BD, headerSize);
        Paragraph pdfParagraph = new Paragraph(docxParagraph.getText(), boldFont);

        for (XWPFRun xwpfRun : docxParagraph.getRuns()) {
            if (xwpfRun.isItalic()) {
                Font italicFont = createFont(DocumentFont.DEJA_VU_SERIF_ITALIC, descriptionSize, Font.ITALIC);
                pdfParagraph = new Paragraph(docxParagraph.getText(), italicFont);
            }
        }

        pdfParagraph.setAlignment(Element.ALIGN_CENTER);

        return pdfParagraph;
    }

    /**
     * Creates a pdf paragraph.
     *
     * @param docxParagraph MSDocx paragraph with text for the new pdf paragraph
     * @return created header paragraph
     * @throws IOException if font file is invalid
     */
    public Paragraph createPdfParagraph(XWPFParagraph docxParagraph) throws IOException {
        Font standardFont = createFont(DocumentFont.FREE_SERIF, defaultSize);

        if (docxParagraph.getAlignment() == ParagraphAlignment.CENTER) {
            return createHeaderParagraph(docxParagraph);
        }

        Paragraph pdfParagraph = new Paragraph(docxParagraph.getText(), standardFont);

        pdfParagraph.setKeepTogether(true);

        return pdfParagraph;
    }

    /**
     * {inherit}
     */
    @Override
    public void convertFile(File sourceFile, File outputFile) throws IOException {
        InputStream is = null;
        OutputStream fileStream = null;
        XWPFDocument doc = null;

        is = new FileInputStream(sourceFile);

        try {
            fileStream = new FileOutputStream(outputFile);
        } catch (IOException e) {
            is.close();
            throw e;
        }

        try {
            doc = new XWPFDocument(is);
        } catch (IOException e) {
            is.close();
            fileStream.close();
            throw e;
        }

        Document resultPdfDocument = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(resultPdfDocument, fileStream);
            resultPdfDocument.open();
            writer.setPageEmpty(true);
            resultPdfDocument.newPage();
            writer.setPageEmpty(true);
        } catch (DocumentException e) {
            is.close();
            fileStream.close();
            resultPdfDocument.close();

            throw new IOException("The output file couldn't be reached.");
        }

        try {
            writeDocument(doc, resultPdfDocument);
        } finally {
            resultPdfDocument.close();

            fileStream.close();
            is.close();
        }
    }

    /**
     * Writes pdf document using paragraphs from a source docx document.
     *
     * @param sourceDocxDocument source document
     * @param resultPdfDocument  target document
     * @throws IOException
     */
    private void writeDocument(XWPFDocument sourceDocxDocument, Document resultPdfDocument) throws IOException {
        List<XWPFParagraph> docxParagraphs = sourceDocxDocument.getParagraphs();
        Paragraph pdfParagraph;

        try {
            for (XWPFParagraph docxParagraph : docxParagraphs) {
                pdfParagraph = createPdfParagraph(docxParagraph);
                resultPdfDocument.add(pdfParagraph);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new IOException("The output file couldn't be reached.");
        }
    }

    public int getDefaultSize() {
        return defaultSize;
    }

    public void setDefaultSize(int defaultSize) {
        this.defaultSize = defaultSize;
    }

    public int getHeaderSize() {
        return headerSize;
    }

    public void setHeaderSize(int headerSize) {
        this.headerSize = headerSize;
    }

    public int getDescriptionSize() {
        return descriptionSize;
    }

    public void setDescriptionSize(int descriptionSize) {
        this.descriptionSize = descriptionSize;
    }
}