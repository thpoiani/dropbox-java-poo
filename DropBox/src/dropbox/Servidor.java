/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

import java.util.Observable;

/**
 *
 * @author Jefferson
 */
public class Servidor extends Observable{
    
    private static Servidor uniServer;
    
    public static synchronized Servidor getInstance() {        
        if(uniServer == null) {
            uniServer = new Servidor();
        }
        return uniServer;
    }
}
