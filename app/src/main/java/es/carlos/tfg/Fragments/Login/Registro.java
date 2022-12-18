package es.carlos.tfg.Fragments.Login;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.carlos.tfg.BaseDatos.BDUsuarios;
import es.carlos.tfg.R;

@RequiresApi(api = Build.VERSION_CODES.M)
public class Registro extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle saveInstanceState){
        final View form = getActivity().getLayoutInflater().inflate(R.layout.dialog_registro,null);
        AlertDialog.Builder ab = new AlertDialog.Builder(getActivity());

        EditText usuario;
        EditText mail;
        EditText password;
        BDUsuarios tabla = new BDUsuarios(getContext());

        ab.setIcon(R.mipmap.ic_app);
        ab.setTitle("Registro");
        ab.setView(form);
        usuario = (EditText)form.findViewById(R.id.etUsuario);
        mail = (EditText)form.findViewById(R.id.etMail);
        password = (EditText)form.findViewById(R.id.etPassword);
        ab.setPositiveButton("Registrar",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String user = usuario.getText().toString();
                String email = mail.getText().toString();
                String pass = password.getText().toString();

                if(validarMail(email)){
                    tabla.insertarUsuario(user, email, pass);
                } else {
                    Toast toast=Toast.makeText(getContext(),"Introduzca un email valido",Toast.LENGTH_SHORT);
                    toast.show();
                    Registro r = new Registro();
                    r.show(getActivity().getFragmentManager(), "Registro");
                }
            }
        });
        ab.setNegativeButton("Cancelar",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        return ab.create();
    }

    public boolean validarMail(String email){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        if (mather.find() == true) {
            System.out.println("El email ingresado es válido.");
            return true;
        } else {
            System.out.println("El email ingresado es inválido.");
            return false;
        }
    }
}
