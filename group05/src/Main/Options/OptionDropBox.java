package Main.Options;

import javax.swing.*;
import java.awt.*;

//creates an interactive dropbox for selecting time bounds
class OptionDropBox<T> extends JComboBox {

    /**
     * @param options an array of values to be shown in the drop box
     * @param title sets the initial value of the dropbox to inform user of what they are selecting in this drop box
     */
    OptionDropBox(T[] options, String title) {
        super(options);
        setPrototypeDisplayValue(title);
        setFont(new Font("Serif", Font.PLAIN, 12));
        setVisible(true);
    }
}
