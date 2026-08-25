package com.charly.gestornotas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class NotaNoEncontradaException extends RuntimeException {

    public NotaNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}