/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author iapereira
 */
public class Veiculo {
    private int id;
    private String placa;
    private int ano;
    private ArrayList<Foto> fotos = new ArrayList<Foto>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void addFoto(String path) throws FileNotFoundException, IOException {
        File newFile = new File(path);

        FileInputStream fileInputStream = new FileInputStream(newFile);
        
        Foto novaFoto = new Foto(fileInputStream.readAllBytes(), this);
        this.fotos.add(novaFoto);

        fileInputStream.close();
    }

    @Override
    public String toString() {
        return "Veiculo{" + "id=" + id + ", placa=" + placa + ", ano=" + ano + '}';
    }
    
    
    
}
