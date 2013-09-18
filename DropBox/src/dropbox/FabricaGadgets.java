/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

import java.io.File;


/**
 *
 * @author Jefferson
 */
public class FabricaGadgets extends FabricaDispositivos {

    public Dispositivo getDispositivo(String tipoDisp, String path) throws Exception {
    	File file = new File(path);
    	if (file.isDirectory()){
	    	switch (tipoDisp.toLowerCase()) {
		        case "tablet": return new Tablet(path);
		        case "smartphone": return new Smartphone(path);
		        default: throw new Exception("A classe " + tipoDisp + " não existe.");
		    }
    	}
    	throw new Exception("O caminho " + path + " não é de uma pasta.");
    }
    
}
