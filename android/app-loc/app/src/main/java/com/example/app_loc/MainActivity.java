package com.example.app_loc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.app_loc.locacoes.AdicionarLocacao;
import com.example.app_loc.locacoes.ListarLocacoes;
import com.example.app_loc.veiculo.AdicionarVeiculo;
import com.example.app_loc.veiculo.ListarVeiculos;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        criarBancoDados();

        Button btnAdicionar = findViewById(R.id.button_AdicionarLocacao);
        Button btnListar = findViewById(R.id.button_ListarLocacoes);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_locacoes, new ListarLocacoes()).commit();
        }

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_locacoes, new ListarLocacoes()).commit();
            }
        });

        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_locacoes, new AdicionarLocacao()).commit();
            }
        });
    }

    private void criarBancoDados() {
        SQLiteDatabase db = openOrCreateDatabase("dbLocacao.db", Context.MODE_PRIVATE, null);
        StringBuilder sql = new StringBuilder();

        sql.append("CREATE TABLE IF NOT EXISTS locacoes (");
        sql.append("_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sql.append("cliente VARCHAR(100), ");
        sql.append("veiculo VARCHAR(100), ");
        sql.append("data_retirada VARCHAR(100), ");
        sql.append("data_devolucao VARCHAR(100), ");
        sql.append("valor VARCHAR(100)");
        sql.append(");");

        sql.append("CREATE TABLE IF NOT EXISTS veiculos (");
        sql.append("_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sql.append("descricao VARCHAR(100), ");
        sql.append("modelo VARCHAR(100), ");
        sql.append("cor VARCHAR(100), ");
        sql.append("ano VARCHAR(100)");
        sql.append(");");

        sql.append("CREATE TABLE IF NOT EXISTS modelos (");
        sql.append("_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sql.append("marca VARCHAR(100), ");
        sql.append("modelo VARCHAR(100), ");
        sql.append("valor VARCHAR(100), ");
        sql.append("descricao VARCHAR(100)");
        sql.append(");");

        sql.append("CREATE TABLE IF NOT EXISTS clientes (");
        sql.append("_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sql.append("nome VARCHAR(100), ");
        sql.append("cpf VARCHAR(14), ");
        sql.append("telefone VARCHAR(15), ");
        sql.append("email VARCHAR(100), ");
        sql.append("senha VARCHAR(100)");
        sql.append(");");

        try {
            String[] queries = sql.toString().split(";");
            for (String query : queries) {
                db.execSQL(query);
            }
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), "Erro " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        db.close();
    }
}