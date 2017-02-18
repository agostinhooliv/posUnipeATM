package br.com.agostinho.sicredimobile.transacao;

import java.util.ArrayList;
import java.util.List;

import br.com.agostinho.sicredimobile.conta.Conta;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class TransacaoService {

    private List<Transacao> listaTransacoes = new ArrayList<Transacao>();
    Transacao transacao;

    public List<Transacao> consultarExtrato(Conta conta){
        return listaTransacoes;
    }

    public Double consultarSaldo(Conta conta){
        return conta.getSaldo();
    }

    public void depositar(Conta conta, Double valor){
        conta.setSaldo(conta.getSaldo() + valor);
        transacao = new Transacao(valor, TipoTransacao.DEPOSITO, conta);
        listaTransacoes.add(transacao);
    }

    public void sacar(Conta conta, Double valor){
        conta.setSaldo(conta.getSaldo() - valor);
        transacao = new Transacao(valor, TipoTransacao.SAQUE, conta);
        listaTransacoes.add(transacao);
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, Double valor){
        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);

        transacao = new Transacao(valor, TipoTransacao.TRANSFERENCIA, contaOrigem);
        listaTransacoes.add(transacao);
    }
}
