package com.example.charlie.parcial1pdm;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

/**
 * Created by Charlie on 5/3/2018.
 */

public class FragmentContacto extends Fragment{
    View view;

    private RecyclerView miRecyclerview;
    private List<Contacto> listaContacto;

    public FragmentContacto() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_contacto,container,false);
        return view;
    }
}
