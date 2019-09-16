/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Interface.C_Trechos;
import Interface.C_Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import model.Trecho;
import model.Usuario;

/**
 *
 * @author Adlla Katarine
 */
public class ControllerTrechos extends UnicastRemoteObject implements C_Trechos{

    private static final long serialVersionUID = 4L;
    private Registry registry = null;
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
    public ArrayList<Trecho> finalizarCompra(Usuario usuario) throws RemoteException{
        return this.cTrechos.finalizarCompra(usuario);
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
