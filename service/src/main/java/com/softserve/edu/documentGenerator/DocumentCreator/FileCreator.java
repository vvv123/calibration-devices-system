package com.softserve.edu.documentGenerator.DocumentCreator;

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
    File createFile() throws IOException;
}
