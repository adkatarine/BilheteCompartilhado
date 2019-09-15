/**
 * 
 * Controller responsável pela venda de trechos disponíveis aos usuários.
 */
package controller;

import Interface.C_Trechos;
import Interface.C_Usuario;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import model.Passagem;
import model.Trecho;
import model.Usuario;
import util.TrechosProntos;
import view.Servidor;

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
    private String servidor;
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
    public Usuario addTrecho(Usuario usuario, Trecho trecho){
        System.out.println("AAAAA");
        /*if(!usuario.getPassagens().isEmpty()){
            Passagem passagem = usuario.getPassagens().getLast();
            if(passagem.isStatusCompra()!=true || usuario.getPassagens().isEmpty()==true){
                if(!passagem.isStatusCompra()){
                    passagem.addTrecho(trecho);
                    System.out.println("primeiro if comprando +1 trecho");
                } else{
                    Passagem passagemAux = new Passagem();
                    passagemAux.addTrecho(trecho);
                    usuario.addPassagem(passagem);
                    System.out.println("primeiro else comprando 1º trecho");
                }
            }
        }*/
        
        
        if(usuario.getPassagens().size() > 0){
            System.out.println("primeiro if");
            Passagem passagem = usuario.getPassagens().getLast();
            if(!passagem.isStatusCompra()){
                passagem.addTrecho(trecho);
                System.out.println("primeiro if comprando"+ usuario.getPassagens().size() +"º trecho");
            } else{
                //addTrechoAux(usuario, trecho);
                //System.out.println("primeiro else comprando 1º trecho");
                Passagem passagemAux = new Passagem();
                passagemAux.addTrecho(trecho);
                usuario.addPassagem(passagemAux);
                System.out.println("primeiro else comprando"+ usuario.getPassagens().size() +"º trecho");
            }
        } else{
            //addTrechoAux(usuario, trecho);
            //System.out.println("segundo else comprando 1º trecho");
            Passagem passagemAux = new Passagem();
            passagemAux.addTrecho(trecho);
            usuario.addPassagem(passagemAux);
            System.out.println("segundo else comprando"+ usuario.getPassagens().size() +"º trecho. SIZE: " + usuario.getPassagens().size());
        }
        System.out.println("Reserva feita: " + trecho.getLocalPartida() + " - " + trecho.getLocalChegada());
        return usuario;
    }
    
   /* private void addTrechoAux(Usuario usuario, Trecho trecho){
        Passagem passagemAux = new Passagem();
        passagemAux.addTrecho(trecho);
        usuario.addPassagem(passagemAux);
    }*/
    
    /*private void finalizarCompra(Usuario usuario){
        if(!usuario.getPassagens().isEmpty()){
            Passagem passagem = usuario.getPassagens().getLast();
            
            if(!passagem.isStatusCompra()){
                passagem.setStatusCompra(true);
                
                Iterator iterator = passagem.getTrechos().iterator();
                
                while(iterator.hasNext()){
                    Trecho trecho = (Trecho) iterator.next();
                    comunicarServidor(trecho.getID());
                }
            }
        }
    }
    
    private void comunicarServidor(String ID) throws RemoteException, NotBoundException{
        if(servidor.equals(ID)){
            
        }
        
    }
    
    private void comprarTrechos(){
        
    }*/
}
