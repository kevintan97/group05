package Main.Parser;

import Main.Application;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Simple class that activates the JFileChooser and sets the parent Application's file field and JTextField as appropriate
public class BrowseButtonListener implements ActionListener {

    private Application parent; //parent Application instance.

    public BrowseButtonListener(Application parent) {
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(parent.panel);

        parent.setFile(jfc.getSelectedFile());

        parent.textField.setText(parent.file.toString());
    }
}
