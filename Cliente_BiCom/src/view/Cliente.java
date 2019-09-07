/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Interface.C_Usuario;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Adlla Katarine
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry(1888);
            //AgendaInterface agenda = (AgendaInterface) registry.lookup("AgendaService");
            C_Usuario CU = (C_Usuario) registry.lookup("CompanhiaAerea");
            CU.cadastrarUsuario("Ad", "222222", "adkatarine@hotmail.com", "adlinda", "eulinda");
            //agenda.adicionarEvento("Quarta-Feira", "PBL", "Sala Tutorial");
            
            //ArrayList<String> eventos = agenda.listarEventos();
            
            /*for(String evento: eventos){
                System.out.println(evento);
            }*/
        } catch(RemoteException | NotBoundException e){
            e.printStackTrace();
        }
    }
    
}
