/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author 1018560
 */
public class OptionsPanel extends JPanel {

    public OptionsPanel() {
        initComponents();
    }
    
    private void initComponents() {
        DataPane = new javax.swing.JTabbedPane();
        WeatherGraph DailyTab = new WeatherGraph("Day");
        WeatherGraph WeeklyTab = new WeatherGraph("Week");
        WeatherGraph MonthlyTab = new WeatherGraph("Month");
        WeatherGraph YearlyTab = new WeatherGraph("Year");
        average = new javax.swing.JRadioButton();
        MinMax = new javax.swing.JRadioButton();
        DataFields = new javax.swing.JComboBox();
        NextData = new javax.swing.JButton();
        PrevData = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ButtonGroup group = new ButtonGroup();

        DataPane.addTab("Daily", DailyTab);
        DataPane.addTab("Weekly", WeeklyTab);
        DataPane.addTab("Monthly", MonthlyTab);
        DataPane.addTab("Yearly", YearlyTab);

        average.setText("Average");
        average.setToolTipText("Show Average of Data");
        average.setSelected(true);
        group.add (average);
        average.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                averageActionPerformed(evt);
            }
        });

        MinMax.setText("Min/Max");
        MinMax.setToolTipText("Show Min/Max of Data");
        group.add(MinMax);
        MinMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinMaxActionPerformed(evt);
            }
        });

        DataFields.setMaximumRowCount(10);
        DataFields.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Temperature", "Humidity", "Barometer", "Wind Speed", "UV Index", "Rainfall" }));
        DataFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataFieldsActionPerformed(evt);
            }
        });
        
        jLabel1.setText("Choose Data Field to Display");
        
        NextData.setText("Next");
        NextData.setToolTipText("View Next Data Set");
        NextData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NextDataActionPerformed(evt);
            }
        });

        PrevData.setText("Previous");
        PrevData.setToolTipText("View Previous Data Set");
        PrevData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrevDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(average)
                                .addGap(18, 18, 18)
                                .addComponent(MinMax))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(DataFields, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel1))))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PrevData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NextData)
                        .addGap(26, 26, 26)))
                .addComponent(DataPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DataPane)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DataFields, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MinMax)
                    .addComponent(average))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NextData)
                    .addComponent(PrevData))
                .addContainerGap(192, Short.MAX_VALUE))
        );
    }// </editor-fold>                        
    
     private void DataFieldsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int value = DataFields.getSelectedIndex();
         
        switch (value)
        {
            case 0:
                //graph temp
                break;
            case 1:
                //graph humidity
                break;
            case 2: //graph barometer
                break;
            case 3: //graph wind speed
                break;
            case 4: //grpah UV Index
                break;
            case 5: //graph rainfall
                break;
        }
    }
     
     private void averageActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        //average the selected data type(s)
    }
     
      private void MinMaxActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        //find min/max of selected data type(s)
    }
      
      private void NextDataActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        //go to next data set
        //check for end of set
    } 
      
      private void PrevDataActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        //go to prev data set
          //check for beg of set
    } 

    // Variables declaration - do not modify                     
    private WeatherGraph DailyTab;
    private javax.swing.JComboBox DataFields;
    private javax.swing.JTabbedPane DataPane;
    private javax.swing.JRadioButton MinMax;
    private javax.swing.JButton NextData;
    private javax.swing.JButton PrevData;
    private WeatherGraph MonthlyTab;
    private WeatherGraph WeeklyTab;
    private WeatherGraph YearlyTab;
    private javax.swing.JRadioButton average;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}

