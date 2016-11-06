package com.example.greciaguzmn.natureheal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
