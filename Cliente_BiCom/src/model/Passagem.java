/*
 * 
 */
package model;

import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Adlla Katarine
 */
public class Passagem implements Serializable{
    private static final long serialVersionUID = 1L;
    private LinkedList<Trecho> trechos; // lista dos trechos comprados
    private boolean statusCompra; // status de compra da passagem, sendo "true=compra confirmada" ou "false = compra não confirmada"
    private float valorTotalPassagem; // o valor total de todos os trechos comprados
    
    /**
     * 
     * Contrutor. Nele, a lista de trechos é instanciada e outros atributos são iniciados automaticamente.
     */
    Passagem(){
        this.trechos = new LinkedList();
        this.statusCompra = false;
        this.valorTotalPassagem = 0;
    }

    public LinkedList<Trecho> getTrechos() {
        return trechos;
    }

    public void setTrechos(LinkedList<Trecho> trechos) {
        this.trechos = trechos;
    }

    public boolean isStatusCompra() {
        return statusCompra;
    }

    public void setStatusCompra(boolean statusCompra) {
        this.statusCompra = statusCompra;
    }

    public float getValorTotalPassagem() {
        return valorTotalPassagem;
    }

    // Responsável pela soma/atualização do valor total da passagem.
    public void setValorTotalPassagem(float valorTotalPassagem) {
        this.valorTotalPassagem = this.valorTotalPassagem + valorTotalPassagem;
    }
    
    
}
