/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.Timer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 *
 * @author Joseph Mowry
 */
public class ChartPanel extends JPanel {
    
    public ChartPanel(){
        createChartPanel();
    }
    
    private void createChartPanel(){
        
        final XYSeries series = new XYSeries("Data");

        for(int i = 0; i < 50; i++){
            series.add(i, new Random().nextInt(1000));
        }
    
        XYSeriesCollection dataset = new XYSeriesCollection(series);
        new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                series.add(series.getItemCount(), new Random().nextInt(1000));
            }
        }).start();
        
        JFreeChart chart = ChartFactory.createXYLineChart("Test", "Domain",
            "Range", dataset, PlotOrientation.VERTICAL, false, false, false);
        
        
    }
}
