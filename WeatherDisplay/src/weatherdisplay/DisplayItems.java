/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Manages weather value statistics with their corresponding images.
 * @authors Allison Bodvig, John Mangold, Joseph Mowry
 */
public class DisplayItems extends JPanel {
    
    public DisplayItems() {
        initialize();
    }
    
    private void initialize() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints a = new GridBagConstraints();
        Random random = new Random();
        int min = 0;
        int outMax = WeatherDisplay.allWeather.size();
        int outRand = random.nextInt(outMax);
        int inMax = WeatherDisplay.allWeather.get(outRand).size();
        int inRand = random.nextInt(inMax);
        
        a.gridx = 0;
        a.gridy = 0;
        a.insets = new Insets(0, 0, 0, 10);
        
        this.add(createTemperature(WeatherDisplay.allWeather.get(outRand).get(inRand).temperature, WeatherDisplay.allWeather.get(outRand).get(inRand).heatindex), a);
        
        a.gridx = 1;
        a.gridy = 0;
        a.insets = new Insets(0, 0, 0, 10);
        this.add(createWindDirection(WeatherDisplay.allWeather.get(outRand).get(inRand).winddirection, WeatherDisplay.allWeather.get(outRand).get(inRand).windchill), a);
        
        a.gridx = 2;
        a.gridy = 0;
        a.insets = new Insets(0, 0, 0, 10);
        this.add(createSpeed(WeatherDisplay.allWeather.get(outRand).get(inRand).windspeed, WeatherDisplay.allWeather.get(outRand).get(inRand).windgust), a);
        
        a.gridx = 3;
        a.gridy = 0;
        a.insets = new Insets(0, 0, 0, 10);
        this.add(createRainfall(WeatherDisplay.allWeather.get(outRand).get(inRand).rainfall, WeatherDisplay.allWeather.get(outRand).get(inRand).humidity), a);
        
