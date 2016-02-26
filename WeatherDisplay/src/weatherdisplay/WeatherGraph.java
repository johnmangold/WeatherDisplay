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
                
        for(int i = 0; i < 1; i++)
        {
            for(int j = 0; j < 100; j++)
            {
                String thing = WeatherDisplay.allWeather.get(i).get(j).temperature;
                String thing2 = WeatherDisplay.allWeather.get(i).get(j).temperature;

                double first = Double.parseDouble(thing);
                double second = Double.parseDouble(thing2);

                series.add(first, second);
            }
        }

        
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
