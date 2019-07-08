package Main;

import Main.Options.OptionContainer;
import Main.Parser.BrowseButton;
import Main.Parser.BrowseButtonListener;
import Main.Parser.Parser;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Application extends JFrame {
    public JPanel panel;
    public File file;
    public JTextField textField;
    private Parser parser;
    private final static Color BG_COLOR = new Color(230, 247, 255);

    /**
     * Creates layout and components
     */
    Application() {

        //create the panel
        panel = new JPanel();

        BrowseButton browse = new BrowseButton("Browse");
        BrowseButtonListener bbl = new BrowseButtonListener(this);
        browse.addActionListener(bbl);

        //create and design the text field
        textField = new JTextField("--No File Selected--");
        textField.setForeground(Color.BLUE);

        //create and design the submit button
        JButton submit = new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.blue);
        submit.setBounds(440, 780, 100,40);
        submit.addActionListener(e -> {
            String fname = textField.getText();
            if (file != null) {
                parser = new Parser(file);
                remove(panel);

                //set new BorderLayout because FlowLayout that appear to that frame cannot resolve our needs
                setLayout(new BorderLayout());
                add(new OptionContainer(parser));
                //maximize the size
                //setExtendedState(JFrame.MAXIMIZED_BOTH);

                revalidate();
            } else {
                file = new File(fname);
                if (!file.exists()) {
                    textField.setText("Invalid path chosen");
                    file = null;
                } else {
                    parser = new Parser(file);
                    remove(panel);
                    setLayout(new BorderLayout());
                    add(new OptionContainer(parser));
                    revalidate();
                }
            }
            if (parser != null) {
                parser.parseData();
            } else {
                JOptionPane.showMessageDialog(null, "No file chosen.");
            }
        });

        //image
        ImageIcon icon = new ImageIcon(getClass().getResource("/search.png"), "Search Image");
        JLabel label1 = new JLabel("", icon, JLabel.CENTER);

        //add the components to the panels
        panel.add(textField);
        panel.add(browse);
        panel.add(submit);
        //panel.add(label1);

        setContentPane(label1);
        setLayout(new FlowLayout());
        setSize(600, 600);
        setLocationRelativeTo(null);

        //using our custom color
        setBackground(BG_COLOR);

        //add the panels to the frame
        //add(panel);
        add(panel);
        panel.setSize(400, 250);


        //set the frame to the center of the screen
        setVisible(true);

        setTitle("Power Generation Viewer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    //simple setter
    public void setFile(File file) { this.file = file; }

}