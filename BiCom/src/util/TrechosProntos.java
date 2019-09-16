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
                this.trecho = new Trecho("Acre", "Amazonas", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Acre", "Rondônia", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Acre", "Brasília", 3, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Pará", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Paraíba", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Rio de Janeiro", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Minas Gerais", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Espirito Santo", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Mato Grosso", 3, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amapá", "Distrito Federal", 3, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Amazonas", "Rio Grande do Norte", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Alagoas", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Goiás", 3, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "São Paulo", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Santa Catarina", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Minas Gerais", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Amazonas", "Rio Grande do Sul", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Pará", "Paraíba", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pará", "Ceará", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pará", "Mato Grosso", 3, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pará", "Distrito Federal", 3, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pará", "Paraná", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                
                this.trecho = new Trecho("Rondônia", "Roraima", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rondônia", "Goiás", 3, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rondônia", "Espirito Santo", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Roraima", "Acre", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Roraima", "Alagoas", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Roraima", "São Paulo", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Tocantins", "Bahia", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Tocantins", "Pernambuco", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Tocantins", "Brasília", 3, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Tocantins", "Santa Catarina", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Tocantins", "Rio Grande do Sul", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                
                this.trecho = new Trecho("Alagoas", "Rio de Janeiro", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Alagoas", "Brasília", 3, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Bahia", "Brasília", 3, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Bahia", "Rio de Janeiro", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Bahia", "Acre", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Ceará", "Espirito Santo", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Maranhão", "Mato Grosso do Sul", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Maranhão", "Amazonas", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Paraíba", "Sergipe", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Paraíba", "São Paulo", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Piauí", "Rondônia", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Piauí", "Minas Gerais", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Pernambuco", "Rio Grande do Sul", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Pernambuco", "Rio Grande do Norte", 3, "CompanhiaA", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Rio Grande do Norte", "Paraná", 3, "CompanhiaA", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rio Grande do Norte", "Distrito Federal", 3, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Sergipe", "Mato Grosso", 3, "CompanhiaA", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                System.out.println("CompanhiaA");
                break;
            case 1889:
                this.trecho = new Trecho("Goiás", "Acre", 3, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Goiás", "São Paulo", 3, "CompanhiaB", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Goiás", "Brasília", 3, "CompanhiaB", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Goiás", "Tocantins", 3, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                
                this.trecho = new Trecho("Mato Grosso", "Rio Grande do Norte", 3, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Mato Grosso", "Brasília", 3, "CompanhiaB", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Mato Grosso do Sul", "São Paulo", 3, "CompanhiaB", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Distrito Federal", "Goiás", 3, "CompanhiaB", "CompanhiaB", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Distrito Federal", "Minas Gerais", 3, "CompanhiaB", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Brasília", "Bahia", 3, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Mato Grosso", "Sergipe", 3, "CompanhiaB", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                System.out.println("CompanhiaB");
                break;
            default:
                this.trecho = new Trecho("Espírito Santo", "Amapá", 3, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Espírito Santo", "Roraima", 3, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Espírito Santo", "Mato Grosso", 3, "CompanhiaC", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Minas Gerais", "Roraima", 3, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Minas Gerais", "Tocantins", 3, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Minas Gerais", "Distrito Federal", 3, "CompanhiaC", "CompanhiaB", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Rio de Janeiro", "São Paulo", 3, "CompanhiaC", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rio de Janeiro", "Pernambuco", 3, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Rio de Janeiro", "Amazonas", 3, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("São Paulo", "Alagoas", 3, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("São Paulo", "Ceará", 3, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("São Paulo", "Rio Grande do Sul", 3, "CompanhiaC", "CompanhiaC", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("São Paulo", "Paraná", 3, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Paraná", "Amazonas", 3, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Santa Catarina", "Bahia", 3, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                this.trecho = new Trecho("Santa Catarina", "Amapá", 3, "CompanhiaC", "CompanhiaA", 200);
                this.trechos.add(trecho);
                
                this.trecho = new Trecho("Rio Grande do Sul", "Rio de Janeiro", 3, "CompanhiaC", "CompanhiaC", 200);
                this.trechos.add(trecho);
                
                System.out.println("CompanhiaC");
                break;
        } return trechos;
    }
}