package com.example.greciaguzmn.natureheal;

/**
 * Created by Grecia Guzmán on 19/11/2016.
 */

public class ClaseEnfermedad {

    static String nombreEnfermedad;

    public ClaseEnfermedad(String nombreEnfermedad) {
        this.setNombreEnfermedad(nombreEnfermedad);
    }

    public static String getNombreEnfermedad() {
        return nombreEnfermedad;
    }

    public void setNombreEnfermedad(String nombreEnfermedad) {
        this.nombreEnfermedad = nombreEnfermedad;
    }
}
