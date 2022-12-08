package es.carlos.tfg.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import es.carlos.tfg.Objetos.Reto;

public class BDResultados extends SQLiteOpenHelper {
    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "TFG.db";
    private static final String TABLA = "CREATE TABLE resultados (id INTEGER PRIMARY KEY AUTOINCREMENT, id_usuario INTEGER, fecha_hora TEXT, aciertos INTEGER, fallos INTEGER, preguntas TEXT, respuestas TEXT)";

    public BDResultados(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS resultados");
        onCreate(db);
    }

    public void insertarResultado (int id_usuario, String fecha_hora, int aciertos, int fallos, String preguntas, String respuestas){
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            ContentValues valores = new ContentValues();
            valores.put("id", (byte[]) null);
            valores.put("id_usuario", id_usuario);
            valores.put("fecha_hora", fecha_hora);
            valores.put("aciertos", aciertos);
            valores.put("fallos", fallos);
            valores.put("preguntas", preguntas);
            valores.put("respuestas", respuestas);
            db.insert("resultados", null, valores);
        }
        db.close();
    }

    public boolean checkIfDbExists(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT count(*) FROM resultados",null);
        cursor.moveToFirst();
        if (cursor.getInt(0) > 0) {
            return true;
        }
        return false;
    }
}

