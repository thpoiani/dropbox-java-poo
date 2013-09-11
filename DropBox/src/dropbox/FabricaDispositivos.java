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
public abstract class FabricaDispositivos {
    
    Dispositivo dispositivo = null;
    
    public Dispositivo criarDispositivo(String tipoDisp) {
        
        switch (tipoDisp.toLowerCase()) {
            case "notebook": dispositivo = new Notebook();
            case "pc": dispositivo = new PC();
            case "tablet": dispositivo = new Tablet();
            case "smartphone": dispositivo = new Smartphone();
            default: try {
                        throw new Exception();
                     } catch (Exception ex) {
                        Logger.getLogger(FabricaDispositivos.class.getName()).log(Level.SEVERE, null, ex);
                     }
        }
        
        return dispositivo;
    }
    
    public abstract Dispositivo getDispositivo(String tipoDisp);
}
