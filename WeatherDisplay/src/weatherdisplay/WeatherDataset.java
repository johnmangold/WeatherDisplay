/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import javafx.scene.chart.NumberAxis;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import static weatherdisplay.WeatherGraph.dataset;
import static weatherdisplay.WeatherGraph.temperatureChart;

/**
 * This object contains the datasets related to weather, and is tasked with
 * creating the chart object with respect to each given range and attribute.
 * @authors Allison Bodvig, John Mangold, Joseph Mowry
 * 
 */
public class WeatherDataset {
    // a DefaultCategoryDataset for each attribute and range combination
    static DefaultCategoryDataset temperatureDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset humidityDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset barometricDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset windspeedDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset uvIndexDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset rainfallDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset windgustDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset temperatureDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset humidityDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset barometricDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset windspeedDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset uvIndexDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset rainfallDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset windgustDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset temperatureDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset humidityDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset barometricDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset windspeedDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset uvIndexDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset rainfallDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset windgustDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset temperatureDatasetYearly = new DefaultCategoryDataset();
    static DefaultCategoryDataset humidityDatasetYearly = new DefaultCategoryDataset();
    static DefaultCategoryDataset barometricDatasetYearly = new DefaultCategoryDataset();
    static DefaultCategoryDataset windspeedDatasetYearly = new DefaultCategoryDataset();
    static DefaultCategoryDataset uvIndexDatasetYearly = new DefaultCategoryDataset();
    static DefaultCategoryDataset rainfallDatasetYearly = new DefaultCategoryDataset();
    static DefaultCategoryDataset windgustDatasetYearly = new DefaultCategoryDataset();
    
    public WeatherDataset() {
    }
    
    /**
     * Obtains a JFreeChart object from the factory, set with the appropriate
     * optional flags.
     * @param ds            the dataset used to plot
     * @param tabName       the name of the current tab
     * @param attributeName name of the current attribute
     * @return 
     */
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
    /**
     * Clears the data set for each range of values.
     * @param type  the desired range
     */
    public void clearDataset(String type) {
        switch(type) {
            case "Daily":
                temperatureDatasetDaily = new DefaultCategoryDataset();
                humidityDatasetDaily = new DefaultCategoryDataset();
                barometricDatasetDaily = new DefaultCategoryDataset();
                windspeedDatasetDaily = new DefaultCategoryDataset();
                uvIndexDatasetDaily = new DefaultCategoryDataset();
                rainfallDatasetDaily = new DefaultCategoryDataset();
                windgustDatasetDaily = new DefaultCategoryDataset();
                break;
            case "Weekly":
                temperatureDatasetWeekly = new DefaultCategoryDataset();
                humidityDatasetWeekly = new DefaultCategoryDataset();
                barometricDatasetWeekly = new DefaultCategoryDataset();
                windspeedDatasetWeekly = new DefaultCategoryDataset();
                uvIndexDatasetWeekly = new DefaultCategoryDataset();
                rainfallDatasetWeekly = new DefaultCategoryDataset();
                windgustDatasetWeekly = new DefaultCategoryDataset();
                break;
            case "Monthly":
                temperatureDatasetMonthly = new DefaultCategoryDataset();
                humidityDatasetMonthly = new DefaultCategoryDataset();
                barometricDatasetMonthly = new DefaultCategoryDataset();
                windspeedDatasetMonthly = new DefaultCategoryDataset();
                uvIndexDatasetMonthly = new DefaultCategoryDataset();
                rainfallDatasetMonthly = new DefaultCategoryDataset();
                windgustDatasetMonthly = new DefaultCategoryDataset();
                break;
            case "Yearly":
                temperatureDatasetYearly = new DefaultCategoryDataset();
                humidityDatasetYearly = new DefaultCategoryDataset();
                barometricDatasetYearly = new DefaultCategoryDataset();
                windspeedDatasetYearly = new DefaultCategoryDataset();
                uvIndexDatasetYearly = new DefaultCategoryDataset();
                rainfallDatasetYearly = new DefaultCategoryDataset();
                windgustDatasetYearly = new DefaultCategoryDataset();
                break;
        }
    }
}
