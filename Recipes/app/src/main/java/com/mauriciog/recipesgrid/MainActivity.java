package com.mauriciog.recipesgrid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.mauriciog.recipesgrid.adapter.Adapter;

public class MainActivity extends AppCompatActivity {


    GridView item;
    String [] equipo;
    String [] descripcion;
    int[] imagen={R.drawable.crema_clabaza,
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        equipo=getResources ().getStringArray (R.array.recetas);
        descripcion=getResources ().getStringArray (R.array.descripciones);

        Adapter adapter= new Adapter (this,equipo,imagen);
        item=(GridView)findViewById (R.id.Id_GridView);
        item.setAdapter (adapter);

        item.setOnItemClickListener (new AdapterView.OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent (MainActivity.this, DetailsActivity.class);
                intent.putExtra ("Titulo", equipo[position]);
                intent.putExtra ("descripcion", descripcion[position]);
                intent.putExtra ("imagen",imagen[position]);
                startActivity (intent);

            }
        });
    }
}
