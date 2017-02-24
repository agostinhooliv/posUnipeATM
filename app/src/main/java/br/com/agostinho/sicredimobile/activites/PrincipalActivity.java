package br.com.agostinho.sicredimobile.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.util.BaseActivity;


public class PrincipalActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //setUpToolbar();
        //setTitleToolbar("Sicredi Mobile");

        // Configura os eventos
        findViewById(R.id.layout_main_saldo).setOnClickListener(getHandleSaldo());
        findViewById(R.id.layout_main_deposito).setOnClickListener(getHandleDeposito());
        findViewById(R.id.layout_main_extrato).setOnClickListener(getHandleExtrato());
        findViewById(R.id.layout_main_saque).setOnClickListener(getHandleSaque());
        findViewById(R.id.layout_main_transferencia).setOnClickListener(getHandleTransferencia());
    }

    private View.OnClickListener getHandleSaldo() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), SaldoActivity.class));
            }
        };
    }


    private View.OnClickListener getHandleDeposito() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, DepositoActivity.class));
            }
        };
    }


    public View.OnClickListener getHandleExtrato() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), ExtratoActivity.class));
            }
        };
    }


    public View.OnClickListener getHandleSaque() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, SaqueActivity.class));
            }
        };
    }


    public View.OnClickListener getHandleTransferencia() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrincipalActivity.this, TransferenciaActivity.class));
            }
        };
    }

    private Context getContext() {
        return this;
    }
}
