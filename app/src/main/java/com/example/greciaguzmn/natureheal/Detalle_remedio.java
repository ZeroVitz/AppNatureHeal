package com.example.greciaguzmn.natureheal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Detalle_remedio extends AppCompatActivity {

    TextView txtremedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_remedio);
        //txtremedio = (TextView) findViewById(R.id.);
        //txtremedio.setText(getIntent().getStringExtra("nombreRemedio"));
    }
}
