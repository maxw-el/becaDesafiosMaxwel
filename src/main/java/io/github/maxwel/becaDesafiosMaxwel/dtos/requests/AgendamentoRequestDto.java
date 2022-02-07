package io.github.maxwel.becaDesafiosMaxwel.dtos.requests;

import lombok.Data;

@Data
public class AgendamentoRequestDto {

    private ClienteRequestDto cliente;
    private ServicoRequestDto servico;
    private String horario;
}
