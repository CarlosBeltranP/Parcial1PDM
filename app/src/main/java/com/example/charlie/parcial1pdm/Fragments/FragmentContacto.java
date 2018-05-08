package com.example.charlie.parcial1pdm.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.charlie.parcial1pdm.Adapters.ContactosRecyclerViewAdapter;
import com.example.charlie.parcial1pdm.Main2Activity;
import com.example.charlie.parcial1pdm.Models.ModelContactos;
import com.example.charlie.parcial1pdm.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 5/3/2018.
 */

public class FragmentContacto extends Fragment {

    Button infoContacto;

    private View v;

    private RecyclerView recyclerView;

    public FragmentContacto(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        v=inflater.inflate(R.layout.fragment_contacto,container,false);

        recyclerView = v.findViewById(R.id.rv_contactos);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        RecyclerView.LayoutManager layoutManager = linearLayoutManager;

        recyclerView.setLayoutManager(layoutManager);

         ContactosRecyclerViewAdapter adapter = new ContactosRecyclerViewAdapter(getContext(),getContacts());

         recyclerView.setAdapter(adapter);
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ OJO
        ImageButton btnOpen = (ImageButton) v.findViewById(R.id.ibtn_contacto);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                startActivity(intent);
            }
        });



        return v;
    }

    private List<ModelContactos> getContacts(){

        List<ModelContactos> list = new ArrayList<>();

        Cursor cursor = getContext().getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                null, null, ContactsContract.Contacts.DISPLAY_NAME + " DESC");

        cursor.moveToFirst();

        while (cursor.moveToNext()){
            list.add(new ModelContactos(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
            )), cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))));

        }

        return list;
    }
}