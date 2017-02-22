package br.com.agostinho.sicredimobile.util;

import android.app.Application;
import android.util.Log;

import br.com.agostinho.sicredimobile.conta.ContaService;
import br.com.agostinho.sicredimobile.login.LoginService;
import br.com.agostinho.sicredimobile.transacao.TransacaoService;
import br.com.agostinho.sicredimobile.usuario.UsuarioService;

/**
 * Created by breno on 21/02/17.
 */

public class BaseApplication extends Application {
    private static final String TAG = "BaseApplication";
    private static BaseApplication instance = null;

    private static ContaService contaService = null;
    private static TransacaoService transacaoService = null;
    private static LoginService loginService = null;
    private static UsuarioService usuarioService = null;

    public static BaseApplication getInstance() {
        if (transacaoService == null) {
            transacaoService = new TransacaoService();
        }

        if (contaService == null) {
            contaService = new ContaService();
        }

        if (loginService == null) {
            loginService = new LoginService();
        }

        if (usuarioService == null) {
            usuarioService = new UsuarioService();
        }

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
        return contaService;
    }

    public static TransacaoService getTransacaoService() {
        return transacaoService;
    }

    public static LoginService getLoginService() {
        return loginService;
    }

    public static UsuarioService getUsuarioService() {
        return usuarioService;
    }
}
