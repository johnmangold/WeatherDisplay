/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import javax.swing.*;

/**
 *
 * @author 1018560
 */
public class DisplaysPanel extends JPanel {
    public static java.util.List< java.util.List<Weather> > data;

    public DisplaysPanel() {
        initialize();
    }
    
    private void initialize() {
        this.add(new DisplayItems());
    }
}
