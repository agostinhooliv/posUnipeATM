package br.com.agostinho.sicredimobile.usuario;

import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.conta.ContaDAO;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class UsuarioService {

    ContaDAO contaDAO = new ContaDAO();

    public void addConta(Conta conta){
        contaDAO.cadastrar(conta);
    }

    public void removeCliente(Conta conta){
        contaDAO.deletar(conta);
    }

    public void updateCliente(Conta conta){
        contaDAO.atualizar(conta);
    }
}
