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
        WeatherGraph DailyTab = new WeatherGraph();
        WeatherGraph WeeklyTab = new WeatherGraph();
        WeatherGraph MonthlyTab = new WeatherGraph();
        WeatherGraph YearlyTab = new WeatherGraph();
        DataFields = new javax.swing.JComboBox();
        NextData = new javax.swing.JButton();
        PrevData = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        DataPane.addTab("Daily", DailyTab);
        DataPane.addTab("Weekly", WeeklyTab);
        DataPane.addTab("Monthly", MonthlyTab);
        DataPane.addTab("Yearly", YearlyTab);

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
    
    private void DataFieldsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int value = DataFields.getSelectedIndex();
        
        switch (value)
        {
            case 0:
                //graph temp
                WeatherDisplay.dataOption = "Temperature";
                //WeatherGraph.WeatherGraph();
                break;
            case 1:
                //graph humidity
                WeatherDisplay.dataOption = "Humidity";
                //WeatherGraph.WeatherGraph();
                break;
            case 2: //graph barometer
                WeatherDisplay.dataOption = "Barometer";
                //WeatherGraph.WeatherGraph();
                break;
            case 3: //graph wind speed
                WeatherDisplay.dataOption = "Wind Speed";
                //WeatherGraph.WeatherGraph();
                break;
            case 4: //grpah UV Index
                WeatherDisplay.dataOption = "UV Index";
                //WeatherGraph.WeatherGraph();
                break;
            case 5: //graph rainfall
                WeatherDisplay.dataOption = "Rainfall";
                //WeatherGraph.WeatherGraph();
                break;
        }
    }
      
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
    private javax.swing.JComboBox DataFields;
    private javax.swing.JTabbedPane DataPane;
    private javax.swing.JButton NextData;
    private javax.swing.JButton PrevData;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
}

