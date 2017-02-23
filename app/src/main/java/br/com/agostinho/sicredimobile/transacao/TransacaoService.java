package br.com.agostinho.sicredimobile.transacao;

import java.util.ArrayList;
import java.util.List;

import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.conta.ContaService;
import br.com.agostinho.sicredimobile.util.AbstractService;
import br.com.agostinho.sicredimobile.util.BaseApplication;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class TransacaoService extends AbstractService<TransacaoDAO, Transacao, Integer>{

    public TransacaoService(TransacaoDAO dao) {
        super(dao);
    }

    public List<Transacao> consultarExtrato(Conta conta){

        return null;
    }

    public Double consultarSaldo(Conta conta){
        return conta.getSaldo();
    }

    public void depositar(Conta conta, Double valor){
        conta.setSaldo(conta.getSaldo() + valor);

        Transacao transacao = new Transacao(valor, TipoTransacao.DEPOSITO, conta);
        super.add(transacao);
    }

    public void depositar(String conta, double valor){
        ContaService contaService = BaseApplication.getInstance().getContaService();
        Conta busca = contaService.findConta(conta);

        this.depositar(busca, valor);
    }

    public void sacar(Conta conta, Double valor){
        conta.setSaldo(conta.getSaldo() - valor);

        Transacao transacao = new Transacao(valor, TipoTransacao.SAQUE, conta);
        super.add(transacao);
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, Double valor){
        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);

        Transacao transacao = new Transacao(valor, TipoTransacao.TRANSFERENCIA, contaOrigem);
        super.add(transacao);
    }
}
