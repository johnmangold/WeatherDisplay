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
 * This creates the menubar and its associated components.
 * @authors Allison Bodvig, John Mangold, Joseph Mowry
 */
public class MenuBar extends JMenuBar {
    private File extraFile;
    
    public MenuBar() {
        createMenuBar();
    }
    /**
     * Sets up the menubar components. This also handles various listeners and
     * calculates the data accordingly.
     */
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
            int highwind = 0;
            String winddate = null;
            String highdate = null;
            String lowdate = null;
            
            double windAverage = 0.0;
            double maxWindSpeed = -1.0;
            double totalrain = 0.0;
            String windDir = "";
            int[] dirArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            String temp;
            
            
            switch(OptionsPanel.DataPane.getSelectedIndex()){
                case 0:
                    for (int i = 0; i < WeatherDataset.temperatureDatasetDaily.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.temperatureDatasetDaily.getColumnCount(); j++ ) {
                            tempAverage = tempAverage + doubleValue(WeatherDataset.temperatureDatasetDaily.getValue(i, j));
                            if (doubleValue(WeatherDataset.temperatureDatasetDaily.getValue(i, j)) > highTemp) {
                                highTemp = doubleValue(WeatherDataset.temperatureDatasetDaily.getValue(i, j));
                                highi = i;
                                highj = j;
                            }
                            if (doubleValue(WeatherDataset.temperatureDatasetDaily.getValue(i, j)) < lowTemp) {
                                lowTemp = doubleValue(WeatherDataset.temperatureDatasetDaily.getValue(i, j));
                                lowi = i;
                                lowj = j;
                            }
                        }
                    }
                    
                    lowdate = WeatherDataset.temperatureDatasetDaily.getColumnKey(lowj).toString();
                    highdate = WeatherDataset.temperatureDatasetDaily.getColumnKey(highj).toString();
                               
                    tempAverage = tempAverage / (WeatherDataset.temperatureDatasetDaily.getRowCount() * WeatherDataset.temperatureDatasetDaily.getColumnCount());
            
