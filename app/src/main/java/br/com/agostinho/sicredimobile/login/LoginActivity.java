package br.com.agostinho.sicredimobile.login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.conta.ContaFormularioActivity;
import br.com.agostinho.sicredimobile.conta.EsqueceuSenhaActivity;
import br.com.agostinho.sicredimobile.main.PrincipalActivity;
import br.com.agostinho.sicredimobile.usuario.Cliente;
import br.com.agostinho.sicredimobile.util.BaseActivity;

public class LoginActivity extends BaseActivity {

    private EditText campoLogin;
    private EditText campoSenha;
    private Button botaoLogin;
    private Cliente cliente = new Cliente();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btn_login_login).setOnClickListener(getHandleLogin());
        findViewById(R.id.lbl_login_novo_usuario).setOnClickListener(getHandleNovoUsuario());
        findViewById(R.id.lbl_login_esqueci_minha_senha).setOnClickListener(getHandleEsqueciSenha());
    }



    private Context getContext() {
        return this;
    }

    private void alert(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    /* Handles */
    View.OnClickListener getHandleLogin(){
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), PrincipalActivity.class);
                startActivity(intent);
            }
        };
    }

    public View.OnClickListener getHandleNovoUsuario() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ContaFormularioActivity.class);
                startActivity(intent);
            }
        };
    }


    public View.OnClickListener getHandleEsqueciSenha() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), EsqueceuSenhaActivity.class);
                startActivity(intent);
            }
        };
    }
}
