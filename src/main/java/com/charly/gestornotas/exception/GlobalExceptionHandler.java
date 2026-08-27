package com.charly.gestornotas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotaNoEncontradaException.class)
    public ResponseEntity<String> manejarNotaNoEncontrada(NotaNoEncontradaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CategoriaNoEncontradaException.class)
    public ResponseEntity<String> manejarCategoriaNoEncontrada(CategoriaNoEncontradaException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}


/*
@ControllerAdvice — le dice a Spring "esta clase va a interceptar y manejar excepciones que ocurran en cualquier controller de la aplicación, no solo en uno específico."
Es "global" en ese sentido — no tienes que repetir este manejo en cada controller que crees a futuro.

@ExceptionHandler(NotaNoEncontradaException.class) — le dice a Spring "cuando en cualquier parte del código se lance específicamente una NotaNoEncontradaException (y no cualquier otra),
ejecutá este método para decidir qué responder." Es acá donde tu excepción con nombre propio empieza a valer la pena — podés apuntar exactamente a ella.

El método recibe la excepción que fue lanzada (ex) — así podés leer su mensaje (ex.getMessage()), el mismo que le pasaste al crearla en el Service ("Nota no encontrada con id: X").

ResponseEntity<String> — es un objeto especial de Spring que te deja controlar tanto el body de la respuesta como el código HTTP, algo que hasta ahora no habías necesitado porque tus métodos del controller devolvían directamente Nota o List<Nota> y Spring asumía 200 OK por defecto.

new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND) — arma la respuesta: el mensaje del error como body, y HttpStatus.NOT_FOUND (que es el código 404) como el status HTTP.
 */