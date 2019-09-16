/**
 *
 * Controller responsável pela venda de trechos disponíveis aos usuários.
 */
package controller;

import Interface.C_Trechos;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import model.Passagem;
import model.Trecho;
import model.Usuario;
import util.TrechosProntos;
/**
 *
 * @author Adlla Katarine
 */
public class ControllerTrechos extends UnicastRemoteObject implements C_Trechos {

    private static final long serialVersionUID = 4L;
    private ArrayList<Trecho> trechos; // lista de todos os trechos disponíveis
    private TrechosProntos tProntos; // classe de trechos prontos para cada companhia

    /**
     *
     * Contrutor. Nele, a lista de trechos é instanciada e inicializada.
     */
    public ControllerTrechos(int porta) throws RemoteException {
        super();
        this.trechos = new ArrayList<>();
        this.tProntos = new TrechosProntos();
        this.trechos = this.tProntos.add(porta);
    }

    public ArrayList<Trecho> getTrechos() {
        return trechos;
    }

    public void setTrechos(ArrayList<Trecho> trechos) {
        this.trechos = trechos;
    }
    @Override
    public ArrayList<Trecho> trechosDisponíveis() {
        return this.trechos;
    }

    /**
     * Verifica se há passagens compradas ou se a última ainda não teve sua compra finalizada. Chama o método addTrechoAux() para
     * add o trecho.
     * 
     * @param usuario
     * @param trecho
     * @return Usuario
     */
    @Override
    public Usuario addTrecho(Usuario usuario, Trecho trecho) {
        if (usuario.getPassagens().size() > 0) {
            Passagem passagem = usuario.getPassagens().getLast();
            System.out.println("primeiro if");
            if (!passagem.isStatusCompra()) {
                passagem.addTrecho(trecho);
                System.out.println("segundo if" + trecho.getLocalPartida() + " - "+ trecho.getLocalChegada());
            } else {
                addTrechoAux(usuario, trecho);
                System.out.println("primeiro else" + trecho.getLocalPartida() + " - "+ trecho.getLocalChegada());
            }
        } else {
            addTrechoAux(usuario, trecho);
            System.out.println("segundo else" + trecho.getLocalPartida() + " - "+ trecho.getLocalChegada());
        }
        return usuario;
    }

    /**
     * Adiciona trecho escolhido pelo usuário em sua passagem.
     * 
     * @param usuario
     * @param trecho 
     */
    private void addTrechoAux(Usuario usuario, Trecho trecho) {
        Passagem passagemAux = new Passagem();
        passagemAux.addTrecho(trecho);
        usuario.addPassagem(passagemAux);
    }

    /**
     * Verifica se há assentos disponiveis no trecho, caso tenho o método subtrai a quantidade de assentos e retorna true;
     * 
     * @return boolean
     */
    @Override
    public boolean comprarTrechos(Trecho trecho) {
        synchronized (this) {
            Iterator iterator = this.trechos.iterator();

            while (iterator.hasNext()) {
                Trecho trechinho = (Trecho) iterator.next();
                if (trecho.getLocalPartida().equals(trechinho.getLocalPartida()) && trecho.getLocalChegada().equals(trechinho.getLocalChegada())) {
                    if (trechinho.getQuantAssentos() > 0) {
                        trechinho.setQuantAssentos();
                        return true;
                    }
                }
            }
        } return false;
    }

    /**
     * Confirma a compra de trechos (bilhetes) do usuário na variável statusCompra da classe Passagem.
     * 
     */
    @Override
    public void confirmarCompra(Usuario usuario) {
        if (!usuario.getPassagens().getLast().isStatusCompra()) {
            usuario.getPassagens().getLast().setStatusCompra(true);
        }
    }
}
