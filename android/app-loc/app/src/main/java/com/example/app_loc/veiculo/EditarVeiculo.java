package com.example.app_loc.veiculo;

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

public class EditarVeiculo extends Fragment {

    EditText etDescricao;
    EditText etModelo;
    EditText etCor;
    EditText etAno;

    public EditarVeiculo() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_editar_veiculo, container, false);

        etDescricao = (EditText) v.findViewById(R.id.editText_DescricaoEditarVeiculo);
        etModelo = (EditText) v.findViewById(R.id.editText_ModeloEditarVeiculo);
        etCor = (EditText) v.findViewById(R.id.editText_CorEditarVeiculo);
        etAno = (EditText) v.findViewById(R.id.editText_AnoEditarVeiculo);

        Bundle b = getArguments();

        String id = b.getString("id");
        etDescricao.setText(b.getString("descricao"));
        etModelo.setText(b.getString("modelo"));
        etCor.setText(b.getString("cor"));
        etAno.setText(b.getString("ano"));

        Button btnExcluir = (Button) v.findViewById(R.id.button_ExcluirEditarVeiculo);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excluirVeiculo(id);
                Toast.makeText(getContext(), "Clicado no botão Cancelar/ EXCLUIR!", Toast.LENGTH_LONG).show();
            }
        });

        Button btnEditar = (Button) v.findViewById(R.id.button_SalvarEditarVeiculo);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PROF VAI VERIFICAR PQ ENTRA NO MESMO ID NA EDIÇÃO DE UM ITEM
                editarVeiculo(id);
            }
        });

        return v;
    }

    private void editarVeiculo(String id) {
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
            sql.append("UPDATE veiculos SET ");
            sql.append("descricao = '" + descricao + "',");
            sql.append("modelo = '" + modelo + "',");
            sql.append("cor = '" + cor + "',");
            sql.append("ano = '" + ano + "'");
            sql.append("WHERE _id = " + id + ";");

            try {
                db.execSQL(sql.toString());
                Toast.makeText(getContext(), "Veículo atualizado com sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(getContext(), "Erro ao atualizar o veículo!" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            db.close();
            ListarVeiculos f = new ListarVeiculos();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_clientes, f);
            ft.commit();
        }
    }

    private void excluirVeiculo(String id) {
            SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);

            StringBuilder sql = new StringBuilder();
            sql.append("DELETE FROM veiculos ");
            sql.append("WHERE _id = " + id + ";");

            try {
                db.execSQL(sql.toString());
                Toast.makeText(getContext(), "Veículo excluído com sucesso!", Toast.LENGTH_LONG).show();
            } catch (SQLException e) {
                Toast.makeText(getContext(), "Erro ao excluir o veículo!" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            db.close();
            ListarVeiculos f = new ListarVeiculos();
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_clientes, f);
            ft.commit();
    }
}