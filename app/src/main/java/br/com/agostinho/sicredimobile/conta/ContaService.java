package br.com.agostinho.sicredimobile.conta;

import java.util.Date;

import br.com.agostinho.sicredimobile.cliente.Cliente;
import br.com.agostinho.sicredimobile.cliente.ClienteDAO;
import br.com.agostinho.sicredimobile.util.AbstractService;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class ContaService extends AbstractService<ContaDAO, Conta, Integer> {

    public ContaService(ContaDAO dao) {
        super(dao);
    }

    public Conta findConta(String conta, String senha) {
        ContaDAO contaDAO = super.getDao();
        Conta busca = contaDAO.findOne(conta, senha);
        return busca;
    }

    public Conta findConta(String conta, String cpf, String dataNascimento) {
        ContaDAO contaDAO = super.getDao();
        Conta busca = contaDAO.findOne(conta, cpf, dataNascimento);
        return busca;
    }

    public Conta findConta(String conta) {
        ContaDAO contaDAO = super.getDao();
        Conta busca = contaDAO.findOne(conta);
        return busca;
    }

    public void modificaSenha(String conta, String novaSenha){
        ContaDAO contaDAO = super.getDao();
        contaDAO.modificaSenha(conta, novaSenha);
    }
}
