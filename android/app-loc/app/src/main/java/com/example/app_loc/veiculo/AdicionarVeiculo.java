package com.example.app_loc.veiculo;

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

public class AdicionarVeiculo extends Fragment {

    EditText etDescricao;
    EditText etModelo;
    EditText etCor;
    EditText etAno;

    public AdicionarVeiculo() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_adicionar_veiculo, container, false);
        Button btn = (Button) v.findViewById(R.id.button_SalvarEditarVeiculo);

        etDescricao = (EditText) v.findViewById(R.id.editText_DescricaoAdicionarVeiculo);
        etModelo = (EditText) v.findViewById(R.id.editText_ModeloAdicionarVeiculo);
        etCor = (EditText) v.findViewById(R.id.editText_CorAdicionarVeiculo);
        etAno = (EditText) v.findViewById(R.id.editText_AnoAdicionarVeiculo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarVeiculo();
            }
        });

        return v;
    }

    private void adicionarVeiculo() {
        String descricao = etDescricao.getText().toString().trim();
        String modelo = etModelo.getText().toString().trim();
        String cor = etCor.getText().toString().trim();
        String ano = etAno.getText().toString().trim();
        if (descricao.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o nome!", Toast.LENGTH_LONG).show();
        } else if (modelo.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o modelo!", Toast.LENGTH_LONG).show();
        } else if (cor.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe a cor!", Toast.LENGTH_LONG).show();
        } else if (ano.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o ano!", Toast.LENGTH_LONG).show();
        } else {
            SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO veiculos (descricao, modelo, ano, cor) VALUES (");
            sql.append("'" + descricao + "',");
            sql.append("'" + modelo + "',");
            sql.append("'" + cor + "',");
            sql.append("'" + ano + "'");
            sql.append(");");

            try {
                db.execSQL(sql.toString());
                Toast.makeText(getContext(), "Veículo salvo com sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(getContext(), "Erro ao salvar o veículo!" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            etDescricao.setText("");
            etModelo.setText("");
            etCor.setText("");
            etAno.setText("");

            db.close();
        }
    }
}