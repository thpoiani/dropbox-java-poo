/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;


/**
 *
 * @author Jefferson
 */
public abstract class FabricaDispositivos {
        
    public abstract Dispositivo getDispositivo(String tipoDisp, String path) throws Exception;
    
}
