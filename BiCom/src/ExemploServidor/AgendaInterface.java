/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemploServidor;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Adlla Katarine
 */
public interface AgendaInterface extends Remote{
    
    public void adicionarEvento(String data, String titulo, String local) throws RemoteException;
    public ArrayList<String> listarEventos() throws RemoteException;
}
