package com.compassito.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compassito.controller.dto.SaldoDto;
import com.compassito.model.Usuario;
import com.compassito.repository.UsuarioRepository;

@CrossOrigin
@RestController
@RequestMapping("/saldo")
public class CreditoController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/{id_usuario}")
	public ResponseEntity<SaldoDto> consultaSaldo(@PathVariable Long id_usuario) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id_usuario);
		
		if(usuario.isPresent()) {			
			
			return ResponseEntity.ok(new SaldoDto(usuario.get().getCredito()));
		}
		
		
		return ResponseEntity.notFound().build();
	
	}
}
