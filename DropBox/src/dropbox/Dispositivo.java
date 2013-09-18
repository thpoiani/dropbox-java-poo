/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Jefferson
 */
public abstract class Dispositivo implements Observer{
    
    private String nome;
    private String caminhoPasta;
    
    public Dispositivo(String caminhoPasta) {}
    
    
	public void sincronizaArquivo(String caminho) {
        
    }

    @Override
    public abstract void update(Observable o, Object arg);
}
