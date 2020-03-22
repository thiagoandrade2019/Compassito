package com.compassito.controller;

import javax.validation.Valid;

import org.h2.security.auth.AuthConfigException;
import org.hibernate.validator.internal.util.privilegedactions.GetInstancesFromServiceLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compassito.config.security.TokenService;
import com.compassito.controller.dto.TokenDto;
import com.compassito.controller.form.LoginForm;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	//Retornando o token como resposta
	@PostMapping
	public ResponseEntity<TokenDto> autenticar(@RequestBody @Valid LoginForm form){
		
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
		try {
			Authentication authentication= authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			return ResponseEntity.ok(new TokenDto(token, "Bearer", tokenService.getIdUsuario(token)));
		} catch (AuthConfigException e) {
			return ResponseEntity.badRequest().build();
		}
		
	}
		
}


