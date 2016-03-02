/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author 1018560
 */
public class WeatherDisplay {

    public static List< List<Weather> > allWeather;
    private static final File main = new File("./");
    private static final File[] listOfFiles = main.listFiles();
    public static String dataOption = "Temperature";
    public static Boolean freshData = true;
    public static WeatherDataset wds = new WeatherDataset();
    public static WeatherGraph wg;
    public static int day;
    public static int week;
    public static int month;
    public static int year;

    //public static int[] startIndex = new int[2]; //holds the two indexes for the start data point
    //public static int[] endIndex = new int[2]; //holds the two indexes for the end data point
    
    private static void createAndShowGui()
    {
        JFrame frame = new JFrame("Weather Information");
        JPanel options = new OptionsPanel();
        frame.setJMenuBar(new MenuBar());
        frame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        frame.add(options, c);
        
        c.gridx = 0;
        c.gridy = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        frame.add(new DisplaysPanel(), c);
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //add options panel, need to change the location of the panel
        
        frame.setLocation(10, 10);
        frame.setVisible(true);
    }
    
    private static void readDirXml() throws ParserConfigurationException, SAXException, IOException, ParseException {
        XmlReader reader = new XmlReader(listOfFiles);
        allWeather = reader.allWeather;
        day = allWeather.get(0).get(0).dateTime.get(Calendar.DAY_OF_MONTH);
        week = allWeather.get(0).get(0).dateTime.get(Calendar.WEEK_OF_YEAR);
        month = allWeather.get(0).get(0).dateTime.get(Calendar.MONTH);
        year = allWeather.get(0).get(0).dateTime.get(Calendar.YEAR);
        wg = new WeatherGraph("It doesn't matter, it's not going to use it.");
    }
    
    public static void main(String[] args) throws ParseException {
        try {
            readDirXml();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(WeatherDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
    
}
