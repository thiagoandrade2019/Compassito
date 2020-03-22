package com.compassito.controller.dto;



public class TokenDto {
	
	private String token;
	private String tipo;
	private Long id_usuario; 
	
	
	
	public String getToken() {
		return token;
	}



	public String getTipo() {
		return tipo;
	}
	
	public Long getId_usuario() {
		return id_usuario;
	}



	public TokenDto(String token, String tipo, Long id_usuario) {
		
		this.token = token;
		this.tipo = tipo;
		this.id_usuario = id_usuario;
	}


}
