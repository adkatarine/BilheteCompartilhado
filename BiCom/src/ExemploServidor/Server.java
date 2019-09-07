/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemploServidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Adlla Katarine
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException {
        try{
            AgendaInterface agenda = new AgendaImpl();
            Registry registry = LocateRegistry.createRegistry(1888);
            registry.rebind("AgendaService", agenda);
            System.out.println("Servidor Iniciado");
        } catch(RemoteException e){
            e.printStackTrace();
        }
    }
    
}
