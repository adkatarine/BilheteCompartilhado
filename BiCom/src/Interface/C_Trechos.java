/*
 * Interface dos métodos para manipulação dos trechos.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import model.Trecho;
import model.Usuario;

/**
 *
 * @author Adlla Katarine
 */
public interface C_Trechos extends Remote{
    
    public ArrayList<Trecho> trechosDisponíveis() throws RemoteException;
    public Usuario addTrecho(Usuario usuario, Trecho trecho) throws RemoteException;
    public ArrayList<Trecho> finalizarCompra(Usuario usuario) throws RemoteException;
    public boolean comprarTrechos(Trecho trecho) throws RemoteException;
    public void confirmarCompra(Usuario usuario) throws RemoteException;
}
