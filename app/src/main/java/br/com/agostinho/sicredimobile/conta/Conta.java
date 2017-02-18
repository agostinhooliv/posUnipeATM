package br.com.agostinho.sicredimobile.conta;

import br.com.agostinho.sicredimobile.transacao.TipoTransacao;
import br.com.agostinho.sicredimobile.usuario.Cliente;

public class Conta {

    private double saldo;
    private int numeroConta;
    //Composição
    private Cliente titular;
    private TipoTransacao tipoTransacao;

    private static int contador = 1000;

    public Conta(double saldo, Cliente titular) {
        this.numeroConta = Conta.contador++;
        this.saldo = saldo;
        this.titular = titular;
    }

    public Conta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Conta() {
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the numeroConta
     */
    public int getNumeroConta() {
        return numeroConta;
    }

    /**
     * @param numeroConta the numeroConta to set
     */
    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    /**
     * @return the titular
     */
    public Cliente getTitular() {
        return titular;
    }

    /**
     * @param titular the titular to set
     */
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    public void setTipoTransacao(TipoTransacao tipoTransacao) {
        this.tipoTransacao = tipoTransacao;
    }
}
