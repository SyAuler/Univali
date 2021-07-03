package com.example.app_loc.modelo;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.app_loc.R;

public class AdicionarModelo extends Fragment {

    EditText etMarca;
    EditText etModelo;
    EditText etValorDiaria;
    EditText etDescricao;

    public AdicionarModelo() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_adicionar_modelos, container, false);
        Button btn = (Button) v.findViewById(R.id.button_SalvarAdicionarModelo);

        etMarca = (EditText) v.findViewById(R.id.editText_MarcaAdicionarModelo);
        etModelo = (EditText) v.findViewById(R.id.editText_ModeloAdicionarModelo);
        etValorDiaria = (EditText) v.findViewById(R.id.editText_ValorDiariaAdicionarModelo);
        etDescricao = (EditText) v.findViewById(R.id.editText_DescricaoAdicionarModelo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { adicionarModelo(); }
        });

        return v;
    }

    private void adicionarModelo() {
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
            Toast.makeText(getContext(), "Por favor, informe a descricão!", Toast.LENGTH_LONG).show();
        } else {
            SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO modelos (marca, modelo, valor, descricao) VALUES (");
            sql.append("'" + marca + "',");
            sql.append("'" + modelo + "',");
            sql.append("'" + valor + "',");
            sql.append("'" + descricao + "'");
            sql.append(");");

            try {
                db.execSQL(sql.toString());
                Toast.makeText(getContext(), "Modelo salvo com sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(getContext(), "Erro ao salvar o modelo!" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            etMarca.setText("");
            etModelo.setText("");
            etValorDiaria.setText("");
            etDescricao.setText("");

            db.close();
        }
    }
}