package com.softserve.edu.documentGenerator.converter;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import com.softserve.edu.documentGenerator.utils.DocumentUtils;
import com.softserve.edu.documentGenerator.utils.StandardPath;
import fr.opensagres.xdocreport.itext.extension.IPdfWriterConfiguration;
import fr.opensagres.xdocreport.itext.extension.font.IFontProvider;
import fr.opensagres.xdocreport.itext.extension.font.ITextFontRegistry;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.awt.Color;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.core.XWPFConverterException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.Test;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;

import javax.persistence.Convert;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Convert Doc document into Pdf document
 */
public class DocToPdf2 implements Converter {
    @Override
    public void convertFile(File readyTemplate, File outputFileName) {
            try {
                InputStream doc = new FileInputStream(readyTemplate);
                XWPFDocument document = new XWPFDocument(doc);
                PdfOptions options = PdfOptions.create();

                options.setConfiguration( new IPdfWriterConfiguration()
                {
                    public void configure( PdfWriter writer )
                    {
                        //writer.setPDFXConformance( PdfWriter.PageLayoutOneColumn );
                    }
                });

                options.fontProvider( new IFontProvider()
                {
                    public Font getFont( String familyName, String encoding, float size, int style, Color color) {
                        try
                        {
                            String fontPath = new DocumentUtils().getFilePath(StandardPath.FONTS +
                                    "/DejaVuSans.ttf");
                            BaseFont bf = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, false);
                            Font f = new Font(bf);

                            if ( familyName != null )
                                f.setFamily( familyName );
                            return f;
                        }
                        catch ( Throwable e )
                        {
                            e.printStackTrace();
                            // An error occurs, use the default font provider.
                            return ITextFontRegistry.getRegistry().getFont( familyName, encoding, size, style, color );
                        }
                    }
                } );

                OutputStream out = new FileOutputStream(outputFileName);
                PdfConverter.getInstance().convert(document, out, options);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Convert.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}