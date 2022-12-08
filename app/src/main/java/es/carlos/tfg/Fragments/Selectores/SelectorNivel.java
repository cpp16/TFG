package es.carlos.tfg.Fragments.Selectores;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import es.carlos.tfg.Fragments.Juego.Juego;
import es.carlos.tfg.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectorNivel#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectorNivel extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SelectorNivel() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectorNivel.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectorNivel newInstance(String param1, String param2) {
        SelectorNivel fragment = new SelectorNivel();
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
        View view = inflater.inflate(R.layout.fragment_selector_nivel, container, false);
        int usuario = requireArguments().getInt("usuario");
        String tipo = requireArguments().getString("tipo");
        ImageButton btNivel1 = (ImageButton) view.findViewById(R.id.btNivel1);
        btNivel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("usuario", usuario);
                bundle.putString("tipo", tipo);
                bundle.putInt("nivel", 1);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.fragmentContainerView, Juego.class, bundle);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        ImageButton btNivel2 = (ImageButton) view.findViewById(R.id.btNivel2);
        btNivel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("usuario", usuario);
                bundle.putString("tipo", tipo);
                bundle.putInt("nivel", 2);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.fragmentContainerView, Juego.class, bundle);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        ImageButton btNivel3 = (ImageButton) view.findViewById(R.id.btNivel3);
        btNivel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("usuario", usuario);
                bundle.putString("tipo", tipo);
                bundle.putInt("nivel", 3);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.fragmentContainerView, Juego.class, bundle);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}