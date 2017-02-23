package br.com.agostinho.sicredimobile.cliente;

import br.com.agostinho.sicredimobile.util.BaseEntity;

/**
 * @author agostinhooliv
 */
public class Cliente extends BaseEntity<Integer> {

    private static int proxId = 1;

    private String nome;
    private String cpf;
    private String rg;
    private String dataNascimento;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rg='" + rg + '\'' +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        return cpf != null ? cpf.equals(cliente.cpf) : cliente.cpf == null;

    }

    @Override
    public int hashCode() {
        return cpf != null ? cpf.hashCode() : 0;
    }

    public Cliente(String nome, String cpf, String rg, String dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    public Cliente() {
        setId(proxId++);
    }
}
