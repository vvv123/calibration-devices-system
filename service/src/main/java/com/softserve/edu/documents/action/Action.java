package com.softserve.edu.documents.action;

import com.softserve.edu.documents.options.FileParameters;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;

import java.io.IOException;

public interface Action {
    FileObject process(FileObject fileObject, FileParameters fileParameters) throws IOException;
}
