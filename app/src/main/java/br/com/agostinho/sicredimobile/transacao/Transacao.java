package br.com.agostinho.sicredimobile.transacao;

import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.util.BaseEntity;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class Transacao extends BaseEntity<Integer> {

    private static int proxId = 1;

    private double valor;
    private TipoTransacao tipoTransacao;
    private Conta conta;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "valor=" + valor +
                ", tipoTransacao=" + tipoTransacao +
                ", conta=" + conta +
                '}';
    }

    public Transacao(double valor, TipoTransacao tipoTransacao, Conta conta) {
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.conta = conta;
    }
}
