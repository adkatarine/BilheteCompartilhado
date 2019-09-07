/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExemploServidor;

import java.io.Serializable;

/**
 *
 * @author Adlla Katarine
 */
public class Evento implements Serializable{
    
    private static final long serialVersionUD = 1L;
    private String data;
    private String titulo;
    private String local;

    public Evento(String data, String titulo, String local) {
        super();
        this.data = data;
        this.titulo = titulo;
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    
}
