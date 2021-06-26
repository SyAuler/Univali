package com.example.calculadora.historico;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.calculadora.R;

import java.util.ArrayList;
import java.util.List;

public class SalvarHistorico extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_calculadora, container, false);
        Button btn = (Button) v.findViewById(R.id.igual);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarDados("", "");
            }
        });

        return v;
    }

    public void salvarDados(String expressao, String resultado) {
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
            db.close();
        }
    }

}
