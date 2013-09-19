/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Jefferson
 */
public abstract class Dispositivo implements Observer{

    private String caminhoPasta;

	public Dispositivo(String caminhoPasta) {
    	this.caminhoPasta = caminhoPasta;
    }
	
	public abstract void update(Observable o, Object arg);
	
    public String getCaminhoPasta() {
		return caminhoPasta;
	}
    
	public void sincronizaArquivo(Object arquivos) throws IOException {
		for (File arquivo : (ArrayList<File>) arquivos) {
			File novoArquivo = new File(getNovoArquivo(arquivo));

			if (novoArquivo.exists()) {
				novoArquivo.delete();
				System.out.println("O arquivo '" + arquivo.getName() + "' foi atualizado.");
			} else {
				System.out.println("O arquivo '" + arquivo.getName() + "' foi adicionado.");
			}
			
			copyFile(arquivo, novoArquivo);
		}
    }

	private void copyFile(File sourceFile, File destFile) throws IOException {
	    if(!destFile.exists()) {
	        destFile.createNewFile();
	    }

	    FileChannel source = null;
	    FileChannel destination = null;

	    try {
	        source = new FileInputStream(sourceFile).getChannel();
	        destination = new FileOutputStream(destFile).getChannel();
	        destination.transferFrom(source, 0, source.size());
	    }
	    finally {
	        if(source != null) {
	            source.close();
	        }
	        if(destination != null) {
	            destination.close();
	        }
	    }
	}
	
	private String getNovoArquivo(File arquivo) {
		return caminhoPasta + "/" + arquivo.getName();
	}
}
