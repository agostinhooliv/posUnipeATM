package br.com.agostinho.sicredimobile.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.agostinho.sicredimobile.cliente.Cliente;

/**
 * Created by breno on 22/02/17.
 */
public class GenerateCliente {


    public static Cliente generateOne() {
        Cliente cliente = new Cliente();
        cliente.setCpf(generateCpf());
        cliente.setRg(generateRg());
        cliente.setDataNascimento(generateDataNascimento());
        cliente.setNome(generateNome());

        return cliente;
    }

    public static List<Cliente> generate(int qtd) {
        List<Cliente> clientes = new ArrayList<>(qtd);

        for (int i = 0; i < qtd; i++) {
            clientes.add(generateOne());
        }

        return clientes;
    }

    private static String generateDataNascimento() {
        return new Date().toString();
    }

    private static String generateRg() {
        // TODO Auto-generated method stub
        int numero = (int) (Math.random() * Math.pow(10, 8));
        return String.valueOf(numero);
    }

    private static String generateCpf() {
        // TODO Auto-generated method stub
        int numero = (int) (Math.random() * Math.pow(10, 8));
        return String.valueOf(numero);
    }


    private static String generateNome() {
        int num = (int) (Math.random() * 10);

        switch (num) {
            case 1:
                return "Joao";
            case 2:
                return "Allan";
            case 3:
                return "Ricardo";
            case 4:
                return "Denis";
            case 5:
                return "Melo";
            case 6:
                return "Silva";
            case 7:
                return "Chico";
            case 8:
                return "Santos";
            case 9:
                return "Jose";
            default:
                return "Geremias";
        }


    }
}