                    for (int i = 0; i < WeatherDataset.windspeedDatasetDaily.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.windspeedDatasetDaily.getColumnCount(); j++ ) {
                            windAverage = windAverage + doubleValue(WeatherDataset.windspeedDatasetDaily.getValue(i, j));
                        }
                    }
           
                    windAverage = windAverage / (WeatherDataset.windspeedDatasetDaily.getRowCount() * WeatherDataset.windspeedDatasetDaily.getColumnCount());
           
                    //wind gust, find max
                    for (int i = 0; i < WeatherDataset.windgustDatasetDaily.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.windgustDatasetDaily.getColumnCount(); j++ ) {
                            if(doubleValue(WeatherDataset.windgustDatasetDaily.getValue(i,j)) > maxWindSpeed){
                                maxWindSpeed = doubleValue(WeatherDataset.windgustDatasetDaily.getValue(i,j));
                                highwind = j;
                            }
                        }
                    }
                    
                    winddate = WeatherDataset.windgustDatasetDaily.getColumnKey(highwind).toString();
                 
                    
           
                    for (int i = 0; i < WeatherDataset.rainfallDatasetDaily.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.rainfallDatasetDaily.getColumnCount(); j++ ) {
                            totalrain = totalrain + doubleValue(WeatherDataset.rainfallDatasetDaily.getValue(i, j));
                        }
                    }
                    break;
                    
                case 1:
                    for (int i = 0; i < WeatherDataset.temperatureDatasetWeekly.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.temperatureDatasetWeekly.getColumnCount(); j++ ) {
                            tempAverage = tempAverage + doubleValue(WeatherDataset.temperatureDatasetWeekly.getValue(i, j));
                            if (doubleValue(WeatherDataset.temperatureDatasetWeekly.getValue(i, j)) > highTemp) {
                                highTemp = doubleValue(WeatherDataset.temperatureDatasetWeekly.getValue(i, j));
                                highi = i;
                                highj = j;
                            }
                            if (doubleValue(WeatherDataset.temperatureDatasetWeekly.getValue(i, j)) < lowTemp) {
                                lowTemp = doubleValue(WeatherDataset.temperatureDatasetWeekly.getValue(i, j));
                                lowi = i;
                                lowj = j;
                            }
                        }
                    }
           
                    tempAverage = tempAverage / (WeatherDataset.temperatureDatasetWeekly.getRowCount() * WeatherDataset.temperatureDatasetWeekly.getColumnCount());
                    
                    lowdate = WeatherDataset.temperatureDatasetWeekly.getColumnKey(lowj).toString();
                    highdate = WeatherDataset.temperatureDatasetWeekly.getColumnKey(highj).toString();
            
                    for (int i = 0; i < WeatherDataset.windspeedDatasetWeekly.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.windspeedDatasetWeekly.getColumnCount(); j++ ) {
                            windAverage = windAverage + doubleValue(WeatherDataset.windspeedDatasetWeekly.getValue(i, j));
                        }
                    }
           
                    windAverage = windAverage / (WeatherDataset.windspeedDatasetWeekly.getRowCount() * WeatherDataset.windspeedDatasetWeekly.getColumnCount());
           
                    //wind gust, find max
                    for (int i = 0; i < WeatherDataset.windgustDatasetWeekly.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.windgustDatasetWeekly.getColumnCount(); j++ ) {
                            if(doubleValue(WeatherDataset.windgustDatasetWeekly.getValue(i,j)) > maxWindSpeed){
                                maxWindSpeed = doubleValue(WeatherDataset.windgustDatasetWeekly.getValue(i,j));
                                highwind = j;
                            }
                        }
                    }
                    
                    winddate = WeatherDataset.windgustDatasetWeekly.getColumnKey(highwind).toString();
           
                    for (int i = 0; i < WeatherDataset.rainfallDatasetWeekly.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.rainfallDatasetWeekly.getColumnCount(); j++ ) {
                            totalrain = totalrain + doubleValue(WeatherDataset.rainfallDatasetWeekly.getValue(i, j));
                        }
                    }                
                             
                    break;
                    
                case 2:
                    for (int i = 0; i < WeatherDataset.temperatureDatasetMonthly.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.temperatureDatasetMonthly.getColumnCount(); j++ ) {
                            tempAverage = tempAverage + doubleValue(WeatherDataset.temperatureDatasetMonthly.getValue(i, j));
                            if (doubleValue(WeatherDataset.temperatureDatasetMonthly.getValue(i, j)) > highTemp) {
                                highTemp = doubleValue(WeatherDataset.temperatureDatasetMonthly.getValue(i, j));
                                highi = i;
                                highj = j;
                            }
                            if (doubleValue(WeatherDataset.temperatureDatasetMonthly.getValue(i, j)) < lowTemp) {
                                lowTemp = doubleValue(WeatherDataset.temperatureDatasetMonthly.getValue(i, j));
                                lowi = i;
                                lowj = j;
                            }
                        }
                    }
           
                    tempAverage = tempAverage / (WeatherDataset.temperatureDatasetMonthly.getRowCount() * WeatherDataset.temperatureDatasetMonthly.getColumnCount());
                    
                    lowdate = WeatherDataset.temperatureDatasetMonthly.getColumnKey(lowj).toString();
                    highdate = WeatherDataset.temperatureDatasetMonthly.getColumnKey(highj).toString();
                    
                    for (int i = 0; i < WeatherDataset.windspeedDatasetMonthly.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.windspeedDatasetMonthly.getColumnCount(); j++ ) {
                            windAverage = windAverage + doubleValue(WeatherDataset.windspeedDatasetMonthly.getValue(i, j));
                        }
                    }
           
                    windAverage = windAverage / (WeatherDataset.windspeedDatasetMonthly.getRowCount() * WeatherDataset.windspeedDatasetMonthly.getColumnCount());
           
                    //wind gust, find max
                    for (int i = 0; i < WeatherDataset.windgustDatasetMonthly.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.windgustDatasetMonthly.getColumnCount(); j++ ) {
                            if(doubleValue(WeatherDataset.windgustDatasetMonthly.getValue(i,j)) > maxWindSpeed){
                                maxWindSpeed = doubleValue(WeatherDataset.windgustDatasetMonthly.getValue(i,j));
                                highwind = j;
                            }
                        }
                    }
                    
                    winddate = WeatherDataset.windgustDatasetMonthly.getColumnKey(highwind).toString();
           
                    for (int i = 0; i < WeatherDataset.rainfallDatasetMonthly.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.rainfallDatasetMonthly.getColumnCount(); j++ ) {
                            totalrain = totalrain + doubleValue(WeatherDataset.rainfallDatasetMonthly.getValue(i, j));
                        }
                    }

                    break;
                    
                case 3:
                    for (int i = 0; i < WeatherDataset.temperatureDatasetYearly.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.temperatureDatasetYearly.getColumnCount(); j++ ) {
                            tempAverage = tempAverage + doubleValue(WeatherDataset.temperatureDatasetYearly.getValue(i, j));
                            if (doubleValue(WeatherDataset.temperatureDatasetYearly.getValue(i, j)) > highTemp) {
                                highTemp = doubleValue(WeatherDataset.temperatureDatasetYearly.getValue(i, j));
                                highi = i;
                                highj = j;
                            }
                            if (doubleValue(WeatherDataset.temperatureDatasetYearly.getValue(i, j)) < lowTemp) {
                                lowTemp = doubleValue(WeatherDataset.temperatureDatasetYearly.getValue(i, j));
                                lowi = i;
                                lowj = j;
                            }
                        }
                    }
           
                    tempAverage = tempAverage / (WeatherDataset.temperatureDatasetYearly.getRowCount() * WeatherDataset.temperatureDatasetYearly.getColumnCount());
                    
                    lowdate = WeatherDataset.temperatureDatasetYearly.getColumnKey(lowj).toString();
                    highdate = WeatherDataset.temperatureDatasetYearly.getColumnKey(highj).toString();
            
                    for (int i = 0; i < WeatherDataset.windspeedDatasetYearly.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.windspeedDatasetYearly.getColumnCount(); j++ ) {
                            windAverage = windAverage + doubleValue(WeatherDataset.windspeedDatasetYearly.getValue(i, j));
                        }
                    }
           
                    windAverage = windAverage / (WeatherDataset.windspeedDatasetYearly.getRowCount() * WeatherDataset.windspeedDatasetYearly.getColumnCount());
           
                    for (int i = 0; i < WeatherDataset.windgustDatasetYearly.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.windgustDatasetYearly.getColumnCount(); j++ ) {
                            if(doubleValue(WeatherDataset.windgustDatasetYearly.getValue(i,j)) > maxWindSpeed){
                                maxWindSpeed = doubleValue(WeatherDataset.windgustDatasetYearly.getValue(i,j));
                                highwind = j;
                            }
                        }
                    }
                    
                    winddate = WeatherDataset.windgustDatasetYearly.getColumnKey(highwind).toString();
           
                    for (int i = 0; i < WeatherDataset.rainfallDatasetYearly.getRowCount(); i++) {
                        for (int j = 0; j < WeatherDataset.rainfallDatasetYearly.getColumnCount(); j++ ) {
                            totalrain = totalrain + doubleValue(WeatherDataset.rainfallDatasetYearly.getValue(i, j));
                        }
                    }
                    break;
            }
            
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
                    "Average Temperature: " + df.format(tempAverage) + " Farenheit" + 
                    "\n\nHigh Temperature: " + df.format(highTemp) + " Farenheit" +
                    "\nOccured on " + highdate +    
                    "\n\nLow Temperature: " + df.format(lowTemp) +" Farenheit" +
                    "\nOccured on " + lowdate +         
                    "\n\nAverage Wind Speed: " + df.format(windAverage) + " mph" +
                    "\n\nMaximum Wind Gust: " + df.format(maxWindSpeed) + " mph" +
                    "\nOccured on " + winddate +
                    "\n\nTotal Rainfall: " + df.format(totalrain) + " inches" +
                    "\n\nPrevailing Wind Direction: " + windDir +
                    "\n\n",
                    "Statistics", JOptionPane.PLAIN_MESSAGE);
        });
        
        calc.add(statsMenuItem);
        
        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
               
        
        JMenuItem instructionsMenuItem = new JMenuItem("Instructions");
        instructionsMenuItem.setMnemonic(KeyEvent.VK_H);
        instructionsMenuItem.addActionListener((ActionEvent event) -> {
            Component frame = new JFrame();
            JOptionPane.showMessageDialog(frame,
                    "Program Usage:" +
                    "\nUse the combo box to select which data element to display" +
                    "\nClick through the tabs to show different amounts of data" +
                    "\nClicking the Next or Previuos buttons will print the next or previous data set" +
                    "\nGoing to Calculations and clicking statistics will show calculations for the data set that is graphed" +
                    "\nYou may add xml files by choosing File then Open and selecting and xml file"        
                    );
            
        });
        
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setMnemonic(KeyEvent.VK_A);
        aboutMenuItem.setToolTipText("Information about the developers");
        aboutMenuItem.addActionListener((ActionEvent event) -> {
            Component frame = new JFrame();
            JOptionPane.showMessageDialog(frame,
                    "This program was created by John Mangold, Joe Mowry, and Allison Bodvig"        
                    );
            
        });
        
        help.add(instructionsMenuItem);
        help.add(aboutMenuItem);
        
        this.add(file);
        this.add(calc);
        this.add(help);
    }
    
}
