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
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, RemoteException, NotBoundException, FileNotFoundException, ClassNotFoundException {
        
        
            Registry registry = null;
            Registry registryTrecho = null;
            Usuario usuario = null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int porta;
            String[] mensagem;
            int opcoesUsuario;
            String dados;
            System.out.println("Digite a porta da Companhia Aerea em que deseja se conectar:");
            System.out.println("[Porta 1888] Companhia Aerea A - Regiões Norte e Nordeste."); //SENDO FEITA
            System.out.println("[Porta 1889] Companhia Aerea B - Regiões Contro-Oeste.");
            System.out.println("[Porta 1890] Companhia Aerea B - Regiões Sudeste e Sul.");

            do{
                    dados = bufferedReader.readLine();
                    porta = Integer.parseInt(dados);
            }while(porta!=1888 && porta!=1889 && porta!=1890);

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
            }

            try{
                C_Usuario interfaceUsuario = (C_Usuario) registry.lookup("CompanhiaAerea");
                C_Trechos interfaceTrechos = (C_Trechos) registryTrecho.lookup("CompanhiaAereaA");
                ControllerUsuario controllerUsuario = new ControllerUsuario(interfaceUsuario);
                ControllerTrechos controllerTrechos = new ControllerTrechos(interfaceTrechos);
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
                                Trecho c = arrayT.get(porta);
                                System.out.println(c.getLocalPartida());
                                controllerTrechos.addTrecho(usuario, arrayT.get(porta));
                            }

                        }while(opcoesUsuario!=02); //DO WHILE que retorna para a opção de trechos ou menu.
                    
                }while(opcoesUsuario == 2); //DO WHILE que retorna o usuário ao menu.
            //}while(opcoesUsuario == 4);
        } catch(RemoteException e){
            e.printStackTrace();
        }
    }
    
}
