package br.com.agostinho.sicredimobile.transacao;

import java.util.Date;

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
    private Date dataTransacao;

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

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date dataTransacao) {
        this.dataTransacao = dataTransacao;
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

    public Transacao(double valor, TipoTransacao tipoTransacao, Conta conta, Date dataTransacao) {
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.conta = conta;
        this.dataTransacao = dataTransacao;
    }
}
