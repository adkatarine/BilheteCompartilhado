/**
 * 
 * Controller responsável pela venda de trechos disponíveis aos usuários.
 */
package controller;

import Interface.C_Trechos;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import model.Passagem;
import model.Trecho;
import model.Usuario;
import util.TrechosProntos;

/**
 *
 * @author Adlla Katarine
 */
public class ControllerTrechos extends UnicastRemoteObject implements C_Trechos{
    private static final long serialVersionUID = 4L;
    private ControllerUsuario controllerUsuario;
    private ArrayList<Trecho> trechos; // lista de todos os trechos disponíveis
    private Trecho trecho;
    private TrechosProntos tProntos;
    
    /**
     * 
     * Contrutor. Nele, a lista de trechos é instanciada e inicializada.
     */
    public ControllerTrechos(int porta) throws RemoteException{
        super();
        this.trechos = new ArrayList<Trecho>();
        this.tProntos = new TrechosProntos();
        this.trechos = this.tProntos.add(porta);
    }

    public ControllerUsuario getControllerUsuario() {
        return controllerUsuario;
    }

    public void setControllerUsuario(ControllerUsuario controllerUsuario) {
        this.controllerUsuario = controllerUsuario;
    }

    public ArrayList<Trecho> getTrechos() {
        return trechos;
    }

    public void setTrechos(ArrayList<Trecho> trechos) {
        this.trechos = trechos;
    }

    public Trecho getTrecho() {
        return trecho;
    }

    public void setTrecho(Trecho trecho) {
        this.trecho = trecho;
    }
    
    @Override
    public ArrayList<Trecho> trechosDisponíveis(){
        return this.trechos;
    }
    
    @Override
    public void addTrecho(Usuario usuario, Trecho trecho){
        System.out.println("AAAAA");
        if(!usuario.getPassagens().isEmpty()){
            System.out.println("bbbbbbbbbb");
            Passagem passagem = usuario.getPassagens().getLast();
            if(!passagem.isStatusCompra()){
            passagem.addTrecho(trecho);
            System.out.println("1 if");
            } else{
                Passagem passagemAux = new Passagem();
                passagemAux.addTrecho(trecho);
                usuario.addPassagem(passagem);
                System.out.println("1 else");
            }
        } else{
            Passagem passagemAux = new Passagem();
            passagemAux.addTrecho(trecho);
            usuario.addPassagem(passagemAux);
            System.out.println("2 else");
        }
        System.out.println("Reserva feita: " + trecho.getLocalPartida() + " - " + trecho.getLocalChegada());
    }
    
    
}
