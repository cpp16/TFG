package es.carlos.tfg.Fragments.Resultados;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import es.carlos.tfg.BaseDatos.BDPregunta;
import es.carlos.tfg.BaseDatos.BDResultados;
import es.carlos.tfg.BaseDatos.BDUsuarios;
import es.carlos.tfg.Objetos.Resultado;
import es.carlos.tfg.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Resultados#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Resultados extends Fragment {
    static ListView listViewResultados;
    ArrayList<Resultado> lista;
    static AdaptadorResultados adaptador;
    BDResultados tablaResultados;
    BDUsuarios tablaUsuarios;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Resultados() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Resultado.
     */
    // TODO: Rename and change types and number of parameters
    public static Resultados newInstance(String param1, String param2) {
        Resultados fragment = new Resultados();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resultados, container, false);
        tablaResultados = new BDResultados(getContext());
        tablaUsuarios = new BDUsuarios(getContext());

        listViewResultados = view.findViewById(R.id.lvResultados);
        lista = llenar();

        adaptador = new AdaptadorResultados(getContext(), lista);
        listViewResultados.setAdapter(adaptador);
        // Inflate the layout for this fragment
        return view;
    }

    public ArrayList<Resultado> llenar(){
        SQLiteDatabase db = tablaResultados.getReadableDatabase();
        Resultado resultado = null;
        ArrayList<Resultado>listaResultados = new ArrayList<Resultado>();
        Cursor c = db.rawQuery("SELECT * FROM resultados", null);
        c.moveToFirst();
        do {
            String usuario = tablaUsuarios.selectUsuario(c.getInt(1));
            resultado = new Resultado();
            resultado.setUsuario(usuario);
            resultado.setFecha_hora(c.getString(2));
            resultado.setAciertos(c.getInt(3));
            resultado.setFallos(c.getInt(4));
            resultado.setPreguntas(c.getString(5));
            resultado.setRespuestas(c.getString(6));

            listaResultados.add(resultado);
        } while (c.moveToNext());

        return listaResultados;
    }
}