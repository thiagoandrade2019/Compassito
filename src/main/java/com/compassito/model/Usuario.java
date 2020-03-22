package com.compassito.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String login;
	private String email;
	private String senha;
	private String nome;
	private int credito;
	
	
	@OneToOne
	@JoinColumn(name = "id_nivel_acesso", referencedColumnName = "id")
	private NivelAcesso nivelAcesso;
	
	@OneToOne
	@JoinColumn(name = "id_cargo", referencedColumnName = "id")
	private Cargo cargo;
	
	@OneToOne
	@JoinColumn(name = "id_unidade", referencedColumnName = "id")
	private Unidade unidade;
	
	@Column(name = "responsavel_unidade")
	private Boolean responsavelUnidade;

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getNome() {
		return nome;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<NivelAcesso> nivelAcesso = new ArrayList<NivelAcesso>();
		nivelAcesso.add(this.nivelAcesso);
		return nivelAcesso;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.email;
	}
	
	public int getCredito() {
		return credito;
	}

	public int setCredito(int credito) {
		return credito = credito;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	
	
}