package com.example.app_loc.locacoes;

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

public class AdicionarLocacao extends Fragment {

    EditText etCliente;
    EditText etVeiculo;
    EditText etDataRetirada;
    EditText etDataDevolucao;
    EditText etValor;

    public AdicionarLocacao() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_adicionar_locacao, container, false);
        Button btn = (Button) v.findViewById(R.id.button_SalvarAdicionarLocacao);

        etCliente = (EditText) v.findViewById(R.id.editText_ClienteAdicionarLocacao);
        etVeiculo = (EditText) v.findViewById(R.id.editText_VeiculoAdicionarLocacao);
        etDataRetirada = (EditText) v.findViewById(R.id.editText_DataRetiradaAdicionarLocacao);
        etDataDevolucao = (EditText) v.findViewById(R.id.editText_DataDevolucaoAdicionarLocacao);
        etValor = (EditText) v.findViewById(R.id.editText_ValorAdicionarLocacao);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adicionarLocacao();
            }
        });
        return v;
    }

    private void adicionarLocacao() {
        String cliente = etCliente.getText().toString().trim();
        String veiculo = etVeiculo.getText().toString().trim();
        String data_retirada = etDataRetirada.getText().toString().trim();
        String data_devolucao = etDataDevolucao.getText().toString().trim();
        String valor = etValor.getText().toString().trim();
        if (cliente.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o cliente!", Toast.LENGTH_LONG).show();
        } else if (veiculo.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o veículo!", Toast.LENGTH_LONG).show();
        } else if (data_retirada.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe a data de retirada!", Toast.LENGTH_LONG).show();
        } else if (data_devolucao.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe a data de devolução!", Toast.LENGTH_LONG).show();
        } else if (valor.equals("")) {
            Toast.makeText(getContext(), "Por favor, informe o valor!", Toast.LENGTH_LONG).show();
        } else {
            SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);

            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO locacoes (cliente, veiculo, data_retirada, data_devolucao, valor) VALUES (");
            sql.append("'" + cliente + "',");
            sql.append("'" + veiculo + "',");
            sql.append("'" + data_retirada + "',");
            sql.append("'" + data_devolucao + "',");
            sql.append("'" + valor + "'");
            sql.append(");");

            try {
                db.execSQL(sql.toString());
                Toast.makeText(getContext(), "Locação salva com sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(getContext(), "Erro ao salvar a locação!" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            etCliente.setText("");
            etVeiculo.setText("");
            etDataRetirada.setText("");
            etDataDevolucao.setText("");
            etValor.setText("");

            db.close();
        }
    }
}