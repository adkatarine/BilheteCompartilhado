/*
 * Classe com todos os trechos "disponíveis" para serem criados assim que cada servidor for iniciado.
 */
package util;

import java.io.Serializable;
import java.util.ArrayList;
import model.Trecho;

/**
 *
 * @author Adlla Katarine
 */
public class TrechosProntos implements Serializable{
    private ArrayList<Trecho> trechos; // array que guarda todos os objetos de trechos criados
    private Trecho trecho; // atributo para instancia de cada trecho
    private static final long serialVersionUID = 6L;
    
    public TrechosProntos(){
        this.trechos = new ArrayList();
    }
    
    /**
     * Recebe o valor da porta do servidor e instacia os trechos referentes a ela.
     * 
     * @param porta
     * @return ArrayList<Trecho>
     */
    public ArrayList<Trecho> add(int porta){
        
        switch (porta) {
            case 1888:
                this.trecho = new Trecho("Acre", "Amazonas", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Acre", "Rondônia", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Acre", "Brasília", 5, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Pará", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Paraíba", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Rio de Janeiro", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Minas Gerais", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Espirito Santo", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Mato Grosso", 5, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Distrito Federal", 5, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Amazonas", "Rio Grande do Norte", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Alagoas", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Goiás", 5, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "São Paulo", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Santa Catarina", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Minas Gerais", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Rio Grande do Sul", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Pará", "Paraíba", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pará", "Ceará", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pará", "Mato Grosso", 5, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pará", "Distrito Federal", 5, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pará", "Paraná", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                
                this.trecho = new Trecho("Rondônia", "Roraima", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rondônia", "Goiás", 5, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rondônia", "Espirito Santo", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Roraima", "Acre", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Roraima", "Alagoas", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Roraima", "São Paulo", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Tocantins", "Bahia", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Tocantins", "Pernambuco", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Tocantins", "Brasília", 5, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Tocantins", "Santa Catarina", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Tocantins", "Rio Grande do Sul", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                
                this.trecho = new Trecho("Alagoas", "Rio de Janeiro", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Alagoas", "Brasília", 5, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Bahia", "Brasília", 5, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Bahia", "Rio de Janeiro", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Bahia", "Acre", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Ceará", "Espirito Santo", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Maranhão", "Mato Grosso do Sul", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Maranhão", "Amazonas", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Paraíba", "Sergipe", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Paraíba", "São Paulo", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Piauí", "Rondônia", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Piauí", "Minas Gerais", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Pernambuco", "Rio Grande do Sul", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pernambuco", "Rio Grande do Norte", 5, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Rio Grande do Norte", "Paraná", 5, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rio Grande do Norte", "Distrito Federal", 5, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Sergipe", "Mato Grosso", 5, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                System.out.println("CompanhiaA");
                break;
            case 1889:
                this.trecho = new Trecho("Goiás", "Acre", 5, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Goiás", "São Paulo", 5, "CompanhiaB", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Goiás", "Brasília", 5, "CompanhiaB", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Goiás", "Tocantins", 5, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                
                this.trecho = new Trecho("Mato Grosso", "Rio Grande do Norte", 5, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Mato Grosso", "Brasília", 5, "CompanhiaB", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Mato Grosso do Sul", "São Paulo", 5, "CompanhiaB", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Distrito Federal", "Goiás", 5, "CompanhiaB", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Distrito Federal", "Minas Gerais", 5, "CompanhiaB", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Brasília", "Bahia", 5, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Mato Grosso", "Sergipe", 5, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                System.out.println("CompanhiaB");
                break;
            default:
                this.trecho = new Trecho("Espírito Santo", "Amapá", 5, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Espírito Santo", "Roraima", 5, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Espírito Santo", "Mato Grosso", 5, "CompanhiaC", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Minas Gerais", "Roraima", 5, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Minas Gerais", "Tocantins", 5, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Minas Gerais", "Distrito Federal", 5, "CompanhiaC", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Rio de Janeiro", "São Paulo", 5, "CompanhiaC", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rio de Janeiro", "Pernambuco", 5, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rio de Janeiro", "Amazonas", 5, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("São Paulo", "Alagoas", 5, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("São Paulo", "Ceará", 5, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("São Paulo", "Rio Grande do Sul", 5, "CompanhiaC", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("São Paulo", "Paraná", 5, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Paraná", "Amazonas", 5, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Santa Catarina", "Bahia", 5, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Santa Catarina", "Amapá", 5, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Rio Grande do Sul", "Rio de Janeiro", 5, "CompanhiaC", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                System.out.println("CompanhiaC");
                break;
        } return trechos;
    }
}