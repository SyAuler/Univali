package com.example.app_loc;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app_loc.cliente.AdicionarCliente;
import com.example.app_loc.cliente.ListarClientes;

public class ClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        //Habilita o botão de voltar para a página inicial
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnAdicionar = findViewById(R.id.button_AdicionarCliente);
        Button btnListar = findViewById(R.id.button_ListarClientes);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_clientes, new ListarClientes()).commit();
        }

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_clientes, new ListarClientes()).commit();
            }
        });

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_clientes, new AdicionarCliente()).commit();
            }
        });

    }

    @Override
    //Função responsável por voltar para a página inicial
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}