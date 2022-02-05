package io.github.maxwel.becaDesafiosMaxwel.dtos.requests;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class PostAgendamentoRequestDto {

    private Long idServico;
    private String horario;
    private String idCliente;
}
