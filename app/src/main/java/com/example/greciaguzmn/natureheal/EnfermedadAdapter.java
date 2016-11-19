package com.example.greciaguzmn.natureheal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Grecia Guzmán on 19/11/2016.
 */

public class EnfermedadAdapter extends RecyclerView.Adapter<EnfermedadAdapter.Custom> {

    List<ClaseEnfermedad> datasource;
    Activity mActivity;

    public EnfermedadAdapter(Activity activity, List<ClaseEnfermedad> fuenteDeDatos) {
        mActivity = activity;
        datasource = fuenteDeDatos;
    }

    @Override
    public Custom onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        Custom custom = new Custom(view);

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

    class Custom extends RecyclerView.ViewHolder implements AdapterView.OnClickListener{

        public TextView textView;
        public TextView nombreEnfermedad;

        public Custom(View itemView) {

            super(itemView);
            ImageView image = (ImageView) itemView.findViewById(R.id.imagen);
            image.setOnClickListener(this);
            itemView.setOnClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.texto);
            nombreEnfermedad = (TextView) itemView.findViewById(R.id.texto2);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(mActivity, nombreEnfermedad.getText().toString(), Toast.LENGTH_LONG ).show();
            Intent intent = new Intent(mActivity, Enfermedades.class);
            mActivity.startActivity(intent);

        }
    }

}
