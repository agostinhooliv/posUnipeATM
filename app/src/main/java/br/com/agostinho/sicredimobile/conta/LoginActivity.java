package br.com.agostinho.sicredimobile.conta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.agostinho.sicredimobile.main.PrincipalActivity;
import agostinho.com.br.sicredimobile.R;
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

        campoLogin = (EditText) findViewById(R.id.campoLoginId);
        campoSenha = (EditText) findViewById(R.id.campoSenhaId);
        botaoLogin = (Button) findViewById(R.id.botaoLoginId);

        //Ação Botão Login
        botaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cliente.setLogin(campoLogin.getText().toString());
                cliente.setSenha(campoSenha.getText().toString());

                if(!cliente.getLogin().equals("agostinhooliv") || !cliente.getSenha().equals("1234")){
                    alert("Login ou Senha inválidos!");
                    System.out.println("Login: "+cliente.getLogin().equals("agostinhooliv") +"\tSenha: "+cliente.getSenha().equals("1234"));
                } else {
                    startActivity(new Intent(LoginActivity.this, PrincipalActivity.class));
                }
            }
        });
    }

    private void alert(String mensagem){
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
