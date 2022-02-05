package io.github.maxwel.becaDesafiosMaxwel.dtos.responses;

import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class PostAgendamentoResponseDto {

    private Servico servico;
    private String horario;
    private String mensagem;
}
