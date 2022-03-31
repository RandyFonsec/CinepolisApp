package com.example.cinepolisapp.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.Modelo.Pelicula;
import com.example.cinepolisapp.R;

import java.util.ArrayList;

public class ListaPeliculasAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Pelicula> peliculas;

    public ListaPeliculasAdapter(Context context, ArrayList<Pelicula> peliculas) {
        this.context = context;
        this.peliculas = peliculas;
    }

    @Override
    public int getCount() {
        return peliculas.size();
    }

    @Override
    public Object getItem(int i) {
        return peliculas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Pelicula item = (Pelicula) getItem(i);

        view = LayoutInflater.from(context).inflate(R.layout.item_list_peliculas, null);

        TextView tVNombrePelicula, tvDuracionPelicula;
        tVNombrePelicula = view.findViewById(R.id.tvNombrePelicula);
        tvDuracionPelicula = view.findViewById(R.id.tvDuracionPelicula);
        String info = "Año publicación: "+String.valueOf(item.getDuracion())+" Duración:"+String.valueOf(item.getAnnoPublicacion());
        tVNombrePelicula.setText(item.getTitulo());
        tvDuracionPelicula.setText(info);


        return view;
    }
}
