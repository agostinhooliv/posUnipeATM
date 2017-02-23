package br.com.agostinho.sicredimobile.activites;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.util.BaseActivity;


public class SaldoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldo);

        setUpToolbar();
        setTitleToolbar("Saldo");
        setDisplayHomeAsUpEnabled(true);

    }
}
