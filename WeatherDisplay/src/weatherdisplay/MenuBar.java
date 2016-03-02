/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import static oracle.jrockit.jfr.events.Bits.doubleValue;
import org.xml.sax.SAXException;

/**
 *
 * @author 1018560
 */
public class MenuBar extends JMenuBar {
    private File extraFile;
    
    public MenuBar() {
        createMenuBar();
    }
    
    private void createMenuBar() {
        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit Application");
        exitMenuItem.addActionListener((ActionEvent event) -> {
            System.exit(0);
        });
        
        JMenuItem openMenuItem = new JMenuItem("Open");
        openMenuItem.setMnemonic(KeyEvent.VK_O);
        openMenuItem.setToolTipText("Open Data File");
        openMenuItem.addActionListener((ActionEvent event) -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Open directory containing XML files");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.setAcceptAllFileFilterUsed(false);
            
            FileNameExtensionFilter filter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
            fileChooser.setFileFilter(filter);
            if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                extraFile = fileChooser.getSelectedFile();
                File[] list = extraFile.listFiles();
                XmlReader reader = new XmlReader();
                try {
                    for(File each : list ) {
                        if(each.toString().endsWith(".xml") || each.toString().endsWith(".XML")) {
                            WeatherDisplay.allWeather.add(reader.read(each.toString()));
                        }
                    }
                } catch (ParserConfigurationException | SAXException | IOException | ParseException ex) {
                    Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        file.add(openMenuItem);
        file.add(exitMenuItem);
        
        JMenu calc = new JMenu("Calculations");
        
        JMenuItem statsMenuItem = new JMenuItem("Statistics");
        statsMenuItem.setToolTipText("Calculate Weather Statistics");
        statsMenuItem.addActionListener((ActionEvent event) -> {
            Component frame = new JFrame();
            DecimalFormat df = new DecimalFormat("#.##");
            df.setRoundingMode(RoundingMode.CEILING);
            
            double tempAverage = 0.0;
            double highTemp = -1000.0;
            double lowTemp = 1000.0;
            int lowi = 0;
            int lowj = 0;
            int highi = 0;
            int highj = 0;
            int count = 0;
            int index = 0;
            double windAverage = 0.0;
            double maxWindSpeed = -1.0;
            String windDate = null;
            String windTime = null;
            double totalrain = 0.0;
            String windDir = "";
            int[] dirArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            
           for (int i = 0; i < WeatherDataset.temperatureDataset.getRowCount(); i++) {
               for (int j = 0; j < WeatherDataset.temperatureDataset.getColumnCount(); j++ ) {
                   tempAverage = tempAverage + doubleValue(WeatherDataset.temperatureDataset.getValue(i, j));
                   if (doubleValue(WeatherDataset.temperatureDataset.getValue(i, j)) > highTemp) {
                       highTemp = doubleValue(WeatherDataset.temperatureDataset.getValue(i, j));
                       highi = i;
                       highj = j;
                   }
                   if (doubleValue(WeatherDataset.temperatureDataset.getValue(i, j)) < lowTemp) {
                       lowTemp = doubleValue(WeatherDataset.temperatureDataset.getValue(i, j));
                       lowi = i;
                       lowj = j;
                   }
               }
           }
           
           tempAverage = tempAverage / (WeatherDataset.temperatureDataset.getRowCount() * WeatherDataset.temperatureDataset.getColumnCount());
            
           for (int i = 0; i < WeatherDataset.windspeedDataset.getRowCount(); i++) {
               for (int j = 0; j < WeatherDataset.windspeedDataset.getColumnCount(); j++ ) {
                   windAverage = windAverage + doubleValue(WeatherDataset.windspeedDataset.getValue(i, j));
               }
           }
           
           windAverage = windAverage / (WeatherDataset.windspeedDataset.getRowCount() * WeatherDataset.windspeedDataset.getColumnCount());
           
           //wind gust, find max
           for(List<Weather> month : WeatherDisplay.allWeather){
            for(Weather record : month){
                if(Double.parseDouble(record.windgust) > maxWindSpeed){
                    maxWindSpeed = Double.parseDouble(record.windgust);
                    windDate = record.date;
                    windTime = record.time;
                }
                
            }
           }
           
           for (int i = 0; i < WeatherDataset.rainfallDataset.getRowCount(); i++) {
               for (int j = 0; j < WeatherDataset.rainfallDataset.getColumnCount(); j++ ) {
                   totalrain = totalrain + doubleValue(WeatherDataset.rainfallDataset.getValue(i, j));
               }
           }

            String temp;
            
            for(List<Weather> month : WeatherDisplay.allWeather){
                for(Weather record : month){ 
                    try{
                    
                        temp = record.winddirection.toUpperCase();
                    }catch(NullPointerException ex){
                        temp = "?";
                    }
                    switch (temp) {
                        case "N":
                            dirArray[0] = dirArray[0] + 1;
                            break;
                        case "NE":
                            dirArray[1] = dirArray[1] + 1;
                            break;
                        case "NNE":
                            dirArray[2] = dirArray[2] + 1;
                            break;
                        case "ENE":
                            dirArray[3] = dirArray[3] + 1;
                            break;
                        case "E":
                            dirArray[4] = dirArray[4] + 1;
                            break;
                        case "ESE":
                            dirArray[5] = dirArray[5] + 1;
                            break;
                        case "SE":
                            dirArray[6] = dirArray[6] + 1;
                            break;
                        case "SSE":
                            dirArray[7] = dirArray[7] + 1;
                            break;
                        case "S":
                            dirArray[8] = dirArray[8] + 1;
                            break;
                        case "SSW":
                            dirArray[9] = dirArray[9] + 1;
                            break;    
                        case "SW":
                            dirArray[10] = dirArray[10] + 1;
                            break;
                        case "WSW":
                            dirArray[11] = dirArray[11] + 1;
                            break;    
                        case "W":
                            dirArray[12] = dirArray[12] + 1;
                            break;
                        case "WNW":
                            dirArray[13] = dirArray[13] + 1;
                            break;
                        case "NW":
                            dirArray[14] = dirArray[14] + 1;
                            break;
                        case "NNW":
                            dirArray[15] = dirArray[15] + 1;
                            break;
                        default:
                            dirArray[16] = dirArray[16] + 1;
                    }
                }
            }
            
            for (int i = 0; i < 17; i++) {
                if (dirArray[i] > count)
                {
                    count = dirArray[i];
                    index = i;
                }
            }
            
            switch (index) {
                case 1:
                    windDir = "N";
                    break;
                case 2:
                    windDir = "NE";
                    break;
                case 3:
                    windDir = "NNE";
                    break;
                case 4:
                    windDir = "ENE";
                    break;
                case 5:
                    windDir = "E";
                    break;
                case 6:
                    windDir = "ESE";
                    break;
                case 7:
                    windDir = "SE";
                    break;
                case 8:
                    windDir = "SSE";
                    break;
                case 9:
                    windDir = "S";
                    break;
                case 10:
                    windDir = "SSW";
                    break;    
                case 11:
                    windDir = "SW";
                    break;
                case 12:
                    windDir = "WSW";
                    break;    
                case 13:
                    windDir = "W";
                    break;
                case 14:
                    windDir = "WNW";
                    break;
                case 15:
                    windDir = "NW";
                    break;
                case 16:
                    windDir = "NNW";
                    break;
                default:
                    windDir = "?";
            }
            
            JOptionPane.showMessageDialog(frame, 
                    "Average Temperature: " + df.format(tempAverage) + 
                    "\n\nHigh Temperature: " + df.format(highTemp) + 
                    "\nOccured on " + WeatherDisplay.allWeather.get(highi).get(highj).date +
                    " at " + WeatherDisplay.allWeather.get(highi).get(highj).time +      
                    "\n\nLow Temperature: " + df.format(lowTemp) +
                    "\nOccured on " + WeatherDisplay.allWeather.get(lowi).get(lowj).date +
                    " at " + WeatherDisplay.allWeather.get(lowi).get(lowj).time +          
                    "\n\nAverage Wind Speed: " + df.format(windAverage) +
                    "\n\nMaximum Wind Gust: " + df.format(maxWindSpeed) +
                    "\nOccured on " + windDate +
                    " at " + windTime + 
                    "\n\nTotal Rainfall: " + df.format(totalrain) +
                    "\n\nPrevailing Wind Direction: " + windDir +
                    "\n\n",
                    "Statistics", JOptionPane.PLAIN_MESSAGE);
        });
        
        calc.add(statsMenuItem);
        
        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        
        JMenuItem instructionsMenuItem = new JMenuItem("Instructions");
        instructionsMenuItem.setMnemonic(KeyEvent.VK_H);
        
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setMnemonic(KeyEvent.VK_A);
        aboutMenuItem.setToolTipText("Information about the developers");
        
        help.add(instructionsMenuItem);
        help.add(aboutMenuItem);
        
        this.add(file);
        this.add(calc);
        this.add(help);
    }
    
}
