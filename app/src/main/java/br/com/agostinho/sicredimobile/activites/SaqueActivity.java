package br.com.agostinho.sicredimobile.activites;

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

public class SaqueActivity extends BaseActivity {

    TransacaoService transacaoService = BaseApplication.getInstance().getTransacaoService();
    LoginService loginService = BaseApplication.getInstance().getLoginService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saque);

        setUpToolbar();
        setTitleToolbar("Saque");
        setDisplayHomeAsUpEnabled(true);

        //configurando labels
        Conta conta = loginService.getContaLogada();
        ((TextView) findViewById(R.id.lbl_saque_conta)).setText(conta.getConta());
        ((TextView) findViewById(R.id.lbl_saque_usuario)).setText(conta.getTitular().getNome());

        //configura eventos
        findViewById(R.id.btn_saque_enviar).setOnClickListener(getHandleBtnEnviar());

    }

    public View.OnClickListener getHandleBtnEnviar() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText campoValor = (EditText) findViewById(R.id.edt_saque_valor);

                String valor = campoValor.getText().toString();
                double parse = Double.parseDouble(valor);

                Log.i("SaqueActivity","Saldo: "+loginService.getContaLogada().getSaldo());
                transacaoService.sacar(loginService.getContaLogada(), parse);
                Log.i("SaqueActivity","Saldo: "+loginService.getContaLogada().getSaldo());

                onBackPressed();
            }
        };
    }
}
