package br.com.agostinho.sicredimobile.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.conta.ContaDAO;
import br.com.agostinho.sicredimobile.login.LoginService;
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

        EditText edtLogin = (EditText) findViewById(R.id.edt_login_conta);
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
    View.OnClickListener getHandleLogin() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LoginService loginService = BaseApplication.getInstance().getLoginService();

                String login = viewHolder.campoLogin.getText().toString();
                String password = viewHolder.campoSenha.getText().toString();

                Log.i("LoginActivity", login);
                Log.i("LoginActivity", password);

                if (!login.isEmpty() && !password.isEmpty()) {
                    Conta conta = loginService.autenticar(login, password);

                    if (conta != null) {
                        Intent intent = new Intent(getContext(), PrincipalActivity.class);
                        intent.putExtra("conta", conta);
                        startActivity(intent);
                    } else {
                        Toast toast = Toast.makeText(LoginActivity.this, "Usuario ou Senha Invalido!", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }

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

    static class ViewHolder {
        public EditText campoLogin;
        public EditText campoSenha;

        public ViewHolder(EditText campoLogin, EditText campoSenha) {
            this.campoLogin = campoLogin;
            this.campoSenha = campoSenha;
        }
    }
}
