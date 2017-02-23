package br.com.agostinho.sicredimobile.conta;

import br.com.agostinho.sicredimobile.cliente.Cliente;
import br.com.agostinho.sicredimobile.util.BaseEntity;

public class Conta extends BaseEntity<Integer>{

    private static int proxId = 1;

    private String conta;
    private String senha;
    private double saldo;
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

    public Conta(String conta, double saldo, Cliente titular) {
        this.conta = conta;
        this.saldo = saldo;
        this.titular = titular;
    }

    public Conta() {
        super.setId(this.proxId++);
    }
}
