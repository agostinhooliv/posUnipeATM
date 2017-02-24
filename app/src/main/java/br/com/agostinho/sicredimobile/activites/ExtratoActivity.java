package br.com.agostinho.sicredimobile.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.transacao.Transacao;
import br.com.agostinho.sicredimobile.transacao.TransacaoDAO;
import br.com.agostinho.sicredimobile.transacao.TransacaoService;
import br.com.agostinho.sicredimobile.util.BaseActivity;
import br.com.agostinho.sicredimobile.util.BaseApplication;


public class ExtratoActivity extends BaseActivity {

    private TextView numeroContaCorrente;
    private TransacaoService transacaoService = BaseApplication.getInstance().getTransacaoService();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private DecimalFormat decimalFormat = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrato);

        setUpToolbar();
        setTitleToolbar("Extrato");
        setDisplayHomeAsUpEnabled(true);

        //configura labels
        Conta conta = BaseApplication.getInstance().getLoginService().getContaLogada();
        numeroContaCorrente = (TextView) findViewById(R.id.valorNumeroContaCorrenteId);
        numeroContaCorrente.setText(conta.getConta());

        //recupera o extrato
        List<Transacao> transacoes = transacaoService.consultarExtrato(conta);
        List<String> listaTransacoes = new ArrayList<String>();

        for(Transacao transacao : transacoes){
            listaTransacoes.add(transacao.getTipoTransacao() + " - " +decimalFormat.format(transacao.getValor()) +" - "+simpleDateFormat.format(transacao.getDataTransacao()));
        }

        //preenche o listview
        ListView listView = (ListView) findViewById(R.id.listaExtratoId);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1 ,listaTransacoes);

        listView.setAdapter(adapter);
    }

    private Context getContext() {
        return this;
    }
}
