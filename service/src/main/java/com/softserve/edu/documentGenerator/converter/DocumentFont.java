package com.softserve.edu.documentGenerator.converter;

import com.softserve.edu.documentGenerator.utils.StandardPath;

import java.io.File;

/**
 * Available fonts.
 */
public enum DocumentFont {
    ARIAL_BD("arialbd"),
    DEJA_VU_SANS("DejaVuSans"),
    DEJA_VU_SERIF_ITALIC("DejaVuSerif-Italic"),
    FREE_MONO("FreeMono"),
    FREE_SERIF("FreeSerif");

    private String fontName;

    DocumentFont(String fontName) {
        this.fontName = fontName;
    }

    public File getFontFile() {
        return new File(StandardPath.FONTS + "/" + this.toString());
    }

    @Override
    public String toString() {
        return fontName + ".ttf";
    }
}
