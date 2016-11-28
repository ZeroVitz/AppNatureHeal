package com.example.greciaguzmn.natureheal;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Remedios extends AppCompatActivity {

    private RecyclerView nlistenfermedades;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedios);

        mDatabase = FirebaseDatabase.getInstance().getReference().child("remedios");

        nlistenfermedades = (RecyclerView) findViewById(R.id.listaremedios);
        nlistenfermedades.setHasFixedSize(true);
        nlistenfermedades.setLayoutManager(new LinearLayoutManager(this));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<EnfermedadRemedio, Enfermedades.EnfermedadViewHolder> FirebaseRecyclerAdapter = new FirebaseRecyclerAdapter<EnfermedadRemedio, Enfermedades.EnfermedadViewHolder>(
                EnfermedadRemedio.class, R.layout.lista_view2, Enfermedades.EnfermedadViewHolder.class,mDatabase) {


            @Override
            protected void populateViewHolder(Enfermedades.EnfermedadViewHolder viewHolder, EnfermedadRemedio model, final int position) {

                final String post_key = model.getNombre();

                viewHolder.setTitle(model.getNombre());
                viewHolder.setImage(getApplicationContext(), model.getImagen());


                viewHolder.mview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if ((post_key.equals("Te de lavanda"))) {
                            Intent intent = new Intent(getApplicationContext(), Detalle_remedio.class);
                            startActivity(intent);
                        }
                    }
                });

            }
        };

        nlistenfermedades.setAdapter(FirebaseRecyclerAdapter);
    }

    public static class EnfermedadViewHolder extends RecyclerView.ViewHolder{

        View mview;
        TextView post_title;

        public EnfermedadViewHolder(View itemView) {
            super(itemView);

            mview = itemView ;

            post_title = (TextView) mview.findViewById(R.id.postTitle);

            post_title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

        public void setTitle(String title) {

            TextView postTitle = (TextView) mview.findViewById(R.id.postTitle);
            postTitle.setText(title);
        }

        public void setImage (Context ctx, String image) {

            ImageView post_image = (ImageView) mview.findViewById(R.id.postImage);
            Picasso.with(ctx).load(image).into(post_image);

        }


    }

}
