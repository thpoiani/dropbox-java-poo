/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author Jefferson
 */
public class DropBox {
	
	private static Servidor servidor;

    public static void main(String[] args) {
        servidor = Servidor.getInstance();
        
        Dispositivo tablet = fabricarDispositivo("tablet", "C:/Users/Public/Documents/tablet");
        Dispositivo notebook = fabricarDispositivo("notebook", "C:/Users/Public/Documents/notebook");
        Dispositivo smartphone = fabricarDispositivo("smartphone", "C:/Users/Public/Documents/smartphone");
        Dispositivo pc = fabricarDispositivo("pc", "C:/Users/Public/Documents/pc");
        
        servidor.addObserver(tablet);
        servidor.addObserver(notebook);
        servidor.addObserver(smartphone);
        servidor.addObserver(pc);
        
        new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					System.out.print(getDate() + " - ");
					servidor.setPath("C:/Users/Public/Documents/servidor");
					try {
						Thread.sleep(5000);
						System.out.println();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
        	
        }).start();
        
    }
    
    private static String getDate() {
    	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	return sdf.format(new Date());
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
