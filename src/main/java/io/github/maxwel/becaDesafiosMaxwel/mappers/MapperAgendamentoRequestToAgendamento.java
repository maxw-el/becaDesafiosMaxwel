package io.github.maxwel.becaDesafiosMaxwel.mappers;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import io.github.maxwel.becaDesafiosMaxwel.dtos.requests.AgendamentoRequestDto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperAgendamentoRequestToAgendamento {

    public Agendamento toDomain(AgendamentoRequestDto agendamentoRequestDTO);

}
