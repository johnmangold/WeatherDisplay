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
    static DefaultCategoryDataset temperatureDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset humidityDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset barometricDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset windspeedDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset uvIndexDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset rainfallDatasetDaily = new DefaultCategoryDataset();
    static DefaultCategoryDataset temperatureDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset humidityDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset barometricDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset windspeedDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset uvIndexDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset rainfallDatasetWeekly = new DefaultCategoryDataset();
    static DefaultCategoryDataset temperatureDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset humidityDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset barometricDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset windspeedDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset uvIndexDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset rainfallDatasetMonthly = new DefaultCategoryDataset();
    static DefaultCategoryDataset temperatureDatasetYearly = new DefaultCategoryDataset();
    static DefaultCategoryDataset humidityDatasetYearly = new DefaultCategoryDataset();
    static DefaultCategoryDataset barometricDatasetYearly = new DefaultCategoryDataset();
    static DefaultCategoryDataset windspeedDatasetYearly = new DefaultCategoryDataset();
    static DefaultCategoryDataset uvIndexDatasetYearly = new DefaultCategoryDataset();
    static DefaultCategoryDataset rainfallDatasetYearly = new DefaultCategoryDataset();
    
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
    
    public void clearDataset(String type) {
        switch(type) {
            case "Daily":
                temperatureDatasetDaily = new DefaultCategoryDataset();
                humidityDatasetDaily = new DefaultCategoryDataset();
                barometricDatasetDaily = new DefaultCategoryDataset();
                windspeedDatasetDaily = new DefaultCategoryDataset();
                uvIndexDatasetDaily = new DefaultCategoryDataset();
                rainfallDatasetDaily = new DefaultCategoryDataset();
                break;
            case "Weekly":
                temperatureDatasetWeekly = new DefaultCategoryDataset();
                humidityDatasetWeekly = new DefaultCategoryDataset();
                barometricDatasetWeekly = new DefaultCategoryDataset();
                windspeedDatasetWeekly = new DefaultCategoryDataset();
                uvIndexDatasetWeekly = new DefaultCategoryDataset();
                rainfallDatasetWeekly = new DefaultCategoryDataset();
                break;
            case "Monthly":
                temperatureDatasetMonthly = new DefaultCategoryDataset();
                humidityDatasetMonthly = new DefaultCategoryDataset();
                barometricDatasetMonthly = new DefaultCategoryDataset();
                windspeedDatasetMonthly = new DefaultCategoryDataset();
                uvIndexDatasetMonthly = new DefaultCategoryDataset();
                rainfallDatasetMonthly = new DefaultCategoryDataset();
                break;
            case "Yearly":
                temperatureDatasetYearly = new DefaultCategoryDataset();
                humidityDatasetYearly = new DefaultCategoryDataset();
                barometricDatasetYearly = new DefaultCategoryDataset();
                windspeedDatasetYearly = new DefaultCategoryDataset();
                uvIndexDatasetYearly = new DefaultCategoryDataset();
                rainfallDatasetYearly = new DefaultCategoryDataset();
                break;
        }
    }
}
