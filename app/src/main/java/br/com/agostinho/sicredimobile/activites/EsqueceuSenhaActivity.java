package br.com.agostinho.sicredimobile.activites;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.conta.ContaService;
import br.com.agostinho.sicredimobile.util.BaseActivity;
import br.com.agostinho.sicredimobile.util.BaseApplication;

public class EsqueceuSenhaActivity extends BaseActivity {

    private EditText conta;
    private EditText cpf;
    private EditText dataNascimento;
    private ContaService contaService = BaseApplication.getInstance().getContaService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueceu_senha);

        setUpToolbar();
        setTitleToolbar("Esqueci Minha Senha");
        setDisplayHomeAsUpEnabled(true);

        conta = (EditText) findViewById(R.id.valorContaId);
        cpf = (EditText) findViewById(R.id.valorCPFId);
        dataNascimento = (EditText) findViewById(R.id.valorDataNascimentoId);

        findViewById(R.id.botaoVerificarId).setOnClickListener(getHandleVerificar());

    }

    public View.OnClickListener getHandleVerificar() {

        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Conta busca = contaService.findConta(conta.getText().toString(), cpf.getText().toString(), dataNascimento.getText().toString());
                if (busca !=null){
                    Intent intent = new Intent(getContext(), MudarSenhaActivity.class);
                    intent.putExtra("conta", busca);
                    startActivity(intent);
                }else{
                    alert("Conta inválida!");
                }

            }
        };
    }

    private Context getContext() {
        return this;
    }

    private void alert(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}
