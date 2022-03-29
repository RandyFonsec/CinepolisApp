package com.example.cinepolisapp.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cinepolisapp.Modelo.Cliente;
import com.example.cinepolisapp.R;

import java.util.ArrayList;

public class ListaClientesAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Cliente> clientes;

    public ListaClientesAdapter(Context context, ArrayList<Cliente> clientes) {
        this.context = context;
        this.clientes = clientes;
    }

    @Override
    public int getCount() {
        return clientes.size();
    }

    @Override
    public Object getItem(int i) {
        return clientes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Cliente item = (Cliente) getItem(i);

        view = LayoutInflater.from(context).inflate(R.layout.item_list_clientes, null);

        TextView tVNombre, tvCorreo, tvCedula;
        tVNombre = view.findViewById(R.id.tvNombreLista);
        tvCorreo = view.findViewById(R.id.tvCorreoLista);
        tvCedula = view.findViewById(R.id.tvCedulaLista);
        String nombreCompleto = item.getNombre()+" "+item.getApellido1()+ " "+item.getApellido2();
        tvCedula.setText("Cédula: "+String.valueOf(item.getNumeroCedula()));
        tVNombre.setText("Nombre: "+nombreCompleto);
        tvCorreo.setText("Correo: "+item.getCorreo());


        return view;
    }
}
