package com.softserve.edu.documents.action;

import com.softserve.edu.documents.options.FileParameters;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;

import java.io.IOException;

/**
 * Created by oleg on 22.05.15.
 */
public interface Action {
    void process(FileObject fileObject, FileParameters fileParameters) throws IOException;
}
