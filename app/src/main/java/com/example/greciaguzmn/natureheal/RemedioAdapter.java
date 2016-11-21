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

public class RemedioAdapter extends RecyclerView.Adapter<RemedioAdapter.Customr> {

    List<ClaseRemedios> datasource2;
    Activity mActivity2;
    Context ctx2;

    public RemedioAdapter(Activity activity2, List<ClaseRemedios> fuenteDeDatos2, Context ctx2) {
        mActivity2 = activity2;
        datasource2 = fuenteDeDatos2;
        this.ctx2 = ctx2;
    }

    @Override
    public RemedioAdapter.Customr onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_remedio, parent, false);
        Customr custom2 = new Customr(view, ctx2, datasource2);

        return custom2;
    }

    @Override
    public void onBindViewHolder(RemedioAdapter.Customr holder, int position) {
        holder.textView.setText(datasource2.get(position).getNombreRemedio());
    }

    @Override
    public int getItemCount() {
        return datasource2.size();
    }

    class Customr extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView textView;
        public TextView nombreRemedio;
        List<ClaseRemedios> remedios = new ArrayList<>();
        Context ctx2;
        public Customr(View itemView, Context ctx2, List<ClaseRemedios> remedios) {

            super(itemView);
            this.remedios = remedios;
            this.ctx2 = ctx2;
            ImageView image = (ImageView) itemView.findViewById(R.id.imagen2);
            image.setOnClickListener(this);
            itemView.setOnClickListener(this);
            textView = (TextView) itemView.findViewById(R.id.txt);
            nombreRemedio = (TextView) itemView.findViewById(R.id.txt2);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            ClaseRemedios remedios= this.remedios.get(position);
            Intent intent = new Intent(this.ctx2, Detalle_remedio.class );
            intent.putExtra("nombreRemedio", ClaseRemedios.getNombreRemedio());
            this.ctx2.startActivity(intent);
        }
    }
}
