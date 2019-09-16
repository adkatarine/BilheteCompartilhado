/**
 * Classe responsável por guardar todas as informações pessoas do usuário, assim como todas as suas passagens adquiridas.
 */
package model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Adlla Katarine
 */
public class Usuario implements Serializable{
    private static final long serialVersionUID = 3L;
    private String nome; // nome completo do usuário
    private String CPF; // CPF do usuário
    private String email; // email do usuário
    private String login; // nome de login do usuário
    private String senha; // senha do usuário
    private LinkedList<Passagem> passagens; // lista de todas as passagens compradas por um determinado usuário

    /**
     * 
     * Contrutor. Nele, a lista de passagens é instanciada e outros atributos são iniciados.
     */
    public Usuario(String nome, String CPF, String email, String login, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.passagens = new LinkedList();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LinkedList<Passagem> getPassagens() {
        return passagens;
    }

    public void setPassagens(LinkedList<Passagem> passagens) {
        this.passagens = passagens;
    }

    public void addPassagem(Passagem passagem){
        this.passagens.add(passagem);
    }
    
    @Override
    public String toString() {
        return "Usuario{" + "nome=" + nome + ", CPF=" + CPF + ", email=" + email + ", login=" + login + ", senha=" + senha + ", passagens=" + passagens + '}';
    }
    
}
