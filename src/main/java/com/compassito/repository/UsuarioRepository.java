package com.compassito.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.compassito.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	java.util.Optional<Usuario> findByEmail(String email);

}
