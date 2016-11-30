package com.example.greciaguzmn.natureheal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Detalle_remedio extends AppCompatActivity {

    TextView txtNombre;

    //Todos los Text del layout
    TextView txtTitulo;
    TextView txtDescripcion;
    TextView txtPreparacion;
    TextView txtAdvertencia;


    //Mandamos a buscar la referencia a la raiz de nuestra BD no relacional
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();

    //Recorremos la BD hasta llegar al dato que nos interesa
    private DatabaseReference dbGripe = mRootRef.child("remedios").child("te_lavanda");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_remedio);
        dbGripe.keepSynced(true);
        txtNombre = (TextView) findViewById(R.id.dtituloRemedio);
        txtNombre.setText(getIntent().getStringExtra("nombreRemedio"));
        // Todos los TextView del layout
        txtTitulo = (TextView) findViewById(R.id.dtituloRemedio);
        txtDescripcion = (TextView) findViewById(R.id.parrafoTe);
        txtPreparacion = (TextView) findViewById(R.id.parrafoPreparacion);
        txtAdvertencia = (TextView) findViewById(R.id.parrafoAd1);
    }

    //Este es el metodo cuando se ejecuta la aplicacion.
    @Override
    protected void onStart() {
        super.onStart();

        dbGripe.addValueEventListener(new ValueEventListener() {
            //Este metodo sirve para cuando inicia y cuando sucede un cambio
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Nuestro respectivo Map que le hacemos un pequeño casting para soporte toda la info de gripe
                Map<String, String> map = (Map)dataSnapshot.getValue();
                //Le pedimos el dato con su clave especifica
                String titulo = map.get("nombre");
                String descripcion = map.get("descripcion");
                String preparacion = map.get("preparacion");
                String advertencia = map.get("advertencia");

                //Agregamos los cambios
                txtTitulo.setText(titulo);
                txtDescripcion.setText(descripcion);
                txtPreparacion.setText(preparacion);
                txtAdvertencia.setText(advertencia);

            }

            //Este metodo sirve para cuando da error
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
