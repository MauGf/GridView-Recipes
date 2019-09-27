package com.mauriciog.recipesgrid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mauriciog.recipesgrid.utils.Tools;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_details);
        final Toolbar toolbar = findViewById (R.id.toolbar);
        toolbar.setTitle ("Detalle");
        setSupportActionBar (toolbar);
        if (getSupportActionBar () != null) {
            getSupportActionBar ().setDisplayHomeAsUpEnabled (true);
            getSupportActionBar ().setDisplayShowHomeEnabled (true);
        }
        Tools.setSystemBarTransparent (this);
        TextView recetaTitle= (TextView)findViewById (R.id.textTitle);
        TextView descripcion= (TextView)findViewById (R.id.idDescript);
        ImageView imagen=(ImageView)findViewById (R.id.imageDetail);

        String title;
        String detalle;
        int img;

        Bundle b= getIntent().getExtras ();
        assert b != null;
        title=b.getString ("Titulo");
        detalle=b.getString ("descripcion");
        img=b.getInt ("imagen");

        recetaTitle.setText(title);
        descripcion.setText (detalle);
        imagen.setImageResource (img);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId () == android.R.id.home) {
            finish ();
        } else {
            Toast.makeText (getApplicationContext (), item.getTitle (), Toast.LENGTH_SHORT).show ();
        }
        return super.onOptionsItemSelected (item);
    }
}
