package com.softserve.edu.documents.action;

import com.softserve.edu.documents.parameter.FileParameters;
import org.apache.commons.io.IOUtils;
import org.apache.commons.vfs2.FileObject;

import java.io.*;

public class LoadTemplate implements Action {
    @Override
    public FileObject process(FileObject fileObject, FileParameters fileParameters) throws IOException {
        FileObject template = fileParameters.getDocumentType().getTemplate();
        InputStream inputStream = template.getContent().getInputStream();

        //byte[] bytes = IOUtils.toByteArray(inputStream);

        OutputStream outputStream = fileObject.getContent().getOutputStream();
//        outputStream.getColumnsNamesValues(bytes);

        IOUtils.copy(inputStream, outputStream);

        inputStream.close();
        outputStream.close();

        return fileObject;
    }

    private static final LoadTemplate instance = new LoadTemplate();

    public static LoadTemplate getInstance() {
        return instance;
    }
}
