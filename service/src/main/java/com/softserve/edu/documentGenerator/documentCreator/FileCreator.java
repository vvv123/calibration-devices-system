package com.softserve.edu.documentGenerator.documentCreator;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * Interface for all document creators
 */
public interface FileCreator {
    /**
     * Creates a document.
     *
     * @return created file
     * @throws IOException in case of file system error
     */
    ByteArrayOutputStream createFile() throws IOException;
}
