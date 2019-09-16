/**
 * 
 * Controller responsável pelo cadastro e login do usuário.
 */
package controller;

import Interface.C_Usuario;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.LinkedList;
import model.Usuario;

/**
 *
 * @author Adlla Katarine
 */
public class ControllerUsuario extends UnicastRemoteObject implements C_Usuario {
    private LinkedList<Usuario> usuarios;
    private static final long serialVersionUID = 5L;
    /**
     * 
     * Contrutor. Nele, a lista de usuarios é instanciada.
     */
    public ControllerUsuario() throws RemoteException{
        super();
        this.usuarios = new LinkedList();
    }

    public LinkedList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(LinkedList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    /**
     * Cadastro de usuário com verificação de CPF.
    */
    @Override
    public Usuario cadastrarUsuario(String nome, String CPF, String email, String login, String senha){
        if(this.verificarCadastroUsuario(CPF, senha) == null){
            Usuario usuarioCadastro = new Usuario(nome, CPF, email, login, senha);
        
            this.usuarios.add(usuarioCadastro);
            return usuarioCadastro;
        } return null;
    }
    
    /**
     * Verifica existencia do usuário no sistema através do seu CPF.
     * 
     * @return Pessoa
    */
    public Usuario verificarCadastroUsuario(String CPF, String senha){
        if(!usuarios.isEmpty()){
            Iterator iterator = usuarios.iterator();
            
            while(iterator.hasNext()){
                Usuario pessoaCadastrada = (Usuario)iterator.next();
                
                if(pessoaCadastrada.getCPF().equals(CPF) && pessoaCadastrada.getSenha().equals(senha)){
                    return pessoaCadastrada;
                }
            }
        }
        return null;
    }
    
    /**
     * Verifica cadastro existente do usuário através do seu CPF.
     * 
     * @return Pessoa
    */
    @Override
    public Usuario loginUsuario(String CPF, String senha){
        Usuario usuarioLogin;
        
        if((usuarioLogin = this.verificarCadastroUsuario(CPF, senha)) != null){
            return usuarioLogin;
        } return null;
    }
  
}
