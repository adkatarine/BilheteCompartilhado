/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemploServidor;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Adlla Katarine
 */
public class AgendaImpl extends UnicastRemoteObject implements AgendaInterface{

    private static final long serialVersionUID = 1L;
    
    private static ArrayList<Evento> eventos = new ArrayList<Evento>();
    
    protected AgendaImpl() throws RemoteException{
        super();
    }
    
    @Override
    public void adicionarEvento(String data, String titulo, String local) throws RemoteException {
        Evento evt = new Evento(data, titulo, local);
        eventos.add(evt);
    }

    @Override
    public ArrayList<String> listarEventos() throws RemoteException {
        ArrayList<String> resposta = new ArrayList<String>();
        
        for(Evento evt: eventos){
            String evento = "\nData"+evt.getData()+
                            "\nTitulo"+evt.getTitulo()+
                            "\nLocal"+evt.getLocal();
            resposta.add(evento);
        }
        return resposta;
    }
    
}
