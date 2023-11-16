package com.EversonSoucek.BackendSpring.controller;

import com.EversonSoucek.BackendSpring.exception.UsuarioNaoEncontradoExcecao;
import com.EversonSoucek.BackendSpring.model.Usuario;
import com.EversonSoucek.BackendSpring.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ControladorUsuario {

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @PostMapping("/usuario")
    Usuario novoUsuario(@RequestBody Usuario novoUsuario){
        return repositorioUsuario.save(novoUsuario);
    }

    @GetMapping("/usuarios")
    List<Usuario> getTodosUsuarios(){
        return repositorioUsuario.findAll();
    }

    @GetMapping("/usuario/{id}")
    Usuario getUsuarioPorId(@PathVariable Long id) {
        return repositorioUsuario.findById(id)
                .orElseThrow(()-> new UsuarioNaoEncontradoExcecao(id));

    }

    @PutMapping("/usuario/{id}")
    Usuario editaUsuario(@RequestBody Usuario novoUsuario,@PathVariable Long id){
        return repositorioUsuario.findById(id)
                .map(usuario -> {
                    usuario.setNomeDeUsuario(novoUsuario.getNomeDeUsuario());
                    usuario.setNome(novoUsuario.getNome());
                    usuario.setEmail(novoUsuario.getEmail());
                    return repositorioUsuario.save(usuario);
                }).orElseThrow(() ->new UsuarioNaoEncontradoExcecao(id));
    }

    @DeleteMapping("/usuario/{id}")
    String deletaUsuario(@PathVariable Long id){
        if(!repositorioUsuario.existsById(id)){
            throw new UsuarioNaoEncontradoExcecao(id);
        }
        repositorioUsuario.deleteById(id);
        return "Usuario com o id"+ id + "foi deletado";
    }

}
