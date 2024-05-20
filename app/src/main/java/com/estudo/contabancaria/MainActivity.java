package com.estudo.contabancaria;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.estudo.contabancaria.model.ContaBancaria;
import com.estudo.contabancaria.model.ContaEspecial;
import com.estudo.contabancaria.model.ContaPoupanca;

public class MainActivity extends AppCompatActivity {

    private Button btnSalvar;
    private Button btnSacar;
    private Button btnDepositar;
    private RadioButton rbCPoupanca;
    private RadioButton rbCEspecial;
    private TextView tvMain;
    private TextView tvValor;
    private EditText etNome;
    private EditText etVInicial;
    private EditText etValor;
    private ContaBancaria conta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnSalvar = findViewById(R.id.btnSalvar);
        rbCPoupanca = findViewById(R.id.rbCPoupanca);
        rbCPoupanca.setChecked(true);
        rbCEspecial = findViewById(R.id.rbCEspecial);
        tvMain = findViewById(R.id.tvMain);
        etNome = findViewById(R.id.etNome);
        etVInicial = findViewById(R.id.etVInicial);
        tvValor = findViewById(R.id.tvValor);
        btnSacar = findViewById(R.id.btnSacar);
        btnDepositar = findViewById(R.id.btnDepositar);
        etValor = findViewById(R.id.etValor);

        btnSalvar.setOnClickListener(op -> cadastrar());

        btnSacar.setOnClickListener(op -> sacarValor());

        btnDepositar.setOnClickListener(op -> depositarValor());
    }

    public void cadastrar(){
        if(rbCPoupanca.isChecked()){
            conta = new ContaPoupanca();
        }
        else {
            conta = new ContaEspecial();
        }
        conta.setCliente(etNome.getText().toString());
        conta.setSaldo(Float.parseFloat(etVInicial.getText().toString()));
        float saldo = conta.getSaldo();
        tvValor.setText(String.valueOf(saldo));

    }
    public void sacarValor(){
        float res = conta.sacar(Float.parseFloat(etValor.getText().toString()));
        if(res == 0){
            tvValor.setText("Não foi possível concluir a operação");
        }else {
            tvValor.setText(String.valueOf(conta.getSaldo()));
        }
    }
    public void depositarValor(){
        float res = conta.depositar(Float.parseFloat(etValor.getText().toString()));
        tvValor.setText(String.valueOf(res));
    }
}