package Main.Graphs;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

//Class using JFreeChart API to generate bar graphs.
class BarChart extends JFrame {
    /**
            * To use the External library a DefaultCategoryDataset from the JCommon library is required.
     * @param title title to be shown within the frame above the graph itself
     * @param category1 label for the x axis
     * @param category2 label for y axis
     * @param data DefaultCategoryDataset containing values to plot.
     */
    BarChart(String title, String category1, String category2, DefaultCategoryDataset data) {
        super(title);

        JFreeChart chart = ChartFactory.createBarChart(title, category1, category2, data);

        ChartPanel panel = new ChartPanel(chart);
        setContentPane(panel);
    }
}








