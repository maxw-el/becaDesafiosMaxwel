package io.github.maxwel.becaDesafiosMaxwel.exceptions.handler;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DefaultException {

    private int status;
    private String mensagem;
    private LocalDateTime dataHora;
}
