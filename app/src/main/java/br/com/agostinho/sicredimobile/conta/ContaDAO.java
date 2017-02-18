package br.com.agostinho.sicredimobile.conta;

import java.util.ArrayList;
import java.util.List;

import br.com.agostinho.sicredimobile.util.AbstractDAO;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class ContaDAO implements AbstractDAO<Conta> {

    public static List<Conta> listaContas = new ArrayList<Conta>();

    @Override
    public Conta cadastrar(Conta conta) {
        listaContas.add(conta);
        return conta;
    }

    @Override
    public Conta deletar(Conta conta) {
        listaContas.remove(conta);
        return conta;
    }

    @Override
    public Conta atualizar(Conta conta) {
        return conta;
    }
}
