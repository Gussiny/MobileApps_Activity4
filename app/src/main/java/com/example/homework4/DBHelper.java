package com.example.homework4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_FILE = "Hobbies.db";
    private static final String TABLE = "Hobbies";
    private static final String FIELD_ID = "id";
    private static final String FIELD_NAME = "nombre";
    private static final String FIELD_HOBBIE = "hobbie";


    public DBHelper(Context context){
        super(context, DB_FILE,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE + " ( " +
                FIELD_ID + " INTEGER PRIMARY KEY, " +
                FIELD_NAME + " TEXT, " +
                FIELD_HOBBIE + " TEXT ) ";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS ?";
        String[] params = {TABLE};
        db.execSQL(query, params);
    }

    public void insertar(String nombre, String hobbie){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put(FIELD_NAME, nombre);
        valores.put(FIELD_HOBBIE, hobbie);

        db.insert(TABLE, null, valores);
    }

    public int eliminar(String nombre){
        SQLiteDatabase db = getWritableDatabase();
        String clause = FIELD_NAME + " = ?";
        String[] params = {nombre};

        return db.delete(TABLE, clause, params);
    }

    public String buscar(String nombre){
       SQLiteDatabase db = getReadableDatabase();
       String filtro = FIELD_NAME + " = ?";
       String[] params = {nombre};

       Cursor c = db.query(TABLE,null,filtro, params, null,null,null);
       String result = "";

       if(c.moveToFirst()){
           result = c.getString(2);
       }

       return result;
    }


}
