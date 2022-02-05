package io.github.maxwel.becaDesafiosMaxwel.dtos.responses;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class GetAgendamentoListarResponseDto {

    Long id;
    String IdCliente;

    public GetAgendamentoListarResponseDto(Agendamento agendamento) {
        this.setId(agendamento.getId());
        this.setIdCliente(agendamento.getCliente().getCpf());
    }
}
