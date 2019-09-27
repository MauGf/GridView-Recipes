package com.mauriciog.recipesgrid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mauriciog.recipesgrid.adapter.Adapter;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {


    GridView item;
    String[] recetas;
    String[] descripcion;
    int[] imagen = {R.drawable.crema_clabaza,
            R.drawable.salmon_alorno,
            R.drawable.tartala,
            R.drawable.tostada_dequeso,
            R.drawable.alitas_de_pollo,
            R.drawable.cerdo_a_la_naranja,
            R.drawable.ensalada_arroz,
            R.drawable.ensalada_de_pasta,
            R.drawable.mejillones_vapor,
            R.drawable.pollo_a_la_cerveza,
            R.drawable.pollo_al_ajillo,
            R.drawable.pollo_dorado,
            R.drawable.sopa_de_fideos,
            R.drawable.sopa_de_mariscos,
            R.drawable.pollo_en_salsa,};
    private BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        recetas = getResources ().getStringArray (R.array.recetas);
        descripcion = getResources ().getStringArray (R.array.descripciones);

        Adapter adapter = new Adapter (this, recetas, imagen);
        item = (GridView) findViewById (R.id.Id_GridView);
        item.setAdapter (adapter);

        item.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (MainActivity.this, DetailsActivity.class);
                intent.putExtra ("Titulo", recetas[position]);
                intent.putExtra ("descripcion", descripcion[position]);
                intent.putExtra ("imagen", imagen[position]);
                startActivity (intent);

            }
        });
        initComponent();

    }

    private void initComponent() {

        navigation = findViewById (R.id.navigation);
        navigation.setOnNavigationItemSelectedListener (new BottomNavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId ()) {
                    case R.id.navigation_home:

                        return true;
                    case R.id.navigation_info:
                        Intent intentSettings = new Intent (getApplicationContext (), AboutActivity.class);
                        intentSettings.setFlags (Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity (intentSettings);
                        return true;
                    case R.id.navigation_exit:
                        finish ();
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater ().inflate (R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId ();

        if (id == R.id.action_settings) {
            Toast.makeText (this, "Boton sin ninguna funcion por ahora", Toast.LENGTH_SHORT).show ();
            return true;
        }
        return super.onOptionsItemSelected (item);
    }

}
