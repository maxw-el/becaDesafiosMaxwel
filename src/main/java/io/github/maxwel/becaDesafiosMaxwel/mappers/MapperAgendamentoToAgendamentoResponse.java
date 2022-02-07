package io.github.maxwel.becaDesafiosMaxwel.mappers;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import io.github.maxwel.becaDesafiosMaxwel.dtos.responses.AgendamentoResponseDto;
import org.mapstruct.Mapper;

@Mapper
public interface MapperAgendamentoToAgendamentoResponse {

    public AgendamentoResponseDto toResponse(Agendamento agendamento);
}
