package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import model.*;
import controller.*;

/**
 * @author Daniel Costa
 * @author Adlla Katarine
 */
public class ArquivoEscritaLeitura implements Serializable {

    private ControllerUsuario usuario;

    public ArquivoEscritaLeitura(ControllerUsuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Grava os dados em um arquivo
     *
     * @throws java.io.FileNotFoundException
     */
    public void gravar() throws FileNotFoundException, IOException {
        //Arquivo que guarda os dados dos usuários
        FileOutputStream fileoutput_BiCom = new FileOutputStream("BiCom");
        try (ObjectOutputStream objectoutput_BiCom = new ObjectOutputStream(fileoutput_BiCom)) {
            objectoutput_BiCom.writeObject(usuario.getUsuarios());
        }
    }

    /**
     * Recupera os dados de um arquivo .ser
     *
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public void recuperar() throws FileNotFoundException, IOException, ClassNotFoundException {
        //Arquivo que guarda os dados dos usuários
        FileInputStream fileinput_BiCom = new FileInputStream("BiCom");
        try (ObjectInputStream objectinput_BiCom = new ObjectInputStream(fileinput_BiCom)) {
            usuario.setUsuarios((LinkedList<Usuario>) objectinput_BiCom.readObject());
        }

    }

}
