package br.com.agostinho.sicredimobile.conta;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.main.PrincipalActivity;
import br.com.agostinho.sicredimobile.usuario.Cliente;

public class LoginActivity extends AppCompatActivity {

    private EditText campoLogin;
    private EditText campoSenha;
    private Button botaoLogin;
    private Cliente cliente = new Cliente();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btn_login_login).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PrincipalActivity.class);
                startActivity(intent);
            }
        });
    }


    Context getContext() {
        return this;
    }

    private void alert(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
