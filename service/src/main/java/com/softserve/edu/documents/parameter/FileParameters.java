package com.softserve.edu.documents.parameter;

import com.softserve.edu.documents.document.Document;

public class FileParameters {
    private Document document;
    private DocumentType documentType;
    private DocumentFormat documentFormat;
    private FileSystem fileSystem;
    private String fileName;

    public FileParameters(Document document, DocumentType documentType, DocumentFormat documentFormat) {
        this.document = document;
        this.documentType = documentType;
        this.documentFormat = documentFormat;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public DocumentFormat getDocumentFormat() {
        return documentFormat;
    }

    public void setDocumentFormat(DocumentFormat documentFormat) {
        this.documentFormat = documentFormat;
    }

    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
