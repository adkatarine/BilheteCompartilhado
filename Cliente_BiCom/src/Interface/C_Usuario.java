/*
 * Interface dos métodos para manipulação de cadastro/login do usuario.
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
