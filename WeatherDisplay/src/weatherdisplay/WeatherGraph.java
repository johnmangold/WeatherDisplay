/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Joseph Mowry
 */
public class WeatherGraph extends JPanel {
    public static JFreeChart chart;
    
    public WeatherGraph(){
        
    }
    public WeatherGraph(String tabName){
        createWeatherGraphUsingString(tabName);
    }

    /**
     * Creates a category-based dataset from the weather data.
     * @return The dataset.
     */
    private CategoryDataset createDataset() {
        
        // TODO: These strings need to be set to something meaningful later.
        
        // Row keys...
        final String series1 = "Temperature";
        final String series2 = "Humidity";
        final String series3 = "Barometer";
        final String series4 = "Wind Speed";
        final String series5 = "UV Index";
        final String series6 = "Rainfall";
        
//        final String series2 = "Second";
//        final String series3 = "Third";

        // Column keys...
//        final String type1 = "Type 1";
//        final String type2 = "Type 2";
//        final String type3 = "Type 3";
//        final String type4 = "Type 4";
//        final String type5 = "Type 5";
//        final String type6 = "Type 6";
//        final String type7 = "Type 7";
//        final String type8 = "Type 8";

        // Create the dataset...
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String attribute = OptionsPanel.DataFields.getSelectedItem().toString();
        
        switch(attribute)
        {
            case "Temperature":
                for(List<Weather> month : WeatherDisplay.allWeather){
                    for(Weather record : month){
                        try{
                            dataset.addValue(Double.parseDouble(record.temperature), series1, record.date);
                        }catch (NullPointerException ex) {
                            dataset.addValue(1, series1, record.date);
                        }
                    }
                }
            break;
                
            case "Humidity":
                for(List<Weather> month : WeatherDisplay.allWeather){
                    for(Weather record : month){
                        try{
                            dataset.addValue(Double.parseDouble(record.humidity), series2, record.date);
                        }catch (NullPointerException ex) {
                            dataset.addValue(1, series2, record.date);
                        }
                    }
                }
            break;
                    
            case "Barometer":
                for(List<Weather> month : WeatherDisplay.allWeather){
                    for(Weather record : month){
                        try{
                            dataset.addValue(Double.parseDouble(record.barometer), series3, record.date);
                        }catch (NullPointerException ex) {
                            dataset.addValue(1, series3, record.date);
                        }
                    }
                }  
            break;
                
            case "Wind Speed":
                for(List<Weather> month : WeatherDisplay.allWeather){
                    for(Weather record : month){
                        try{
                            dataset.addValue(Double.parseDouble(record.windspeed), series4, record.date);
                        }catch (NullPointerException ex) {
                            dataset.addValue(1, series4, record.date);
                        }
                    }
                }  
            break;
            
            case "UV Index":
                for(List<Weather> month : WeatherDisplay.allWeather){
                    for(Weather record : month){
                        try{
                            dataset.addValue(Double.parseDouble(record.uvindex), series5, record.date);
                        }catch (NullPointerException ex) {
                            dataset.addValue(1, series5, record.date);
                        }
                    }
                }  
            break;
                
            case "Rainfall":
                for(List<Weather> month : WeatherDisplay.allWeather){
                    for(Weather record : month){
                        try{
                            dataset.addValue(Double.parseDouble(record.rainfall), series6, record.date);
                        }catch (NullPointerException ex) {
                            dataset.addValue(1, series6, record.date);
                        }
                    }
                }  
            break;
        }
        return dataset;      
    }
    
    private void createWeatherGraphUsingString(String tabName) {
        CategoryDataset dataset = createDataset();
        String name;
        try{
            name = OptionsPanel.DataFields.getSelectedItem().toString();
        }catch(NullPointerException ex){
            name = "exception!";
        }
        // Create the chart
        chart = ChartFactory.createLineChart(
            "Weather",                 // chart title
            "Time (" + tabName + ")",  // domain axis label
            name,                      // range axis label
            dataset,                   // data
            PlotOrientation.VERTICAL,  // orientation
            true,                      // include legend
            true,                      // tooltips
            true                       // urls
        );
        
//        chart.setBackgroundPaint(Color.white);
//        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
//        plot.setBackgroundPaint(Color.lightGray);
//        plot.setRangeGridlinePaint(Color.white);
        
        ChartPanel chartPanel = new ChartPanel(chart) {
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(700, 500);
            }
        };
        chartPanel.setDomainZoomable(true);
        chartPanel.setRangeZoomable(true);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setBackground(Color.lightGray);
        chart.setBackgroundPaint(Color.white);
        chart.getPlot();
        
        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);
        
        add(chartPanel);
    }
}
