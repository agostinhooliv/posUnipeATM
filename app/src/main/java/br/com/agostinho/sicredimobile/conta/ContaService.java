package br.com.agostinho.sicredimobile.conta;

import br.com.agostinho.sicredimobile.usuario.Cliente;
import br.com.agostinho.sicredimobile.usuario.ClienteDAO;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class ContaService {

    ClienteDAO clienteDAO = new ClienteDAO();

    public void addCliente(Cliente cliente){
        clienteDAO.cadastrar(cliente);
    }

    public void removeCliente(Cliente cliente){
        clienteDAO.deletar(cliente);
    }

    public void updateCliente(Cliente cliente){
        clienteDAO.atualizar(cliente);
    }
}
