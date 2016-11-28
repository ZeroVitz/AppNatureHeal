package com.example.greciaguzmn.natureheal;

/**
 * Created by CRUZ on 27/11/2016.
 */

public class Enfermedad {

    private String nombre, imagen;

    public Enfermedad (){}

    public Enfermedad(String nombre, String imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
