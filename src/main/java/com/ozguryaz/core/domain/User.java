package com.ozguryaz.core.domain;

import com.ozguryaz.ui.component.AuthCombobox;
import com.ozguryaz.ui.component.EnumAuth;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "auth")
    @Enumerated(EnumType.STRING)
    private EnumAuth auth;

    public EnumAuth getAuth() {
        return auth;
    }

    public void setAuth(EnumAuth auth) {
        this.auth = auth;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
