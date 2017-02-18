package br.com.agostinho.sicredimobile.transacao;

import br.com.agostinho.sicredimobile.conta.Conta;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class Transacao {

    private int identificacao;
    private double valor;
    private TipoTransacao tipoTransacao;
    private Conta conta;

    private static int contador = 1;

    public Transacao(Double valor, TipoTransacao tipoTransacao, Conta conta){
        this.identificacao = Transacao.contador++;
        this.valor = valor;
        this.tipoTransacao = tipoTransacao;
        this.conta = conta;
    }

    public Transacao(){
    }

    public int getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(int identificacao) {
        this.identificacao = identificacao;
    }

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
}
