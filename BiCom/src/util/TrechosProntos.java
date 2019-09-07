/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import model.Trecho;

/**
 *
 * @author Adlla Katarine
 */
public class TrechosProntos implements Serializable{
    private ArrayList<Trecho> trechos;
    private Trecho trecho;
    private static final long serialVersionUID = 6L;
    
    public TrechosProntos(){
        this.trechos = new ArrayList();
    }
    
    //Trecho(String localPartida, String localChegada, int quantAssentos, String ID, float valorTrecho)
    
    public ArrayList<Trecho> add(int porta){
        
        switch (porta) {
            case 1888:
                this.trecho = new Trecho("Acre", "Amazonas", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Acre", "Rondônia", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Acre", "Brasília", 50, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Pará", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Paraíba", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Rio de Janeiro", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Minas Gerais", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Espirito Santo", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Mato Grosso", 50, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Distrito Federal", 50, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Amazonas", "Rio Grande do Norte", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Alagoas", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Goiás", 50, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "São Paulo", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Santa Catarina", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Minas Gerais", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Rio Grande do Sul", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Pará", "Paraíba", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pará", "Ceará", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pará", "Mato Grosso", 50, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pará", "Distrito Federal", 50, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pará", "Paraná", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                
                this.trecho = new Trecho("Rondônia", "Roraima", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rondônia", "Goiás", 50, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rondônia", "Espirito Santo", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Roraima", "Acre", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Roraima", "Alagoas", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Roraima", "São Paulo", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Tocantins", "Bahia", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Tocantins", "Pernambuco", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Tocantins", "Brasília", 50, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Tocantins", "Santa Catarina", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Tocantins", "Rio Grande do Sul", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                
                this.trecho = new Trecho("Alagoas", "Rio de Janeiro", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Alagoas", "Brasília", 50, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Bahia", "Brasília", 50, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Bahia", "Rio de Janeiro", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Bahia", "Acre", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Ceará", "Espirito Santo", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Maranhão", "Mato Grosso do Sul", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Maranhão", "Amazonas", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Paraíba", "Sergipe", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Paraíba", "São Paulo", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Piauí", "Rondônia", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Piauí", "Minas Gerais", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Pernambuco", "Rio Grande do Sul", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pernambuco", "Rio Grande do Norte", 50, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Rio Grande do Norte", "Paraná", 50, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rio Grande do Norte", "Distrito Federal", 50, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Sergipe", "Mato Grosso", 50, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                
                break;
            case 1889:
                this.trecho = new Trecho("Goiás", "Acre", 50, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Goiás", "São Paulo", 50, "CompanhiaB", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Goiás", "Brasília", 50, "CompanhiaB", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Goiás", "Tocantins", 50, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                
                this.trecho = new Trecho("Mato Grosso", "Rio Grande do Norte", 50, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Mato Grosso", "Brasília", 50, "CompanhiaB", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Mato Grosso do Sul", "São Paulo", 50, "CompanhiaB", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Distrito Federal", "Goiás", 50, "CompanhiaB", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Distrito Federal", "Minas Gerais", 50, "CompanhiaB", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Brasília", "Bahia", 50, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Mato Grosso", "Sergipe", 50, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                break;
            default:
                this.trecho = new Trecho("Espírito Santo", "Amapá", 50, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Espírito Santo", "Roraima", 50, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Espírito Santo", "Mato Grosso", 50, "CompanhiaC", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Minas Gerais", "Roraima", 50, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Minas Gerais", "Tocantins", 50, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Minas Gerais", "Distrito Federal", 50, "CompanhiaC", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Rio de Janeiro", "São Paulo", 50, "CompanhiaC", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rio de Janeiro", "Pernambuco", 50, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rio de Janeiro", "Amazonas", 50, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("São Paulo", "Alagoas", 50, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("São Paulo", "Ceará", 50, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("São Paulo", "Rio Grande do Sul", 50, "CompanhiaC", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("São Paulo", "Paraná", 50, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Paraná", "Amazonas", 50, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Santa Catarina", "Bahia", 50, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Santa Catarina", "Amapá", 50, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Rio Grande do Sul", "Rio de Janeiro", 50, "CompanhiaC", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                break;
        }
        
        return trechos;
    }
}
