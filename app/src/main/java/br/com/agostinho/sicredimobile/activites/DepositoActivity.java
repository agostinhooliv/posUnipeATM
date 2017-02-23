package br.com.agostinho.sicredimobile.activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.util.BaseActivity;

public class DepositoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposito);

        setUpToolbar();
        setTitleToolbar("Deposito");
        setDisplayHomeAsUpEnabled(true);

    }
}
