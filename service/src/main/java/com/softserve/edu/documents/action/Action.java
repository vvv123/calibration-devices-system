package com.softserve.edu.documents.action;

import com.softserve.edu.documents.parameter.FileParameters;
import org.apache.commons.vfs2.FileObject;

import java.io.IOException;

public interface Action {
    FileObject process(FileObject fileObject, FileParameters fileParameters) throws IOException;
}
