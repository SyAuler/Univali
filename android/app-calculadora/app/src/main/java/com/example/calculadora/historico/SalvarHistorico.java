package com.example.calculadora.historico;

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

import com.example.calculadora.R;

public class SalvarHistorico extends Fragment {
    EditText etExpressao;
    EditText etResultado;

    public SalvarHistorico() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_calculadora, container, false);
        Button btn = (Button) v.findViewById(R.id.igual);

        //  etExpressao = (EditText) v.findViewById(R.id.editText_DescricaoAdicionarVeiculo);
        //  etResultado = (EditText) v.findViewById(R.id.editText_ModeloAdicionarVeiculo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarDados("", "");
            }
        });

        return v;
    }

    public void salvarDados(String expressao, String resultado) {
       // String expressao = etExpressao.getText().toString().trim();
       // String resultado = etResultado.getText().toString().trim();
        if (expressao.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe um valor!", Toast.LENGTH_LONG).show();
        } else {
            SQLiteDatabase db = getActivity().openOrCreateDatabase("dbCalculator.db", Context.MODE_PRIVATE, null);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO calculator (expressao, resultado) VALUES (");
            sql.append("'" + expressao + "',");
            sql.append("'" + resultado + "',");
            sql.append(");");

            try {
                db.execSQL(sql.toString());
                Toast.makeText(getContext(), "Dados salvos com sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(getContext(), "Erro ao salvar os dados!" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            etExpressao.setText("");
            etResultado.setText("");

            db.close();
        }
    }

}
