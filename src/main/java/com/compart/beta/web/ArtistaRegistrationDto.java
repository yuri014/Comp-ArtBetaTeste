package com.compart.beta.web;

import javax.validation.constraints.NotEmpty;

public class ArtistaRegistrationDto {

    @NotEmpty
    private String nomeArtista;

    @NotEmpty
    private String username;

    @NotEmpty
    private String senhaArtista;

    @NotEmpty
    private String tipoArte;

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenhaArtista() {
        return senhaArtista;
    }

    public void setSenhaArtista(String senhaArtista) {
        this.senhaArtista = senhaArtista;
    }

    public String getTipoArte() {
        return tipoArte;
    }

    public void setTipoArte(String tipoArte) {
        this.tipoArte = tipoArte;
    }
}
