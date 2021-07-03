package com.example.app_loc.locacoes;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_loc.R;
import com.example.app_loc.locacoes.ListarLocacoes;

public class EditarLocacao extends Fragment {

    EditText etCliente;
    EditText etVeiculo;
    EditText etDataRetirada;
    EditText etDataDevolucao;
    EditText etValor;

    public EditarLocacao() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_editar_locacao, container, false);

        etCliente = (EditText) v.findViewById(R.id.editText_ClienteEditarLocacao);
        etVeiculo = (EditText) v.findViewById(R.id.editText_VeiculoEditarLocacao);
        etDataRetirada = (EditText) v.findViewById(R.id.editText_DataRetiradaEditarLocacao);
        etDataDevolucao = (EditText) v.findViewById(R.id.editText_DataDevolucaoEditarLocacao);
        etValor = (EditText) v.findViewById(R.id.editText_ValorEditarLocacao);

        Bundle b = getArguments();

        String id = b.getString("id");
        etCliente.setText(b.getString("cliente"));
        etVeiculo.setText(b.getString("veiculo"));
        etDataRetirada.setText(b.getString("data_retirada"));
        etDataDevolucao.setText(b.getString("data_devolucao"));
        etValor.setText(b.getString("valor"));

        Button btnExcluir = (Button) v.findViewById(R.id.button_ExcluirEditarLocacao);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excluirLocacao(id);
                Toast.makeText(getContext(), "Clicado no botão Cancelar/ EXCLUIR!", Toast.LENGTH_LONG).show();
            }
        });

        Button btnEditar = (Button) v.findViewById(R.id.button_SalvarEditarLocacao);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PROF VAI VERIFICAR PQ ENTRA NO MESMO ID NA EDIÇÃO DE UM ITEM
                editarLocacao(id);
            }
        });

        return v;
    }

    private void editarLocacao(String id) {
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
            sql.append("UPDATE locacoes SET ");
            sql.append("cliente = '" + cliente + "',");
            sql.append("veiculo = '" + veiculo + "',");
            sql.append("data_retirada = '" + data_retirada + "',");
            sql.append("data_devolucao = '" + data_devolucao + "'");
            sql.append("valor = '" + valor + "'");
            sql.append("WHERE _id = " + id + ";");

            try {
                db.execSQL(sql.toString());
                Toast.makeText(getContext(), "Locação atualizada com sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(getContext(), "Erro ao atualizar a locação!" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            db.close();
            ListarLocacoes f = new ListarLocacoes();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_locacoes, f);
            ft.commit();
        }
    }

    private void excluirLocacao(String id) {
        SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);

        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM locacoes ");
        sql.append("WHERE _id = " + id + ";");

        try {
            db.execSQL(sql.toString());
            Toast.makeText(getContext(), "Locação excluída com sucesso!", Toast.LENGTH_LONG).show();
        } catch (SQLException e) {
            Toast.makeText(getContext(), "Erro ao excluir a locação!" + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        db.close();
        ListarLocacoes f = new ListarLocacoes();
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_locacoes, f);
        ft.commit();
    }
}