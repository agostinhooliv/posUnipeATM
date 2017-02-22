package br.com.agostinho.sicredimobile.transacao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.util.BaseActivity;

public class SaqueActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saque);

        setUpToolbar();
        setTitleToolbar("Saque");
        setDisplayHomeAsUpEnabled(true);
    }
}
