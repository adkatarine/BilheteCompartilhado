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
public class ArquivoEscritaLeitura2 implements Serializable {

    private ControllerUsuario usuario;

    public ArquivoEscritaLeitura2(ControllerUsuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Grava os dados em um arquivo
     *
     * @throws java.io.FileNotFoundException
     */
    public void gravar() throws FileNotFoundException, IOException {
        //Arquivo que guarda os dados dos ADM's
        FileOutputStream fileoutput_ADM = new FileOutputStream("IDB_ADM");
        ObjectOutputStream objectoutput_ADM = new ObjectOutputStream(fileoutput_ADM);
        objectoutput_ADM.writeObject(usuario.getUsuarios());
        objectoutput_ADM.close();
    }

    /**
     * Recupera os dados de um arquivo .ser
     *
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public void recuperar() throws FileNotFoundException, IOException, ClassNotFoundException {
        //Arquivo que guarda os dados dos ADM's
        FileInputStream fileinput_ADM = new FileInputStream("IDB_ADM");
        ObjectInputStream objectinput_ADM = new ObjectInputStream(fileinput_ADM);
        usuario.setUsuarios((LinkedList<Usuario>) objectinput_ADM.readObject());
        objectinput_ADM.close();

    }

}
