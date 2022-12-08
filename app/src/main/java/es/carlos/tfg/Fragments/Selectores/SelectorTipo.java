package es.carlos.tfg.Fragments.Selectores;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import es.carlos.tfg.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectorTipo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectorTipo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SelectorTipo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectorTipo.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectorTipo newInstance(String param1, String param2) {
        SelectorTipo fragment = new SelectorTipo();
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
        View view = inflater.inflate(R.layout.fragment_selector_tipo, container, false);
        ImageButton btGeografia = (ImageButton) view.findViewById(R.id.btGeografia);
        btGeografia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int usuario = requireArguments().getInt("usuario");
                Bundle bundle = new Bundle();
                bundle.putInt("usuario", usuario);
                bundle.putString("tipo", "Geografia");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.fragmentContainerView, SelectorNivel.class, bundle);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        ImageButton btCGeneral = (ImageButton) view.findViewById(R.id.btCulturaGeneral);
        btCGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int usuario = requireArguments().getInt("usuario");
                Bundle bundle = new Bundle();
                bundle.putInt("usuario", usuario);
                bundle.putString("tipo", "CulturaGeneral");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.fragmentContainerView, SelectorNivel.class, bundle);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        ImageButton btHistoria = (ImageButton) view.findViewById(R.id.btHistoria);
        btHistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int usuario = requireArguments().getInt("usuario");
                Bundle bundle = new Bundle();
                bundle.putInt("usuario", usuario);
                bundle.putString("tipo", "Historia");
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.fragmentContainerView, SelectorNivel.class, bundle);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
}