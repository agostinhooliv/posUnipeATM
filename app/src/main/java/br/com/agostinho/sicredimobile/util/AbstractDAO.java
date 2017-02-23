package br.com.agostinho.sicredimobile.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by agostinhooliv on 18/02/17.
 */

public abstract class AbstractDAO<Entity extends BaseEntity<PK>, PK extends Serializable> {

    private List<Entity> repostorio = new ArrayList<Entity>();

    public void add(Entity t) {
        repostorio.add(t);
    }

    public void remove(Entity t) {
        repostorio.remove(t);
    }

    public Entity update(Entity t) {
        for (int i = 0; i < repostorio.size(); i++) {
            Entity query = repostorio.get(i);

            if (t.equals(query)) {
                repostorio.set(i, t);
                return t;
            }
        }

        return null;
    }

    public Entity findById(PK pk) {
        for (Entity entity : repostorio) {
            if (entity.getId().equals(pk)) {
                return entity;
            }
        }

        return null;
    }

    public List<Entity> findAll() {
        return this.repostorio;
    }

    public List<Entity> getRepostorio() {
        return repostorio;
    }

    public void setRepostorio(List<Entity> repostorio) {
        this.repostorio = repostorio;
    }
}
