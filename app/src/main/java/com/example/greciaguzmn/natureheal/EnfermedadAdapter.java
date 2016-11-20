package com.example.greciaguzmn.natureheal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Grecia Guzmán on 19/11/2016.
 */

public class EnfermedadAdapter extends RecyclerView.Adapter<EnfermedadAdapter.Custom> {

    List<ClaseEnfermedad> datasource;
    Activity mActivity;
    Context ctx;

    public EnfermedadAdapter(Activity activity, List<ClaseEnfermedad> fuenteDeDatos, Context ctx) {
        mActivity = activity;
        datasource = fuenteDeDatos;
        this.ctx = ctx;
    }

    @Override
    public Custom onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        Custom custom = new Custom(view, ctx, datasource);

        return custom;
    }

    @Override
    public void onBindViewHolder(Custom holder, int position) {
        holder.textView.setText(datasource.get(position).getNombreEnfermedad());
    }

    @Override
    public int getItemCount() {
        return datasource.size();
    }

    class Custom extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView textView;
        public TextView nombreEnfermedad;
        List<ClaseEnfermedad> enfermedades = new ArrayList<>();
        Context ctx;

        public Custom(View itemView, Context ctx, List<ClaseEnfermedad> enfermedad) {

            super(itemView);
            this.enfermedades = enfermedad;
            this.ctx = ctx;
            itemView.setOnClickListener(this);
            ImageView image = (ImageView) itemView.findViewById(R.id.imagen);
            image.setOnClickListener(this);
            itemView.setOnClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.texto);
            nombreEnfermedad = (TextView) itemView.findViewById(R.id.texto2);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ClaseEnfermedad enfermedad = this.enfermedades.get(position);
            Intent intent = new Intent(this.ctx, DetallesEnfermedad.class );
            intent.putExtra("nombreEnfermedad",ClaseEnfermedad.getNombreEnfermedad());
            this.ctx.startActivity(intent);
        }
    }

}