        a.gridx = 4;
        a.gridy =0;
        a.insets = new Insets(0, 0, 0, 0);
        this.add(createPressure(WeatherDisplay.allWeather.get(outRand).get(inRand).barometer, WeatherDisplay.allWeather.get(outRand).get(inRand).uvindex), a);
    }
    /**
     * Creates and manages temperature and heat index values to attach to the
     * corresponding images.
     * @param temperature
     * @param heatIndex
     * @return 
     */
    private JPanel createTemperature( String temperature, String heatIndex) {
        JPanel tempPanel = new JPanel();
        tempPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.NONE;

        ImageIcon icon;
        if( Float.parseFloat(temperature) >= 80 ) {
            icon = new ImageIcon("images/hot.png");
        }
        else if(Float.parseFloat(temperature) >= 40) {
            icon = new ImageIcon("images/warm.png");
        }
        else if(Float.parseFloat(temperature) < 40) {
            icon = new ImageIcon("images/cold.png");
        }
        else {
            icon = new ImageIcon();
        }

        Image image = icon.getImage();
        image = image.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        icon.setImage(image);
        JLabel temperatureLabel = new JLabel();
        temperatureLabel.setIcon( icon );
        tempPanel.add(temperatureLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        
        String degFer = "\u00b0F";
        JLabel header = new JLabel("Temperature: " + temperature + degFer);
        header.setFont(new Font("Serif", Font.PLAIN, 20));
        tempPanel.add(header, c);
        
        c.gridx = 0;
        c.gridy = 2;
        
        JLabel indexHeader = new JLabel("Heat Index: " + heatIndex + degFer);
        indexHeader.setFont(new Font("Serif", Font.PLAIN, 20));
        tempPanel.add(indexHeader, c);
        
        return tempPanel;
    }
    /**
     * Creates and manages wind direction and wind chill values to attach to the
     * corresponding images.
     * @param windDirection
     * @param windChill
     * @return 
     */
    private JPanel createWindDirection( String windDirection, String windChill) {
        JPanel dirPanel = new JPanel();
        dirPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.NONE;
        
        ImageIcon icon = null;
        if( null != windDirection ) switch (windDirection.toUpperCase()) {
            case "N":
                icon = new ImageIcon("images/north.png");
                break;
            case "NE":
                icon = new ImageIcon("images/ne.png");
                break;
            case "NNE":
                icon = new ImageIcon("images/ne.png");
                break;
            case "ENE":
                icon = new ImageIcon("images/ne.png");
                break;
            case "E":
                icon = new ImageIcon("images/east.png");
                break;
            case "ESE":
                icon = new ImageIcon("images/se.png");
                break;
            case "SE":
                icon = new ImageIcon("images/se.png");
                break;
            case "SSE":
                icon = new ImageIcon("images/se.png");
                break;
            case "S":
                icon = new ImageIcon("images/south.png");
                break;
            case "SSW":
                icon = new ImageIcon("images/sw.png");
                break;    
            case "SW":
                icon = new ImageIcon("images/sw.png");
                break;
            case "WSW":
                icon = new ImageIcon("images/sw.png");
                break;    
            case "W":
                icon = new ImageIcon("images/west.png");
                break;
            case "WNW":
                icon = new ImageIcon("images/nw.png");
                break;
            case "NW":
                icon = new ImageIcon("images/nw.png");
                break;
            case "NNW":
                icon = new ImageIcon("images/nw.png");
                break;    
            default:
                icon = new ImageIcon("images/cold.png");
                break;
        }

        Image image = icon.getImage();
        image = image.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        icon.setImage(image);
        JLabel temperatureLabel = new JLabel();
        temperatureLabel.setIcon( icon );
        dirPanel.add(temperatureLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        
        JLabel header = new JLabel("Wind Direction: " + windDirection);
        header.setFont(new Font("Serif", Font.PLAIN, 20));
        dirPanel.add(header, c);
        
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.NONE;
        
        String degFer = "\u00b0F";
        JLabel chillLabel = new JLabel("Windchill: " + windChill + degFer);
        chillLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        dirPanel.add(chillLabel, c);
        
        return dirPanel;
    }
    /**
     * Creates and manages wind speed and gust values to attach to the
     * corresponding images.
     * @param speed
     * @param gust
     * @return 
     */
    private JPanel createSpeed( String speed, String gust) {
        JPanel speedPanel = new JPanel();
        speedPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.NONE;

        ImageIcon icon;
        if( Float.parseFloat(speed) >= 100 ) {
            icon = new ImageIcon("images/tornado.png");
        }
        else if(Float.parseFloat(speed) >= 50) {
            icon = new ImageIcon("images/strong.png");
        }
        else if(Float.parseFloat(speed) >= 30) {
            icon = new ImageIcon("images/some.png");
        }
        else if(Float.parseFloat(speed) >= 10) {
            icon = new ImageIcon("images/weak.png");
        }
        else if(Float.parseFloat(speed) >= 0) {
            icon = new ImageIcon("images/none.png");
        }
        else {
            icon = new ImageIcon();
        }

        Image image = icon.getImage();
        image = image.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        icon.setImage(image);
        JLabel temperatureLabel = new JLabel();
        temperatureLabel.setIcon( icon );
        speedPanel.add(temperatureLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        
        String mph = "mph";
        JLabel header = new JLabel("Wind Speed: " + speed + mph);
        header.setFont(new Font("Serif", Font.PLAIN, 20));
        speedPanel.add(header, c);
        
        c.gridx = 0;
        c.gridy = 2;
        
        JLabel gustHeader = new JLabel("Wind Gust: " + gust + mph);
        gustHeader.setFont(new Font("Serif", Font.PLAIN, 20));
        speedPanel.add(gustHeader, c);
        
        return speedPanel;
    }
    /**
     * Creates and manages rainfall and humidity values to attach to the
     * corresponding images.
     * @param rainfall
     * @param humidity
     * @return 
     */
    private JPanel createRainfall( String rainfall, String humidity) {
        JPanel rainPanel = new JPanel();
        rainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.NONE;

        ImageIcon icon;
        if( Float.parseFloat(rainfall) >= 30 ) {
            icon = new ImageIcon("images/superheavyrain.png");
        }
        else if(Float.parseFloat(rainfall) >= 20) {
            icon = new ImageIcon("images/heavyrain.png");
        }
        else if(Float.parseFloat(rainfall) >= 5) {
            icon = new ImageIcon("images/somerain.png");
        }
        else if(Float.parseFloat(rainfall) < 5) {
            icon = new ImageIcon("images/norain.png");
        }
        else {
            icon = new ImageIcon();
        }

        Image image = icon.getImage();
        image = image.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        icon.setImage(image);
        JLabel temperatureLabel = new JLabel();
        temperatureLabel.setIcon( icon );
        rainPanel.add(temperatureLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        
        String in = "in";
        JLabel header = new JLabel("Rainfall: " + rainfall + in);
        header.setFont(new Font("Serif", Font.PLAIN, 20));
        rainPanel.add(header, c);
        
        c.gridx = 0;
        c.gridy = 2;
        c.fill = GridBagConstraints.NONE;
        
        JLabel humidityLabel = new JLabel("Humidity: " + humidity + "%");
        humidityLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        rainPanel.add(humidityLabel, c);
        
        return rainPanel;
    }
    /**
     * Creates and manages pressure and UV index values to attach to the
     * corresponding images.
     * @param pressure
     * @param uvIndex
     * @return 
     */
    private JPanel createPressure( String pressure, String uvIndex) {
        JPanel pressurePanel = new JPanel();
        pressurePanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.NONE;

        ImageIcon icon;
        if( Float.parseFloat(pressure) >= 30 ) {
            icon = new ImageIcon("images/highweight.png");
        }
        else if(Float.parseFloat(pressure) >= 25) {
            icon = new ImageIcon("images/normalweight.png");
        }
        else if(Float.parseFloat(pressure) >= 10) {
            icon = new ImageIcon("images/mountainweight.png");
        }
        else if(Float.parseFloat(pressure) < 10) {
            icon = new ImageIcon("images/everestweight.png");
        }
        else {
            icon = new ImageIcon();
        }

        Image image = icon.getImage();
        image = image.getScaledInstance(175, 175, Image.SCALE_SMOOTH);
        icon.setImage(image);
        JLabel temperatureLabel = new JLabel();
        temperatureLabel.setIcon( icon );
        pressurePanel.add(temperatureLabel, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.NONE;
        
        String in = "in";
        JLabel header = new JLabel("Pressure: " + pressure + in);
        header.setFont(new Font("Serif", Font.PLAIN, 20));
        pressurePanel.add(header, c);
        
        c.gridx = 0;
        c.gridy = 2;
        
        JLabel uvLabel = new JLabel("UV Index: " + uvIndex);
        uvLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        pressurePanel.add(uvLabel, c);
        
        return pressurePanel;
    }
}
