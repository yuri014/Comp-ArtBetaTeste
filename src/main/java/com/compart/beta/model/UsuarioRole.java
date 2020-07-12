package com.compart.beta.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UsuarioRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeRole;

    public UsuarioRole() {

    }

    public UsuarioRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeRole() {
        return nomeRole;
    }

    public void setNomeRole(String nomeRole) {
        this.nomeRole = nomeRole;
    }

    @Override
    public String toString() {
        return "UsuarioRole{" +
                "id=" + id +
                ", name='" + nomeRole + '\'' +
                '}';
    }

}
