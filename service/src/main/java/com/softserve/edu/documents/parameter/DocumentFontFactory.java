package com.softserve.edu.documents.parameter;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;
import com.softserve.edu.documents.utils.FileLocator;
import org.apache.commons.vfs2.FileObject;

import java.io.IOException;

public class DocumentFontFactory {
    private DocumentFontFactory() {
    }

    public static Font buildFont(DocumentFont documentFont) throws IOException {
        return createFont(documentFont);
    }

    public static Font buildFont(DocumentFont documentFont, int size) throws IOException {
        return createFont(documentFont, size);
    }

    public static Font buildFont(DocumentFont documentFont, int size, int style) throws IOException {
        return createFont(documentFont, size, style);
    }

    /**
     * Creates a base font that can be used for creation of a font
     *
     * @param font to create
     * @return created font
     * @throws IOException if font is invalid or the font's file couldn't be found
     */
    static private BaseFont createBaseFont(DocumentFont font) throws IOException {
        FileObject file = FileLocator.getFile(FileSystem.RES, StandardPath.FONTS + "/" + font.toString());
        String path = file.getURL().getPath();

        BaseFont bf;

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
     * @return created font
     * @throws IOException if font is invalid or the font's file couldn't be found
     */
    static private Font createFont(DocumentFont font) throws IOException {
        BaseFont bf = createBaseFont(font);
        return new Font(bf);
    }

    /**
     * Creates a font
     *
     * @param font to create
     * @param size needed font size
     * @return created font
     * @throws IOException if font is invalid or the font's file couldn't be found
     */
    static private Font createFont(DocumentFont font, int size) throws IOException {
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
    static private Font createFont(DocumentFont font, int size, int style) throws IOException {
        BaseFont bf = createBaseFont(font);
        return new Font(bf, size, style);
    }
}
