package com.softserve.edu.documentGenerator.DocumentCreator;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.softserve.edu.documentGenerator.documents.BaseDocument;
import com.softserve.edu.documentGenerator.utils.DocumentFont;
import com.softserve.edu.documentGenerator.utils.DocumentFormat;
import com.softserve.edu.documentGenerator.utils.PathBuilder;
import com.softserve.edu.documentGenerator.utils.StandardPath;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import java.io.*;


public class PdfFileCreator implements FileCreator {
    BaseDocument document;
    private int defaultSize = 12;
    private int headerSize = 14;
    private int descriptionSize = 7;

    /**
     * Constructor.
     *
     * @param document with the data to be used for file generation.
     */
    public PdfFileCreator(BaseDocument document) {
        this.setDocument(document);
    }

    /**
     * Constructor.
     * Creates a converter with the specified sizes.
     *
     * @param defaultSize     size for simple text
     * @param headerSize      size for headers
     * @param descriptionSize size for small description text fields
     */
    public PdfFileCreator(BaseDocument document, int defaultSize, int headerSize, int descriptionSize) {
        this.defaultSize = defaultSize;
        this.headerSize = headerSize;
        this.descriptionSize = descriptionSize;
    }

    /**
     * {inherit}
     */
    @Override
    public File createFile() throws IOException {
        String documentName = document.getDeviceName() + String.valueOf(document.getDeviceManufacturerSerial());
        String outputFileName = PathBuilder.build(StandardPath.DOCUMENTS_GENERATED, documentName, DocumentFormat.PDF);

        File convertedFile = new File(outputFileName);
        File docxDocument = document.getDocumentType().getTemplate();

        try {
            convertFile(docxDocument, convertedFile);
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new RuntimeException(exception);
        }

        return convertedFile;
    }

    /**
     * {inherit}
     */
    public void convertFile(File sourceFile, File outputFile) throws IOException {
        XWPFDocument doc;
        Document resultPdfDocument;
        PdfWriter writer;

        try (InputStream is = new FileInputStream(sourceFile)) {
            try (OutputStream fileStream = new FileOutputStream(outputFile)) {
                doc = new XWPFDocument(is);

                resultPdfDocument = new Document();

                try {
                    writer = PdfWriter.getInstance(resultPdfDocument, fileStream);
                } catch (DocumentException e) {
                    resultPdfDocument.close();
                    throw new IOException("The output file couldn't be reached.");
                }

                resultPdfDocument.open();
                writer.setPageEmpty(true);
                resultPdfDocument.newPage();
                writer.setPageEmpty(true);

                writeDocument(doc, resultPdfDocument);

                resultPdfDocument.close();
            }
        }
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

        String text = docxParagraph.getText();
        com.softserve.edu.documentGenerator.Writer.Writer writer = document.getWriter();
        text = writer.replaceTokens(text);

        for (XWPFRun xwpfRun : docxParagraph.getRuns()) {
            if (xwpfRun.isItalic()) {
                Font italicFont = createFont(DocumentFont.DEJA_VU_SERIF_ITALIC, descriptionSize, Font.ITALIC);
                return new Paragraph(text, italicFont);
            }
        }

        Paragraph pdfParagraph = new Paragraph(text, boldFont);
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
    public Paragraph createPdfParagraph(XWPFParagraph docxParagraph) throws IOException, InvalidFormatException {
        Font standardFont = createFont(DocumentFont.FREE_SERIF, defaultSize);

        if (docxParagraph.getAlignment() == ParagraphAlignment.CENTER) {
            return createHeaderParagraph(docxParagraph);
        }

        String text = docxParagraph.getText();
        com.softserve.edu.documentGenerator.Writer.Writer writer = document.getWriter();
        text = writer.replaceTokens(text);

        Paragraph pdfParagraph = new Paragraph(text, standardFont);

        pdfParagraph.setKeepTogether(true);

        return pdfParagraph;
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

    public BaseDocument getDocument() {
        return document;
    }

    public void setDocument(BaseDocument document) {
        this.document = document;
    }
}
