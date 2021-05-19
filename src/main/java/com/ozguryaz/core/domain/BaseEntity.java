package com.ozguryaz.core.domain;

import java.io.Serializable;

public abstract class BaseEntity implements Serializable {
    public abstract Long getId();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseEntity that = (BaseEntity) o;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return this.getId().hashCode();
    }
}
