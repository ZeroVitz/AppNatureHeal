package com.example.greciaguzmn.natureheal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

public class Enfermedades extends AppCompatActivity {

    RecyclerView nlistcontainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enfermedades);
        nlistcontainer = (RecyclerView)findViewById(R.id.listcontainer);
        EnfermedadAdapter adapter = new EnfermedadAdapter(this,getDatasources(),this);
        nlistcontainer.setLayoutManager(new LinearLayoutManager(this));
        nlistcontainer.setAdapter(adapter);
    }

    private List<ClaseEnfermedad> getDatasources(){
        List<ClaseEnfermedad> list = new ArrayList<>();

        list.add(new ClaseEnfermedad("Gripe"));
        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
