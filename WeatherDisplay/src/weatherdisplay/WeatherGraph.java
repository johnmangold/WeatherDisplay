/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.util.Calendar;
import java.util.List;
import javax.swing.JPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * Creates the associated datasets for the subsets of weather data that need to
 * be parsed.
 * @authors Allison Bodvig, John Mangold, Joseph Mowry
 */
public class WeatherGraph extends JPanel {
    public static JFreeChart chart;
    public static JFreeChart temperatureChart;
    public static JFreeChart humidityChart;
    public static JFreeChart barometricChart;
    public static JFreeChart windspeedChart;
    public static JFreeChart uvIndexChart;
    public static JFreeChart rainfallChart;
    
    public static CategoryDataset dataset = null;
    public WeatherGraph(){
        
    }
    /**
     * A constructor that takes only the name of the tab it came from to
     * indicate range.
     * @param tabName 
     */
    public WeatherGraph(String tabName){
        createSmallerDataset("Daily", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
    }
    /**
     * The overloaded constructor for WeatherGraph that accepts various relevant
     * data depending on the context of the tab.
     * @param tabName
     * @param day
     * @param month
     * @param year 
     */
    public WeatherGraph(String tabName, int day, int month, int year){
        createSmallerDataset(tabName, day, month, year);
    }

    /**
     * Creates a category-based dataset from the weather data.
     * @return The dataset.
     */
    private void createDataset() {
        final String series1 = "Temperature";
        final String series2 = "Humidity";
        final String series3 = "Barometer";
        final String series4 = "Wind Speed";
        final String series5 = "UV Index";
        final String series6 = "Rainfall";
           
    }
    /**
     * Creates a dataset according to the supplied range.
     * @param size
     * @param day
     * @param month
     * @param year 
     */
    public void createSmallerDataset(String size, int day, int month, int year) {
        final String series1 = "Temperature";
        final String series2 = "Humidity";
        final String series3 = "Barometer";
        final String series4 = "Wind Speed";
        final String series5 = "UV Index";
        final String series6 = "Rainfall";
        final String series7 = "Wind Gust";
        
        if("Daily".equalsIgnoreCase(size)) {
            for(List<Weather> innerMonth : WeatherDisplay.allWeather ) {
                for(Weather record : innerMonth ){
                    if( record.dateTime.get(Calendar.DAY_OF_MONTH) == day) {
                        try{
                            WeatherDisplay.wds.temperatureDatasetDaily.addValue(Double.parseDouble(record.temperature), series1, record.date);
                            WeatherDisplay.wds.humidityDatasetDaily.addValue(Double.parseDouble(record.humidity), series2, record.date);
                            WeatherDisplay.wds.barometricDatasetDaily.addValue(Double.parseDouble(record.barometer), series3, record.date);
                            WeatherDisplay.wds.windspeedDatasetDaily.addValue(Double.parseDouble(record.windspeed), series4, record.date);
                            WeatherDisplay.wds.uvIndexDatasetDaily.addValue(Double.parseDouble(record.uvindex), series5, record.date);
                            WeatherDisplay.wds.rainfallDatasetDaily.addValue(Double.parseDouble(record.rainfall), series6, record.date);
                            WeatherDisplay.wds.windgustDatasetDaily.addValue(Double.parseDouble(record.windgust), series7, record.date);
                        }catch (NullPointerException ex){
                            WeatherDisplay.wds.rainfallDatasetDaily.addValue(1, series6, record.date);
                        }
                    }
                }
            }
        }
        else if ("Weekly".equalsIgnoreCase(size)) {
            for(List<Weather> innerMonth : WeatherDisplay.allWeather ) {
                for(Weather record : innerMonth){
                    if( record.dateTime.get(Calendar.WEEK_OF_MONTH) == WeatherDisplay.week) {
                        try{
                            WeatherDisplay.wds.temperatureDatasetWeekly.addValue(Double.parseDouble(record.temperature), series1, record.date);
                            WeatherDisplay.wds.humidityDatasetWeekly.addValue(Double.parseDouble(record.humidity), series2, record.date);
                            WeatherDisplay.wds.barometricDatasetWeekly.addValue(Double.parseDouble(record.barometer), series3, record.date);
                            WeatherDisplay.wds.windspeedDatasetWeekly.addValue(Double.parseDouble(record.windspeed), series4, record.date);
                            WeatherDisplay.wds.uvIndexDatasetWeekly.addValue(Double.parseDouble(record.uvindex), series5, record.date);
                            WeatherDisplay.wds.rainfallDatasetWeekly.addValue(Double.parseDouble(record.rainfall), series6, record.date);
                            WeatherDisplay.wds.windgustDatasetWeekly.addValue(Double.parseDouble(record.windgust), series7, record.date);
                        }catch (NullPointerException ex){
                            WeatherDisplay.wds.rainfallDatasetWeekly.addValue(1, series6, record.date);
                        }
                    }
                }
            }
        }
        else if ("Monthly".equalsIgnoreCase(size)) {
            for(List<Weather> innerMonth : WeatherDisplay.allWeather){
                for(Weather record : innerMonth){
                    if(record.dateTime.get(Calendar.MONTH) == month) {
                        try{
                            WeatherDisplay.wds.temperatureDatasetMonthly.addValue(Double.parseDouble(record.temperature), series1, record.date);
                            WeatherDisplay.wds.humidityDatasetMonthly.addValue(Double.parseDouble(record.humidity), series2, record.date);
                            WeatherDisplay.wds.barometricDatasetMonthly.addValue(Double.parseDouble(record.barometer), series3, record.date);
                            WeatherDisplay.wds.windspeedDatasetMonthly.addValue(Double.parseDouble(record.windspeed), series4, record.date);
                            WeatherDisplay.wds.uvIndexDatasetMonthly.addValue(Double.parseDouble(record.uvindex), series5, record.date);
                            WeatherDisplay.wds.rainfallDatasetMonthly.addValue(Double.parseDouble(record.rainfall), series6, record.date);
                            WeatherDisplay.wds.windgustDatasetMonthly.addValue(Double.parseDouble(record.windgust), series7, record.date);
                        }catch (NullPointerException ex){
                            WeatherDisplay.wds.rainfallDatasetMonthly.addValue(1, series6, record.date);
                        }
                    }
                }
            }
        }
        else if ("Yearly".equalsIgnoreCase(size)) {
            for(List<Weather> innerMonth : WeatherDisplay.allWeather){
                for(Weather record : innerMonth){
                    if(record.dateTime.get(Calendar.YEAR) == year) {
                        try{
                            WeatherDisplay.wds.temperatureDatasetYearly.addValue(Double.parseDouble(record.temperature), series1, record.date);
                            WeatherDisplay.wds.humidityDatasetYearly.addValue(Double.parseDouble(record.humidity), series2, record.date);
                            WeatherDisplay.wds.barometricDatasetYearly.addValue(Double.parseDouble(record.barometer), series3, record.date);
                            WeatherDisplay.wds.windspeedDatasetYearly.addValue(Double.parseDouble(record.windspeed), series4, record.date);
                            WeatherDisplay.wds.uvIndexDatasetYearly.addValue(Double.parseDouble(record.uvindex), series5, record.date);
                            WeatherDisplay.wds.rainfallDatasetYearly.addValue(Double.parseDouble(record.rainfall), series6, record.date);
                            WeatherDisplay.wds.windgustDatasetYearly.addValue(Double.parseDouble(record.windgust), series7, record.date);
                        }catch (NullPointerException ex){
                            WeatherDisplay.wds.rainfallDatasetYearly.addValue(1, series6, record.date);
                        }
                    }
                }
            }
        }
    }
}
