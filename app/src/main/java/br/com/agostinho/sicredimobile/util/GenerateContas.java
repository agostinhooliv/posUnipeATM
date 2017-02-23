package br.com.agostinho.sicredimobile.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.agostinho.sicredimobile.cliente.Cliente;
import br.com.agostinho.sicredimobile.conta.Conta;

/**
 * Created by breno on 22/02/17.
 */

public class GenerateContas {

    public static List<Conta> generate(int qtd) {
        List<Conta> contas = new ArrayList<Conta>(qtd);

        for (int i = 0; i < qtd; i++) {
            Conta conta = generateOne();
            contas.add(conta);
        }

        return contas;
    }

    public static Conta generateOne() {
        Conta conta = new Conta();
        conta.setConta(generateNumConta());
        conta.setSaldo(generateSaldo());
        conta.setTitular(generateTitular());

        return conta;
    }

    private static Cliente generateTitular() {
        Cliente cliente = GenerateCliente.generateOne();

        return null;
    }

    private static double generateSaldo() {
        Random random = new Random();
        double v = random.nextDouble();

        return v * 100;
    }

    private static String generateNumConta() {
        Random random = new Random();
        int i = random.nextInt(1000);

        return String.valueOf(i);
    }

}
