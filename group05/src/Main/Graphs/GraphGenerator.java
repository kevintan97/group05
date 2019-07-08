package Main.Graphs;

import Main.Options.OptionContainer;
import Main.Parser.Parser;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.util.Date;
import java.util.List;

//Generates a graph based on the options chosen in the OptionContainer class.
public class GraphGenerator {
    private OptionContainer container;
    private List<Data> data;
    private DefaultCategoryDataset dataSet;

    public GraphGenerator(OptionContainer container, Parser parser) {
        this.container = container;

        data = parser.getData();

        buildGraphData();
    }

    //Fills DefaultCategoryDataset based on options chosen, each if statement uses the OptionCheckBox selected field to
    //find which fields of the data objects within the Parser's data object list to plot.
    //NB: Frequency is seperated because it has its own unique value of Hz instead of GW this prevents comparing data
    //incorrectly.
    private void buildGraphData() {
        dataSet = new DefaultCategoryDataset();
        for (Data d : data) {
            Date date = d.getDate();

            if (date.compareTo(container.timeStart) > -1 && date.compareTo(container.timeEnd) < 1) {
                if (container.frequency.selected) {
                    dataSet.addValue(d.getFrequency(), "Frequency", date);
                } else {
                    if (container.demand.selected) { dataSet.addValue(d.getDemand(), "Demand", date); }
                    if (container.solar.selected) { dataSet.addValue(d.getSolar(), "Solar", date); }
                    if (container.ocgt.selected) { dataSet.addValue(d.getOcgt(), "OCGT", date); }
                    if (container.ccgt.selected) { dataSet.addValue(d.getCcgt(), "CCGT", date); }
                    if (container.wind.selected) { dataSet.addValue(d.getWind(), "Wind", date); }
                    if (container.pumped.selected) { dataSet.addValue(d.getPumped(), "Pumped", date); }
                    if (container.hydro.selected) { dataSet.addValue(d.getHydro(), "Hydro", date); }
                    if (container.coal.selected) { dataSet.addValue(d.getCoal(), "Coal", date); }
                    if (container.oil.selected) { dataSet.addValue(d.getOil(), "Oil", date); }
                    if (container.nuclear.selected) { dataSet.addValue(d.getNuclear(), "Nuclear", date); }
                    if (container.frenchICT.selected) { dataSet.addValue(d.getFrench_ict(), "French ICT", date); }
                    if (container.irishICT.selected) { dataSet.addValue(d.getIrish_ict(), "Irish ICT", date); }
                    if (container.dutchICT.selected) { dataSet.addValue(d.getDutch_ict(), "Dutch ICT", date); }
                    if (container.ewICT.selected) { dataSet.addValue(d.getEw_ict(), "EW ICT", date); }
                    if (container.other.selected) { dataSet.addValue(d.getOther(), "Other", date); }
                }
            } else if(date.compareTo(container.timeEnd) > 0) {
                break;
            }
        }
        chooseGraph();
    }

    //determines which graph type to generate, it is possible to generate one of each simultaneously
    private void chooseGraph() {
        if (container.line.selected) { makeLineGraph(); }
        if (container.bar.selected) { makeBarChart(); }
    }
    //creates appropriate label for y axis.
    private String yAxisLabel() {
        String yAxis;
        if (container.frequency.selected) {
            yAxis = "Grid Frequency (Hz)";
        } else {
            yAxis = "GW";
        }
        return yAxis;
    }

    //creates appropriate title for each graph
    private String graphTitle() {
        String title;
        if (container.frequency.selected) {
            title = "Frequency: " + container.timeStart + " to " + container.timeEnd;
        } else {
            title = "Power output (GW): " + container.timeStart + " to " + container.timeEnd;
        }
        return title;
    }

    //creates linegraph object using selected data
    private void makeLineGraph() {
        LineGraph lg = new LineGraph(graphTitle(), "Time", yAxisLabel(), dataSet);
        lg.pack();
        lg.setExtendedState(JFrame.MAXIMIZED_BOTH);
        lg.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        lg.setVisible(true);
    }

    //creates bargraph object using selected data
    private void makeBarChart() {
        BarChart bg = new BarChart(graphTitle(), "Time", yAxisLabel(), dataSet);
        bg.pack();
        bg.setExtendedState(JFrame.MAXIMIZED_BOTH);
        bg.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        bg.setVisible(true);
    }
}
