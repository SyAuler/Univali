package com.example.app_loc.modelo;

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

public class EditarModelo extends Fragment {

    EditText etMarca;
    EditText etModelo;
    EditText etValorDiaria;
    EditText etDescricao;

    public EditarModelo() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_editar_modelos, container, false);

        etMarca = (EditText) v.findViewById(R.id.editText_MarcaEditarModelo);
        etModelo = (EditText) v.findViewById(R.id.editText_ModeloEditarModelo);
        etValorDiaria = (EditText) v.findViewById(R.id.editText_ValorDiariaEditarModelo);
        etDescricao = (EditText) v.findViewById(R.id.editText_DescricaoEditarModelo);

        Bundle b = getArguments();

        String id = b.getString("id");
        etMarca.setText(b.getString("marca"));
        etModelo.setText(b.getString("modelo"));
        etValorDiaria.setText(b.getString("valorDiaria"));
        etDescricao.setText(b.getString("descricao"));

        Button btnExcluir = (Button) v.findViewById(R.id.button_ExcluirEditarModelo);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excluirModelo(id);
                Toast.makeText(getContext(), "Clicado no botão Cancelar/ EXCLUIR!", Toast.LENGTH_LONG).show();
            }
        });

        Button btnEditar = (Button) v.findViewById(R.id.button_SalvarEditarModelo);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarModelo(id);
            }
        });

        return v;
    }

    private void editarModelo(String id) {
        String marca = etMarca.getText().toString().trim();
        String modelo = etModelo.getText().toString().trim();
        String valor = etValorDiaria.getText().toString().trim();
        String descricao = etDescricao.getText().toString().trim();
        if (marca.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe a marca!", Toast.LENGTH_LONG).show();
        } else if (modelo.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o modelo!", Toast.LENGTH_LONG).show();
        } else if (valor.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o valor da diária!", Toast.LENGTH_LONG).show();
        } else if (descricao.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe uma descrição!", Toast.LENGTH_LONG).show();
        } else {
            SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);

            StringBuilder sql = new StringBuilder();
            sql.append("UPDATE modelos SET ");
            sql.append("marca = '" + marca + "',");
            sql.append("modelo = '" + modelo + "',");
            sql.append("valor = '" + valor + "',");
            sql.append("descricao = '" + descricao + "'");
            sql.append("WHERE _id = " + id + ";");

            try {
                db.execSQL(sql.toString());
                Toast.makeText(getContext(), "Modelo atualizado com sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(getContext(), "Erro ao atualizar o modelo!" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            db.close();
            ListarModelos f = new ListarModelos();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_modelos, f);
            ft.commit();
        }
    }

    private void excluirModelo(String id) {
        SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);

        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM modelos ");
        sql.append("WHERE _id = " + id + ";");

        try {
            db.execSQL(sql.toString());
            Toast.makeText(getContext(), "Modelo excluído com sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(getContext(), "Erro ao excluir o modelo!" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        db.close();
        ListarModelos f = new ListarModelos();
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_modelos, f);
        ft.commit();
    }
}