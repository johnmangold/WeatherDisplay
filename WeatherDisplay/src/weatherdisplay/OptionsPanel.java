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
public class OptionsPanel extends JPanel {

    public OptionsPanel() {
        initComponents();
    }
    
    private void initComponents() {
        DataPane = new javax.swing.JTabbedPane();
        DailyTab = new javax.swing.JTabbedPane();
        WeeklyTab = new javax.swing.JTabbedPane();
        MonthlyTab = new javax.swing.JTabbedPane();
        YearlyTab = new javax.swing.JTabbedPane();
        average = new javax.swing.JRadioButton();
        MinMax = new javax.swing.JRadioButton();
        DataFields = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        ButtonGroup group = new ButtonGroup();

        DataPane.addTab("Daily", new WeatherGraph());
        DataPane.addTab("Weekly", new WeatherGraph());
        DataPane.addTab("Monthly", new WeatherGraph());
        DataPane.addTab("Yearly", new WeatherGraph());

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
        MinMax.setToolTipText("Show MIn/Max of Data");
        group.add(MinMax);
        MinMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinMaxActionPerformed(evt);
            }
        });

        DataFields.setMaximumRowCount(10);
        DataFields.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Temperature", "Humidity", "Barometer", "Wind Speed", "Wind Direction", "Wind Gust", "Wind Chill", "Heat Index", "UV Index", "Rainfall" }));
        DataFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataFieldsActionPerformed(evt);
            }
        });
        
        jLabel1.setText("Choose Data Field to Display");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
                .addGap(19, 19, 19)
                .addComponent(DataPane, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
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
                .addContainerGap(233, Short.MAX_VALUE))
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
            case 4: //graph wind direction
                break;
            case 5: // graph wind gust
                break;
            case 6: //graph wind chill
                break;
            case 7: //graph Heat Index
                break;
            case 8: //grpah UV Index
                break;
            case 9: //graph rainfall
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

    // Variables declaration - do not modify                     
    private javax.swing.JTabbedPane DailyTab;
    private javax.swing.JComboBox DataFields;
    private javax.swing.JTabbedPane DataPane;
    private javax.swing.JRadioButton MinMax;
    private javax.swing.JTabbedPane MonthlyTab;
    private javax.swing.JTabbedPane WeeklyTab;
    private javax.swing.JTabbedPane YearlyTab;
    private javax.swing.JRadioButton average;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}

