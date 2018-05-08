package com.example.charlie.parcial1pdm.Adapters;

import android.Manifest;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.charlie.parcial1pdm.Models.ModelContactos;
import com.example.charlie.parcial1pdm.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 5/7/2018.
 */

public class ContactosRecyclerViewAdapter extends RecyclerView.Adapter<ContactosRecyclerViewAdapter.ViewHolder>{

    private Context mContext;
    private LayoutInflater inflater;
    private List<ModelContactos> mListaContactos;

    public  ContactosRecyclerViewAdapter(Context context, List<ModelContactos> listaContactos){

        mListaContactos = listaContactos;

        mContext = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.eltos_contactos,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;


    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        TextView nombre_contacto, numero_contacto;

        nombre_contacto = holder.nombre_contacto;
        numero_contacto = holder.numero_contacto;

        nombre_contacto.setText(mListaContactos.get(position).getNombre());
        numero_contacto.setText(mListaContactos.get(position).getNumero());


        holder.llamada.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+mListaContactos.get(position).getNumero()));

                if(ContextCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE)!=
                        PackageManager.PERMISSION_GRANTED )
                    return;
                mContext.startActivity(intent);
            }

        });

    }

    @Override
    public int getItemCount() {
        return mListaContactos.size();
    }

    public  void filterList(List<ModelContactos> filteredList){
        mListaContactos = filteredList;
        notifyDataSetChanged();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombre_contacto, numero_contacto;
        Button llamada;
        ImageButton contacto;


        public ViewHolder(View itemView) {
            super(itemView);

            nombre_contacto = itemView.findViewById(R.id.tv_nombre_contacto);
            numero_contacto = itemView.findViewById(R.id.tv_numero_contacto);

            llamada = itemView.findViewById(R.id.boton_llamar);
            contacto = itemView.findViewById(R.id.ibtn_contacto);

        }
    }
}
