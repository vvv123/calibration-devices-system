package com.softserve.edu.documents.utils;

import com.softserve.edu.documents.parameter.FileSystem;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;

public class FileLocator {
    public static FileObject getFile(FileSystem fileSystem, String fileName) {
        FileObject fileToReturn = null;

        String filePath = fileSystem.name().toLowerCase() + "://" + fileName;

        try {
            FileSystemManager manager = VFS.getManager();
            fileToReturn = manager.resolveFile(filePath);

            if (!fileToReturn.exists())
                fileToReturn.createFile();
        } catch (FileSystemException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        return fileToReturn;
    }
}