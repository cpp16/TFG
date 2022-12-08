package es.carlos.tfg.BaseDatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class BDUsuarios extends SQLiteOpenHelper {
    private static final int VERSION_BASEDATOS = 1;
    private static final String NOMBRE_BASEDATOS = "TFG.db";
    private static final String TABLA_USERS = "CREATE TABLE usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, email TEXT, password TEXT)";

    public BDUsuarios(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLA_USERS);
        onCreate(db);
    }

    public void insertarUsuario(String usuario, String email, String password) {
        SQLiteDatabase db = getWritableDatabase();
        if (db != null) {
            ContentValues valores = new ContentValues();
            valores.put("id", (byte[]) null);
            valores.put("usuario", usuario);
            valores.put("email", email);
            valores.put("password", password);
            db.insert("usuarios", null, valores);
        }
        db.close();
    }

    public String selectUsuario(int id_usuario){
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT usuario FROM usuarios WHERE id = " + id_usuario, null);
        c.moveToFirst();
        String usuario = c.getString(0);
        c.close();
        return usuario;
    }

    public boolean checkIfDbExists(){
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios",null);
        Log.d("DEV", cursor.toString());
        if (cursor.moveToFirst()) {
            cursor.close();

            return true;
        }
            cursor.close();

            return false;

    }
}

