/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemploCliente;

import ExemploServidor.AgendaInterface;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 *
 * @author Adlla Katarine
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
        try{
            Registry registry = LocateRegistry.getRegistry(1888);
            AgendaInterface agenda = (AgendaInterface) registry.lookup("AgendaService");
            
            agenda.adicionarEvento("Quarta-Feira", "PBL", "Sala Tutorial");
            agenda.adicionarEvento("Quinta-Feira", "PBL", "Sala Tutorial");
            agenda.adicionarEvento("Domingo", "Maratonar Series", "Minha casa");
            
            ArrayList<String> eventos = agenda.listarEventos();
            
            for(String evento: eventos){
                System.out.println(evento);
            }
        } catch(RemoteException | NotBoundException e){
            e.printStackTrace();
        }
    }
    
}
