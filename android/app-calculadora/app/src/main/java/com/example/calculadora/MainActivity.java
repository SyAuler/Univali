package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button numZero, numUm, numDois, numTres, numQuatro, numCinco,
    numSeis, numSete, numOito, numNove, ponto, soma, subtracao, multiplicacao,
    divisao, igual, btn_limpar;

    private TextView txtExpressao, txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();

        //definir os eventos de click em cada componente do tipo button
        //para recuperar o click a partir do contexto atual
        numZero.setOnClickListener(this);
        numUm.setOnClickListener(this);
        numDois.setOnClickListener(this);
        numTres.setOnClickListener(this);
        numQuatro.setOnClickListener(this);
        numCinco.setOnClickListener(this);
        numSeis.setOnClickListener(this);
        numSete.setOnClickListener(this);
        numOito.setOnClickListener(this);
        numNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        soma.setOnClickListener(this);
        subtracao.setOnClickListener(this);
        multiplicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

        btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });

        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()) {
                    byte varZero = 0;
                    int varUm = string.length()-1;
                    String txtExpressao = string.substring(varZero, varUm);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });

        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // responsável por fazer todos os cálculos
                    Expression expression = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expression.evaluate(); //vai avaliar a expressão e fazer todos os tratamentos necessários
                    long longResult = (long) resultado;

                    if (resultado == (double)longResult) {
                        //vai converter em string
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    } else {
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                } catch (Exception e) {

                }

            }
        });
    }

    private void IniciarComponentes() {
        numZero = findViewById(R.id.num_zero);
        numUm = findViewById(R.id.num_um);
        numDois = findViewById(R.id.num_dois);
        numTres = findViewById(R.id.num_tres);
        numQuatro = findViewById(R.id.num_quatro);
        numCinco = findViewById(R.id.num_cinco);
        numSeis = findViewById(R.id.num_seis);
        numSete = findViewById(R.id.num_sete);
        numOito = findViewById(R.id.num_oito);
        numNove = findViewById(R.id.num_nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.soma);
        subtracao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        btn_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
    }

    public void AcrescentarUmaExpressao(String string, boolean limpar_dados) {
        if (txtResultado.getText().equals("")) {
            txtExpressao.setText(" ");
        }

        if (limpar_dados) {
            txtResultado.setText(" ");
            txtExpressao.append(string);
        } else {
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        //recuperar o id do botão clicado
        switch (view.getId()) {
            case R.id.num_zero:
                AcrescentarUmaExpressao("0",true);
                break;
            case R.id.num_um:
                AcrescentarUmaExpressao("1",true);
                break;
            case R.id.num_dois:
                AcrescentarUmaExpressao("2",true);
                break;
            case R.id.num_tres:
                AcrescentarUmaExpressao("3",true);
                break;
            case R.id.num_quatro:
                AcrescentarUmaExpressao("4",true);
                break;
            case R.id.num_cinco:
                AcrescentarUmaExpressao("5",true);
                break;
            case R.id.num_seis:
                AcrescentarUmaExpressao("6",true);
                break;
            case R.id.num_sete:
                AcrescentarUmaExpressao("7",true);
                break;
            case R.id.num_oito:
                AcrescentarUmaExpressao("8",true);
                break;
            case R.id.num_nove:
                AcrescentarUmaExpressao("9",true);
                break;
            case R.id.ponto:
                AcrescentarUmaExpressao(".",true);
                break;
            case R.id.soma:
                AcrescentarUmaExpressao("+",false);
                break;
            case R.id.subtracao:
                AcrescentarUmaExpressao("-",false);
                break;
            case R.id.multiplicacao:
                AcrescentarUmaExpressao("*",false);
                break;
            case R.id.divisao:
                AcrescentarUmaExpressao("/",false);
                break;
        }
    }
}