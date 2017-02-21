package br.com.agostinho.sicredimobile.conta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.util.BaseActivity;

public class ContaFormularioActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_conta);
        setUpToolbar();
        setTitleToolbar("Cadastre-se");
        setDisplayHomeAsUpEnabled(true);
    }
}
