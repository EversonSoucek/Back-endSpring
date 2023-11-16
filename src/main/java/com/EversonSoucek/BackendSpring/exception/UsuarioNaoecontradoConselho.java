package com.EversonSoucek.BackendSpring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class UsuarioNaoecontradoConselho {

    @ResponseBody
    @ExceptionHandler(UsuarioNaoEncontradoExcecao.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(UsuarioNaoEncontradoExcecao excecao) {
        Map<String, String> errMap = new HashMap<>();
        errMap.put("Mensagem de erro", excecao.getMessage());
        return errMap;
    }
}
