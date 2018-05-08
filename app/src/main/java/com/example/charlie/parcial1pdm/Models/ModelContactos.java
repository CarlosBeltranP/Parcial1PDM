package com.example.charlie.parcial1pdm.Models;

/**
 * Created by Charlie on 5/7/2018.
 */

public class ModelContactos {

    private  String nombre, numero;

    public ModelContactos(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
