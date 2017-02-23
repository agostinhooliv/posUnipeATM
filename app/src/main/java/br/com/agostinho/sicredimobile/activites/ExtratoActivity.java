package br.com.agostinho.sicredimobile.activites;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.util.BaseActivity;


public class ExtratoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrato);

        setUpToolbar();
        setTitleToolbar("Extrato");
        setDisplayHomeAsUpEnabled(true);

        ListView extrato = (ListView) findViewById(R.id.listaExtratoId);

        ArrayList<String> listaExtratos = new ArrayList<String>();
        listaExtratos.add("extrato1");
        listaExtratos.add("extrato2");
        listaExtratos.add("extrato3");
        listaExtratos.add("extrato4");
        listaExtratos.add("extrato4");
        listaExtratos.add("extrato4");
        listaExtratos.add("extrato4");
        listaExtratos.add("extrato2");
        listaExtratos.add("extrato3");
        listaExtratos.add("extrato4");
        listaExtratos.add("extrato4");
        listaExtratos.add("extrato4");
        listaExtratos.add("extrato4");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1 ,listaExtratos);

        extrato.setAdapter(adapter);
    }

    private Context getContext() {
        return this;
    }
}
