package com.garcesito.tiendaplaneta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pepel on 1/11/2017.
 */

public class BibliotecaSQLiteHelper extends SQLiteOpenHelper {
    String DATA_BASE_NAME = "LibrosBD";
    int DATA_VERSION = 1;

    String sqlCreate = "CREATE TABLE libros("+
            "id     INTEGER PRIMARY KEY AUTOINCREMENT," + //0
            "name   TEXT,"+ //1
            "autor  TEXT,"+//2
            "name_user  TEXT,"+ //3
            "phone  TEXT)"; //4

    public BibliotecaSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS libros");
        db.execSQL(sqlCreate);
    }
}
