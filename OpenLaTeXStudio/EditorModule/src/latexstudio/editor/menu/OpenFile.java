/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latexstudio.editor.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import latexstudio.editor.EditorTopComponent;
import latexstudio.editor.files.FileChooserService;
import latexstudio.editor.files.FileService;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

@ActionID(
        category = "File",
        id = "latexstudio.editor.OpenFile"
)
@ActionRegistration(
        displayName = "#CTL_OpenFile"
)
@ActionReference(path = "Menu/File", position = 1200)
@Messages("CTL_OpenFile=Open file")
public final class OpenFile implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        TopComponent tc = WindowManager.getDefault().findTopComponent("EditorTopComponent");
        EditorTopComponent etc = (EditorTopComponent) tc;
        
        File file = FileChooserService.getSelectedFile("tex", "TeX files");
        if (file != null) {
            String content = FileService.readFromFile(file.getAbsolutePath());
            etc.setEditorContent(content);
        }
    }
}
