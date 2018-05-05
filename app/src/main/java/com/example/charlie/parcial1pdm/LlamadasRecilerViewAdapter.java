package com.example.charlie.parcial1pdm;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.CallLog;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.app.PendingIntent.getActivity;

/**
 * Created by Charlie on 5/3/2018.
 */

public class LlamadasRecilerViewAdapter extends RecyclerView.Adapter<LlamadasRecilerViewAdapter.ViewHolder> {

   FragmentLlamada m = null;
    private Context context;


    private LayoutInflater layoutInflater;
    private Context miContext;

    private List<ModelLLamadas> milistaLLamadas;

    public LlamadasRecilerViewAdapter(Context context, List<ModelLLamadas> listCalls) {
        miContext = context;
        milistaLLamadas = listCalls;
    }

    public LlamadasRecilerViewAdapter(MainActivity mainActivity) {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        layoutInflater = layoutInflater.from(miContext);

        View view = layoutInflater.inflate(R.layout.eltos_llamadas, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final TextView nombre, numero, fecha, numero2;

        nombre = holder.nombre;
        fecha = holder.fecha;
        numero2 = holder.numero;
        numero = holder.numero;


        nombre.setText(milistaLLamadas.get(position).getNombre());
        numero.setText(milistaLLamadas.get(position).getNumero());
        fecha.setText(milistaLLamadas.get(position).getFecha());



        holder.llamada.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+milistaLLamadas.get(position).getNumero()));

                if(ContextCompat.checkSelfPermission(miContext, Manifest.permission.CALL_PHONE)!=
                        PackageManager.PERMISSION_GRANTED )
                    return;
               miContext.startActivity(intent);
            }

        });

    }


    @Override
    public int getItemCount() {
        return milistaLLamadas.size();
    }


    //PLACE VIEW HOLDER

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, numero, fecha;
        Button inf_contacto, llamada;

        ArrayList<Contacto> contacts = new ArrayList<Contacto>();
        Context context;

        public ViewHolder(View itemView) {

            super(itemView);


            //TEXTVIEWS
            nombre = (TextView) itemView.findViewById(R.id.tv_nombre_contacto);
            numero = (TextView) itemView.findViewById(R.id.tv_numero_contacto);
            fecha = (TextView) itemView.findViewById(R.id.tv_fecha);

            //BOTONES
            inf_contacto = (Button) itemView.findViewById(R.id.btn_contacto);
            llamada = (Button) itemView.findViewById(R.id.boton_llamar);


        }


    }
}

