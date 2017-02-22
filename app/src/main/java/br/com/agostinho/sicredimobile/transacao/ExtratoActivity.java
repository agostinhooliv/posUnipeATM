package br.com.agostinho.sicredimobile.transacao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.util.BaseActivity;


public class ExtratoActivity extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrato);

        setUpToolbar();
        setTitleToolbar("Extrato");
        setDisplayHomeAsUpEnabled(true);
    }
}
