/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Usuario;

/**
 *
 * @author Adlla Katarine
 */
public interface C_Usuario extends Remote{
    
    public Usuario cadastrarUsuario(String nome, String CPF, String email, String login, String senha) throws RemoteException;
    public Usuario loginUsuario(String CPF, String senha) throws RemoteException;
}
