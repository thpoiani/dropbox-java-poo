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
    
    public String nome;
    public String caminhoPasta;
    
    public void Dispositivo(String caminhoPasta) {
        
        
    }
    
    public void sincronizaArquivo(String caminho) {
        
        
    }

    @Override
    public abstract void update(Observable o, Object arg);
}
