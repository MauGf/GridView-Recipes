package com.mauriciog.recipesgrid;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Objects;

public class AboutActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_about);
        Toolbar toolbar = findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);
        Objects.requireNonNull (getSupportActionBar ());
        Objects.requireNonNull (getSupportActionBar ()).setDisplayHomeAsUpEnabled (true);
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
