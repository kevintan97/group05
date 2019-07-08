package Main.Graphs;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

//Class using the JFreeChart API to generate the line graphs.
class LineGraph extends JFrame {
    /**
     * To use the External library a DefaultCategoryDataset from the JCommon library is required.
     * @param title title to be shown within the frame above the graph itself
     * @param categoryAxisLabel label for the x axis
     * @param valueAxisLabel label for y axis
     * @param data DefaultCategoryDataset containing values to plotted.
     */
    LineGraph(String title, String categoryAxisLabel, String valueAxisLabel, DefaultCategoryDataset data) {
        super(title);

        // Create chart
        JFreeChart chart = ChartFactory.createLineChart(title, categoryAxisLabel, valueAxisLabel, data);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
}
