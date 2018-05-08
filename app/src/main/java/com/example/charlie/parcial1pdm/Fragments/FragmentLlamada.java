package com.example.charlie.parcial1pdm.Fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charlie.parcial1pdm.Adapters.LlamadasRecilerViewAdapter;
import com.example.charlie.parcial1pdm.Models.ModelLLamadas;
import com.example.charlie.parcial1pdm.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Charlie on 5/3/2018.
 */

public class FragmentLlamada extends Fragment {


    private RecyclerView recyclerView;
    View view;


    public FragmentLlamada() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_llamada, container, false);
        recyclerView = view.findViewById(R.id.RecyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(layoutManager);

        LlamadasRecilerViewAdapter adapter = new LlamadasRecilerViewAdapter(getContext(), getCallLogs());

        recyclerView.setAdapter(adapter);

        return view;
    }

    private List<ModelLLamadas> getCallLogs() {
        List<ModelLLamadas> lista = new ArrayList<>();

        if(ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_CALL_LOG}, 1);
        }
        Cursor cursor = getContext().getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, CallLog.Calls.DATE + " DESC");

        int nombre =  cursor.getColumnIndex(CallLog.Calls.CACHED_NAME);
        int numero =  cursor.getColumnIndex(CallLog.Calls.NUMBER);

        int fecha  = cursor.getColumnIndex(CallLog.Calls.DATE);




        cursor.moveToFirst();
        while (cursor.moveToNext()){
            Date fecha1 = new Date(Long.valueOf(cursor.getString(fecha)));
            lista.add(new ModelLLamadas(cursor.getString(nombre), cursor.getString(numero), fecha1.toString()));
        }

        return lista;

    }

}
