package com.ozguryaz.core.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Actor")
public class Actor extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Override
    public String toString() {
        return name;
    }

    @Column(name = "Name", length = 50)
    @NotNull
    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }
}
