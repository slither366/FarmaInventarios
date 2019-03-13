package com.example.farmaapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.farmaapp.db.InventarioDatabase;
import com.example.farmaapp.entity.Producto;

public class ProductoInventarioDAO {

    private static String NOMBRE_TABLA = "Producto";

    private static String COL_CODPRODUCTO = "co_producto";
    private static String COL_DESPRODUCTO = "de_producto";
    private static String COL_UNIDAD = "de_unidad";
    private static String COL_UNIDADFRACCION = "de_unidad_fraccion";
    private static String COL_FLATFRACCIONADO= "in_prod_fraccionado";
    private static String COL_VAFRACCION= "va_fraccion";
    private static String COL_CODLABORATORIO = "co_laboratorio";
    private static String COL_DESCLABORATORIO = "de_laboratorio";

    private InventarioDatabase inventarioDatabase;

    public ProductoInventarioDAO(Context context){
        inventarioDatabase = new InventarioDatabase(context);
    }

    public void insertarProducto(Producto producto){
        SQLiteDatabase db = inventarioDatabase.getWritableDatabase();

        ContentValues valores = new ContentValues();
        //valores.put()
    }

}
