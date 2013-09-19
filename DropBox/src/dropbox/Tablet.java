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
public class Tablet extends Dispositivo {

    public Tablet(String path) {
		super(path);
	}
    
    public void update(Observable o, Object arg) {
		System.out.println("Tablet: ");

		try {
			sincronizaArquivo(arg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}
