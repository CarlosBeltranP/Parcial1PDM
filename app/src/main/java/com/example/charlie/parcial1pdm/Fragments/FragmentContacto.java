package com.example.charlie.parcial1pdm.Fragments;

import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
    private ContactosRecyclerViewAdapter mAdapter;

    Button infoContacto;

    private View v;

    private RecyclerView recyclerView;

    public FragmentContacto(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        getContacts();

        v=inflater.inflate(R.layout.fragment_contacto,container,false);

        recyclerView = v.findViewById(R.id.rv_contactos);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

        RecyclerView.LayoutManager layoutManager = linearLayoutManager;

        recyclerView.setLayoutManager(layoutManager);

         ContactosRecyclerViewAdapter adapter = new ContactosRecyclerViewAdapter(getContext(),getContacts());

         recyclerView.setAdapter(adapter);

     /*   ImageButton btnOpen = (ImageButton) v.findViewById(R.id.ibtn_contacto);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Main2Activity.class);
                startActivity(intent);
            }
        });*/

        final EditText editText  =  v.findViewById(R.id.et_buscar);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0 && (charSequence.toString().contains("-") || charSequence.toString().contains(" "))) {
                    editText.setText(charSequence.toString().replace("-", "_").replace(" ", "_"));
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });




        return v;
    }
    private void filter(String text){

        List<ModelContactos> filteredList = new ArrayList<>();

        for (ModelContactos item : getContacts()){
            if(item.getNombre().toLowerCase().contains(text.toLowerCase())){
                filteredList.add(item);
            }
        }

        mAdapter.filterList(filteredList);


    }


    private List<ModelContactos> getContacts(){



      List<ModelContactos> list = new ArrayList<>();

        ContactosRecyclerViewAdapter adapter;

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