package br.com.agostinho.sicredimobile.util;

import java.io.Serializable;

import br.com.agostinho.sicredimobile.conta.Conta;
import br.com.agostinho.sicredimobile.conta.ContaDAO;

/**
 * Created by breno on 22/02/17.
 */

public abstract class AbstractService<DAO extends AbstractDAO<Entity, PK>, Entity extends BaseEntity<PK>, PK extends Serializable> {
    DAO dao;

    public void add(Entity entity) {
        dao.add(entity);
    }

    public void remove(Entity entity) {
        dao.remove(entity);
    }

    public void update(Entity entity) {
        dao.update(entity);
    }

    public Entity findContaById(PK pk) {
        Entity query = dao.findById(pk);
        return query;
    }

    public DAO getDao() {
        return dao;
    }

    public AbstractService(DAO dao) {
        this.dao = dao;
    }
}
