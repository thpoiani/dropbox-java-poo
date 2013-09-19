/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

import java.io.IOException;
import java.util.Observable;

/**
 *
 * @author Jefferson
 */
public class Notebook extends Dispositivo {

	public Notebook(String path) {
		super(path);
	}
	
    public void update(Observable o, Object arg) {
		try {
			sincronizaArquivo(arg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
