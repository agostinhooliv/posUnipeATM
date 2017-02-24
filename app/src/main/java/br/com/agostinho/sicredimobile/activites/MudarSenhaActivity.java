package br.com.agostinho.sicredimobile.activites;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.conta.ContaService;
import br.com.agostinho.sicredimobile.login.LoginService;
import br.com.agostinho.sicredimobile.util.BaseActivity;
import br.com.agostinho.sicredimobile.util.BaseApplication;

public class MudarSenhaActivity extends BaseActivity {

    private EditText senha1;
    private EditText senha2;
    private ContaService contaService = BaseApplication.getInstance().getContaService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mudar_senha);

        setUpToolbar();
        setTitleToolbar("Mudar Senha");
        setDisplayHomeAsUpEnabled(true);

        senha1 = (EditText) findViewById(R.id.valorSenha1d);
        senha2 = (EditText) findViewById(R.id.valorSenha2d);

        findViewById(R.id.botaoMudarId).setOnClickListener(getHandleMudarSenha());
    }

    public View.OnClickListener getHandleMudarSenha() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conta conta = (Conta) getIntent().getExtras().getSerializable("conta");
                if(senha1.getText().toString().equals(senha2.getText().toString())){
                    contaService.modificaSenha(conta.getConta(), senha1.getText().toString());
                    alert("Senha modificada!");

                    Intent intent = new Intent(getContext(), LoginActivity.class);
                    startActivity(intent);

                } else {
                    alert("Senhas diferentes!");
                }

            }
        };
    }



    private void alert(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    private Context getContext(){
        return this;
    }
}
