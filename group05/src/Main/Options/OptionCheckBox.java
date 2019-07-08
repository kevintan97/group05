package Main.Options;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

//OptionCheckBox instances for use in the section of application
//used for working with user selections.

public class OptionCheckBox extends JCheckBox {
    public boolean selected;

    /**
     * @param message - sets the text next to the checkbox.
     */
    OptionCheckBox(String message) {
        super.setText(message);
        setFont(new Font("Serif", Font.PLAIN, 12));
        addItemListener(new CheckBoxListener(this));
        setBorderPaintedFlat(false);
    }

    //simple itemlistener class to work with OptionCheckBoxes.
    class CheckBoxListener implements ItemListener {
        OptionCheckBox ocb;

        CheckBoxListener(OptionCheckBox ocb) {
            this.ocb = ocb;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                ocb.selected = true;
            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                ocb.selected = false;
            }
        }
    }
}
