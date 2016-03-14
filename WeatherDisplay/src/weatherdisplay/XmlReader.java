/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Handles the reading and storing of XML data into an allWeather object for
 * future handling.
 * @authors Allison Bodvig, John Mangold, Joseph Mowry
 */
public class XmlReader {
    List< List<Weather> > allWeather = new ArrayList();
    
    public XmlReader() {
        
    }
    /**
     * Takes the given files and extracts the data into an allWeather object.
     * @param fileList
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws ParseException 
     */
    public XmlReader(File[] fileList) throws ParserConfigurationException, SAXException, IOException, ParseException {
        for (File file : fileList) {
            if(file.toString().endsWith(".xml") || file.toString().endsWith(".XML")) {
                if( !file.toString().endsWith("ild.xml") ) {
                    allWeather.add(this.read(file.toString()));
                }
            }
        }
    }
    /**
     * Takes a given file and extracts the data into an allWeather object.
     * @param file
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws ParseException 
     */
    public XmlReader(File file) throws ParserConfigurationException, SAXException, IOException, ParseException {
        allWeather.add(this.read(file.toString()));
    }
    /**
     * Handles the actual cycling of XML files and appending them into lists,
     * returning the data as a list of weather objects.
     * @param filename
     * @return
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @throws ParseException 
     */
    protected List<Weather> read(String filename) throws ParserConfigurationException, SAXException, IOException, ParseException {
        List<Weather> weatherList = new ArrayList();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new FileInputStream(filename));
        
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        
        Boolean first = true;
        for(int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if( node instanceof Element ) {
                Weather weather = new Weather();
                
                NodeList childNodes = node.getChildNodes();
                for( int j = 0; j < childNodes.getLength(); j++ ) {
                    Node childNode = childNodes.item(j);
                    
                    if( childNode instanceof Element ) {
                        String content = childNode.getLastChild().getTextContent().trim();
                        switch( childNode.getNodeName() ) {
                            case "date":
                                weather.date = content;
                                break;
                            case "time":
                                weather.time = content;
                                break;
                            case "temperature":
                                weather.temperature = content;
                                break;
                            case "humidity":
                                weather.humidity = content;
                                break;
                            case "barometer":
                                weather.barometer = content;
                                break;
                            case "windspeed":
                                weather.windspeed = content;
                                break;
                            case "winddirection":
                                weather.winddirection = content;
                                break;
                            case "windgust":
                                weather.windgust = content;
                                break;
                            case "windchill":
                                weather.windchill = content;
                                break;
                            case "heatindex":
                                weather.heatindex = content;
                                break;
                            case "uvindex":
                                weather.uvindex = content;
                                break;
                            case "rainfall":
                                weather.rainfall = content;
                                break;
                        }
                    }
                }
                weather.dateTime = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy", Locale.US);
                weather.dateTime.setTime(sdf.parse(weather.date));
                weatherList.add(weather);
            }
        }
        return weatherList;
    }
}