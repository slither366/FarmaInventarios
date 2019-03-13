package com.example.farmaapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.farmaapp.R;
import com.example.farmaapp.entity.Producto;

import java.util.List;

public class InventarioAdapter extends RecyclerView.Adapter<InventarioAdapter.ViewHolder>{

    List<Producto> productos;

    public InventarioAdapter(List<Producto> producto) {
        this.productos = producto;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_inventario, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Producto producto = productos.get(i);

        viewHolder.tv_codigo.setText(producto.getCodigo());
        viewHolder.tv_nombre.setText(producto.getNombre());
        viewHolder.tv_anaquel.setText(producto.getAnaquel());
        viewHolder.tv_entero.setText(producto.getCantEntero());
        viewHolder.tv_fraccion.setText(producto.getCantFraccion());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv_codigo, tv_nombre, tv_anaquel, tv_entero, tv_fraccion;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            tv_codigo = itemView.findViewById(R.id.tv_codigo);
            tv_nombre = itemView.findViewById(R.id.tv_nombre);
            tv_anaquel = itemView.findViewById(R.id.tv_anaquel);
            tv_entero = itemView.findViewById(R.id.tv_entero);
            tv_fraccion = itemView.findViewById(R.id.tv_fraccion);
        }
    }



}
