package com.example.app_loc.veiculo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.app_loc.R;

public class ListarVeiculos extends Fragment {

    ListView lv;

    public ListarVeiculos() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listar_veiculos, container, false);

        lv = (ListView) v.findViewById(R.id.listView_Veiculos);

        listarVeiculos();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tvId = v.findViewById(R.id.textView_IdListarVeiculo);
                TextView tvDescricao = v.findViewById(R.id.textView_DescricaoListarVeiculo);
                TextView tvModelo = v.findViewById(R.id.textView_ModeloListarVeiculo);
                TextView tvCor = v.findViewById(R.id.textView_CorListarVeiculo);
                TextView tvAno = v.findViewById(R.id.textView_AnoListarVeiculo);

                Bundle b = new Bundle();
                b.putString("id", tvId.getText().toString());
                b.putString("descricao", tvDescricao.getText().toString());
                b.putString("modelo", tvModelo.getText().toString());
                b.putString("cor", tvCor.getText().toString());
                b.putString("ano", tvAno.getText().toString());

                EditarVeiculo f = new EditarVeiculo();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                f.setArguments(b);
                ft.replace(R.id.frame_clientes, f);
                ft.commit();
            }
        });

        return v;
    }

    private void listarVeiculos() {

        SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);
        String sql = "SELECT * FROM veiculos ORDER BY _id;";
        Cursor dados = db.rawQuery(sql, null);
        String[] from = {"_id", "descricao", "modelo", "cor", "ano"};
        int[] to = {R.id.textView_IdListarVeiculo,
                R.id.textView_DescricaoListarVeiculo,
                R.id.textView_ModeloListarVeiculo,
                R.id.textView_CorListarVeiculo,
                R.id.textView_AnoListarVeiculo};

        SimpleCursorAdapter adapter =
                new SimpleCursorAdapter(getContext(), R.layout.item_listview_veiculo, dados, from, to, 0);
        lv.setAdapter(adapter);

        db.close();


    }
}