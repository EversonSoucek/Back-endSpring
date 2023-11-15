package com.EversonSoucek.BackendSpring.controller;

import com.EversonSoucek.BackendSpring.model.Usuario;
import com.EversonSoucek.BackendSpring.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @PostMapping("/usuario")
    Usuario novoUsuario(@RequestBody Usuario novoUsuario){
        return repositorioUsuario.save(novoUsuario);
    }

}
