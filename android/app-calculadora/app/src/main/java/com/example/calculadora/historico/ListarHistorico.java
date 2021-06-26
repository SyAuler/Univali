package com.example.calculadora.historico;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.calculadora.R;

public class ListarHistorico extends Fragment {
    public ListView lista;

    public ListarHistorico() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listarHistorico();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_historico, container, false);

        lista = (ListView) v.findViewById(R.id.listView_Historico);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tvId = v.findViewById(R.id.textView_IdListar);
                TextView tvExpressao = v.findViewById(R.id.textView_Expressao);
                TextView tvResultado = v.findViewById(R.id.textView_Resultado);

                Bundle b = new Bundle();
                b.putString("id", tvId.getText().toString());
                b.putString("expressao", tvExpressao.getText().toString());
                b.putString("resultado", tvResultado.getText().toString());

            }
        });

        return v;
    }

    private void listarHistorico() {

       // SQLiteDatabase db = openOrCreateDatabase("dbCalculator.db", Context.MODE_PRIVATE, null);

        SQLiteDatabase db = getActivity().openOrCreateDatabase("dbCalculator.db", Context.MODE_PRIVATE, null);
        String sql = "SELECT * FROM calculator ORDER BY id;";
        Cursor dados = db.rawQuery(sql, null);
        String[] from = {"_id", "expressao", "resultado"};
        int[] to = {R.id.textView_IdListar, R.id.textView_Expressao, R.id.textView_Resultado};

        SimpleCursorAdapter adapter =
                new SimpleCursorAdapter(getContext(), R.layout.item_listview_historico, dados, from, to, 0);
        lista.setAdapter(adapter);

        db.close();
    }
}
