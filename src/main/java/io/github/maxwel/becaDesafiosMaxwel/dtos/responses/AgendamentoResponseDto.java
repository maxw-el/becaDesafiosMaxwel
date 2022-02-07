package io.github.maxwel.becaDesafiosMaxwel.dtos.responses;

import lombok.Data;

@Data
public class AgendamentoResponseDto {

    private ClienteResponseDto cliente;
    private ServicoResponseDto servico;
    private String horario;

}
