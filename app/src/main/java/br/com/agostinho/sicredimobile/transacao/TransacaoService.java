package br.com.agostinho.sicredimobile.transacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.conta.ContaService;
import br.com.agostinho.sicredimobile.util.AbstractService;
import br.com.agostinho.sicredimobile.util.BaseApplication;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class TransacaoService extends AbstractService<TransacaoDAO, Transacao, Integer> {

    private List<Transacao> listaTransacoes = new ArrayList<Transacao>();

    public TransacaoService(TransacaoDAO dao) {
        super(dao);
    }

    public TransacaoService() {
    }

    public List<Transacao> consultarExtrato(Conta conta) {
        listaTransacoes.clear();
        for (Transacao transacao : super.findAll()) {
            if (transacao.getConta().getConta().equals(conta.getConta()))
                listaTransacoes.add(transacao);
        }
        return listaTransacoes;
    }

    public Double consultarSaldo(Conta conta) {
        return conta.getSaldo();
    }

    public void depositar(Conta conta, Double valor) {
        conta.setSaldo(conta.getSaldo() + valor);

        Transacao transacao = new Transacao(valor, TipoTransacao.DEPOSITO, conta, new Date());
        super.add(transacao);
    }

    public void depositar(String conta, double valor) {
        ContaService contaService = BaseApplication.getInstance().getContaService();
        Conta busca = contaService.findConta(conta);

        this.depositar(busca, valor);
    }

    public void sacar(Conta conta, Double valor) {
        conta.setSaldo(conta.getSaldo() - valor);

        Transacao transacao = new Transacao(valor, TipoTransacao.SAQUE, conta, new Date());
        super.add(transacao);
    }

    public void sacar(String conta, Double valor){
        ContaService contaService = BaseApplication.getInstance().getContaService();
        Conta busca = contaService.findConta(conta);

        this.sacar(busca, valor);
    }

    public void transferir(Conta contaOrigem, Conta contaDestino, Double valor){
        contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
        contaDestino.setSaldo(contaDestino.getSaldo() + valor);

        Transacao transacao = new Transacao(valor, TipoTransacao.TRANSFERENCIA, contaOrigem, new Date());
        super.add(transacao);
    }

    public void carregaTransacoesDefault(Conta conta){

        Conta conta = new Conta("100");

        this.sacar(conta, 100.00);
        this.sacar(conta, 500.00);
        this.depositar(conta, 5000.00);
        this.sacar(conta, 100.00);

        Conta conta2 = new Conta("101");
        this.sacar(conta2, 30.00);
        this.sacar(conta2, 200.00);
        this.depositar(conta2, 500.00);
        this.sacar(conta2, 100.00);
    }
}
