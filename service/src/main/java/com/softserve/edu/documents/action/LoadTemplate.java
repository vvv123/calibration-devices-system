package com.softserve.edu.documents.action;

import com.softserve.edu.documents.options.FileParameters;
import com.softserve.edu.entity.user.SystemAdmin;
import org.apache.commons.io.IOUtils;
import org.apache.commons.vfs2.FileObject;

import java.io.*;
import java.nio.charset.Charset;

public class LoadTemplate implements Action {
    @Override
    public void process(FileObject fileObject, FileParameters fileParameters) throws IOException {
        FileObject template = fileParameters.getDocumentType().getTemplate();
        InputStream inputStream = template.getContent().getInputStream();

        //byte[] bytes = IOUtils.toByteArray(inputStream);

        OutputStream outputStream = fileObject.getContent().getOutputStream();
//        outputStream.getColumnsNamesValues(bytes);

        IOUtils.copy(inputStream, outputStream);

        inputStream.close();
        outputStream.close();
    }

    private static final LoadTemplate instance = new LoadTemplate();

    public static LoadTemplate getInstance() {
        return instance;
    }
}
