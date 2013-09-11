/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dropbox;

/**
 *
 * @author Jefferson
 */
public class DropBox {

    public static void main(String[] args) {
        Servidor.getInstance(); //Pega a instância do servidor, vai faltar os metodos de cadastros dos dispositvos
        
        FabricaGadgets fg = new FabricaGadgets();
        FabricaComputadores fc = new FabricaComputadores();
        
        try {
			Dispositivo tablet = fg.getDispositivo("TABLET");
			Dispositivo smartphone = fg.getDispositivo("smartphone");
			Dispositivo notebook = fc.getDispositivo("notebook");
			Dispositivo pc = fc.getDispositivo("pc");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
    }
}
