package com.example.cinepolisapp.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cinepolisapp.Modelo.Alimento;
import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.R;

import java.util.ArrayList;

public class ListaAlimentosAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Alimento> alimentos;

    public ListaAlimentosAdapter(Context context, ArrayList<Alimento> alimentos) {
        this.context = context;
        this.alimentos = alimentos;
    }

    @Override
    public int getCount() {
        return alimentos.size();
    }

    @Override
    public Object getItem(int i) {
        return alimentos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Alimento item = (Alimento) getItem(i);
        view = LayoutInflater.from(context).inflate(R.layout.item_list_alimentos, null);
        TextView tvNombre, tvCantidad, tvPrecio;
        tvNombre = view.findViewById(R.id.tvNombreAlimento);
        tvCantidad = view.findViewById(R.id.tvCantidadAlimento);
        tvPrecio = view.findViewById(R.id.tvPrecioAlimento);
        tvNombre.setText("\t\tNombre: " + item.getNombre());
        tvCantidad.setText("Cantidad disponible: " + item.getCantidadDisponible());
        tvPrecio.setText("Precio: ₡" + item.getPrecio());
        return view;
    }

}
