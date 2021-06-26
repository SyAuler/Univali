package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.calculadora.historico.ListarHistorico;

public class HistoricoActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //ListView btnListar = (ListView) findViewById(R.id.listView_Historico);
        //Button btnListar = findViewById(R.id.button_ListarHistorico);

       /* if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_historico, new ListarHistorico()).commit();
        }

       btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_historico, new ListarHistorico()).commit();
            }
        }); */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}