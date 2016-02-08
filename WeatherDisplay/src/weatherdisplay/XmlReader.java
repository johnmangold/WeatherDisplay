/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author 1018560
 */
public class XmlReader {
    String filename;
    List<Weather> weatherList;
    
    public XmlReader(String xmlFilename) {
        this.filename = xmlFilename;
        this.weatherList = new ArrayList<>();
    }
    
    private void read() throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(ClassLoader.getSystemResourceAsStream("xml/"+filename));
        
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        
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
                weatherList.add(weather);
            }
        }
    }
}

class Weather {
    String date;
    String time;
    String temperature;
    String humidity;
    String barometer;
    String windspeed;
    String winddirection;
    String windgust;
    String windchill;
    String heatindex;
    String uvindex;
    String rainfall;
}
