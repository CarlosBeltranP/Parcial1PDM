package com.example.charlie.parcial1pdm.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charlie on 5/3/2018.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> listaFragment = new ArrayList<>();
    private final List<String> listaTitulos = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listaFragment.get(position);
    }

    @Override
    public int getCount() {
        return listaTitulos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listaTitulos.get(position);
    }

    public void AddFragment(Fragment fragment, String titulo) {
        listaFragment.add(fragment);
        listaTitulos.add(titulo);
    }
}


