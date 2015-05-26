package com.softserve.edu.documents;

import com.softserve.edu.documents.action.*;
import com.softserve.edu.documents.chain.ActionChain;
import com.softserve.edu.documents.parameter.FileParameters;
import org.apache.commons.vfs2.FileObject;

import java.util.ArrayList;
import java.util.List;

public class FileFactory {
    public static FileObject buildFile(FileParameters fileParameters) {
        List<Action> actions = new ArrayList<>();

        switch (fileParameters.getDocumentFormat()) {
            case DOCX:
                actions.add(LoadTemplate.getInstance());
                actions.add(new Normalize());
                actions.add(new InsertText());
                actions.add(new AdjustLines());
                actions.add(new Cleanse());
                break;
            case PDF:
                actions.add(LoadTemplate.getInstance());
                actions.add(new Normalize());
                actions.add(new InsertText());
                actions.add(new AdjustLines());
                actions.add(new Cleanse());
                actions.add(new TransformToPdf());
                break;
        }

        return ActionChain.processChain(fileParameters, actions);
    }
}
