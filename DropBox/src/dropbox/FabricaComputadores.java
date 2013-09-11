/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;


/**
 *
 * @author Jefferson
 */
public class FabricaComputadores extends FabricaDispositivos {

    public Dispositivo getDispositivo(String tipoDisp) throws Exception {
    	switch (tipoDisp.toLowerCase()) {
        	case "notebook": return new Notebook("path");
	        case "pc": return new PC("path");
	        default: throw new Exception("A classe " + tipoDisp + " não existe.");
	    }
    }
    
}
