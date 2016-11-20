package com.example.greciaguzmn.natureheal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Remedios extends AppCompatActivity {

    RecyclerView nlistcontainer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedios);
        nlistcontainer2 = (RecyclerView)findViewById(R.id.listcontainer2);
        RemedioAdapter adapter = new RemedioAdapter(this, getDatasources2());
        nlistcontainer2.setLayoutManager(new LinearLayoutManager(this));
        nlistcontainer2.setAdapter(adapter);

    }

    private List<ClaseRemedios> getDatasources2(){
        List<ClaseRemedios> list = new ArrayList<>();
        list.add(new ClaseRemedios("Té de lavanda"));
        list.add(new ClaseRemedios("Té de canela tibio"));
        list.add(new ClaseRemedios("Infusión de eucalipto"));
        list.add(new ClaseRemedios("Vinagre de manzana"));
        list.add(new ClaseRemedios("Mascarilla de naranja"));
        return list;
    }


}
