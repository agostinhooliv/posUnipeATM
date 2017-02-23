package br.com.agostinho.sicredimobile.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.activites.NovaContaActivity;
import br.com.agostinho.sicredimobile.activites.EsqueceuSenhaActivity;
import br.com.agostinho.sicredimobile.login.LoginService;
import br.com.agostinho.sicredimobile.main.PrincipalActivity;
import br.com.agostinho.sicredimobile.cliente.Cliente;
import br.com.agostinho.sicredimobile.util.BaseActivity;
import br.com.agostinho.sicredimobile.util.BaseApplication;

public class LoginActivity extends BaseActivity {

    private ViewHolder viewHolder;
    private Button botaoLogin;
    private Cliente cliente = new Cliente();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edtLogin = (EditText) findViewById(R.id.edt_login_usuario);
        EditText edtPassword = (EditText) findViewById(R.id.edt_login_password);

        this.viewHolder = new ViewHolder(edtLogin, edtPassword);

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
                LoginService loginService = BaseApplication.getLoginService();

                String login = viewHolder.campoLogin.getText().toString();
                String password = viewHolder.campoSenha.getText().toString();

                if(!login.isEmpty() && !password.isEmpty()){

                }

                Intent intent = new Intent(getContext(), PrincipalActivity.class);
                startActivity(intent);
            }
        };
    }

    public View.OnClickListener getHandleNovoUsuario() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NovaContaActivity.class);
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

    static class ViewHolder{
        public EditText campoLogin;
        public EditText campoSenha;

        public ViewHolder(EditText campoLogin, EditText campoSenha) {
            this.campoLogin = campoLogin;
            this.campoSenha = campoSenha;
        }
    }
}
