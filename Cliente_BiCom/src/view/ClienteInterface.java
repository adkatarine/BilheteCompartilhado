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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Passagem;
import model.Trecho;
import model.Usuario;

/**
 *
 * @author Adlla Katarine
 */
public class ClienteInterface {

    /**
     * Separa strings em um vetor de strings.
     * 
     * @param info
     * @return String[]
     */
    public static String[] separarString(String info) {
        return info.split(" ");
    }

    /**
     * Finaliza a execução do programa.
     * 
     */
    public static void finalizarPrograma() {
        System.out.println("O PROGRAMA SERÁ FINALIZADO.");
        System.exit(0);
    }

    /**
     * Conecta o usuário ao servidor escolhido por ele através do número da porta.
     * 
     * @param porta
     * @return Registry[]
     * @throws RemoteException 
     */
    public static Registry[] conectarServidores(int porta) throws RemoteException {
        Registry registry = null;
        Registry registryTrecho = null;
        if (porta == 1888) {
            try {
                registry = LocateRegistry.getRegistry(porta);
                registryTrecho = LocateRegistry.getRegistry(porta);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else if (porta == 1889) {
            try {
                registry = LocateRegistry.getRegistry(porta);
                registryTrecho = LocateRegistry.getRegistry(porta);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                registry = LocateRegistry.getRegistry(porta);
                registryTrecho = LocateRegistry.getRegistry(porta);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        Registry[] r = new Registry[2];
        r[0] = registry;
        r[1] = registryTrecho;
        return r;
    }
    
    /**
     * Faz a troca de servidor ou não dependendo dos trechos comprados pelo usuário.
     * 
     * @param companhia
     * @return Registry[]
     * @throws RemoteException 
     */
    public static Registry[] trocarServidor(String companhia) throws RemoteException {
        if (companhia.equalsIgnoreCase("CompanhiaA")) {
            System.out.println("CompanhiaA");
            return conectarServidores(1888);
        } else if (companhia.equalsIgnoreCase("CompanhiaB")) {
            System.out.println("CompanhiaB");
            return conectarServidores(1889);
        } else {
            System.out.println("CompanhiaC");
            return conectarServidores(1890);
        }
    }

    public static Object[] iniciarController(Registry registry, Registry registryTrecho) throws RemoteException, IOException, NotBoundException, FileNotFoundException, ClassNotFoundException {
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
     * Responsável por verificar se existe passagem a ser comprada, chama o método comunicarServidor, verificando e tratando o seu return.
     * 
     * @param usuario
     * @param c
     * @return ArrayList<Trecho>
     * @throws RemoteException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    public static ArrayList<Trecho> finalizarCompra(Usuario usuario, ControllerTrechos c) throws RemoteException, IOException, FileNotFoundException, ClassNotFoundException {
        if (!usuario.getPassagens().isEmpty()) {
            Passagem passagem = usuario.getPassagens().getLast();
            if (!passagem.isStatusCompra()) {
                Iterator iterator = passagem.getTrechos().iterator();
                ArrayList<Trecho> auxTrechos = new ArrayList();

                while (iterator.hasNext()) {
                    Trecho trecho = (Trecho) iterator.next();
                    boolean auxB = false;
                    try {
                        auxB = comunicarServidor(trecho, c);
                    } catch (NotBoundException ex) {
                        Logger.getLogger(ControllerTrechos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (!auxB) {
                        auxTrechos.add(trecho);
                    }
                }
                if (auxTrechos.isEmpty()) {
                    passagem.setStatusCompra(true);
                    return null;
                } else {
                    return auxTrechos;
                }
            }
        }
        return null;
    }

    /**
     * Verifica em qual companhia o trecho foi comprado, conecta-se a ele e chama o método para comprar os trechos.
     * 
     * @param trecho
     * @param c
     * @return
     * @throws RemoteException
     * @throws NotBoundException
     * @throws IOException
     * @throws FileNotFoundException
     * @throws ClassNotFoundException 
     */
    private static boolean comunicarServidor(Trecho trecho, ControllerTrechos c) throws RemoteException, NotBoundException, IOException, FileNotFoundException, ClassNotFoundException {
        Registry registry = null;
        Registry registryTrecho = null;
        if ("CompanhiaB".equals(trecho.getID())) {
            return c.comprarTrechos(trecho);
        } else {
            if ("CompanhiaA".equals(trecho.getID())) {
                registry = LocateRegistry.getRegistry(1888);
                registryTrecho = LocateRegistry.getRegistry(1888);
            } else if ("CompanhiaB".equals(trecho.getID())) {
                registry = LocateRegistry.getRegistry(1889);
                registryTrecho = LocateRegistry.getRegistry(1889);
            } else {
                registry = LocateRegistry.getRegistry(1890);
                registryTrecho = LocateRegistry.getRegistry(1890);
            }
            C_Usuario interfaceUsuario = (C_Usuario) registry.lookup("CompanhiaAerea");
            C_Trechos interfaceTrechos = (C_Trechos) registryTrecho.lookup("CompanhiaAereaA");
            ControllerUsuario controllerUsuario = new ControllerUsuario(interfaceUsuario);
            ControllerTrechos controllerTrechos = new ControllerTrechos(interfaceTrechos);
            return controllerTrechos.comprarTrechos(trecho);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, RemoteException, NotBoundException, FileNotFoundException, ClassNotFoundException {

        Registry registry = null;
        Registry registryTrecho = null;
        Registry[] rAux = new Registry[2];
        ControllerUsuario controllerUsuario;
        ControllerTrechos controllerTrechos;
        Object[] obj = new Object[2]; //variável auxiliar
        Usuario usuario = null; // variável que instanciará o usuário.
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int porta; // variável para guardar valor da porta escolhida
        String[] mensagem; // variável auxiliar
        int opcoesUsuario; // variável auxiliar para leitura do teclado
        String dados; // variável auxiliar para leitura do teclado

        System.out.println("Digite a porta da Companhia Aerea em que deseja se conectar:");
        System.out.println("[Porta 1888] Companhia Aerea A - Regiões Norte e Nordeste.");
        System.out.println("[Porta 1889] Companhia Aerea B - Regiões Contro-Oeste.");
        System.out.println("[Porta 1890] Companhia Aerea B - Regiões Sudeste e Sul.");

        do {
            dados = bufferedReader.readLine();
            porta = Integer.parseInt(dados);
        } while (porta != 1888 && porta != 1889 && porta != 1890);

        rAux = conectarServidores(porta);
        registry = rAux[0];
        registryTrecho = rAux[1];

        try {
            obj = iniciarController(registry, registryTrecho);
            controllerUsuario = (ControllerUsuario) obj[0];
            controllerTrechos = (ControllerTrechos) obj[1];

            do {
                System.out.println("********** MENU **********");
                System.out.println("Digite a opção que desejar:");
                System.out.println("[1] - Fazer cadastro.");
                System.out.println("[2] - Fazer login.");
                System.out.println("[3] - Comprar passagem.");
                System.out.println("[4] - Ver passagens compradas.");
                System.out.println("[5] - Finalizar conexão.");

                dados = bufferedReader.readLine();
                opcoesUsuario = Integer.parseInt(dados);
                switch (opcoesUsuario) {

                    case 1: // cadastro do usuário
                        System.out.println("Digite seu nome, CPF, email, user e senha nessa ordem e com um espaço entre cada informação.");
                        mensagem = separarString(bufferedReader.readLine());
                        usuario = controllerUsuario.cadastrarUsuario(mensagem[0], mensagem[1], mensagem[2], mensagem[3], mensagem[4]);
                        break;
                    case 2: // login do usuário
                        System.out.println("Digite seu user, senha e CPF nessa ordem e com um espaço entre cada informação.");
                        mensagem = separarString(bufferedReader.readLine());
                        usuario = controllerUsuario.loginUsuario(mensagem[2], mensagem[1]);
                        opcoesUsuario = 1;
                        break;
                    case 4: // ver passagens compradas
                        System.out.println("Digite a opção que desejar:");
                        System.out.println("[01] - Ver última passagem adquirida.");
                        System.out.println("[02] - Ver todas as passagens adquiridas.");

                        dados = bufferedReader.readLine();
                        opcoesUsuario = Integer.parseInt(dados);
                        Iterator iterator;

                        if (opcoesUsuario == 1) { // printa a última passagem aerea comprada pelo usuário.
                            iterator = usuario.getPassagens().getLast().getTrechos().iterator();
                            System.out.println("PASSAGEM AEREA");
                            System.out.println("");
                            System.out.println("Nome: " + usuario.getNome());
                            while (iterator.hasNext()) {
                                Trecho trecho = (Trecho) iterator.next();
                                System.out.println("TRECHO: " + trecho.getLocalPartida() + " -> " + trecho.getLocalChegada());
                            }
                            System.out.println("");
                        } else { // printa todas as passagens compradas pelo usuário.
                            Iterator iteratorP = usuario.getPassagens().iterator();
                            int aux = 1;
                            while (iteratorP.hasNext()) {
                                Passagem passagem = (Passagem) iteratorP.next();
                                if (passagem.isStatusCompra()) {
                                    System.out.println("************** " + aux + "ª PASSAGEM AEREA **************");
                                    iterator = usuario.getPassagens().getLast().getTrechos().iterator();
                                    System.out.println("");
                                    System.out.println("Nome: " + usuario.getNome());
                                    aux++;
                                    while (iterator.hasNext()) {
                                        Trecho trecho = (Trecho) iterator.next();
                                        System.out.println("TRECHO: " + trecho.getLocalPartida() + " --> " + trecho.getLocalChegada());
                                    }
                                    System.out.println("");
                                    System.out.println("");
                                }

                            }
                        }
                        break;
                    case 5:
                        finalizarPrograma();
                        break;

                }
                
                // logo após finalização do cadastro ou login e da escolha da opção 3 do menu, o usuário é direcionado para este if.
                if (opcoesUsuario == 1 || opcoesUsuario == 2 || opcoesUsuario == 3) {
                    do {
                        System.out.println("Digite a opção que desejar: ");
                        System.out.println("[01] - Ver trechos.");
                        System.out.println("[02] - Finalizar compra.");
                        dados = bufferedReader.readLine();
                        opcoesUsuario = Integer.parseInt(dados);

                        /* Aqui faz verificação para saber se há algum trecho comprado pelo usuário em sua atual passagem.
                        Caso haja, é feito o tratamento para que a opção de compra desse trecho não apareça. */
                        if (opcoesUsuario == 01) {
                            System.out.println("TRECHOS DISPONÍVEIS PARA VIAGEM:");
                            ArrayList<Trecho> arrayT = controllerTrechos.trechosDisponíveis();

                            int i = 0;
                            boolean boo = false;
                            while (i < arrayT.size()) {
                                Trecho trecho = (Trecho) arrayT.get(i);
                                if (!usuario.getPassagens().isEmpty()) {
                                    Iterator iterator = usuario.getPassagens().getLast().getTrechos().iterator();
                                    while (iterator.hasNext()) {
                                        Trecho trechoAux = (Trecho) iterator.next();
                                        if (trechoAux.getLocalPartida().equals(trecho.getLocalPartida()) && trechoAux.getLocalChegada().equals(trecho.getLocalChegada())) {
                                            boo = true;
                                        }
                                        if (!boo) {
                                            System.out.println(i + " - Partida: " + trecho.getLocalPartida() + " || Chegada: " + trecho.getLocalChegada());
                                        }
                                    }
                                    boo = false;
                                    i++;
                                } else {
                                    System.out.println(i + " - Partida: " + trecho.getLocalPartida() + " || Chegada: " + trecho.getLocalChegada());
                                    i++;
                                }

                            }

                            System.out.println("");
                            System.out.println("Digite a opção que deseja comprar:");

                            do {
                                dados = bufferedReader.readLine();
                                porta = Integer.parseInt(dados);

                                if (porta < 0 && porta > arrayT.size() + 1) {
                                    System.out.println("");
                                    System.out.println("Opção incorreta. Digite novamente, por favor.");
                                }
                            } while (porta < 0 && porta > arrayT.size() + 1);
                            Trecho t = arrayT.get(porta);
                            usuario.setPassagens(controllerTrechos.addTrecho(usuario, t).getPassagens());

                            // método é chamado para fazer a troca (ou não) do servidor dependendo do trecho escolhido
                            rAux = trocarServidor(t.getIDCOMPRA());
                            registry = rAux[0];
                            registryTrecho = rAux[1];

                            obj = iniciarController(registry, registryTrecho);
                            controllerUsuario = (ControllerUsuario) obj[0];
                            controllerTrechos = (ControllerTrechos) obj[1];
                        } else {
                            ArrayList<Trecho> auxTrechos = new ArrayList();
                            auxTrechos = finalizarCompra(usuario, controllerTrechos);

                            /*verifica se o método finalizarCompra retornou algum trecho. Caso sim, estes são retirados da lista
                            de trechos do usuário e a compra é finalizada sem esses trechos. */
                            if (auxTrechos == null) {
                                usuario.getPassagens().getLast().setStatusCompra(true);
                                controllerTrechos.confirmarCompra(usuario);
                                System.out.println("Sua compra foi finalizada com sucesso!");
                            } else {
                                System.out.println("O(s) seguinte(s) bilhete(s) que você escolheu esgotou(aram) recentemente e "
                                        + "sua compra foi finalizada com os bilhetes disponíveis.");
                                System.out.println("");
                                Iterator iterator = auxTrechos.iterator();
                                while (iterator.hasNext()) {
                                    Trecho trechoComprado = (Trecho) iterator.next();
                                    System.out.println("TRECHO: " + trechoComprado.getLocalPartida() + " --> " + trechoComprado.getLocalChegada());
                                }
                                System.out.println("");
                                System.out.println("");

                                for (int i = 0; i < auxTrechos.size(); i++) {
                                    usuario.getPassagens().getLast().getTrechos().remove(auxTrechos.get(i));
                                }
                                usuario.getPassagens().getLast().setStatusCompra(true);
                                controllerTrechos.confirmarCompra(usuario);
                                System.out.println("Sua compra foi finalizada com sucesso!");
                            }
                        }
                    } while (opcoesUsuario == 01); //DO WHILE que retorna para a opção de trechos ou menu.
                }opcoesUsuario = 2;
            } while (opcoesUsuario == 2); //DO WHILE que retorna o usuário ao menu.
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
