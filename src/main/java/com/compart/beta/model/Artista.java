package com.compart.beta.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Artista{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;

	private String nomeArtista;

	private String username;

	private String senhaArtista;

	private String tipoArte;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "artists_roles",
			joinColumns = @JoinColumn(
					name = "user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "role_id", referencedColumnName = "id"))
	private Collection<ArtistaRole> artistaRoles;

	public Artista() {

	}

	public Artista(Long id, String nomeArtista, String username, String senhaArtista, String tipoArte) {
		Id = id;
		this.nomeArtista = nomeArtista;
		this.username = username;
		this.senhaArtista = senhaArtista;
		this.tipoArte = tipoArte;
	}

	public Artista(Long id, String nomeArtista, String username, String senhaArtista, String tipoArte, Collection<ArtistaRole> artistaRoles) {
		Id = id;
		this.nomeArtista = nomeArtista;
		this.username = username;
		this.senhaArtista = senhaArtista;
		this.tipoArte = tipoArte;
		this.artistaRoles = artistaRoles;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNomeArtista() {
		return nomeArtista;
	}

	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
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

	public Collection<ArtistaRole> getArtistaRoles() {
		return artistaRoles;
	}

	public void setArtistaRoles(Collection<ArtistaRole> artistaRoles) {
		this.artistaRoles = artistaRoles;
	}
}
