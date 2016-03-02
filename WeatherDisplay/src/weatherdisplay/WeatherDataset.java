/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import static weatherdisplay.WeatherGraph.dataset;
import static weatherdisplay.WeatherGraph.temperatureChart;

/**
 *
 * @author 1959760
 */
public class WeatherDataset {
    static DefaultCategoryDataset temperatureDataset = new DefaultCategoryDataset();
    static DefaultCategoryDataset humidityDataset = new DefaultCategoryDataset();
    static DefaultCategoryDataset barometricDataset = new DefaultCategoryDataset();
    static DefaultCategoryDataset windspeedDataset = new DefaultCategoryDataset();
    static DefaultCategoryDataset uvIndexDataset = new DefaultCategoryDataset();
    static DefaultCategoryDataset rainfallDataset = new DefaultCategoryDataset();
    static DefaultCategoryDataset reusableDataset = new DefaultCategoryDataset();
    
    public WeatherDataset() {
    }
    
    public static ChartPanel createChartFromDataset(CategoryDataset ds, String tabName, String attributeName){
        
        JFreeChart chart = ChartFactory.createLineChart(
            "Weather",                 // chart title
            "Time (" + tabName + ")",  // domain axis label
            attributeName,             // range axis label
            ds,                        // data
            PlotOrientation.VERTICAL,  // orientation
            false,                      // include legend
            true,                      // tooltips
            true                       // urls
        );
        
        return new ChartPanel(chart);
    }
}
