package com.example.app_loc.veiculo;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.app_loc.R;

public class EditarFragment extends Fragment {

    public EditarFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_editar_veiculo, container, false);

        Bundle b = new Bundle();
        if (b != null) {
            b = getArguments();
            Toast.makeText(getContext(), "ID recebido: " + b.getString("id"), Toast.LENGTH_LONG).show();
        }

        Button btnExcluir = (Button) v.findViewById(R.id.button_SalvarEditarVeiculo);
        btnExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clicado no botão Cancelar!", Toast.LENGTH_LONG).show();
            }
        });

        Button btnEditar = (Button) v.findViewById(R.id.button_SalvarEditarVeiculo);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clicado no botão Salvar!", Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }
}