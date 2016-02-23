/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 *
 * @author Joseph Mowry
 */
public class WeatherGraph extends JPanel {
    
    public WeatherGraph(){
        createWeatherGraph();
    }
    
    private void createWeatherGraph(){
        
        XYSeries series = new XYSeries("Data");
        
        series.add(1,1);
        series.add(2,7);
        series.add(3,3);
        series.add(4,5);
        series.add(5,14);
        
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        
        JFreeChart chart = ChartFactory.createXYLineChart("Weather", "Time",
            "Temperature", dataset, PlotOrientation.VERTICAL, false, false, false);
        
        ChartPanel chartPanel = new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(700, 500);
            }
        };
        
        chartPanel.setMouseWheelEnabled(true);
        add(chartPanel);
    }
}
