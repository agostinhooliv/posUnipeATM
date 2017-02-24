package br.com.agostinho.sicredimobile.activites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.login.LoginService;
import br.com.agostinho.sicredimobile.transacao.TransacaoService;
import br.com.agostinho.sicredimobile.util.BaseActivity;
import br.com.agostinho.sicredimobile.util.BaseApplication;

public class DepositoActivity extends BaseActivity {

    private ViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposito);

        // Configura o Toolbar
        setUpToolbar();
        setTitleToolbar("Deposito");
        setDisplayHomeAsUpEnabled(true);

        // Configura o viewHolder e seus eventos
        TextView lblNomeDepositante = (TextView) findViewById(R.id.lbl_deposito_nome_depositante);
        EditText edtConta = (EditText) findViewById(R.id.edt_deposito_conta);
        EditText edtValor = (EditText) findViewById(R.id.edt_deposito_valor);

        lblNomeDepositante.setText(BaseApplication.getInstance()
                .getLoginService()
                .getContaLogada()
                .getTitular()
                .getNome());

        this.viewHolder = new ViewHolder(lblNomeDepositante, edtConta, edtValor);

        findViewById(R.id.btn_deposito_enviar).setOnClickListener(getHandleBtnEnviar());

    }

    public View.OnClickListener getHandleBtnEnviar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginService loginService = BaseApplication.getInstance().getLoginService();
                TransacaoService transacaoService = BaseApplication.getInstance().getTransacaoService();

                Conta contaLogada = loginService.getContaLogada();

                // Dados deposito
                String conta = viewHolder.campoConta.getText().toString();
                String valor = viewHolder.campoValor.getText().toString();
                Double parseValor = Double.parseDouble(valor);

                Log.i("DepositoActivity","Saldo: "+ contaLogada.getSaldo());
                transacaoService.depositar(conta, parseValor);
                Log.i("DepositoActivity","Saldo: "+ contaLogada.getSaldo());

                Intent intent = new Intent(DepositoActivity.this, FeedbackActivity.class);
                intent.putExtra("OPERACAO","DEPOSITO");
                intent.putExtra("VALOR", valor);
                intent.putExtra("CONTA", conta);

                startActivity(intent);

            }
        };
    }

    static class ViewHolder {
        public TextView labelNomeDepositante;
        public EditText campoConta;
        public EditText campoValor;

        public ViewHolder(TextView labelNomeDepositante, EditText campoConta, EditText campoValor) {
            this.labelNomeDepositante = labelNomeDepositante;
            this.campoConta = campoConta;
            this.campoValor = campoValor;
        }
    }
}
