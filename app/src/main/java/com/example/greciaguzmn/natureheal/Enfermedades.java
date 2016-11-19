package com.example.greciaguzmn.natureheal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Enfermedades extends AppCompatActivity {

    RecyclerView nlistcontainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enfermedades);
        nlistcontainer = (RecyclerView)findViewById(R.id.listcontainer);
        EnfermedadAdapter adapter = new EnfermedadAdapter(this,getDatasources());
        nlistcontainer.setLayoutManager(new LinearLayoutManager(this));
        nlistcontainer.setAdapter(adapter);
    }

    private List<ClaseEnfermedad> getDatasources(){
        List<ClaseEnfermedad> list = new ArrayList<>();

        list.add(new ClaseEnfermedad("Gripe"));
        list.add(new ClaseEnfermedad("Fiebre"));
        list.add(new ClaseEnfermedad("Dolor de cabeza"));
        list.add(new ClaseEnfermedad("Dolor de Estomago"));
        list.add(new ClaseEnfermedad("Salpullido"));
        return list;
    }

}
