package com.example.app_loc.modelo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.List;

import com.example.app_loc.R;

public class ListarFragment extends Fragment {

    public ListarFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_listar_modelos, container, false);

        ListView lv = (ListView) v.findViewById(R.id.listView_Modelos);

        List<String> lista_modelos = new ArrayList<String>();
        lista_modelos.add("Modelo 1");
        lista_modelos.add("Modelo 2");
        lista_modelos.add("Modelo 3");
        lista_modelos.add("Modelo 4");
        lista_modelos.add("Modelo 5");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                getContext(),
                android.R.layout.simple_list_item_1,
                lista_modelos
        );

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EditarFragment f = new EditarFragment();
                Bundle b = new Bundle();

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();

                b.putString("id", "1");

                f.setArguments(b);

                ft.replace(R.id.frame_modelos, f);

                ft.commit();
            }
        });

        return v;
    }
}