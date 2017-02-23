package br.com.agostinho.sicredimobile.util;

import android.app.Application;
import android.util.Log;

import br.com.agostinho.sicredimobile.cliente.ClienteDAO;
import br.com.agostinho.sicredimobile.conta.ContaDAO;
import br.com.agostinho.sicredimobile.conta.ContaService;
import br.com.agostinho.sicredimobile.login.LoginService;
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

        Log.d(TAG, "BaseApplication.onCreate()");
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
