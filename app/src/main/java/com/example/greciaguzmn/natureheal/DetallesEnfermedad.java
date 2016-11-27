package com.example.greciaguzmn.natureheal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetallesEnfermedad extends AppCompatActivity {

    TextView txtNombre;

    TextView txtTitulo;
    //Mandamos a buscar la referencia a la raiz de nuestra BD no relacional
    private DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    //Recorremos la BD hasta llegar al dato que nos interesa
    private DatabaseReference mTitulo = mRootRef.child("enfermedades").child("gripe").child("nombre");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_enfermedad);
        txtNombre =(TextView)findViewById(R.id.dtituloenfermedad);
        txtNombre.setText(getIntent().getStringExtra("nombreEnfermedad"));
        //

        txtTitulo = (TextView) findViewById(R.id.dtituloenfermedad);

    }

    //Este es el metodo cuando se ejecuta la aplicacion.
    @Override
    protected void onStart() {
        super.onStart();

        mTitulo.addValueEventListener(new ValueEventListener() {
            //Este metodo sirve para cuando inicia y cuando sucede un cambio
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String data = dataSnapshot.getValue(String.class);
                txtTitulo.setText(data);
            }
            //Este metodo sirve para cuando da error
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
