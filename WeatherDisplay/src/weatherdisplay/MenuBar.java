/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.KeyEvent;

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
        
        help.add(instructionsMenuItem);
        help.add(aboutMenuItem);
        
        this.add(file);
        this.add(help);
    }
    
}
