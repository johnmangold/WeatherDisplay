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

/**
 *
 * @author Joseph Mowry
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
    public WeatherGraph(String tabName){
        //createWeatherGraphUsingString(tabName);
        createDataset();
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
        
        for(List<Weather> month : WeatherDisplay.allWeather){
            for(Weather record : month){
                try{
                    WeatherDisplay.wds.temperatureDataset.addValue(Double.parseDouble(record.temperature), series1, record.date);
                    WeatherDisplay.wds.humidityDataset.addValue(Double.parseDouble(record.humidity), series2, record.date);
                    WeatherDisplay.wds.barometricDataset.addValue(Double.parseDouble(record.barometer), series3, record.date);
                    WeatherDisplay.wds.windspeedDataset.addValue(Double.parseDouble(record.windspeed), series4, record.date);
                    WeatherDisplay.wds.uvIndexDataset.addValue(Double.parseDouble(record.uvindex), series5, record.date);
                    WeatherDisplay.wds.rainfallDataset.addValue(Double.parseDouble(record.rainfall), series6, record.date);
                }catch (NullPointerException ex){
                    WeatherDisplay.wds.rainfallDataset.addValue(1, series6, record.date);
                }
            }
        }
           
    }
    
    private void createSmallerDataset(String size, int day, int month, int year) {
        final String series1 = "Temperature";
        final String series2 = "Humidity";
        final String series3 = "Barometer";
        final String series4 = "Wind Speed";
        final String series5 = "UV Index";
        final String series6 = "Rainfall";
        
        for(List<Weather> innerMonth : WeatherDisplay.allWeather){
            for(Weather record : innerMonth){
                try{
                    WeatherDisplay.wds.temperatureDataset.addValue(Double.parseDouble(record.temperature), series1, record.date);
                    WeatherDisplay.wds.humidityDataset.addValue(Double.parseDouble(record.humidity), series2, record.date);
                    WeatherDisplay.wds.barometricDataset.addValue(Double.parseDouble(record.barometer), series3, record.date);
                    WeatherDisplay.wds.windspeedDataset.addValue(Double.parseDouble(record.windspeed), series4, record.date);
                    WeatherDisplay.wds.uvIndexDataset.addValue(Double.parseDouble(record.uvindex), series5, record.date);
                    WeatherDisplay.wds.rainfallDataset.addValue(Double.parseDouble(record.rainfall), series6, record.date);
                }catch (NullPointerException ex){
                    WeatherDisplay.wds.rainfallDataset.addValue(1, series6, record.date);
                }
            }
        }
        
        if("Daily".equalsIgnoreCase(size)) {
            for(Weather record : WeatherDisplay.allWeather.get(month)){
                if( record.dateTime.get(Calendar.DAY_OF_MONTH) == day) {
                    try{
                        WeatherDisplay.wds.temperatureDataset.addValue(Double.parseDouble(record.temperature), series1, record.date);
                        WeatherDisplay.wds.humidityDataset.addValue(Double.parseDouble(record.humidity), series2, record.date);
                        WeatherDisplay.wds.barometricDataset.addValue(Double.parseDouble(record.barometer), series3, record.date);
                        WeatherDisplay.wds.windspeedDataset.addValue(Double.parseDouble(record.windspeed), series4, record.date);
                        WeatherDisplay.wds.uvIndexDataset.addValue(Double.parseDouble(record.uvindex), series5, record.date);
                        WeatherDisplay.wds.rainfallDataset.addValue(Double.parseDouble(record.rainfall), series6, record.date);
                    }catch (NullPointerException ex){
                        WeatherDisplay.wds.rainfallDataset.addValue(1, series6, record.date);
                    }
                }
            }
        }
        else if ("Weekly".equalsIgnoreCase(size)) {
            
        }
        else if ("Monthly".equalsIgnoreCase(size)) {
            
        }
        else if ("Yearly".equalsIgnoreCase(size)) {
            
        }
    }
}
