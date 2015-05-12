package com.softserve.edu.documentGenerator.converter;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import com.softserve.edu.documentGenerator.utils.DocumentUtils;
import com.softserve.edu.documentGenerator.utils.StandardPath;
import fr.opensagres.xdocreport.converter.*;
import fr.opensagres.xdocreport.core.document.DocumentKind;
import fr.opensagres.xdocreport.itext.extension.font.IFontProvider;
import fr.opensagres.xdocreport.itext.extension.font.ITextFontRegistry;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.persistence.Convert;
import java.awt.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Convert Doc document into Pdf document
 */
public class DocToPdf4 implements Converter {
    @Override
    public void convertFile(File readyTemplate, File outputFileName) {
        Options options = Options.getFrom(DocumentKind.DOCX).to(ConverterTypeTo.PDF);
        IConverter converter = ConverterRegistry.getRegistry().getConverter(options);

        InputStream in= null;
        try {
            in = new FileInputStream(new File("documents/017905.docx"));
            OutputStream out = new FileOutputStream(new File("documents/test.pdf"));
            converter.convert(in, out, options);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XDocConverterException e) {
            e.printStackTrace();
        }
    }
}