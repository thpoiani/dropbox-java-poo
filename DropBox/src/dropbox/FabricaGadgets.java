/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

/**
 *
 * @author Jefferson
 */
public class FabricaGadgets extends FabricaDispositivos {

    public Dispositivo getDispositivo(String tipoDisp) throws Exception {
    	switch (tipoDisp.toLowerCase()) {
	        case "tablet": return new Tablet("path");
	        case "smartphone": return new Smartphone("path");
	        default: throw new Exception("A classe " + tipoDisp + " não existe.");
	    }
    }
    
}
