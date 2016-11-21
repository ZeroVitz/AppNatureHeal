package com.example.greciaguzmn.natureheal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Registro2Activity extends AppCompatActivity implements View.OnClickListener {

    Button boton, boton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro2);
        boton = (Button) findViewById(R.id.botonReg2);
        boton.setOnClickListener(this);
        boton2 = (Button) findViewById(R.id.boton2Reg2);
        boton.setOnClickListener(this);

        Spinner spinner_alimentos = (Spinner) findViewById(R.id.spinnerAlimentos);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource( this, R.array.alimentos , android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_alimentos.setAdapter(spinner_adapter);

        Spinner spinner_alergias = (Spinner) findViewById(R.id.spinnerAlergia);
        ArrayAdapter spinner_adapter2 = ArrayAdapter.createFromResource( this, R.array.alergias, android.R.layout.simple_spinner_item);
        spinner_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_alergias.setAdapter(spinner_adapter2);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botonReg2:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.boton2Reg2:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                break;

            default:
                break;
        }

    }
}
