/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherdisplay;

import java.io.File;

/**
 *
 * @author 1018560
 */
public class XmlReader {
    File file = null;
    String filename;
    
    public XmlReader(String xmlFilename) {
        this.filename = xmlFilename;
    }
}
