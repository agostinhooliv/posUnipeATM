package br.com.agostinho.sicredimobile.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.conta.ContaService;
import br.com.agostinho.sicredimobile.login.LoginService;
import br.com.agostinho.sicredimobile.transacao.TransacaoService;
import br.com.agostinho.sicredimobile.util.BaseActivity;
import br.com.agostinho.sicredimobile.util.BaseApplication;

public class TransferenciaActivity extends BaseActivity {

    private static final String TAG = "TRANSFERENCIA_ACTIVITY";

    TransacaoService transacaoService = BaseApplication.getInstance().getTransacaoService();
    LoginService loginService = BaseApplication.getInstance().getLoginService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferencia);

        setUpToolbar();
        setTitleToolbar("Transferencia");
        setDisplayHomeAsUpEnabled(true);

        ((TextView) findViewById(R.id.lbl_transferencia_usuario)).setText(loginService.getContaLogada().getTitular().getNome());
        ((TextView) findViewById(R.id.lbl_transferencia_conta)).setText(loginService.getContaLogada().getConta());

        findViewById(R.id.btn_transferencia_enviar).setOnClickListener(getHandleBtnEnviar());

    }

    public View.OnClickListener getHandleBtnEnviar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText campoConta = (EditText) findViewById(R.id.edt_transferencia_conta);
                EditText campoValor = (EditText) findViewById(R.id.edt_transferencia_valor);

                String contaOrigem = loginService.getContaLogada().getConta();
                String contaDestino = campoConta.getText().toString();
                Double valor = Double.parseDouble(campoValor.getText().toString());

                Log.i(TAG, "Conta Fonte: " + loginService.getContaLogada().getConta());
                Log.i(TAG, "Titular Conta Fonte: " + loginService.getContaLogada().getTitular().getNome());

                Log.i(TAG, "Conta Destino: " + campoConta.getText().toString());
                Log.i(TAG, "Valor: " + campoValor.getText().toString());

                transacaoService.transferir(contaOrigem, contaDestino, valor);

                ContaService contaService = BaseApplication.getInstance().getContaService();
                Conta destino = contaService.findConta(contaDestino);

                Log.i(TAG, "Conta Fonte: " + loginService.getContaLogada().getConta());
                Log.i(TAG, "Saldo Conta Fonte: " + loginService.getContaLogada().getSaldo());

                Log.i(TAG, "Conta Destino: " + destino.getConta());
                Log.i(TAG, "Saldo Conta Fonte: " + destino.getSaldo());

                onBackPressed();

            }
        };
    }
}
