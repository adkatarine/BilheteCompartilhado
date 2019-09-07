/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Iterator;
import model.Trecho;
import model.Usuario;

/**
 *
 * @author Adlla Katarine
 */
public class ClienteInterface {

    public static String[] separarString(String info) {
        return info.split(" ");
    }
    
    public static void finalizarPrograma(){
        System.out.println("O PROGRAMA SERÁ FINALIZADO.");
        System.exit(0);
    }
    
    public static Registry[] conectarServidores(int porta) throws RemoteException{
        Registry registry = null;
        Registry registryTrecho = null;
        if(porta==1888){
                try{
                registry = LocateRegistry.getRegistry(porta);
                registryTrecho = LocateRegistry.getRegistry(porta);
                    System.out.println("AQUI");
            } catch(RemoteException e){
                e.printStackTrace();
                }
            } else if(porta==1889){
                try{
                registry = LocateRegistry.getRegistry(porta);
                registryTrecho = LocateRegistry.getRegistry(porta);
            } catch(RemoteException e){
                e.printStackTrace();
                }
            } else{
                try{
                registry = LocateRegistry.getRegistry(porta);
                registryTrecho = LocateRegistry.getRegistry(porta);
            } catch(RemoteException e){
                e.printStackTrace();
                }
            } Registry[] r = new Registry[2];
              r[0] = registry;
              r[1] = registryTrecho;
              return r;
    }
    
    public static Registry[] trocarServidor(String companhia) throws RemoteException{
        if(companhia.equalsIgnoreCase("CompanhiaA")) {
            System.out.println("CompanhiaA");
            return conectarServidores(1888);
        } else if(companhia.equalsIgnoreCase("CompanhiaB")){
            System.out.println("CompanhiaB");
            return conectarServidores(1889);
        } else{
            System.out.println("CompanhiaC");
            return conectarServidores(1890);
        }
    } 
    
      
    public static Object[] iniciarController(Registry registry, Registry registryTrecho) throws RemoteException, IOException, NotBoundException, FileNotFoundException, ClassNotFoundException{
        C_Usuario interfaceUsuario = (C_Usuario) registry.lookup("CompanhiaAerea");
        C_Trechos interfaceTrechos = (C_Trechos) registryTrecho.lookup("CompanhiaAereaA");
        ControllerUsuario controllerUsuario = new ControllerUsuario(interfaceUsuario);
        ControllerTrechos controllerTrechos = new ControllerTrechos(interfaceTrechos);
        
        Object[] obj = new Object[2];
        obj[0] = controllerUsuario;
        obj[1] = controllerTrechos;
        return obj;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, RemoteException, NotBoundException, FileNotFoundException, ClassNotFoundException {
        
        
            Registry registry = null;
            Registry registryTrecho = null;
            Registry[ ] rAux = new Registry[2];
            ControllerUsuario controllerUsuario;
            ControllerTrechos controllerTrechos;
            Object[] obj = new Object[2];
            Usuario usuario = null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int porta;
            String[] mensagem;
            int opcoesUsuario;
            String dados;
            
            System.out.println("Digite a porta da Companhia Aerea em que deseja se conectar:");
            System.out.println("[Porta 1888] Companhia Aerea A - Regiões Norte e Nordeste.");
            System.out.println("[Porta 1889] Companhia Aerea B - Regiões Contro-Oeste.");
            System.out.println("[Porta 1890] Companhia Aerea B - Regiões Sudeste e Sul.");

            do{
                dados = bufferedReader.readLine();
                porta = Integer.parseInt(dados);
            }while(porta!=1888 && porta!=1889 && porta!=1890);

            rAux = conectarServidores(porta);
            registry = rAux[0];
            registryTrecho = rAux[1];

            try{
                obj = iniciarController(registry, registryTrecho);
                controllerUsuario = (ControllerUsuario)obj[0];
                controllerTrechos = (ControllerTrechos)obj[1];

                do{
                    System.out.println("********** MENU **********");
                    System.out.println("Digite a opção que desejar:");
                    System.out.println("[1] - Fazer cadastro.");
                    System.out.println("[2] - Fazer login.");
                    System.out.println("[3] - Finalizar conexão.");
                    System.out.println("[4] - Fazer troca de Companhia Aerea.");

                    dados = bufferedReader.readLine();
                    opcoesUsuario = Integer.parseInt(dados);
                    switch(opcoesUsuario){

                        case 1:
                            System.out.println("Digite seu nome, CPF, email, user e senha nessa ordem e com um espaço entre cada informação.");
                            mensagem = separarString(bufferedReader.readLine());
                            usuario = controllerUsuario.cadastrarUsuario(mensagem[0], mensagem[1], mensagem[2], mensagem[3], mensagem[4]);
                            break;
                        case 2:
                            System.out.println("Digite seu user, senha e CPF nessa ordem e com um espaço entre cada informação.");
                            mensagem = separarString(bufferedReader.readLine());
                            usuario = controllerUsuario.loginUsuario(mensagem[2], mensagem[1]);
                            opcoesUsuario=1;
                            break;
                        case 3:
                            finalizarPrograma();
                            break;
                       
                    }
                    do{
                            System.out.println("Digite a opção que desejar: ");
                            System.out.println("[01] - Ver trechos.");
                            System.out.println("[02] - Voltar ao menu.");

                            dados = bufferedReader.readLine();
                            opcoesUsuario = Integer.parseInt(dados);

                            if(opcoesUsuario == 1){
                                System.out.println("TRECHOS DISPONÍVEIS PARA VIAGEM:");
                                ArrayList<Trecho> arrayT = controllerTrechos.trechosDisponíveis();
                                
                                int i = 0;
                                while(i < arrayT.size()){
                                    Trecho trecho = (Trecho) arrayT.get(i);
                                    System.out.println(i+" - Partida: " + trecho.getLocalPartida() + "|| Chegada: "+ trecho.getLocalChegada());
                                    i++;
                                }
                                System.out.println("");
                                System.out.println("Digite a opção que deseja comprar:");
                                
                                do{
                                    dados = bufferedReader.readLine();
                                    porta = Integer.parseInt(dados);
                                    
                                    if(porta <0 && porta>arrayT.size()+1){
                                        System.out.println("");
                                        System.out.println("Opção incorreta. Digite novamente, por favor.");
                                    }
                                }while(porta <0 && porta>arrayT.size()+1);
                                Trecho t = arrayT.get(porta);
                                controllerTrechos.addTrecho(usuario, t);
                                
                                rAux = trocarServidor(t.getIDCOMPRA());
                                registry = rAux[0];
                                registryTrecho = rAux[1];
                                
                                obj = iniciarController(registry, registryTrecho);
                                controllerUsuario = (ControllerUsuario)obj[0];
                                controllerTrechos = (ControllerTrechos)obj[1];
                            }

                        }while(opcoesUsuario!=02); //DO WHILE que retorna para a opção de trechos ou menu.
                    
                }while(opcoesUsuario == 2); //DO WHILE que retorna o usuário ao menu.
            //}while(opcoesUsuario == 4);
        } catch(RemoteException e){
            e.printStackTrace();
        }
    }
    
}
