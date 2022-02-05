package io.github.maxwel.becaDesafiosMaxwel.mappers;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import io.github.maxwel.becaDesafiosMaxwel.dtos.requests.PostAgendamentoRequestDto;
import io.github.maxwel.becaDesafiosMaxwel.dtos.responses.GetAgendamentoListarResponseDto;
import io.github.maxwel.becaDesafiosMaxwel.dtos.responses.PostAgendamentoResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class AgendamentoMapper {

    public abstract PostAgendamentoResponseDto toPostAgendamentoRequest(PostAgendamentoRequestDto postAgendamentoRequestDto);

    //public abstract PostAgendamentoResponseDto toPostAgendamentoResponseDto(Agendamento agendamento);

    public abstract List<GetAgendamentoListarResponseDto> toGetAgendamentoListarResponseDto(List<Agendamento> agendamento);

}
