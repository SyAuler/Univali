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
import androidx.fragment.app.FragmentTransaction;

import com.example.app_loc.R;

public class EditarCliente extends Fragment {

    EditText etNome;
    EditText etCpf;
    EditText etTelefone;
    EditText etEmail;

    public EditarCliente() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_editar_cliente, container, false);

        etNome = (EditText) v.findViewById(R.id.editText_NomeEditarCliente);
        etCpf = (EditText) v.findViewById(R.id.editText_CPFEditarCliente);
        etTelefone = (EditText) v.findViewById(R.id.editText_TelefoneEditarCliente);
        etEmail = (EditText) v.findViewById(R.id.editText_EmailEditarCliente);

        Bundle b = getArguments();

        String id = b.getString("id");
        etNome.setText(b.getString("nome"));
        etCpf.setText(b.getString("cpf"));
        etTelefone.setText(b.getString("telefone"));
        etEmail.setText(b.getString("email"));

        Button btnExcluir = (Button) v.findViewById(R.id.button_ExcluirEditarCliente);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excluirCliente(id);
                Toast.makeText(getContext(), "Clicado no botão Cancelar/ EXCLUIR!", Toast.LENGTH_LONG).show();
            }
        });

        Button btnEditar = (Button) v.findViewById(R.id.button_SalvarEditarCliente);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PROF VAI VERIFICAR PQ ENTRA NO MESMO ID NA EDIÇÃO DE UM ITEM
                editarCliente(id);
            }
        });

        return v;
    }

    private void editarCliente(String id) {
        String nome = etNome.getText().toString().trim();
        String cpf = etCpf.getText().toString().trim();
        String telefone = etTelefone.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if (nome.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o nome!", Toast.LENGTH_LONG).show();
        } else if (cpf.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o CPF!", Toast.LENGTH_LONG).show();
        } else if (telefone.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o telefone!", Toast.LENGTH_LONG).show();
        } else if (email.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o e-mail!", Toast.LENGTH_LONG).show();
        } else {
            SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE clientes SET ");
            sql.append("nome = '" + nome + "',");
            sql.append("cpf = '" + cpf + "',");
            sql.append("telefone = '" + telefone + "',");
            sql.append("email = '" + email + "'");
            sql.append("WHERE _id = " + id + ";");

            try {
                db.execSQL(sql.toString());
                Toast.makeText(getContext(), "Cliente atualizado com sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(getContext(), "Erro ao atualizar o cliente!" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            db.close();
            ListarClientes f = new ListarClientes();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_clientes, f);
            ft.commit();
        }
    }

    private void excluirCliente(String id) {
        SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);

        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM clientes ");
        sql.append("WHERE _id = " + id + ";");

        try {
            db.execSQL(sql.toString());
            Toast.makeText(getContext(), "Cliente excluído com sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(getContext(), "Erro ao excluir o cliente!" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        db.close();
        ListarClientes f = new ListarClientes();
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_clientes, f);
        ft.commit();
    }
}