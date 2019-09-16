/*
 * 
 */
package view;

import Interface.C_Trechos;
import Interface.C_Usuario;
import controller.ControllerTrechos;
import controller.ControllerUsuario;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Iterator;
import model.Usuario;
import util.*;

/**
 *
 * @author Adlla Katarine
 */
public class Servidor implements Serializable {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, AlreadyBoundException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int porta; //variável para guardar valor da porta escolhida
            String companhia; // variável para guardar a companhia escolhida dependendo do valor da porta
            String dados; // variável auxiliar para leitura do teclado
            ArquivoEscritaLeitura2 arquivo = null;
            String IP = "localhost";
        try {
            System.out.println("Digite sua porta de Companhia Aerea:");
            System.out.println("[Porta 1888] Companhia Aerea A - Regiões Norte e Nordeste.");
            System.out.println("[Porta 1889] Companhia Aerea B - Regiões Contro-Oeste.");
            System.out.println("[Porta 1890] Companhia Aerea C - Regiões Sudeste e Sul.");

            //usuário escolhe o servidor que deseja iniciar
            do {
                dados = bufferedReader.readLine();
                porta = Integer.parseInt(dados);
            } while (porta != 1888 && porta != 1889 && porta != 1890);
            System.out.println("\n");

            C_Usuario CU = new ControllerUsuario();
            ControllerUsuario C_CU = (ControllerUsuario) CU;
            
            C_Trechos cTrechos = new ControllerTrechos(porta);
            ControllerTrechos cTrecho = (ControllerTrechos)cTrechos;
            arquivo = new ArquivoEscritaLeitura2(C_CU);
            arquivo.recuperar();
            
            Iterator iterator = C_CU.getUsuarios().iterator();
            while(iterator.hasNext()){
                Usuario u = (Usuario) iterator.next();
                System.out.println(u.getNome());
            }
            System.setProperty("java.rmi.server.hostname", IP);
            Registry registry = LocateRegistry.createRegistry(porta);
            registry.bind("CompanhiaAerea", CU);
            registry.bind("CompanhiaAereaTrecho", cTrechos);
            System.out.println("Servidor Iniciado");
            if (porta == 1888) {
                companhia = "A";
            } else if (porta == 1889) {
                companhia = "B";
            } else {
                companhia = "C";
            }
            System.out.println("Você é a Companhia Aerea " + companhia);
            System.out.println("\n");
            arquivo.gravar();
        } catch (RemoteException e) {
            e.printStackTrace();
        } finally {
            
        }
    }
}
