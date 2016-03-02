/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.util.Calendar;

/**
 * The container for all associated weather data for a given record.
 * @authors Allison Bodvig, John Mangold, Joseph Mowry
 */
public class Weather {
    public String date;
    public String time;
    public Calendar dateTime;
    public String temperature;
    public String humidity;
    public String barometer;
    public String windspeed;
    public String winddirection;
    public String windgust;
    public String windchill;
    public String heatindex;
    public String uvindex;
    public String rainfall;
}
