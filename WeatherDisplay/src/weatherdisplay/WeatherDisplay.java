/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import javax.swing.*;
import java.awt.FlowLayout;

/**
 *
 * @author 1018560
 */
public class WeatherDisplay {

    /**
     * @param args the command line arguments
     */
    
    private static void createAndShowGui()
    {
        JFrame frame = new JFrame("Weather Information");
        frame.setJMenuBar(new MenuBar());
        frame.setLayout(new FlowLayout());
        
        frame.pack();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        SwingUtilities.invokeLater(() -> {
            createAndShowGui();
        });
    }
    
}
