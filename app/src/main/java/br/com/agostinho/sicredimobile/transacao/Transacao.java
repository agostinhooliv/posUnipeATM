package br.com.agostinho.sicredimobile.transacao;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class Transacao {

    private int identificacao;
    private double valor;
    private TipoTransacao tipoTransacao;

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
}
