package com.example.app_loc.cliente;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.example.app_loc.R;

public class AdicionarCliente extends Fragment {

    EditText etNome;
    EditText etCpf;
    EditText etTelefone;
    EditText etEmail;

    public AdicionarCliente() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_adicionar_cliente, container, false);
        Button btn = (Button) v.findViewById(R.id.button_SalvarEditarCliente);

        etNome = (EditText) v.findViewById(R.id.editText_NomeAdicionarCliente);
        etCpf = (EditText) v.findViewById(R.id.editText_CPFAdicionarCliente);
        etTelefone = (EditText) v.findViewById(R.id.editText_TelefoneAdicionarCliente);
        etEmail = (EditText) v.findViewById(R.id.editText_EmailAdicionarCliente);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarCliente();
            }
        });
        return v;
    }

    private void adicionarCliente() {
        String nome = etNome.getText().toString().trim();
        String cpf = etCpf.getText().toString().trim();
        String telefone = etTelefone.getText().toString().trim();
        String email = etEmail.getText().toString().trim();


        if (nome.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o nome!", Toast.LENGTH_LONG).show();
        } else if (cpf.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o cpf!", Toast.LENGTH_LONG).show();
        } else if (telefone.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o telefone!", Toast.LENGTH_LONG).show();
        } else if (email.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o email!", Toast.LENGTH_LONG).show();
        } else {
            SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO clientes (nome, cpf, telefone, email) VALUES (");
            sql.append("'" + nome + "',");
            sql.append("'" + cpf + "',");
            sql.append("'" + telefone + "',");
            sql.append("'" + email + "'");
            sql.append(");");

            try {
                db.execSQL(sql.toString());
                Toast.makeText(getContext(), "Cliente salvo com sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(getContext(), "Erro ao salvar o cliente!" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            etNome.setText("");
            etCpf.setText("");
            etTelefone.setText("");
            etEmail.setText("");

            db.close();
        }
    }
}