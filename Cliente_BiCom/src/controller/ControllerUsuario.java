/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Interface.C_Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import model.Usuario;

/**
 *
 * @author Adlla Katarine
 */
public class ControllerUsuario extends UnicastRemoteObject implements C_Usuario{
    
    private Registry registry = null;
    C_Usuario CU;
    private static final long serialVersionUID = 5L;
    
    
  public ControllerUsuario(C_Usuario a) throws RemoteException, NotBoundException, IOException, FileNotFoundException, ClassNotFoundException{
        this.CU = a;
    }
    
    @Override
    public Usuario cadastrarUsuario(String nome, String CPF, String email, String login, String senha) throws RemoteException {
        System.out.println("a");
        Usuario u = CU.cadastrarUsuario(nome, CPF, email, login, senha);
       return u;
    }

    @Override
    public Usuario loginUsuario(String CPF, String senha) throws RemoteException {
        return CU.loginUsuario(CPF, senha);
    }
}
