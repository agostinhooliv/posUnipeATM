package br.com.agostinho.sicredimobile.conta;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import br.com.agostinho.sicredimobile.cliente.Cliente;
import br.com.agostinho.sicredimobile.transacao.TransacaoDAO;
import br.com.agostinho.sicredimobile.transacao.TransacaoService;
import br.com.agostinho.sicredimobile.util.AbstractDAO;
import br.com.agostinho.sicredimobile.util.GenerateContas;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public class ContaDAO extends AbstractDAO<Conta, Integer> {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");

    public Conta findOne(String conta, String senha) {

        for (Conta c : super.getRepostorio()) {
            if (c.getConta().equalsIgnoreCase(conta) && c.getSenha().equalsIgnoreCase(senha)) {
                return c;
            }
        }

        return null;
    }

    public Conta findOne(String conta, String cpf, String dataNascimento) {

        String data1 = null;

        for (Conta c : super.getRepostorio()) {
            data1 = simpleDateFormat.format(c.getTitular().getDataNascimento());
            if (c.getConta().equalsIgnoreCase(conta) && c.getTitular().getCpf().equalsIgnoreCase(cpf) && (data1.equals(dataNascimento))) {
                return c;
            }
        }

        return null;
    }

    public Conta findOne(String conta) {
        List<Conta> repostorio = super.getRepostorio();

        for (int i = 0; i < repostorio.size(); i++) {
            Conta c = repostorio.get(i);
            if (c.getConta().equalsIgnoreCase(conta)) {
                return c;
            }
        }

        return null;
    }

    public void modificaSenha(String conta, String novaSenha) {
        Conta busca = this.findOne(conta);
        if (busca != null) {
            busca.setSenha(novaSenha);
        }
    }


    public ContaDAO() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1987, 12, 25);
        Cliente cliente = new Cliente("Allan Jefferson", "12345", "12345", calendar.getTime());

        calendar.set(2020, 12, 31);
        Conta conta = new Conta(1000.00, 1000.00, 23.99, 33.88, calendar.getTime(), cliente, "asdf");

        super.getRepostorio().add(conta);

        calendar.set(1960, 01, 01);
        Cliente cliente2 = new Cliente("João da Silva", "54321", "54321", calendar.getTime());

        calendar.set(2030, 9, 01);
        Conta conta2 = new Conta(1000.00, 1000.00, 0.00, 1.88, calendar.getTime(), cliente2, "qwer");

        super.getRepostorio().add(conta2);
    }
}
