package br.com.agostinho.sicredimobile.activites;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.cliente.Cliente;
import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.conta.ContaService;
import br.com.agostinho.sicredimobile.util.BaseActivity;
import br.com.agostinho.sicredimobile.util.BaseApplication;

public class NovaContaActivity extends BaseActivity {

    ViewHolder viewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_conta);

        //configura toolbar
        setUpToolbar();
        setTitleToolbar("Cadastre-se");
        setDisplayHomeAsUpEnabled(true);

        //configura o viewHolder
        viewHolder.campoNome = (EditText) findViewById(R.id.edt_novaconta_nome);
        viewHolder.campoCpf = (EditText) findViewById(R.id.edt_novaconta_cpf);
        viewHolder.campoRg = (EditText) findViewById(R.id.edt_novaconta_rg);
        viewHolder.campoDataNasc = (EditText) findViewById(R.id.edt_novaconta_datanasc);
        viewHolder.campoSenha = (EditText) findViewById(R.id.edt_novaconta_senha);

        //configura o evento
        findViewById(R.id.bnt_novaconta_salvar).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                ContaService contaService = BaseApplication.getInstance().getContaService();

                try {
                    Cliente cliente = new Cliente();
                    cliente.setNome(viewHolder.campoNome.getText().toString());
                    cliente.setRg(viewHolder.campoRg.getText().toString());
                    cliente.setCpf(viewHolder.campoCpf.getText().toString());
                    cliente.setDataNascimento(sdf.parse(viewHolder.campoDataNasc.getText().toString()));

                    Conta conta = new Conta();
                    conta.setTitular(cliente);
                    conta.setSenha(viewHolder.campoSenha.getText().toString());

                    Log.i("NovaActivity", conta.toString());
                    contaService.add(conta);

                    onBackPressed();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    static class ViewHolder {
        public EditText campoNome;
        public EditText campoCpf;
        public EditText campoRg;
        public EditText campoDataNasc;
        public EditText campoSenha;

        public ViewHolder() {
        }
    }
}
