/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author 1018560
 */
public class OptionsPanel extends JPanel {
    
    public OptionsPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel dataLabel = new JLabel("Pick the Data to Graph");
        
        String[] dataOptionsList = {"Temperature", "Humidity", "Barometric Pressure",
            "Wind Speed", "UV Index", "Rainfall"};
        JComboBox dataOptionsBox = new JComboBox(dataOptionsList);
        
        JLabel dataIntervalLabel = new JLabel("Choose a Data Interval");
        
        JRadioButton dailyButton = new JRadioButton("Daily");
        JRadioButton weeklyButton = new JRadioButton("Weekly");
        JRadioButton monthlyButton = new JRadioButton("Monthly");
        JRadioButton yearlyButton = new JRadioButton("Yearly");
        ButtonGroup group = new ButtonGroup();
        group.add(dailyButton);
        group.add(weeklyButton);
        group.add(monthlyButton);
        group.add(yearlyButton);
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout());
        radioPanel.add(dailyButton);
        radioPanel.add(weeklyButton);
        radioPanel.add(monthlyButton);
        radioPanel.add(yearlyButton);
        
        JCheckBox checkbox = new JCheckBox("Snap to the beginning of the data interval");
        checkbox.setSelected(true);
        
        JButton previousButton = new JButton("Previous Data Set");
        JButton nextButton = new JButton("Next Data Set");
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(previousButton);
        buttonPanel.add(nextButton);
        
        this.add(dataLabel);
        this.add(dataOptionsBox);
        this.add(dataIntervalLabel);
        this.add(radioPanel);
        this.add(checkbox);
        this.add(buttonPanel);
    }
}
