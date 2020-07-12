package com.compart.beta.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nomeUsuario;

	private String sobrenomeUsuario;

	private String username;

	private String senhaUsuario;

	private String preferencia;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
	        name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(
				        name = "role_id", referencedColumnName = "id"))
	private Collection<UsuarioRole> usuarioRoles;

	public Usuario() {
		
	}
	
	public Usuario(String nomeUsuario, String sobrenomeUsuario, String username, String senhaUsuario, String preferencia) {
		this.nomeUsuario = nomeUsuario;
		this.sobrenomeUsuario = sobrenomeUsuario;
		this.username = username;
		this.senhaUsuario = senhaUsuario;
		this.preferencia = preferencia;
	}

	public Usuario(String nomeUsuario, String sobrenomeUsuario, String username, String senhaUsuario, String preferencia, Collection <UsuarioRole> usuarioRoles) {
		this.nomeUsuario = nomeUsuario;
		this.sobrenomeUsuario = sobrenomeUsuario;
		this.username = username;
		this.senhaUsuario = senhaUsuario;
		this.preferencia = preferencia;
		this.usuarioRoles = usuarioRoles;
	}

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

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSobrenomeUsuario() {
		return sobrenomeUsuario;
	}

	public void setSobrenomeUsuario(String sobrenomeUsuario) {
		this.sobrenomeUsuario = sobrenomeUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public String getPreferencia() {
		return preferencia;
	}

	public void setPreferencia(String preferencia) {
		this.preferencia = preferencia;
	}

	public Collection<UsuarioRole> getUsuarioRoles() {
		return usuarioRoles;
	}

	public void setUsuarioRoles(Collection<UsuarioRole> usuarioRoles) {
		this.usuarioRoles = usuarioRoles;
	}

	@Override
	public String toString() {
		return "Usuario{ " + "id=" + id +
				", firstName='" + nomeUsuario + '\'' +
				", lastName='" + sobrenomeUsuario + '\'' +
				", email='" + username + '\'' +
				", password='" + "*********" + '\'' +
				", preferencia='" + preferencia + '\'' +
				", roles=" + usuarioRoles +
				'}';
	}

}
