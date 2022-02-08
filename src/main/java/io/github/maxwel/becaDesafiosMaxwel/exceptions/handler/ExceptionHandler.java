package io.github.maxwel.becaDesafiosMaxwel.exceptions.handler;

import io.github.maxwel.becaDesafiosMaxwel.exceptions.TamanhoNaoValidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(TamanhoNaoValidoException.class)
    public ResponseEntity<DefaultException> handler(TamanhoNaoValidoException e) {

        DefaultException defaultException = new DefaultException();
        defaultException.setMensagem(e.getMessage());
        defaultException.setDataHora((LocalDateTime.now()));
        defaultException.setStatus((HttpStatus.NOT_ACCEPTABLE.value()));

        return ResponseEntity.status(defaultException.getStatus()).body(defaultException);
    }
}
