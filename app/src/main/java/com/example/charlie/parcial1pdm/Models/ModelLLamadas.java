package com.example.charlie.parcial1pdm.Models;

/**
 * Created by Charlie on 5/3/2018.
 */

public class ModelLLamadas {
    private String nombre;
    private String numero;
    private String fecha;


    public ModelLLamadas (String nombre, String numero, String fecha){
        this.nombre = nombre;
        this.fecha = fecha;
        this.numero = numero;


    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
