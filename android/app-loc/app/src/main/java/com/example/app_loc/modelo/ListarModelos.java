package com.example.app_loc.modelo;

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
import androidx.fragment.app.FragmentTransaction;

import com.example.app_loc.R;

public class ListarModelos extends Fragment {

    ListView lv;

    public ListarModelos() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listar_modelos, container, false);

        lv = (ListView) v.findViewById(R.id.listView_Modelos);

        listarModelos();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tvId = v.findViewById(R.id.textView_IdListarModelo);
                TextView tvMarca = v.findViewById(R.id.textView_MarcaListarModelo);
                TextView tvModelo = v.findViewById(R.id.textView_ModeloListarModelo);
                TextView tvValorDiaria = v.findViewById(R.id.textView_ValorDiariaListarModelo);
                TextView tvDescricao = v.findViewById(R.id.textView_DescricaoListarModelo);

                Bundle b = new Bundle();
                b.putString("id", tvId.getText().toString());
                b.putString("marca", tvMarca.getText().toString());
                b.putString("modelo", tvModelo.getText().toString());
                b.putString("valor", tvValorDiaria.getText().toString());
                b.putString("descricao", tvDescricao.getText().toString());

                EditarModelo f = new EditarModelo();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                f.setArguments(b);
                ft.replace(R.id.frame_modelos, f);
                ft.commit();
            }
        });
        return v;
    }

    private void listarModelos() {

        SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);
        String sql = "SELECT * FROM modelos ORDER BY _id;";
        Cursor dados = db.rawQuery(sql, null);
        String[] from = {"_id", "marca", "modelo", "valor", "descricao"};
        int[] to = {R.id.textView_IdListarModelo,
                R.id.textView_MarcaListarModelo,
                R.id.textView_ModeloListarModelo,
                R.id.textView_ValorDiariaListarModelo,
                R.id.textView_DescricaoListarModelo};

        SimpleCursorAdapter adapter =
                new SimpleCursorAdapter(getContext(), R.layout.item_listview_modelo, dados, from, to, 0);
        lv.setAdapter(adapter);

        db.close();


    }
}