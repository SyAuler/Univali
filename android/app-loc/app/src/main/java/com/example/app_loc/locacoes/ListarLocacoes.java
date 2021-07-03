package com.example.app_loc.locacoes;

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
import com.example.app_loc.locacoes.EditarLocacao;

public class ListarLocacoes extends Fragment {

    ListView lv;

    public ListarLocacoes() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listar_locacoes, container, false);

        lv = (ListView) v.findViewById(R.id.listView_Locacoes);

        listarLocacoes();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tvId = v.findViewById(R.id.textView_IdListarLocacao);
                TextView tvCliente = v.findViewById(R.id.textView_ClienteListarLocacao);
                TextView tvVeiculo = v.findViewById(R.id.textView_VeiculoListarLocacao);
                TextView tvDataRetirada = v.findViewById(R.id.textView_DataRetiradaListarLocacao);
                TextView tvDataDevolucao = v.findViewById(R.id.textView_DataDevolucaoListarLocacao);
                TextView tvValor = v.findViewById(R.id.textView_ValorListarLocacao);

                Bundle b = new Bundle();
                b.putString("id", tvId.getText().toString());
                b.putString("cliente", tvCliente.getText().toString());
                b.putString("veiculo", tvVeiculo.getText().toString());
                b.putString("data_retirada", tvDataRetirada.getText().toString());
                b.putString("data_devolucao", tvDataDevolucao.getText().toString());
                b.putString("valor", tvValor.getText().toString());

                EditarLocacao f = new EditarLocacao();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                f.setArguments(b);
                ft.replace(R.id.frame_locacoes, f);
                ft.commit();
            }
        });

        return v;
    }

    private void listarLocacoes() {

        SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);
        String sql = "SELECT * FROM locacoes ORDER BY _id;";
        Cursor dados = db.rawQuery(sql, null);
        String[] from = {"_id", "cliente", "veiculo", "data_retirada", "data_devolucao", "valor"};
        int[] to = {R.id.textView_IdListarLocacao,
                R.id.textView_ClienteListarLocacao,
                R.id.textView_VeiculoListarLocacao,
                R.id.textView_DataRetiradaListarLocacao,
                R.id.textView_DataDevolucaoListarLocacao,
                R.id.textView_ValorListarLocacao};

        SimpleCursorAdapter adapter =
                new SimpleCursorAdapter(getContext(), R.layout.item_listview_locacao, dados, from, to, 0);
        lv.setAdapter(adapter);

        db.close();
    }
}