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

public class detalles_remedio2 extends AppCompatActivity {

    TextView txtNombre;
    TextView txtTitulo;
    TextView txtDescripcion;
    TextView txtPreparacion;
    TextView txtAdvertencia;

    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    //Recorremos la BD hasta llegar al dato que nos interesa
    private DatabaseReference dbPerejil = mRootRef.child("remedios").child("perejil con limon");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_remedio2);
        dbPerejil.keepSynced(true);
        txtNombre = (TextView) findViewById(R.id.dtituloRemedio2);
        txtNombre.setText(getIntent().getStringExtra("nombreRemedio"));
        // Todos los TextView del layout
        txtTitulo = (TextView) findViewById(R.id.dtituloRemedio2);
        txtDescripcion = (TextView) findViewById(R.id.parrafoperejil);
        txtPreparacion = (TextView) findViewById(R.id.parrafoPreparacion2);
        txtAdvertencia = (TextView) findViewById(R.id.parrafoAd2);
    }

    @Override
    protected void onStart() {
        super.onStart();

        dbPerejil.addValueEventListener(new ValueEventListener() {
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

}
