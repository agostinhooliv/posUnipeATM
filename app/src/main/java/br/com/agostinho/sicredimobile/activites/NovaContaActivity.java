package br.com.agostinho.sicredimobile.activites;

import android.os.Bundle;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.util.BaseActivity;

public class NovaContaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_conta);
        setUpToolbar();
        setTitleToolbar("Cadastre-se");
        setDisplayHomeAsUpEnabled(true);
    }
}
