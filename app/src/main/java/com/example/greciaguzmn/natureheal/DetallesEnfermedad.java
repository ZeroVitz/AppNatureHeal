package com.example.greciaguzmn.natureheal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetallesEnfermedad extends AppCompatActivity {

    TextView txtNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_enfermedad);
        txtNombre =(TextView)findViewById(R.id.dtituloenfermedad);
        txtNombre.setText(getIntent().getStringExtra("nombreEnfermedad"));
    }
}
