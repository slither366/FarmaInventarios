package com.example.farmaapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.farmaapp.util.Constantes;

public class InventarioDatabase extends SQLiteOpenHelper {

    public InventarioDatabase(@Nullable Context context) {
        super(context, Constantes.DB_NAME, null, Constantes.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
