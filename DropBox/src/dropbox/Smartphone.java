/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

import java.io.File;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Jefferson
 */
public class Smartphone extends Dispositivo {
    
    private ArrayList<File> fileList = new ArrayList<>();

    public Smartphone(String path) {
    	super(path);
	}

    public void update(Observable o, Object arg) {
        System.out.println(arg);
        fileList = (ArrayList<File>) arg;
    }
    
    
}
