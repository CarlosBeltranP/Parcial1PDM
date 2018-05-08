package com.example.charlie.parcial1pdm;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class infoContacto extends AppCompatActivity {
    private Toolbar toolbar;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_contacto);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem){
        switch (menuItem.getItemId()){
            case R.id.borrar:
                Toast.makeText(this, "Has pulsado el menu borrar", Toast.LENGTH_SHORT).show();
                break;

            case R.id.editar:
                Toast.makeText(this, "Has pulsado el menu editar", Toast.LENGTH_SHORT).show();
                break;

            case android.R.id.home:

                Toast.makeText(this, "Has pulsado la flecha atrás", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }
}

