package com.example.farmaapp.dao;

import android.content.Context;

import com.example.farmaapp.db.InventarioDatabase;

public class ProductoBarraDAO {

    private static String NOMBRE_TABLA = "Producto";

    private static String COL_CODPRODUCTO = "co_producto";
    private static String COL_DEPRODUCTO = "de_producto";
    private static String COL_DEUNIDAD = "de_unidad";
    private static String COL_DEUNIDADFRACCION = "de_unidad_fraccion";
    private static String COL_INPRODFRACCIONADO = "in_prod_fraccionado";
    private static String COL_VAFRACCION= "va_fraccion";
    private static String COL_COLABORATORIO = "co_laboratorio";
    private static String COL_DELABORATORIO = "de_laboratorio";

    private InventarioDatabase inventarioDatabase;

    public ProductoBarraDAO(Context context){
        inventarioDatabase = new InventarioDatabase(context);
    }

}
