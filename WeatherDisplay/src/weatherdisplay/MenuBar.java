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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
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
            fileChooser.setDialogTitle("Open additional XML file");
            FileNameExtensionFilter filter = new FileNameExtensionFilter("xml files (*.xml)", "xml");
            fileChooser.setFileFilter(filter);
            if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                extraFile = fileChooser.getSelectedFile();
                XmlReader reader = new XmlReader();
                try {
                    WeatherDisplay.allWeather.add(reader.read(extraFile.toString()));
                } catch (ParserConfigurationException | SAXException | IOException ex) {
                    Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        file.add(openMenuItem);
        file.add(exitMenuItem);
        
        JMenu calc = new JMenu("Calculations");
        
        JMenuItem averageMenuItem = new JMenuItem("Average");
        averageMenuItem.setToolTipText("Calculate Average of the Data");
        averageMenuItem.addActionListener((ActionEvent event) -> {
            Component frame = new JFrame();
            //calcuate min and max
            //calculate average for the data that is being graphed
            double average = 0.0;
//            OptionsPanel.CalcAvg();
            JOptionPane.showMessageDialog(frame, "Average: " + average, "Average", JOptionPane.PLAIN_MESSAGE);
           
        });
        
        JMenuItem minMaxMenuItem = new JMenuItem("Min and Max");
        minMaxMenuItem.setToolTipText("Calculate Min and Max of the Data");
        minMaxMenuItem.addActionListener((ActionEvent event) -> {
            Component frame = new JFrame();
            //calculate min and max
            double min = 1000;
            double max = -1000;
            //loop through data that is graphed and find min and max
            JOptionPane.showMessageDialog(frame, "Min: " + min +  "\nMax: " + max, "Min and Max", JOptionPane.PLAIN_MESSAGE);
        });
        
        calc.add(averageMenuItem);
        calc.add(minMaxMenuItem);
        
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
