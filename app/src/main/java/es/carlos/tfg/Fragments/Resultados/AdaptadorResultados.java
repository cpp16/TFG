package es.carlos.tfg.Fragments.Resultados;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.carlos.tfg.BaseDatos.BDUsuarios;
import es.carlos.tfg.Objetos.Resultado;
import es.carlos.tfg.R;

public class AdaptadorResultados extends ArrayAdapter<Resultado> {
    Resultado item;
    View listItemView;

    public AdaptadorResultados(Context context, List<Resultado> objects){ super (context, 0, objects); }

    public View getView (int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listItemView = convertView;
        if (null == convertView){
            listItemView = inflater.inflate(R.layout.filaresultado, parent, false);
        }
        item = getItem(position);

        TextView ID = (TextView) listItemView.findViewById(R.id.lbIDUsuario);
        ID.setText("Usuario: " + item.getUsuario());

        TextView fecha_hora = (TextView) listItemView.findViewById(R.id.lbFecha_hora);
        fecha_hora.setText("Fecha y Hora: " + item.getFecha_hora());

        TextView aciertos = (TextView) listItemView.findViewById(R.id.lbAciertos);
        Integer nA = (item.getAciertos());
        aciertos.setText("Aciertos: " + nA);

        TextView fallos = (TextView) listItemView.findViewById(R.id.lbFallos);
        Integer nF = (item.getFallos());
        fallos.setText("Fallos:" + nF);

        TextView preguntas = (TextView) listItemView.findViewById(R.id.lbPreguntas);
        preguntas.setText("Preguntas:\n" + item.getPreguntas());

        TextView respuestas = (TextView) listItemView.findViewById(R.id.lbRespuestas);
        respuestas.setText("Respuestas:\n" + item.getRespuestas());

        return listItemView;
    }
}
