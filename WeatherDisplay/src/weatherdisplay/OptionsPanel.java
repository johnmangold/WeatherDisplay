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

        DataFields = new javax.swing.JComboBox();
        DataFields.setMaximumRowCount(10);
        DataFields.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Temperature", "Humidity", "Barometer", "Wind Speed", "UV Index", "Rainfall" }));
        DataFields.setSelectedIndex(0);
       
        
        /*WeatherGraph DailyTab = new WeatherGraph("Day");
        WeatherGraph WeeklyTab = new WeatherGraph("Week");
        WeatherGraph MonthlyTab = new WeatherGraph("Month");
        WeatherGraph YearlyTab = new WeatherGraph("Year");*/
        
        NextData = new javax.swing.JButton();
        PrevData = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        //createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Day", "Temperature");
        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Day", "Temperature")));
        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Week", "Temperature")));
        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Month", "Temperature")));
        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Year", "Temperature")));

         DataFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Day", "Temperature")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Week", "Temperature")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Month", "Temperature")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Year", "Temperature")));
                DataPane.validate();
                switch( DataFields.getSelectedItem().toString()) {
                    case "Temperature":
                        DataPane.removeAll();
                        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Day", "Temperature")));
                        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Week", "Temperature")));
                        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Month", "Temperature")));
                        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Year", "Temperature")));
                        DataPane.validate();
                        break;
                    case "Humidity":
                        DataPane.removeAll();
                        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDataset, "Day", "Humidity")));
                        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDataset, "Week", "Humidity")));
                        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDataset, "Month", "Humidity")));
                        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDataset, "Year", "Humidity")));
                        DataPane.validate();
                        break;
                    case "Barometer":
                        DataPane.removeAll();
                        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDataset, "Day", "Barometer")));
                        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDataset, "Week", "Barometer")));
                        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDataset, "Month", "Barometer")));
                        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDataset, "Year", "Barometer")));
                        DataPane.validate();
                        break;
                    case "Wind Speed":
                        DataPane.removeAll();
                        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDataset, "Day", "Wind Speed")));
                        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDataset, "Week", "Wind Speed")));
                        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDataset, "Month", "Wind Speed")));
                        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDataset, "Year", "Wind Speed")));
                        DataPane.validate();
                        break;
                    case "UV Index":
                        DataPane.removeAll();
                        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDataset, "Day", "UV Index")));
                        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDataset, "Week", "UV Index")));
                        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDataset, "Month", "UV Index")));
                        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDataset, "Year", "UV Index")));
                        DataPane.validate();
                        break;
                    case "Rainfall":
                        DataPane.removeAll();
                        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDataset, "Day", "Rainfall")));
                        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDataset, "Week", "Rainfall")));
                        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDataset, "Month", "Rainfall")));
                        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDataset, "Year", "Rainfall")));
                        DataPane.validate();
                        break;
                }
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
                //PrevDataActionPerformed(evt);
                
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
                                .addGap(19, 19, 19)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(DataFields, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(PrevData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NextData)
                                .addGap(26, 26, 26))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                .addComponent(DataPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(DataFields, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PrevData)
                    .addComponent(NextData))
                .addGap(28, 28, 28)
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DataPane)
                .addContainerGap())    
        );
    }// </editor-fold>                        
      
    private void NextDataActionPerformed(java.awt.event.ActionEvent evt) {                                         
     // TODO add your handling code here:
        //go to next data set
        //check for end of set
        String title;
        
        //get the title of the selected tab
        title = DataPane.getTitleAt(DataPane.getSelectedIndex());
        /*****
        switch (title) {
            case "Daily":
                //set start to start + 1 and end to end + 1
                WeatherDisplay.startIndex[1] = WeatherDisplay.startIndex[1] + 1;
                WeatherDisplay.endIndex[1] = WeatherDisplay.startIndex[1];
                //check for end of list, either no more data or go to next month                
                break;
            case "Weekly":
                //set start to end + 1 and start to end + 7
                WeatherDisplay.startIndex[1] = WeatherDisplay.endIndex[1] + 1;
                WeatherDisplay.endIndex[1] = WeatherDisplay.endIndex[1] + 7;
                //check for end of list, either no more data or go to next month 
                break;
            case "Monthly":
                //go forward one list
                WeatherDisplay.startIndex[0] = WeatherDisplay.startIndex[0] + 1;
                WeatherDisplay.endIndex[0] = WeatherDisplay.startIndex[0];
                WeatherDisplay.startIndex[1] = 0;
//                find the last index for the given list
//                WeatherDisplay.endIndex[1] = 
                //check for first list index (ie 0)
                break;
            case "Yearly":
                //set start to end + 1 and start to start + 12
                WeatherDisplay.startIndex[0] = WeatherDisplay.endIndex[1] + 1;
                WeatherDisplay.endIndex[0] = WeatherDisplay.endIndex[1] + 12;
                //check for end of data
                break;
        }  *****/
    } 
      
    private void PrevDataActionPerformed(java.awt.event.ActionEvent evt) {                                         
       // TODO add your handling code here:
        //go to prev data set
        //check for beg of set
          
        String title;
        
        //get the title of the selected tab
        title = DataPane.getTitleAt(DataPane.getSelectedIndex());
        /****
        switch (title) {
            case "Daily":
                //set end to start - 1 and start to end - 1
                WeatherDisplay.startIndex[1] = WeatherDisplay.startIndex[1] - 1;
                WeatherDisplay.endIndex[1] = WeatherDisplay.startIndex[1];
                //check for end of list, either no more data or go back 1 month                
                break;
            case "Weekly":
                //set end to start - 1 and start to start - 7
                WeatherDisplay.endIndex[1] = WeatherDisplay.startIndex[1] - 1;
                WeatherDisplay.startIndex[1] = WeatherDisplay.startIndex[1] - 7;
                //check for end of list, either no more data or go back 1 month 
                break;
            case "Monthly":
                //go back one list
                WeatherDisplay.startIndex[0] = WeatherDisplay.startIndex[0] - 1;
                WeatherDisplay.endIndex[0] = WeatherDisplay.startIndex[0];
                WeatherDisplay.startIndex[1] = 0;
//                find the last index for the given list
//                WeatherDisplay.endIndex[1] = 
                //check for first list index (ie 0)
                break;
            case "Yearly":
                //set end to start - 1 and start to start - 12
                WeatherDisplay.endIndex[1] = WeatherDisplay.startIndex[1] - 1;
                WeatherDisplay.startIndex[1] = WeatherDisplay.startIndex[1] - 12;
                //check for end of list
                break;
        }  ****/
    } 

    // Variables declaration - do not modify                     
   // private WeatherGraph DailyTab;
    public static javax.swing.JComboBox DataFields;
    private javax.swing.JTabbedPane DataPane;
    private javax.swing.JButton NextData;
    private javax.swing.JButton PrevData;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}

