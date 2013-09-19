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
import java.util.Date;
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
    
    /**
     * Método template para sincronizar os arquivos entre o servidor e o device
     * 
     * @param ArrayList<File> arquivos
     * @throws IOException
     */
	public void sincronizaArquivo(Object arquivos) throws IOException {
		Date now = new Date();
		
		for (File arquivo : (File[]) arquivos) {
			File novoArquivo = atualizarArquivos(arquivo);
			copyFile(arquivo, novoArquivo);
		}		
		removerArquivosAntigos(now);
    }

	/**
	 * Método para sincronizar arquivos, removendo o que já existe, 
	 * retornando o novo arquivo a ser copiado
	 * 
	 * @param File arquivo
	 * @return File
	 */
	private File atualizarArquivos(File arquivo) {
		File novoArquivo = new File(getNovoArquivo(arquivo));

		if (novoArquivo.exists()) {
			novoArquivo.delete();
			System.out.println("O arquivo '" + arquivo.getName() + "' foi atualizado.");
		} else {
			System.out.println("O arquivo '" + arquivo.getName() + "' foi adicionado.");
		}
		
		return novoArquivo;
	}
	
	/**
	 * Método para remoção de arquivos antigos da pasta do device.
	 * <br>
	 * Caso a data de modificação do arquivo seja menor que a do ciclo de atualização,
	 * isso significa que o arquivo não estava no servidor e deve ser removido do device
	 * 
	 * @param Date base
	 */
	private void removerArquivosAntigos(Date base) {
		File path = new File(caminhoPasta);
		
		for (File file : path.listFiles()) {
			Date lastModified = new Date(file.lastModified());
			if (lastModified.compareTo(base) < 0) {
				System.out.println("O arquivo '" + file.getName() + "' foi removido.");
				file.delete();
			}
		}
	}
	
	/**
	 * Método para retornar o caminho do arquivo, dentro da pasta do device
	 *  
	 * @param File arquivo
	 * @return String
	 */
	private String getNovoArquivo(File arquivo) {
		return caminhoPasta + "/" + arquivo.getName();
	}

	/**
	 * Método para copiar arquivos da pasta de origem para a pasta de destino
	 * 
	 * @param File sourceFile
	 * @param File destFile
	 * @throws IOException
	 */
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
}
