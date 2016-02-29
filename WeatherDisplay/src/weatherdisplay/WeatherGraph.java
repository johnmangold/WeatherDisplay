/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
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
import org.jfree.data.xy.XYDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author Joseph Mowry
 */
public class WeatherGraph extends JPanel {
    
    public WeatherGraph(){
        createWeatherGraph();
    }
    
    private void createWeatherGraph(){
        
        CategoryDataset dataset = createDataset();

        
        // Create the chart
        final JFreeChart chart = ChartFactory.createLineChart(
            "Weather",                 // chart title
            "Time",                    // domain axis label
            "Temperature",             // range axis label
            dataset,                   // data
            PlotOrientation.VERTICAL,  // orientation
            true,                      // include legend
            true,                      // tooltips
            true                      // urls
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
        
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setBackground(Color.lightGray);
        chart.setBackgroundPaint(Color.white);
        
        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);
        
        add(chartPanel);
    }

    /**
     * Creates a category-based dataset from the weather data.
     * @return The dataset.
     */
    private CategoryDataset createDataset() {
        
        // TODO: These strings need to be set to something meaningful later.
        
        // Row keys...
        final String series1 = "First";
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

        /*
        dataset.addValue(1.0, series1, type1);
        dataset.addValue(4.0, series1, type2);
        dataset.addValue(3.0, series1, type3);
        dataset.addValue(5.0, series1, type4);
        dataset.addValue(5.0, series1, type5);
        dataset.addValue(7.0, series1, type6);
        dataset.addValue(7.0, series1, type7);
        dataset.addValue(8.0, series1, type8);

        dataset.addValue(5.0, series2, type1);
        dataset.addValue(7.0, series2, type2);
        dataset.addValue(6.0, series2, type3);
        dataset.addValue(8.0, series2, type4);
        dataset.addValue(4.0, series2, type5);
        dataset.addValue(4.0, series2, type6);
        dataset.addValue(2.0, series2, type7);
        dataset.addValue(1.0, series2, type8);

        dataset.addValue(4.0, series3, type1);
        dataset.addValue(3.0, series3, type2);
        dataset.addValue(2.0, series3, type3);
        dataset.addValue(3.0, series3, type4);
        dataset.addValue(6.0, series3, type5);
        dataset.addValue(3.0, series3, type6);
        dataset.addValue(4.0, series3, type7);
        dataset.addValue(3.0, series3, type8);
        */  // dummy data
        
        // TODO: This block should iterate through each month, then each record,
        // then try to convert the "temperature" data point to a double, or else
        // put a "1" in that spot. This needs to change.
        
        // NOTE: This block currently does not display the graph at all.
        // However, this should be the correct approach.
        for(List<Weather> month : WeatherDisplay.allWeather){
            for(Weather record : month){
                try{
                    dataset.addValue(Double.parseDouble(record.temperature), series1, record.date);
                }catch (NullPointerException ex) {
                    dataset.addValue(1, series1, record.date);
                }
            }
        }
        return dataset;      
    }
    
    private XYSeriesCollection createMyDataset(){
                
        XYSeries series = new XYSeries("Data");

        int numMonths = WeatherDisplay.allWeather.size();        

        for(int i = 0; i < numMonths; i++)
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
        
//        for(List<Weather> month : WeatherDisplay.allWeather){
//            for(Weather record : month){
//                record.temperature
//            }
//        }

//                double first = Double.parseDouble(thing);
//                double second = Double.parseDouble(thing2);
        
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        
        return dataset;

    }
}
