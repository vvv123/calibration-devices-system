package com.softserve.edu.documents;

import com.softserve.edu.documents.action.AdjustLines;
import com.softserve.edu.documents.action.InsertText;
import com.softserve.edu.documents.action.LoadTemplate;
import com.softserve.edu.documents.action.Normalize;
import com.softserve.edu.documents.chain.ActionChain;
import com.softserve.edu.documents.chain.ActionList;
import com.softserve.edu.documents.options.FileParameters;
import org.apache.commons.vfs2.FileObject;

public class FileFactory {
    public static FileObject buildFile(FileParameters fileParameters) {
        ActionList actions = new ActionList();
        actions.add(LoadTemplate.getInstance());
        actions.add(new Normalize());
        actions.add(new InsertText());
        actions.add(new AdjustLines());

        return ActionChain.processChain(fileParameters, actions);
    }
}
