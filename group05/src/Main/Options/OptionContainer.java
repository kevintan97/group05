package Main.Options;

import Main.Graphs.Data;
import Main.Graphs.GraphGenerator;
import Main.Parser.Parser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static Utilities.Constants.*;
import static Utilities.Constants.YEARS;

//creates a panel to replace the panel within the initial Application.java
// instance once a file has been successfully parsed
public class OptionContainer extends JPanel {

    Parser parser;
    public OptionCheckBox bar, line, demand, frequency, solar, ocgt, ccgt, wind, hydro, pumped, coal, oil, nuclear, frenchICT, irishICT, dutchICT, ewICT, other;
    public Date timeStart, timeEnd;
    String startDateToFormat, endDateToFormat;
    OptionDropBox<Integer> yearBox, yearBox2;
    OptionDropBox<String> dayBox, hourBox,  dayBox2, hourBox2, monthBox, monthBox2;

    /**
     * @param parser holds the created instance of the parser to be passed to a GraphGenerator instance once user
     *               has selected appropriate time bounds and data options.
     */
    public OptionContainer(Parser parser) {
        this.parser = parser;
        GridLayout layout = new GridLayout(0,2);
        setLayout(layout);
        setBackground(BG_COLOR);

        makeBoxes();

        formAndAddCategories();

        formTimeBounds();

        addTimeBounds();

        addSubmitButton();

        setVisible(true);
    }

    /**
     * Creates all of the necessary OptionCheckBoxes
     */
    private void makeBoxes() {
        bar = new OptionCheckBox("Bar Chart");
        line = new OptionCheckBox("Line Graph");
        demand = new OptionCheckBox("Demand");
        frequency = new OptionCheckBox("Frequency");
        solar = new OptionCheckBox("Solar");
        ccgt = new OptionCheckBox("CCGT");
        ocgt = new OptionCheckBox("OCGT");
        wind = new OptionCheckBox("Wind");
        pumped = new OptionCheckBox("Pumped");
        hydro = new OptionCheckBox("Hydro");
        coal = new OptionCheckBox("Coal");
        oil = new OptionCheckBox("Oil");
        nuclear = new OptionCheckBox("Nuclear");
        frenchICT = new OptionCheckBox("French ICT");
        irishICT = new OptionCheckBox("Irish ICT");
        dutchICT = new OptionCheckBox("Dutch ICT");
        ewICT = new OptionCheckBox("EW ICT");
        other = new OptionCheckBox("Other");
    }

    //creates a list of checkboxes for each option category
    //the name of each list matches the category that it will form.
    private void formAndAddCategories() {
        List<OptionCheckBox> graphTypes = new ArrayList<>();
        graphTypes.add(bar);
        graphTypes.add(line);

        List<OptionCheckBox> dataTypes = new ArrayList<>();
        dataTypes.add(demand);
        dataTypes.add(frequency);
        dataTypes.add(other);

        List<OptionCheckBox> energyTypes = new ArrayList<>();
        energyTypes.add(solar);
        energyTypes.add(wind);
        energyTypes.add(hydro);
        energyTypes.add(pumped);

        List<OptionCheckBox> energyTypes2 = new ArrayList<>();
        energyTypes2.add(coal);
        energyTypes2.add(oil);
        energyTypes2.add(nuclear);
        energyTypes2.add(ocgt);
        energyTypes2.add(ccgt);

        List<OptionCheckBox> energyTypes3 = new ArrayList<>();
        energyTypes3.add(frenchICT);
        energyTypes3.add(irishICT);
        energyTypes3.add(dutchICT);
        energyTypes3.add(ewICT);

        //add created OptionPanels to the OptionContainer
        OptionPanel op1 = new OptionPanel(graphTypes, "Graph Types");
        OptionPanel op2 = new OptionPanel(dataTypes, "Data types");
        OptionPanel op3 = new OptionPanel(energyTypes, "Renewable");
        OptionPanel op4 = new OptionPanel(energyTypes2, "Non-renewable");
        OptionPanel op5 = new OptionPanel(energyTypes3, "ICT");

        add(op1);
        add(op2);
        add(op3);
        add(op4);
        add(op5);
    }

