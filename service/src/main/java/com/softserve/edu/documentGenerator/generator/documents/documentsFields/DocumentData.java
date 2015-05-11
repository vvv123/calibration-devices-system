package com.softserve.edu.documentGenerator.generator.documents.documentsFields;

import java.util.Date;

/**
 * Created by oleg on 5/11/15.
 */
public class DocumentData {
    private Integer documentNumber;  // no info in DB
    private Date documentDate;

    public Integer getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(Integer documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(Date documentDate) {
        this.documentDate = documentDate;
    }
}
