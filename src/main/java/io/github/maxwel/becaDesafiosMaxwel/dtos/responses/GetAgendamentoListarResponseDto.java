package io.github.maxwel.becaDesafiosMaxwel.dtos.responses;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;

public class GetAgendamentoListarResponseDto {

    Long id;
    String IdCliente;

    public GetAgendamentoListarResponseDto(Agendamento agendamento) {
        this.setId(agendamento.getId());
        this.setIdCliente(agendamento.getCliente().getCpf());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(String idCliente) {
        IdCliente = idCliente;
    }
}
