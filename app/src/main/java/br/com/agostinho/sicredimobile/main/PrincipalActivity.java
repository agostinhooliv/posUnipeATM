package br.com.agostinho.sicredimobile.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import agostinho.com.br.sicredimobile.R;
import br.com.agostinho.sicredimobile.conta.LoginActivity;
import br.com.agostinho.sicredimobile.usuario.Cliente;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Intent intent = new Intent(PrincipalActivity.this, LoginActivity.class);
        Bundle bundle = intent.getExtras();

        Cliente cliente = (Cliente) intent.getSerializableExtra("cliente");
        System.out.println("Nome: "+cliente.getNome());
        TextView contaLabel = (TextView) findViewById(R.id.contaLabel);
        contaLabel.setText(cliente.getNome());
    }
}
