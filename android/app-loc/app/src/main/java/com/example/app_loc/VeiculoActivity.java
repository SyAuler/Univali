package com.example.app_loc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.app_loc.veiculo.AdicionarVeiculo;
import com.example.app_loc.veiculo.ListarVeiculos;

public class VeiculoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculos);

        //Habilita o botão de voltar para a página inicial
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnAdicionar = findViewById(R.id.button_AdicionarVeiculo);
        Button btnListar = findViewById(R.id.button_ListarVeiculos);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_veiculos, new ListarVeiculos()).commit();
        }

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_veiculos, new ListarVeiculos()).commit();
            }
        });

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_veiculos, new AdicionarVeiculo()).commit();
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