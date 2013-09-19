/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

import java.io.File;


/**
 *
 * @author Jefferson
 */
public class DropBox {

    public static void main(String[] args) {
        Servidor servidor = Servidor.getInstance();
        
        // TODO unix directory separator
        // TODO implementar abstract factory
        Dispositivo tablet = fabricarDispositivo("tablet", "C:/Users/Public/Documents/tablet");
        Dispositivo notebook = fabricarDispositivo("notebook", "C:/Users/Public/Documents/notebook");
        Dispositivo smartphone = fabricarDispositivo("smartphone", "C:/Users/Public/Documents/smartphone");
        Dispositivo pc = fabricarDispositivo("pc", "C:/Users/Public/Documents/Desktop/pc");
        
        servidor.addObserver(tablet);
        servidor.addObserver(notebook);
        servidor.addObserver(smartphone);
        servidor.addObserver(pc);
        
        servidor.setPath("C:/Users/Public/Documents/servidor");
    }
    
    private static Dispositivo fabricarDispositivo(String type, String path) {
    	File file = new File(path);
    	if (file.isDirectory()) {
    		try {
    			return new FabricaComputadores().getDispositivo(type, path);
    		} catch (Exception e) {
    			try {
    				return new FabricaGadgets().getDispositivo(type, path);
    			} catch (Exception e2) {
    				e.printStackTrace();
    			}
    		}    		
    	}
    	return null;
    }
}
