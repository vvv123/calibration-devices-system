package com.softserve.edu.documentGenerator;

/**
 * class for testing purposes, not for production
 */
public class Main {

    public static void main(String[] args) {
        FormFiller formFiller = new FormFiller();
        formFiller.replaceTokenAndSave("$NAME", "Олег", "documentsTemplates/form.doc");
    }

}
