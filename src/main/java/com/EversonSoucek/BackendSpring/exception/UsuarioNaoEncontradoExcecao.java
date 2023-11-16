package com.EversonSoucek.BackendSpring.exception;

public class UsuarioNaoEncontradoExcecao extends RuntimeException {
    public UsuarioNaoEncontradoExcecao (Long id) {
        super("Não foi possível achar usuário com o id" + id);
    }
}
