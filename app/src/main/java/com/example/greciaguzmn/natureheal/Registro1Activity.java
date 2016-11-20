package com.example.greciaguzmn.natureheal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.stephentuso.welcome.WelcomeHelper;

public class Registro1Activity extends AppCompatActivity implements View.OnClickListener {

    Button boton;
    WelcomeHelper welcomeScreen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro1);
        boton = (Button) findViewById(R.id.botonReg);
        boton.setOnClickListener(this);

        welcomeScreen = new WelcomeHelper(this, MyWelcomeActivity.class);
        welcomeScreen.show(savedInstanceState);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.botonReg:
                Intent intent = new Intent(this, Registro2Activity.class);
                startActivity(intent);
                break;

            default:
                break;
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        welcomeScreen.onSaveInstanceState(outState);
    }


}
