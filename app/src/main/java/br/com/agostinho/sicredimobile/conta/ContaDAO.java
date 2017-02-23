package br.com.agostinho.sicredimobile.conta;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.agostinho.sicredimobile.cliente.Cliente;
import br.com.agostinho.sicredimobile.util.AbstractDAO;
import br.com.agostinho.sicredimobile.util.GenerateContas;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class ContaDAO extends AbstractDAO<Conta, Integer> {

    public Conta findOne(String conta, String senha) {

        for (Conta c : super.getRepostorio()) {
            if (c.getConta().equalsIgnoreCase(conta) && c.getSenha().equalsIgnoreCase(senha)) {
                return c;
            }
        }

        return null;
    }

    public Conta findOne(String conta) {
        List<Conta> repostorio = super.getRepostorio();

        for(int i = 0; i < repostorio.size(); i++){
            Conta c = repostorio.get(i);
            if (c.getConta().equalsIgnoreCase(conta)) {
                return c;
            }
        }


        return null;
    }

    public ContaDAO(){
        Cliente cliente = new Cliente();
        cliente.setNome("Allan Jefferson");
        cliente.setRg("12345");
        cliente.setCpf("12345");
        cliente.setDataNascimento("020202");

        Conta conta = new Conta();
        conta.setConta("1");
        conta.setSenha("asdf");
        conta.setSaldo(100);
        conta.setTitular(cliente);

        super.getRepostorio().add(conta);
    }
}
