package Main.Options;

import Utilities.Constants;
import org.omg.CORBA.BAD_INV_ORDER;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

//creates a panel containing OptionCheckBoxes
class OptionPanel extends JPanel {
    /**
     * @param boxList a list of OptionCheckBoxes
     * @param title the title to be placed at the top within the border
     */
    OptionPanel(List<OptionCheckBox> boxList, String title) {
        setBackground(Constants.BG_COLOR);
        setSize(new Dimension(200, 200));
        setLayout(new GridLayout(0, 1));
        Border border = BorderFactory.createTitledBorder(null, title, TitledBorder.CENTER, TitledBorder.TOP, Constants.BORDER_FONT, Color.black);

        setBorder(border);
        for (OptionCheckBox ocb : boxList) {
            add(ocb);
        }

        setVisible(true);
    }
}
