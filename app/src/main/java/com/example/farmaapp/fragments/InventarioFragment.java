package com.example.farmaapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmaapp.R;
import com.example.farmaapp.adapter.InventarioAdapter;
import com.example.farmaapp.entity.Producto;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InventarioFragment extends Fragment {

    RecyclerView rv_inventario;

    public InventarioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inventario, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_inventario = view.findViewById(R.id.rv_inventario);

        InventarioAdapter adapter = new InventarioAdapter(obtenerProductos());

        rv_inventario.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_inventario.setAdapter(adapter);

    }

    private List<Producto> obtenerProductos(){
        List<Producto> productos = new ArrayList<>();
        Producto producto1 = new Producto("010934","Perplus","31","10","2");
        Producto producto2 = new Producto("010584","Vitaminas","32","150","30");
        Producto producto3 = new Producto("010134","Gentamisina","30","13","1");
        Producto producto4 = new Producto("010988","Panadol","11","15","2");
        Producto producto5 = new Producto("010994","VipVaporup","77","33","3");
        Producto producto6 = new Producto("010155","Condones","3","72","1");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);
        productos.add(producto4);
        productos.add(producto5);
        productos.add(producto6);

        return productos;
    }
}
