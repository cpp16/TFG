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

public class BDRetos extends SQLiteOpenHelper {
    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "TFG.db";
    private static final String TABLA = "CREATE TABLE retos (id INTEGER PRIMARY KEY AUTOINCREMENT, pregunta TEXT, respuestaA TEXT, respuestaB TEXT, respuestaC TEXT, respuestaOK TEXT, nivel INTEGER, tipo TEXT)";

    public BDRetos(Context context) {
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

    public void insertarReto (String pregunta, String respuestaOK, String respuestaA, String respuestaB, String respuestaC, int nivel, String tipo){
        SQLiteDatabase db = getWritableDatabase();
        if (db != null){
            ContentValues valores = new ContentValues();
            valores.put("id", (byte[]) null);
            valores.put("pregunta", pregunta);
            valores.put("respuestaA", respuestaA);
            valores.put("respuestaB", respuestaB);
            valores.put("respuestaC", respuestaC);
            valores.put("respuestaOK", respuestaOK);
            valores.put("nivel", nivel);
            valores.put("tipo", tipo);
            db.insert("retos", null, valores);
        }
        db.close();
    }

    public List<Reto> selectRetos(int nivel, String tipo){
        SQLiteDatabase db = getReadableDatabase();
        List<Reto> lista_retos = new ArrayList<Reto>();
        Cursor c = db.rawQuery("select * from retos where nivel = " + nivel + " and tipo = '" + tipo + "'", null);
        c.moveToFirst();
        do{
            Reto r = new Reto (c.getInt(0), c.getString(1), c.getString(2), c.getString(3), c.getString(4), c.getString(5), c.getInt(6), c.getString(7));
            lista_retos.add(r);
        }while (c.moveToNext());
        c.close();
        db.close();
        return lista_retos;
    }

    public boolean checkIfDbExists(){
        SQLiteDatabase db = getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM retos",null);
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



