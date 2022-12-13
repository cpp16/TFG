package es.carlos.tfg.Fragments.Login;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import es.carlos.tfg.BaseDatos.BDResultados;
import es.carlos.tfg.BaseDatos.BDUsuarios;
import es.carlos.tfg.Fragments.Selectores.SelectorTipo;
import es.carlos.tfg.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Login extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    Cursor c;

    public Login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Login.
     */
    // TODO: Rename and change types and number of parameters
    public static Login newInstance(String param1, String param2) {
        Login fragment = new Login();
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
        BDResultados bdResultados = new BDResultados(getContext());
        SQLiteDatabase db = bdResultados.getWritableDatabase();
        bdResultados.onUpgrade(db, 1, 2);
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        EditText usuario = (EditText) view.findViewById(R.id.edUsuario);
        EditText password = (EditText) view.findViewById(R.id.edPassword);
        Bundle bundle = new Bundle();

        Button btLogin = (Button) view.findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BDUsuarios tabla = new BDUsuarios(getContext());
                SQLiteDatabase db = tabla.getReadableDatabase();
                String user = usuario.getText().toString();
                String pass = password.getText().toString();
                c = db.rawQuery("select id, usuario, password from usuarios where usuario = '" + user + "' and password = '" + pass + "'", null);
                try{
                    if(user.matches("") && pass.matches("")) {
                        Toast toast = Toast.makeText(getContext(), "Introduzca usuario y contraseña", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    if (c.moveToFirst()){
                        int id = c.getInt(0);
                        String usr = c.getString(1);
                        String pswrd = c.getString(2);
                        if (user.equals(usr) && pass.equals(pswrd)){
                            bundle.putInt("usuario", id);
                            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                            FragmentTransaction transaction = fragmentManager.beginTransaction();
                            transaction.setReorderingAllowed(true);
                            transaction.replace(R.id.fragmentContainerView, SelectorTipo.class, bundle);
                            transaction.addToBackStack(null);
                            transaction.commit();
                            Toast toast=Toast.makeText(getContext(),"Datos correctos",Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    } else {
                        Toast toast=Toast.makeText(getContext(),"Datos incorrectos",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } catch (Exception e){
                    Toast toast=Toast.makeText(getContext(),"Error",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        Button btRegistrarse = (Button) view.findViewById(R.id.btRegistrar);
        btRegistrarse.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                Registro r = new Registro();
                r.show(getActivity().getFragmentManager(), "Registro");
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}