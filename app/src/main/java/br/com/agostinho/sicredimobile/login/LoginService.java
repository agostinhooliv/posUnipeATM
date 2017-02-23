package br.com.agostinho.sicredimobile.login;

import android.util.Log;

import br.com.agostinho.sicredimobile.cliente.ClienteService;
import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.conta.ContaService;
import br.com.agostinho.sicredimobile.util.BaseApplication;

/**
 * Created by agostinhooliv on 20/02/17.
 */

public class LoginService {

    private ContaService contaService = BaseApplication.getInstance().getContaService();
    private Conta contaLogada = null;

    /**
     * Metodo responsavel por autenticar uma conta de usuario.
     * Caso ela exista, o serviço de login guarda a referencia da mesma.
     *
     * @param login
     * @param senha
     * @return
     */
    public Conta autenticar(String login, String senha) {
        Conta conta = null;

        if(login != null && senha != null) {
            conta = contaService.findConta(login, senha);
            contaLogada = conta;
        }

        return conta;
    }

    /** Retorna a conta logada
     *
     * @return
     */
    public Conta getContaLogada() {
        return contaLogada;
    }

    /**
     * Verifica se o usuario já esta logado
     * @return
     */
    public boolean isAutenticado() {
        if (contaLogada != null) {
            return true;
        }

        return false;
    }

}
