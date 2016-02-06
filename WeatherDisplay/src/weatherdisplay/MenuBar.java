/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author 1018560
 */
public class MenuBar extends JMenuBar {
    
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
        
        file.add(openMenuItem);
        file.add(exitMenuItem);
        
        JMenu help = new JMenu("Help");
        help.setMnemonic(KeyEvent.VK_H);
        
        JMenuItem instructionsMenuItem = new JMenuItem("Instructions");
        instructionsMenuItem.setMnemonic(KeyEvent.VK_H);
        
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setMnemonic(KeyEvent.VK_A);
        aboutMenuItem.setToolTipText("Information about the developers");
        
        JMenuItem zackMenuItem = new JMenuItem("Zack Morris");
        zackMenuItem.setMnemonic(KeyEvent.VK_Z);
        zackMenuItem.setToolTipText("Zack Morris needs no tool tip");
        zackMenuItem.addActionListener((ActionEvent event) -> {
            BufferedImage image = null;
            try {
                image = ImageIO.read(new File("./images/zms.jpg"));
            } catch (IOException ex) {
                Logger.getLogger(MenuBar.class.getName()).log(Level.SEVERE, null, ex);
            }
            JLabel picLabel = new JLabel(new ImageIcon(image));
            JOptionPane.showMessageDialog(null, picLabel, "Zack Attack!!!", JOptionPane.PLAIN_MESSAGE, null);
        });
        
        help.add(instructionsMenuItem);
        help.add(aboutMenuItem);
        help.add(zackMenuItem);
        
        this.add(file);
        this.add(help);
    }
    
}
