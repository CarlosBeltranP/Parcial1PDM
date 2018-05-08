package com.example.charlie.parcial1pdm;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

import com.example.charlie.parcial1pdm.Adapters.ViewPagerAdapter;
import com.example.charlie.parcial1pdm.Fragments.FragmentContacto;
import com.example.charlie.parcial1pdm.Fragments.FragmentFavorito;
import com.example.charlie.parcial1pdm.Fragments.FragmentLlamada;

public class MainActivity extends AppCompatActivity {
ImageButton siguiente;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter vpadapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        tabLayout = (TabLayout)findViewById(R.id.tablayout);
        viewPager = (ViewPager)findViewById(R.id.viewpager);
        vpadapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Agregar aqui el Fragnment

        vpadapter.AddFragment(new FragmentLlamada(), "");
        vpadapter.AddFragment(new FragmentContacto(), "");
        vpadapter.AddFragment(new FragmentFavorito(), "");

        viewPager.setAdapter(vpadapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_llamadas1);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_contactos);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_favoritos);


    }



    private void preguntaPermisos(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CALL_LOG)
                != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this , new String[] {Manifest.permission.READ_CONTACTS}, 1);
            ActivityCompat.requestPermissions(this , new String[] {Manifest.permission.READ_CALL_LOG}, 1);
            ActivityCompat.requestPermissions(this , new String[] {Manifest.permission.CALL_PHONE}, 1);
            ActivityCompat.requestPermissions(this , new String[] {Manifest.permission.CALL_PRIVILEGED}, 1);
        }

    }
}
