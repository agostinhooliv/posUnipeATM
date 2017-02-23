package br.com.agostinho.sicredimobile.cliente;

import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.conta.ContaDAO;
import br.com.agostinho.sicredimobile.util.AbstractService;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class ClienteService extends AbstractService<ClienteDAO, Cliente, Integer>{

    public ClienteService(ClienteDAO dao) {
        super(dao);
    }
}
