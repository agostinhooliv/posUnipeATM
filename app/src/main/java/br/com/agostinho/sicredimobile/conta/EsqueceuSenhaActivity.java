package br.com.agostinho.sicredimobile.conta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.util.BaseActivity;

public class EsqueceuSenhaActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_esqueceu_senha);

        setUpToolbar();
        setTitleToolbar("Esqueci Minha Senha");
        setDisplayHomeAsUpEnabled(true);
    }
}
