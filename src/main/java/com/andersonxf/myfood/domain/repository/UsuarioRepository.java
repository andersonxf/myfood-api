
package com.andersonxf.myfood.domain.repository;

import org.springframework.stereotype.Repository;

import com.andersonxf.myfood.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {

}