package com.softserve.edu.documents.parameter;

import com.softserve.edu.documents.utils.FileLocator;
import org.apache.commons.vfs2.FileObject;

/**
 * Types of documents supported by the application.
 */
public enum DocumentType {
    VERIFICATION_CERTIFICATE,
    UNFITNESS_CERTIFICATE;

    /**
     * @return the template's name with format
     */
    @Override
    public String toString() {
        return name().toLowerCase() + ".docx";
    }

    /**
     * @return the template's file.
     */
    public FileObject getTemplate() {
        return FileLocator.getFile(FileSystem.RES, StandardPath.DOCUMENTS_TEMPLATES + "/" + this.toString());
    }

}