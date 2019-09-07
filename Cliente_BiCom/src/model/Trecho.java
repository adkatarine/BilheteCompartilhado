/*
 * 
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Adlla Katarine
 */
public class Trecho implements Serializable{
    private static final long serialVersionUID = 2L;
    private String localPartida; // local de partida do avião
    private String localChegada; // local de chegada do avião
    private int quantAssentos; // quantidade de assentos totais para este voo
    private String ID; // ID que identificará de qual companhia aerea um trecho pertence: CompanhiaA, CompanhiaB ou CompanhiaC
    private float valorTrecho; // valor da compra de um trecho

    /**
     * 
     * Contrutor. Nele, todos os atributos são iniciados.
     */
    public Trecho(String localPartida, String localChegada, int quantAssentos, String ID, float valorTrecho) {
        this.localPartida = localPartida;
        this.localChegada = localChegada;
        this.quantAssentos = quantAssentos;
        this.ID = ID;
        this.valorTrecho = valorTrecho;
    }

    public String getLocalPartida() {
        return localPartida;
    }

    public void setLocalPartida(String localPartida) {
        this.localPartida = localPartida;
    }

    public String getLocalChegada() {
        return localChegada;
    }

    public void setLocalChegada(String localChegada) {
        this.localChegada = localChegada;
    }

    public int getQuantAssentos() {
        return quantAssentos;
    }

    public void setQuantAssentos() {
        if(this.quantAssentos >= 1){
            this.quantAssentos = this.quantAssentos - 1;
        }
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getValorTrecho() {
        return valorTrecho;
    }

    public void setValorTrecho(float valorTrecho) {
        this.valorTrecho = valorTrecho;
    }
    
    
}
