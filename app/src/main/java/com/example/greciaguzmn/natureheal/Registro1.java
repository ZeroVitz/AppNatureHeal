package com.example.greciaguzmn.natureheal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Registro1 extends AppCompatActivity implements View.OnClickListener{

    Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro1);
        boton = (Button) findViewById(R.id.botonReg);
        boton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonReg:
                Intent intent= new Intent(this, Registro2.class);
                startActivity(intent);
                break;

            default:
                break;
        }

    }
}
