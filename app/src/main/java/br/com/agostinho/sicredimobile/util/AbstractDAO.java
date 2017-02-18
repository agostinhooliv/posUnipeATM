package br.com.agostinho.sicredimobile.util;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public interface AbstractDAO<T> {

    public T cadastrar(T t);
    public T deletar(T t);
    public T atualizar(T t);
}