    //Creates OptionDropBoxes,
    private void formTimeBounds() {
        hourBox = new OptionDropBox<>(HOURS, "Hour");
        hourBox.setRenderer(new MyComboBoxRenderer("Hour"));
        hourBox.setSelectedIndex(-1);

        dayBox = new OptionDropBox<>(DAYS, "Day");
        dayBox.setRenderer(new MyComboBoxRenderer("Day"));
        dayBox.setSelectedIndex(-1);

        monthBox = new OptionDropBox<>(MONTHS, "Month");
        monthBox.setRenderer(new MyComboBoxRenderer("Month"));
        monthBox.setSelectedIndex(-1);

        yearBox = new OptionDropBox<>(YEARS, "Year");
        yearBox.setEditable(true);

        hourBox2 = new OptionDropBox<>(HOURS, "Hour");
        hourBox2.setRenderer(new MyComboBoxRenderer("Hour"));
        hourBox2.setSelectedIndex(-1);

        dayBox2 = new OptionDropBox<>(DAYS, "Day");
        dayBox2.setRenderer(new MyComboBoxRenderer("Day"));
        dayBox2.setSelectedIndex(-1);

        monthBox2 = new OptionDropBox<>(MONTHS, "Month");
        monthBox2.setRenderer(new MyComboBoxRenderer("Month"));
        monthBox2.setSelectedIndex(-1);

        yearBox2 = new OptionDropBox<>(YEARS, "Year");
        yearBox2.setEditable(true);
    }

    //adds the created OptionDropBoxes to a panel to be placed in the container panel
    private void addTimeBounds() {
        JPanel jp3 = new JPanel();
        Border border = BorderFactory.createTitledBorder(null, "Time/Date Start", TitledBorder.CENTER, TitledBorder.TOP, BORDER_FONT, Color.black);
        //Border border = BorderFactory.createTitledBorder("Time/Date Start");
        jp3.setBorder(border);

        jp3.add(hourBox);
        jp3.add(dayBox);
        jp3.add(monthBox);
        jp3.add(yearBox);

        JPanel jp4 = new JPanel();
        Border border1 = BorderFactory.createTitledBorder(null, "Time/Date End", TitledBorder.CENTER, TitledBorder.TOP, BORDER_FONT, Color.black);
        //Border border1 = BorderFactory.createTitledBorder("Time/Date End");
        jp4.setBorder(border1);

        jp4.add(hourBox2);
        jp4.add(dayBox2);
        jp4.add(monthBox2);
        jp4.add(yearBox2);

        add(jp3);
        add(jp4);
    }

    //adds submit button to a panel to be added to the container
    private void addSubmitButton() {
        JPanel jp5 = new JPanel();
        JButton submitValues = new JButton("Create Graph");
        Border border2 = BorderFactory.createTitledBorder(null, "Submit", TitledBorder.CENTER, TitledBorder.TOP, BORDER_FONT, Color.black);
        submitValues.setBackground(Color.blue);
        submitValues.setForeground(Color.white);
        submitValues.addActionListener(new SubmitListener(this));

        jp5.setBorder(border2);
        jp5.add(submitValues);

        add(jp5);
    }
}
//Small class that allows DropBoxes to display text describing what they contain
class MyComboBoxRenderer extends JLabel implements ListCellRenderer {
    private String title;

    MyComboBoxRenderer(String newTitle) {
        title = newTitle;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean hasFocus) {
        if (index == -1 && value == null) setText(title );
        else setText(value.toString());
        return this;
    }
}

//parses selected time and date from the OptionDropBoxes
//catches bad time bound input and sets the limit on the size of the time bound that can be generated.
//if no errors are found within the time bounds, a new GraphGenerator is created.
class SubmitListener implements ActionListener {
    private OptionContainer container;

    SubmitListener(OptionContainer container) {
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        container.startDateToFormat = container.yearBox.getSelectedItem() + "-" + container.monthBox.getSelectedItem() + "-" +
                container.dayBox.getSelectedItem() + " " + container.hourBox.getSelectedItem() + ":" + "00:00";

        container.endDateToFormat = container.yearBox2.getSelectedItem() + "-" + container.monthBox2.getSelectedItem() + "-" +
                container.dayBox2.getSelectedItem() + " " + container.hourBox2.getSelectedItem() + ":" + "00:00";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            container.timeStart = sdf.parse(container.startDateToFormat);
            container.timeEnd = sdf.parse(container.endDateToFormat);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        List<Data> data = container.parser.getData();
        if (container.timeEnd.compareTo(data.get(0).getDate()) < 1 ) {
            JOptionPane.showMessageDialog(null, "Invalid time bounds chosen. Choose between : " + data.get(0).getDate() + " and " + data.get(data.size() - 1).getDate());
        } else if (container.timeStart.compareTo(container.timeEnd) > -1) {
            JOptionPane.showMessageDialog(null, "End date is earlier than start date");
        } else {
            long diffInMillies = Math.abs(container.timeEnd.getTime() - container.timeStart.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if (diff > 30 * 3) {
                JOptionPane.showMessageDialog(null, "The time constraints are too large to generate a graph within a reasonable amount of time");
            } else {
                new GraphGenerator(container, container.parser);
            }
        }
    }
}