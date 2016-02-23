/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import javax.swing.*;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author 1018560
 */
public class WeatherDisplay {

    /**
     * @param args the command line arguments
     */
    private static Map<String, List<Weather>> allWeather;
    private static final File main = new File("xml/");
    private static final File[] listOfFiles = main.listFiles();
    
    private static void createAndShowGui()
    {
        JFrame frame = new JFrame("Weather Information");
        frame.setJMenuBar(new MenuBar());
        frame.setLayout(new FlowLayout());
        frame.setContentPane(new WeatherGraph());
        
        frame.pack();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    
    private static void readDirXml() throws ParserConfigurationException, SAXException, IOException {
        XmlReader reader = new XmlReader(listOfFiles);
        allWeather = reader.allWeather;
    }
    
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            readDirXml();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(WeatherDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
    
}
