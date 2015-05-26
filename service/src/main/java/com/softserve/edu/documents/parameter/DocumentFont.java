package com.softserve.edu.documents.parameter;

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

    @Override
    public String toString() {
        return fontName + ".ttf";
    }
}
