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
public class PC extends Dispositivo {

    public PC(String path) {
		super(path);
	}

    public void update(Observable o, Object arg) {
        System.out.println(arg);
    }
    
}
