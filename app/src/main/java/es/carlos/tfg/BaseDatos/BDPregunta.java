package es.carlos.tfg.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.carlos.tfg.Objetos.Reto;

public class BDPregunta extends SQLiteOpenHelper {
    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "TFG.db";
    private static final String TABLA = "CREATE TABLE pregunta (id INTEGER PRIMARY KEY AUTOINCREMENT, id_reto integer, pregunta TEXT, respuestaA TEXT, respuestaB TEXT, respuestaC TEXT, respuestaOK TEXT)";

    public BDPregunta(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS retos");
        onCreate(db);
    }

    public void insertarPregunta (int id_reto, String pregunta, String respuestaOK, String respuestaA, String respuestaB, String respuestaC){
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            ContentValues valores = new ContentValues();
            valores.put("id", (byte[]) null);
            valores.put("id_reto", id_reto);
            valores.put("pregunta", pregunta);
            valores.put("respuestaA", respuestaA);
            valores.put("respuestaB", respuestaB);
            valores.put("respuestaC", respuestaC);
            valores.put("respuestaOK", respuestaOK);
            db.insert("pregunta", null, valores);
        }
        db.close();
    }

    public boolean checkIfDbExists(){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM pregunta",null);
        Log.d("lol", cursor.toString());
        if (cursor.moveToFirst()) {
            cursor.close();

            return true;
        }else {
            cursor.close();

            return false;
        }
    }


}



