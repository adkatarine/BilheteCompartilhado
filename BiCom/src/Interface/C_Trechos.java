/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
}
