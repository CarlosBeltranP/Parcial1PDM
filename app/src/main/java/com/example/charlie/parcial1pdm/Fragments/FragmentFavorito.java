package com.example.charlie.parcial1pdm.Fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.charlie.parcial1pdm.R;

/**
 * Created by Charlie on 5/3/2018.
 */

public class FragmentFavorito extends Fragment {
    View view;

    public FragmentFavorito(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_favorito,container,false);

        return view;
    }
}
