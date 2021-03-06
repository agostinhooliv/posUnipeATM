package br.com.agostinho.sicredimobile.conta;

import java.io.Serializable;
import java.util.Date;

import br.com.agostinho.sicredimobile.cliente.Cliente;
import br.com.agostinho.sicredimobile.util.BaseEntity;

public class Conta extends BaseEntity<Integer> implements Serializable {

    private static int proxId = 100;

    private String conta;
    private String senha;
    private double saldo;
    private double chequeEspecial;
    private double chequeEspecialIOF;
    private double chequeEspecialJuros;
    private Date vencimentoChequeEspecial;
    private Cliente titular;

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecialIOF() {
        return chequeEspecialIOF;
    }

    public void setChequeEspecialIOF(double chequeEspecialIOF) {
        this.chequeEspecialIOF = chequeEspecialIOF;
    }

    public double getChequeEspecialJuros() {
        return chequeEspecialJuros;
    }

    public void setChequeEspecialJuros(double chequeEspecialJuros) {
        this.chequeEspecialJuros = chequeEspecialJuros;
    }

    public Date getVencimentoChequeEspecial() {
        return vencimentoChequeEspecial;
    }

    public void setVencimentoChequeEspecial(Date vencimentoChequeEspecial) {
        this.vencimentoChequeEspecial = vencimentoChequeEspecial;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "conta='" + conta + '\'' +
                ", senha='" + senha + '\'' +
                ", saldo=" + saldo +
                ", titular=" + titular +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Conta conta1 = (Conta) o;

        return conta != null ? conta.equals(conta1.conta) : conta1.conta == null;

    }

    @Override
    public int hashCode() {
        return conta != null ? conta.hashCode() : 0;
    }

    public Conta(double saldo, double chequeEspecial, double chequeEspecialIOF, double chequeEspecialJuros, Date vencimentoChequeEspecial, Cliente titular, String senha) {
        super.setId(this.proxId);
        this.conta = String.valueOf(this.proxId);
        this.saldo = saldo;
        this.chequeEspecial = chequeEspecial;
        this.chequeEspecialIOF = chequeEspecialIOF;
        this.chequeEspecialJuros = chequeEspecialJuros;
        this.vencimentoChequeEspecial = vencimentoChequeEspecial;
        this.titular = titular;
        this.senha = senha;

        //incrementa id para proxima conta
        this.proxId += 1;

    }

    public Conta() {
        super.setId(this.proxId);
        this.conta = String.valueOf(this.proxId);
        this.saldo = 0;
        this.chequeEspecial = 0;
        this.chequeEspecialIOF = 0;
        this.chequeEspecialJuros = 0;
        this.vencimentoChequeEspecial = new Date();

        //incrementa id para proxima conta
        this.proxId += 1;
    }
}
