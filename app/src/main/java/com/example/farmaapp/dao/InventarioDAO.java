package com.example.farmaapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.farmaapp.db.InventarioDatabase;
import com.example.farmaapp.entity.ProductoInventario;

public class InventarioDAO {

    private static String NOMBRE_TABLA = "ProductoInventario";

    private static String COL_CODPRODUCTO = "co_producto";
    private static String COL_CODLABORATORIO = "co_laboratorio";
    private static String COL_INPRODFRACCIONADO = "in_prod_fraccionado";
    private static String COL_VAFRACCION = "va_fraccion";
    private static String COL_CAENTERO = "ca_entero";
    private static String COL_CAFRACCION= "ca_fraccion";
    private static String COL_NUANAQUEL = "nu_anaquel";
    private static String COL_ANAQUELCONCAT = "nu_anaquel_concat";

    private InventarioDatabase inventarioDatabase;

    public InventarioDAO(Context context){
        inventarioDatabase = new InventarioDatabase(context);
    }

    public void insertarInventario(ProductoInventario productoInventario){
        SQLiteDatabase db = inventarioDatabase.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(COL_CODPRODUCTO, productoInventario.getCoProducto());
        valores.put(COL_CODLABORATORIO, productoInventario.getCoLaboratorio());
        valores.put(COL_INPRODFRACCIONADO, productoInventario.getInProdFraccionado());
        valores.put(COL_VAFRACCION, productoInventario.getVaFraccion());
        valores.put(COL_CAENTERO, productoInventario.getCaEntero());
        valores.put(COL_CAFRACCION, productoInventario.getCaFraccion());
        valores.put(COL_NUANAQUEL, productoInventario.getNuAnaquel());
        valores.put(COL_ANAQUELCONCAT, productoInventario.getNuAnaquelConcat());

        db.insert(NOMBRE_TABLA,null,valores);
    }

}
