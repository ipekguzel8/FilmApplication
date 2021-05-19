package com.ozguryaz.core.domain;

import javax.persistence.*;
@Entity
@Table(name = "FilmActor")
public class FilmActor extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="ID_Film", foreignKey = @ForeignKey(name = "FK_Film_Actor_Film"))
    private Film film;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Actor", foreignKey = @ForeignKey(name = "FK_Film_Actor_Actor"))
    private Actor actor;

    @Column(name = "Role", length = 100)
    private String role;

    @Column(name = "Role_Description")
    private String roleDescription;

    public void setId(Long id) {
        this.id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public Long getId() {
        return id;
    }
}
