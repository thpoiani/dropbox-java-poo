/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

import java.io.File;
import java.util.Observable;

/**
 *
 * @author Jefferson
 */
public class Servidor extends Observable {
    
    private static Servidor uniServer;
    private String path;

	private Servidor() {}
    
    public static synchronized Servidor getInstance() {        
        if(uniServer == null) {
            uniServer = new Servidor();
        }
        
        return uniServer;
    }

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		File file = new File(path);
		
		if (file.isDirectory()) {
			setChanged();
			notifyObservers(file.listFiles());			
		}
	}
}
