package br.com.agostinho.sicredimobile.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.transacao.DepositoActivity;
import br.com.agostinho.sicredimobile.transacao.ExtratoActivity;
import br.com.agostinho.sicredimobile.transacao.SaldoActivity;
import br.com.agostinho.sicredimobile.transacao.SaqueActivity;
import br.com.agostinho.sicredimobile.util.BaseActivity;


public class PrincipalActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        setUpToolbar();
        setTitleToolbar("Sicredi Mobile");

        // Configura os eventos
        findViewById(R.id.layout_main_saldo).setOnClickListener(getHandleMainSaldo());
        findViewById(R.id.layout_main_deposito).setOnClickListener(getHandleMainDeposito());
        findViewById(R.id.layout_main_extrato).setOnClickListener(getHandleMainExtrato());
        findViewById(R.id.layout_main_saque).setOnClickListener(getHandleMainSaque());
        findViewById(R.id.layout_main_transferencia).setOnClickListener(getHandleMainTransferencia());
    }

    private View.OnClickListener getHandleMainSaldo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, SaldoActivity.class));
            }
        };
    }


    private View.OnClickListener getHandleMainDeposito() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, DepositoActivity.class));
            }
        };
    }


    public View.OnClickListener getHandleMainExtrato() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, ExtratoActivity.class));
            }
        };
    }


    public View.OnClickListener getHandleMainSaque() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, SaqueActivity.class));
            }
        };
    }


    public View.OnClickListener getHandleMainTransferencia() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        };
    }
}
