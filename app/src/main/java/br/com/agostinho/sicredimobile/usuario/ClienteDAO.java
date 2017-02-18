package br.com.agostinho.sicredimobile.usuario;

import java.util.ArrayList;
import java.util.List;

import br.com.agostinho.sicredimobile.util.AbstractDAO;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class ClienteDAO implements AbstractDAO<Cliente> {

    List<Cliente> listaClientes = new ArrayList<Cliente>();

    @Override
    public Cliente cadastrar(Cliente cliente) {
        listaClientes.add(cliente);
        return cliente;
    }

    @Override
    public Cliente deletar(Cliente cliente) {
        listaClientes.remove(cliente);
        return cliente;
    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        return cliente;
    }
}
