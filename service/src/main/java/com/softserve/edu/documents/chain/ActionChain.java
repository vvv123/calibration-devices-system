package com.softserve.edu.documents.chain;

import com.softserve.edu.documents.action.Action;
import com.softserve.edu.documents.utils.FileLocator;
import com.softserve.edu.documents.parameter.FileParameters;
import org.apache.commons.vfs2.FileObject;

import java.io.IOException;
import java.util.List;

public class ActionChain {
    private ActionChain() {
    }

    public static FileObject processChain(FileParameters fileParameters, List<Action> actionList) {
        org.apache.commons.vfs2.FileObject file = FileLocator.getFile(fileParameters.getFileSystem(),
                fileParameters.getFileName());

        for (Action action : actionList) {
            try {
                file = action.process(file, fileParameters);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        return file;
    }
}
