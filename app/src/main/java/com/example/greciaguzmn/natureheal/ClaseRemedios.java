package com.example.greciaguzmn.natureheal;

/**
 * Created by Grecia Guzmán on 19/11/2016.
 */

public class ClaseRemedios {

    static String nombreRemedio;

    public ClaseRemedios(String nombreRemedio) {
        this.nombreRemedio = nombreRemedio;
    }

    public static String getNombreRemedio() {
        return nombreRemedio;
    }

    public void setNombreRemedio(String nombreRemedio) {
        this.nombreRemedio = nombreRemedio;
    }
}
