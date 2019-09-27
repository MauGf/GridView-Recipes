package com.mauriciog.recipesgrid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.mauriciog.recipesgrid.R;

public class Adapter  extends BaseAdapter {

    private Context contexto;
    private String [] receta;
    private int[] imagen;

    public Adapter (Context contexto, String[]equipo, int[] imagen){
        this.contexto=contexto;
        this.receta=equipo;
        this.imagen=imagen;
    }

    @Override
    public int getCount() {
        return receta.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View arg1, ViewGroup arg2) {
        View item;
        if(arg1==null){
            LayoutInflater inflar=(LayoutInflater)contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item=new View(contexto);
            assert inflar != null;
            item=inflar.inflate (R.layout.item_row,null);
        }else{
            item=(View)arg1;
        }

        TextView nombreEquipo = (TextView) item.findViewById (R.id.textTitlePlato);
        ImageView escudo = (ImageView) item.findViewById (R.id.imgReceta);
        nombreEquipo.setText (receta[position]);
        escudo.setImageResource (imagen[position]);
        return item;
    }
}
