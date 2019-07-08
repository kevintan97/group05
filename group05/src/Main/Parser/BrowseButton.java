package Main.Parser;

import javax.swing.*;
import java.awt.*;

//Creates and formats a Button for the BrowseListener to work with.
public class BrowseButton extends JButton {
    public BrowseButton(String label) {
        super(label);
        setForeground(Color.white);
        setBackground(Color.blue);
    }
}
