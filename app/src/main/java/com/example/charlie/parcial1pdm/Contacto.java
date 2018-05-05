package com.example.charlie.parcial1pdm;

/**
 * Created by Charlie on 5/3/2018.
 */

public class Contacto {
    private String Nombre;
    private String Tel;
    private String Foto;

    public Contacto(String nombre, String tel, String foto) {
        Nombre = nombre;
        Tel = tel;
        Foto = foto;
    }

    //Getters and Setters


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getFoto() {
        return Foto;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }
}
