package com.softserve.edu.documents.action;

import com.softserve.edu.documents.options.FileParameters;
import org.apache.commons.vfs2.FileObject;

public class FillDocumentInfo implements Action {
    @Override
    public void process(FileObject fileObject, FileParameters fileParameters) {

    }

    private static final FillDocumentInfo instance = new FillDocumentInfo();

    public static FillDocumentInfo getInstance() {
        return instance;
    }
}
