package com.example.app_loc.cliente;

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

public class ListarClientes extends Fragment {

    ListView lv;

    public ListarClientes() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listar_clientes, container, false);

        lv = (ListView) v.findViewById(R.id.listView_Clientes);

        listarClientes();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tvId = v.findViewById(R.id.textView_IdListarCliente);
                TextView tvNome = v.findViewById(R.id.textView_NomeListarCliente);
                TextView tvCpf = v.findViewById(R.id.textView_CPFListarCliente);
                TextView tvTelefone = v.findViewById(R.id.textView_TelefoneListarCliente);
                TextView tvEmail = v.findViewById(R.id.textView_EmailListarCliente);

                Bundle b = new Bundle();
                b.putString("id", tvId.getText().toString());
                b.putString("nome", tvNome.getText().toString());
                b.putString("cpf", tvCpf.getText().toString());
                b.putString("telefone", tvTelefone.getText().toString());
                b.putString("email", tvEmail.getText().toString());

                EditarCliente f = new EditarCliente();
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                f.setArguments(b);
                ft.replace(R.id.frame_clientes, f);
                ft.commit();
            }
        });

        return v;
    }

    private void listarClientes() {

        SQLiteDatabase db = getActivity().openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);
        String sql = "SELECT * FROM clientes ORDER BY _id;";
        Cursor dados = db.rawQuery(sql, null);
        String[] from = {"_id", "nome", "cpf", "telefone", "email"};
        int[] to = {R.id.textView_IdListarCliente,
                R.id.textView_NomeListarCliente,
                R.id.textView_CPFListarCliente,
                R.id.textView_TelefoneListarCliente,
                R.id.textView_EmailListarCliente};

        SimpleCursorAdapter adapter =
                new SimpleCursorAdapter(getContext(), R.layout.item_listview_cliente, dados, from, to, 0);
        lv.setAdapter(adapter);

        db.close();


    }
}