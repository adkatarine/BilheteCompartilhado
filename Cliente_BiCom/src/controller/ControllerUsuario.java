/*
 * Controller responsável pelo cadastro e login do usuário.
 */
package controller;

import Interface.C_Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import model.Usuario;

/**
 *
 * @author Adlla Katarine
 */
public class ControllerUsuario extends UnicastRemoteObject implements C_Usuario{
    
    C_Usuario controller_U;
    private static final long serialVersionUID = 5L;
    
    
  public ControllerUsuario(C_Usuario controllerUsuario) throws RemoteException, NotBoundException, IOException, FileNotFoundException, ClassNotFoundException{
        this.controller_U = controllerUsuario;
    }
    
    @Override
    public Usuario cadastrarUsuario(String nome, String CPF, String email, String login, String senha) throws RemoteException {
        Usuario u = controller_U.cadastrarUsuario(nome, CPF, email, login, senha);
       return u;
    }

    @Override
    public Usuario loginUsuario(String CPF, String senha) throws RemoteException {
        return controller_U.loginUsuario(CPF, senha);
    }
}
