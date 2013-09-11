/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jefferson
 */
public class FabricaDispositivos {
    
    Dispositivo dispositivo = null;
    
    public Dispositivo criarDispositivo(String tipoDisp) {
        
        switch (tipoDisp.toLowerCase()) {
            case "Notebook": dispositivo = new Notebook();
            case "PC": dispositivo = new PC();
            case "Tablet": dispositivo = new Tablet();
            case "Smartphone": dispositivo = new Smartphone();
            default: try {
                        throw new Exception();
                     } catch (Exception ex) {
                        Logger.getLogger(FabricaDispositivos.class.getName()).log(Level.SEVERE, null, ex);
                     }
        }
        
        return dispositivo;
    }
    
    public Dispositivo getDispositivo(String tipoDisp) {
        
        return dispositivo;
    }
}
