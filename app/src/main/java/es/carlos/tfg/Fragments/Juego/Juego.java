package es.carlos.tfg.Fragments.Juego;

import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import es.carlos.tfg.BaseDatos.BDPregunta;
import es.carlos.tfg.BaseDatos.BDResultados;
import es.carlos.tfg.BaseDatos.BDRetos;
import es.carlos.tfg.Fragments.Resultados.Resultados;
import es.carlos.tfg.Objetos.Pregunta;
import es.carlos.tfg.Objetos.Reto;
import es.carlos.tfg.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Juego#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Juego extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    int pregunta = 0;
    int random;
    List<Reto> lista_retos = new ArrayList<>();
    List<String> lista_respuestas = new ArrayList<>();
    List<Reto> lista_preguntas = new ArrayList<>();
    List<String> respuestas_contestadas = new ArrayList<>();
    int[] numeroPregunta = new int[10];
    int aciertos = 0;
    int fallos = 0;

    public Juego() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Juego.
     */
    // TODO: Rename and change types and number of parameters
    public static Juego newInstance(String param1, String param2) {
        Juego fragment = new Juego();
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
        View view = inflater.inflate(R.layout.fragment_juego, container, false);

        TextView enunciado = (TextView) view.findViewById(R.id.enunciado);
        RadioButton preguntaA = (RadioButton) view.findViewById(R.id.preguntaA);
        RadioButton preguntaB = (RadioButton) view.findViewById(R.id.preguntaB);
        RadioButton preguntaC = (RadioButton) view.findViewById(R.id.preguntaC);
        ImageButton btSiguiente = (ImageButton) view.findViewById(R.id.btSiguiente);
        Button btResultados = (Button) view.findViewById(R.id.btResultados);

        BDRetos bd = new BDRetos(getContext());
        int usuario = requireArguments().getInt("usuario");
        String tipo = requireArguments().getString("tipo");
        int nivel = requireArguments().getInt("nivel");

        if(tipo.matches("CulturaGeneral")){
            lista_retos = bd.selectRetos(nivel, tipo);
        } else if(tipo.matches("Geografia")){
            lista_retos = bd.selectRetos(nivel, tipo);
        } else if(tipo.matches("Historia")){
            lista_retos = bd.selectRetos(nivel, tipo);
        }

        generarAleatorio();
        cargarRetos();
        cargarRespuestas();
        cargarPregunta(lista_preguntas, enunciado, preguntaA, preguntaB, preguntaC, pregunta);


        btSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pregunta < 9){
                    if (preguntaA.isChecked()){
                        String respuesta = preguntaA.getText().toString();
                        if (lista_respuestas.contains(respuesta)){
                            aciertos++;
                            respuestas_contestadas.add("id: " + lista_preguntas.get(pregunta).getId() + " Respuesta: " + respuesta);
                        } else {
                            fallos++;
                            respuestas_contestadas.add("id: " + lista_preguntas.get(pregunta).getId() + " Respuesta: " + respuesta);                        }
                    } else if (preguntaB.isChecked()){
                        String respuesta = preguntaB.getText().toString();
                        if (lista_respuestas.contains(respuesta)){
                            aciertos++;
                            respuestas_contestadas.add("id: " + lista_preguntas.get(pregunta).getId() + " Respuesta: " + respuesta);                        } else {
                            fallos++;
                            respuestas_contestadas.add("id: " + lista_preguntas.get(pregunta).getId() + " Respuesta: " + respuesta);                        }
                    } else if (preguntaC.isChecked()) {
                        String respuesta = preguntaC.getText().toString();
                        if (lista_respuestas.contains(respuesta)) {
                            aciertos++;
                            respuestas_contestadas.add("id: " + lista_preguntas.get(pregunta).getId() + " Respuesta: " + respuesta);                        } else {
                            fallos++;
                            respuestas_contestadas.add("id: " + lista_preguntas.get(pregunta).getId() + " Respuesta: " + respuesta);                        }
                    }
                    pregunta++;
                    cargarPregunta(lista_preguntas, enunciado, preguntaA, preguntaB, preguntaC, pregunta);
                } else {
                    btSiguiente.setClickable(false);
                }
            }
        });

        btResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pregunta < 9){
                    Toast toast = Toast.makeText(getContext(), "Debe contestar a todas las preguntas para ver los resultados", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    String fecha = java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
                    String preguntas = "";
                    for (int i = 0; i<9; i++){
                        preguntas += lista_preguntas.get(i).toString() + "\n";
                    }
                    String respuestas = "";
                    for (int i = 0; i<9; i++){
                        respuestas += respuestas_contestadas.get(i) + "\n";
                    }
                    BDResultados bdResultados = new BDResultados(getContext());
                    bdResultados.insertarResultado(usuario, fecha, aciertos, fallos, preguntas, respuestas);
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.setReorderingAllowed(true);
                    transaction.replace(R.id.fragmentContainerView, Resultados.class, null);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    public void cargarPregunta(List<Reto> lista_preguntas, TextView enunciado, RadioButton preguntaA, RadioButton preguntaB, RadioButton preguntaC, int pregunta){
        enunciado.setText(lista_preguntas.get(pregunta).getPregunta());
        preguntaA.setText(lista_preguntas.get(pregunta).getPreguntaA());
        preguntaB.setText(lista_preguntas.get(pregunta).getPreguntaB());
        preguntaC.setText(lista_preguntas.get(pregunta).getPreguntaC());
    }


    public int[] generarAleatorio(){
        for(int i = 0; i < 10; i++){
            random = (int) Math.floor(Math.random()*lista_retos.size());
            if (numeroPregunta[i] != random){
                numeroPregunta[i] = random;
            }
        }
        return numeroPregunta;
    }

    public List<Reto> cargarRetos (){
        BDPregunta bd = new BDPregunta(getContext());
        for(int i = 0; i < 10; i++){
            lista_preguntas.add(lista_retos.get(numeroPregunta[i]));
            bd.insertarPregunta(lista_retos.get(numeroPregunta[i]).getId(), lista_retos.get(numeroPregunta[i]).getPregunta(),
                    lista_retos.get(numeroPregunta[i]).getPreguntaA(), lista_retos.get(numeroPregunta[i]).getPreguntaB(),
                    lista_retos.get(numeroPregunta[i]).getPreguntaC(), lista_retos.get(numeroPregunta[i]).getPreguntaOK());
        }
        return lista_preguntas;
    }

    public List<String> cargarRespuestas(){
        for (int i = 0; i < 10; i++){
            lista_respuestas.add(lista_preguntas.get(i).getPreguntaOK());
        }
        return lista_respuestas;
    }
}