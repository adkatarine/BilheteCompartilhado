/*
 * Controller responsável pela venda de trechos disponíveis aos usuários.
 */
package controller;

import Interface.C_Trechos;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import model.Trecho;
import model.Usuario;

/**
 *
 * @author Adlla Katarine
 */
public class ControllerTrechos extends UnicastRemoteObject implements C_Trechos{

    private static final long serialVersionUID = 4L;
    private C_Trechos cTrechos;
    
    public ControllerTrechos(C_Trechos trecho) throws RemoteException, NotBoundException, IOException, FileNotFoundException, ClassNotFoundException{
        this.cTrechos = trecho;
    }
    
    @Override
    public ArrayList<Trecho> trechosDisponíveis() throws RemoteException {
        return this.cTrechos.trechosDisponíveis();
    }

    @Override
    public Usuario addTrecho(Usuario usuario, Trecho trecho) throws RemoteException {
        return this.cTrechos.addTrecho(usuario, trecho);
    }
    
    @Override
    public boolean comprarTrechos(Trecho trecho) throws RemoteException{
        return this.cTrechos.comprarTrechos(trecho);
    }
    
    @Override
    public void confirmarCompra(Usuario usuario) throws RemoteException{
        this.cTrechos.confirmarCompra(usuario);
    }
}
