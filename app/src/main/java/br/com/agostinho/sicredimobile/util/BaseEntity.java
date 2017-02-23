package br.com.agostinho.sicredimobile.util;

import java.io.Serializable;

/**
 * Created by breno on 22/02/17.
 */

public class BaseEntity<PK extends Serializable> {

    private PK id;

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }
}
