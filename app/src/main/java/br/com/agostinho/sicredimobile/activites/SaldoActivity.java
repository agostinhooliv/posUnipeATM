package br.com.agostinho.sicredimobile.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;

import br.com.agostinho.sicredimobile.R;
import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.login.LoginService;
import br.com.agostinho.sicredimobile.util.BaseActivity;


public class SaldoActivity extends BaseActivity {

    private TextView numeroContaCorrente;
    private TextView saldoConta;
    private TextView chequeEspecial;
    private TextView disponivelSaque;
    private TextView iof;
    private TextView juros;
    private TextView vencimentoChequeEspecial;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private DecimalFormat decimalFormat = new DecimalFormat("##,###,###,##0.00", new DecimalFormatSymbols(new Locale("pt", "BR")));
    private LoginService loginService = new LoginService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldo);

        setUpToolbar();
        setTitleToolbar("Saldo");
        setDisplayHomeAsUpEnabled(true);

        decimalFormat.setMinimumFractionDigits(2);
        decimalFormat.setParseBigDecimal (true);

        Intent intent = getIntent();
        Conta conta = (Conta) intent.getExtras().getSerializable("conta");
//        Conta conta = loginService.getContaLogada();

        numeroContaCorrente = (TextView) findViewById(R.id.valorNumeroContaCorrenteId);
        numeroContaCorrente.setText(conta.getConta());

        saldoConta = (TextView) findViewById(R.id.valorSaldoId);
        saldoConta.setText(String.valueOf(decimalFormat.format(conta.getSaldo())));

        chequeEspecial = (TextView) findViewById(R.id.valorChequeEspecialId);
        chequeEspecial.setText(String.valueOf(decimalFormat.format(conta.getChequeEspecial())));

        disponivelSaque = (TextView) findViewById(R.id.valorDisponivelId);
        disponivelSaque.setText(String.valueOf(decimalFormat.format(conta.getSaldo() + conta.getChequeEspecial())));

        iof = (TextView) findViewById(R.id.valorIOFId);
        iof.setText(String.valueOf(decimalFormat.format(conta.getChequeEspecialIOF())));

        juros = (TextView) findViewById(R.id.valorJurosId);
        juros.setText(String.valueOf(decimalFormat.format(conta.getChequeEspecialJuros())));

        vencimentoChequeEspecial = (TextView) findViewById(R.id.valorVencimentoId);
        vencimentoChequeEspecial.setText(String.valueOf(simpleDateFormat.format(conta.getVencimentoChequeEspecial())));

    }

    private Context getContext(){
        return this;
    }
}
