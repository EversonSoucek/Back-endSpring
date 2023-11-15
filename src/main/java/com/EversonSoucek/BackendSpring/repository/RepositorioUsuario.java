package com.EversonSoucek.BackendSpring.repository;

import com.EversonSoucek.BackendSpring.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario,Long> {

}
