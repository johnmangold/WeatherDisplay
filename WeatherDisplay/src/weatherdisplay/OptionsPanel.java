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
        
        WeatherDisplay.wg.createSmallerDataset("Daily", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetDaily, "Day", "Temperature")));
        
        WeatherDisplay.wg.createSmallerDataset("Weekly", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetWeekly, "Week", "Temperature")));
        
        WeatherDisplay.wg.createSmallerDataset("Monthly", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetMonthly, "Month", "Temperature")));
        
        WeatherDisplay.wg.createSmallerDataset("Yearly", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetYearly, "Year", "Temperature")));
        
        /*DataPane.addChangeListener((ChangeEvent e) -> {
            String currentTab = "Weekly";
            System.out.println(currentTab);
            switch( currentTab ) {
                case "Daily":
                    WeatherDisplay.wds.clearDataset();
                    WeatherDisplay.wg.createSmallerDataset("Daily", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
                    DataPane.removeAll();
                    DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Day", "Temperature")));
                    DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Week", "Temperature")));
                    DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Month", "Temperature")));
                    DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDataset, "Year", "Temperature")));
                    DataPane.validate();
                    break;
                case "Weekly":
                    WeatherDisplay.wds.clearDataset();
                    WeatherDisplay.wg.createSmallerDataset("Weekly", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
                    DataPane.removeAll();
                    DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDataset, "Day", "Humidity")));
                    DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDataset, "Week", "Humidity")));
                    DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDataset, "Month", "Humidity")));
                    DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDataset, "Year", "Humidity")));
                    DataPane.validate();
                    break;
                case "Monthly":
                    WeatherDisplay.wds.clearDataset();
                    WeatherDisplay.wg.createSmallerDataset("Monthly", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
                    DataPane.removeAll();
                    DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDataset, "Day", "Barometer")));
                    DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDataset, "Week", "Barometer")));
                    DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDataset, "Month", "Barometer")));
                    DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDataset, "Year", "Barometer")));
                    DataPane.validate();
                    break;
                case "Yearly":
                    WeatherDisplay.wds.clearDataset();
                    WeatherDisplay.wg.createSmallerDataset("Yearly", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
                    DataPane.removeAll();
                    DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDataset, "Day", "Wind Speed")));
                    DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDataset, "Week", "Wind Speed")));
                    DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDataset, "Month", "Wind Speed")));
                    DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDataset, "Year", "Wind Speed")));
                    DataPane.validate();
                    break;
            }
        });*/

         DataFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int selectedPane = DataPane.getSelectedIndex();
                switch( DataFields.getSelectedItem().toString()) {
                    case "Temperature":
                        DataPane.removeAll();
                        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetDaily, "Day", "Temperature")));
                        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetWeekly, "Week", "Temperature")));
                        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetMonthly, "Month", "Temperature")));
                        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetYearly, "Year", "Temperature")));
                        DataPane.setSelectedIndex(selectedPane);
                        DataPane.validate();
                        break;
                    case "Humidity":
                        DataPane.removeAll();
                        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDatasetDaily, "Day", "Humidity")));
                        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDatasetWeekly, "Week", "Humidity")));
                        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDatasetMonthly, "Month", "Humidity")));
                        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDatasetYearly, "Year", "Humidity")));
                        DataPane.setSelectedIndex(selectedPane);
                        DataPane.validate();
                        break;
                    case "Barometer":
                        DataPane.removeAll();
                        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDatasetDaily, "Day", "Barometer")));
                        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDatasetWeekly, "Week", "Barometer")));
                        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDatasetMonthly, "Month", "Barometer")));
                        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDatasetYearly, "Year", "Barometer")));
                        DataPane.setSelectedIndex(selectedPane);
                        DataPane.validate();
                        break;
                    case "Wind Speed":
                        DataPane.removeAll();
                        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDatasetDaily, "Day", "Wind Speed")));
                        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDatasetWeekly, "Week", "Wind Speed")));
                        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDatasetMonthly, "Month", "Wind Speed")));
                        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDatasetYearly, "Year", "Wind Speed")));
                        DataPane.setSelectedIndex(selectedPane);
                        DataPane.validate();
                        break;
                    case "UV Index":
                        DataPane.removeAll();
                        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDatasetDaily, "Day", "UV Index")));
                        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDatasetWeekly, "Week", "UV Index")));
                        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDatasetMonthly, "Month", "UV Index")));
                        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDatasetYearly, "Year", "UV Index")));
                        DataPane.setSelectedIndex(selectedPane);
                        DataPane.validate();
                        break;
                    case "Rainfall":
                        DataPane.removeAll();
                        DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDatasetDaily, "Day", "Rainfall")));
                        DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDatasetWeekly, "Week", "Rainfall")));
                        DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDatasetMonthly, "Month", "Rainfall")));
                        DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDatasetYearly, "Year", "Rainfall")));
                        DataPane.setSelectedIndex(selectedPane);
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
     
        String category = DataFields.getSelectedItem().toString();
        String title = DataPane.getTitleAt(DataPane.getSelectedIndex());
        int selectedPane = DataPane.getSelectedIndex();
        switch (title) {
            case "Daily":
                WeatherDisplay.day += 1;
                WeatherDisplay.wds.clearDataset("Daily");
                WeatherDisplay.wg.createSmallerDataset("Daily", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
                break;
            case "Weekly":
                WeatherDisplay.week += 1;
                WeatherDisplay.wds.clearDataset("Weekly");
                WeatherDisplay.wg.createSmallerDataset("Weekly", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
                break;
            case "Monthly":
                WeatherDisplay.month += 1;
                WeatherDisplay.wds.clearDataset("Monthly");
                WeatherDisplay.wg.createSmallerDataset("Monthly", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
                break;
            case "Yearly":
                WeatherDisplay.year += 1;
                WeatherDisplay.wds.clearDataset("Yearly");
                WeatherDisplay.wg.createSmallerDataset("Yearly", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
                break;
        }
        
        switch( category) {
            case "Temperature":
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetDaily, "Day", "Temperature")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetWeekly, "Week", "Temperature")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetMonthly, "Month", "Temperature")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetYearly, "Year", "Temperature")));
                DataPane.setSelectedIndex(selectedPane);
                DataPane.validate();
                break;
            case "Humidity":
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDatasetDaily, "Day", "Humidity")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDatasetWeekly, "Week", "Humidity")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDatasetMonthly, "Month", "Humidity")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDatasetYearly, "Year", "Humidity")));
                DataPane.setSelectedIndex(selectedPane);
                DataPane.validate();
                break;
            case "Barometer":
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDatasetDaily, "Day", "Barometer")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDatasetWeekly, "Week", "Barometer")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDatasetMonthly, "Month", "Barometer")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDatasetYearly, "Year", "Barometer")));
                DataPane.setSelectedIndex(selectedPane);
                DataPane.validate();
                break;
            case "Wind Speed":
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDatasetDaily, "Day", "Wind Speed")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDatasetWeekly, "Week", "Wind Speed")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDatasetMonthly, "Month", "Wind Speed")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDatasetYearly, "Year", "Wind Speed")));
                DataPane.setSelectedIndex(selectedPane);
                DataPane.validate();
                break;
            case "UV Index":
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDatasetDaily, "Day", "UV Index")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDatasetWeekly, "Week", "UV Index")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDatasetMonthly, "Month", "UV Index")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDatasetYearly, "Year", "UV Index")));
                DataPane.setSelectedIndex(selectedPane);
                DataPane.validate();
                break;
            case "Rainfall":
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDatasetDaily, "Day", "Rainfall")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDatasetWeekly, "Week", "Rainfall")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDatasetMonthly, "Month", "Rainfall")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDatasetYearly, "Year", "Rainfall")));
                DataPane.setSelectedIndex(selectedPane);
                DataPane.validate();
                break;
        }
    } 
      
    private void PrevDataActionPerformed(java.awt.event.ActionEvent evt) {
        String category = DataFields.getSelectedItem().toString();
        String title = DataPane.getTitleAt(DataPane.getSelectedIndex());
        int selectedPane = DataPane.getSelectedIndex();
        switch (title) {
            case "Daily":
                WeatherDisplay.day -= 1;
                WeatherDisplay.wds.clearDataset("Daily");
                WeatherDisplay.wg.createSmallerDataset("Daily", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
                break;
            case "Weekly":
                WeatherDisplay.week -= 1;
                WeatherDisplay.wds.clearDataset("Weekly");
                WeatherDisplay.wg.createSmallerDataset("Weekly", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
                break;
            case "Monthly":
                WeatherDisplay.month -= 1;
                WeatherDisplay.wds.clearDataset("Monthly");
                WeatherDisplay.wg.createSmallerDataset("Monthly", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
                break;
            case "Yearly":
                WeatherDisplay.year -= 1;
                WeatherDisplay.wds.clearDataset("Yearly");
                WeatherDisplay.wg.createSmallerDataset("Yearly", WeatherDisplay.day, WeatherDisplay.month, WeatherDisplay.year);
                break;
        }
        
        switch( category) {
            case "Temperature":
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetDaily, "Day", "Temperature")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetWeekly, "Week", "Temperature")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetMonthly, "Month", "Temperature")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.temperatureDatasetYearly, "Year", "Temperature")));
                DataPane.setSelectedIndex(selectedPane);
                DataPane.validate();
                break;
            case "Humidity":
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDatasetDaily, "Day", "Humidity")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDatasetWeekly, "Week", "Humidity")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDatasetMonthly, "Month", "Humidity")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.humidityDatasetYearly, "Year", "Humidity")));
                DataPane.setSelectedIndex(selectedPane);
                DataPane.validate();
                break;
            case "Barometer":
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDatasetDaily, "Day", "Barometer")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDatasetWeekly, "Week", "Barometer")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDatasetMonthly, "Month", "Barometer")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.barometricDatasetYearly, "Year", "Barometer")));
                DataPane.setSelectedIndex(selectedPane);
                DataPane.validate();
                break;
            case "Wind Speed":
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDatasetDaily, "Day", "Wind Speed")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDatasetWeekly, "Week", "Wind Speed")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDatasetMonthly, "Month", "Wind Speed")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.windspeedDatasetYearly, "Year", "Wind Speed")));
                DataPane.setSelectedIndex(selectedPane);
                DataPane.validate();
                break;
            case "UV Index":
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDatasetDaily, "Day", "UV Index")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDatasetWeekly, "Week", "UV Index")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDatasetMonthly, "Month", "UV Index")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.uvIndexDatasetYearly, "Year", "UV Index")));
                DataPane.setSelectedIndex(selectedPane);
                DataPane.validate();
                break;
            case "Rainfall":
                DataPane.removeAll();
                DataPane.addTab("Daily", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDatasetDaily, "Day", "Rainfall")));
                DataPane.addTab("Weekly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDatasetWeekly, "Week", "Rainfall")));
                DataPane.addTab("Monthly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDatasetMonthly, "Month", "Rainfall")));
                DataPane.addTab("Yearly", new JPanel().add(WeatherDisplay.wds.createChartFromDataset(WeatherDisplay.wds.rainfallDatasetYearly, "Year", "Rainfall")));
                DataPane.setSelectedIndex(selectedPane);
                DataPane.validate();
                break;
        }
    } 

    // Variables declaration - do not modify                     
   // private WeatherGraph DailyTab;
    public static javax.swing.JComboBox DataFields;
    public static javax.swing.JTabbedPane DataPane;
    private javax.swing.JButton NextData;
    private javax.swing.JButton PrevData;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}

