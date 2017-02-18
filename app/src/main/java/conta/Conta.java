package conta;

import cliente.Cliente;

public class Conta {

    private double saldo;
    private int numeroConta;
    //Composição
    private Cliente titular;

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
}
