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
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
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
                addTrechoAux(usuario, trecho);
                //System.out.println("primeiro else comprando 1º trecho");
                /*Passagem passagemAux = new Passagem();
                passagemAux.addTrecho(trecho);
                usuario.addPassagem(passagemAux);*/
                System.out.println("primeiro else comprando"+ usuario.getPassagens().size() +"º trecho");
            }
        } else{
            addTrechoAux(usuario, trecho);
            //System.out.println("segundo else comprando 1º trecho");
            /*Passagem passagemAux = new Passagem();
            passagemAux.addTrecho(trecho);
            usuario.addPassagem(passagemAux);*/
            System.out.println("segundo else comprando"+ usuario.getPassagens().size() +"º trecho. SIZE: " + usuario.getPassagens().size());
        }
        System.out.println("Reserva feita: " + trecho.getLocalPartida() + " - " + trecho.getLocalChegada());
        return usuario;
    }
    
    private void addTrechoAux(Usuario usuario, Trecho trecho){
        Passagem passagemAux = new Passagem();
        passagemAux.addTrecho(trecho);
        usuario.addPassagem(passagemAux);
    }
    
    /**
     *
     * @param usuario
     * @return
     * @throws RemoteException
     * @throws NotBoundException
     */
    @Override
    public ArrayList<Trecho> finalizarCompra(Usuario usuario) throws RemoteException{
        System.out.println("AQUIIIIIIIIIIIIIIIIIIIIII");
        if(!usuario.getPassagens().isEmpty()){
            Passagem passagem = usuario.getPassagens().getLast();
            
            if(!passagem.isStatusCompra()){
                passagem.setStatusCompra(true);
                
                Iterator iterator = passagem.getTrechos().iterator();
                ArrayList<Trecho> auxTrechos = new ArrayList();
                while(iterator.hasNext()){
                    System.out.println("DEPOIS DO 1 WHILE");
                    Trecho trecho = (Trecho) iterator.next();
                    boolean auxB = false;
                    try {
                        auxB = comunicarServidor(trecho.getID(), trecho);
                        System.out.println("DEPOIS DA CHAMADA DE COMUNICARSERVIDOR");
                    } catch (NotBoundException ex) {
                        Logger.getLogger(ControllerTrechos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(!auxB){
                        auxTrechos.add(trecho);
                    }
                } if(auxTrechos.isEmpty()){
                    passagem.setStatusCompra(true);
                    return null;
                } else{
                    return auxTrechos;
                }
            }
        } return null;
    }
    
    private boolean comunicarServidor(String ID, Trecho trecho) throws RemoteException, NotBoundException{
        Registry registry = null;
        Registry registryTrecho = null;
        if(servidor.equals(ID)){
            return comprarTrechos(trecho);
        } else{
            if("CompanhiaA".equals(ID)){
                System.out.println("IF ANTES");
                registry = LocateRegistry.getRegistry(1888);
                registryTrecho = LocateRegistry.getRegistry(1888); 
                System.out.println("IF DEPOIS");
            } else if("CompanhiaB".equals(ID)){
                System.out.println("ELSE IF ANTES");
                registry = LocateRegistry.getRegistry(1889);
                registryTrecho = LocateRegistry.getRegistry(1889); 
                System.out.println("ELSE IF DEPOIS");
            } else{
                System.out.println("ELSE ANTES");
                registry = LocateRegistry.getRegistry(1890);
                registryTrecho = LocateRegistry.getRegistry(1890); 
                System.out.println("ELSE DEPOIS");
            } System.out.println("DEPOIS DO 1 ELSE");
            C_Usuario interfaceUsuario = (C_Usuario) registry.lookup("CompanhiaAerea");
            System.out.println("1");
            C_Trechos interfaceTrechos = (C_Trechos) registryTrecho.lookup("CompanhiaAereaA");
            System.out.println("2");
            ControllerUsuario cU = (ControllerUsuario)interfaceUsuario;
            System.out.println("3");
            ControllerTrechos cT = (ControllerTrechos)interfaceTrechos;
            System.out.println("4");
            System.out.println("FINAL DO MÉTODO");
            return cT.comprarTrechos(trecho);
        }
    }
    
    @Override
    public boolean comprarTrechos(Trecho trecho){
        Iterator iterator = this.trechos.iterator();
        
        while(iterator.hasNext()){
            Trecho trechinho = (Trecho) iterator.next();
            if(trecho.getLocalPartida().equals(trechinho.getLocalPartida()) && trecho.getLocalChegada().equals(trechinho.getLocalChegada())){
                if(trechinho.getQuantAssentos() > 0){
                    trechinho.setQuantAssentos();
                    System.out.println("CONSEGUIU COMPRAR.");
                    return true;
                }
            }
        } return false;
    }
    
    @Override
    public void confirmarCompra(Usuario usuario){
        if(!usuario.getPassagens().getLast().isStatusCompra()){
            usuario.getPassagens().getLast().setStatusCompra(true);
        }
    }
}
