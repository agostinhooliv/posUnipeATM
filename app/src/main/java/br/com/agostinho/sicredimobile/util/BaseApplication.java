package br.com.agostinho.sicredimobile.util;

import android.app.Application;
import android.util.Log;

import java.util.Calendar;

import br.com.agostinho.sicredimobile.cliente.Cliente;
import br.com.agostinho.sicredimobile.cliente.ClienteDAO;
import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.conta.ContaDAO;
import br.com.agostinho.sicredimobile.conta.ContaService;
import br.com.agostinho.sicredimobile.login.LoginService;
import br.com.agostinho.sicredimobile.transacao.Transacao;
import br.com.agostinho.sicredimobile.transacao.TransacaoDAO;
import br.com.agostinho.sicredimobile.transacao.TransacaoService;
import br.com.agostinho.sicredimobile.cliente.ClienteService;

/**
 * Created by breno on 21/02/17.
 */

public class BaseApplication extends Application {
    private static final String TAG = "BaseApplication";
    private static BaseApplication instance = null;

    private static ContaService contaService = null;
    private static TransacaoService transacaoService = null;
    private static LoginService loginService = null;
    private static ClienteService clienteService = null;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        preencheContasDefault();

        Log.d(TAG, "BaseApplication.onCreate()");
    }

    public void preencheContasDefault(){
        ContaService contaService = getInstance().getContaService();

        //Conta 100
        Calendar calendar = Calendar.getInstance();

        calendar.set(1987, 12, 25);
        Cliente cliente = new Cliente("Allan Jefferson", "12345", "12345", calendar.getTime());

        calendar.set(2020, 12, 31);
        Conta conta = new Conta(0.00, 1000.00, 23.99, 33.88, calendar.getTime(), cliente, "asdf");
        contaService.add(conta);

        //Conta 101
        cliente = new Cliente("Ricardo Sá", "23456", "23456", calendar.getTime());
        conta = new Conta(0.00, 1000.00, 23.99, 33.88, calendar.getTime(), cliente, "qwert");
        contaService.add(conta);

        //Conta 102
        calendar.set(1960, 01, 01);
        cliente = new Cliente("João da Silva", "54321", "54321", calendar.getTime());
        contaService.add(conta);

        calendar.set(2030, 9, 01);
        conta = new Conta(0.00, 1000.00, 0.00, 1.88, calendar.getTime(), cliente, "qwer");
        contaService.add(conta);

        //adiciona transacoes conta 100, 101 e 102
        TransacaoService transacaoService = getInstance().getTransacaoService();
        transacaoService.sacar(contaService.findConta("100"), 100.00);
        transacaoService.sacar(contaService.findConta("100"), 500.00);
        transacaoService.depositar(contaService.findConta("100"), 5000.00);
        transacaoService.sacar(contaService.findConta("100"), 100.00);

        transacaoService.sacar(contaService.findConta("101"), 30.00);
        transacaoService.sacar(contaService.findConta("101"), 200.00);
        transacaoService.depositar(contaService.findConta("101"), 500.00);
        transacaoService.sacar(contaService.findConta("101"), 100.00);

        transacaoService.sacar(contaService.findConta("102"), 30.00);
        transacaoService.sacar(contaService.findConta("102"), 200.00);
        transacaoService.depositar(contaService.findConta("102"), 500.00);
        transacaoService.sacar(contaService.findConta("102"), 100.00);


    }


    @Override
    public void onTerminate() {
        super.onTerminate();

        Log.d(TAG, "BaseApplication.onTerminate()");
    }

    public static ContaService getContaService() {
        if (contaService == null) {
            contaService = new ContaService(new ContaDAO());
        }

        return contaService;
    }

    public static TransacaoService getTransacaoService() {
        if (transacaoService == null) {
            transacaoService = new TransacaoService(new TransacaoDAO());
        }

        return transacaoService;
    }

    public static LoginService getLoginService() {

        if (loginService == null) {
            loginService = new LoginService();
        }

        return loginService;
    }

    public static ClienteService getClienteService() {

        if(clienteService == null){
            clienteService = new ClienteService(new ClienteDAO());
        }

        return clienteService;
    }
}
