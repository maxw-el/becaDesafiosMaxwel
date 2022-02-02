package io.github.maxwel.becaDesafiosMaxwel.services;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import io.github.maxwel.becaDesafiosMaxwel.dtos.requests.PostAgendamentoRequestDto;
import io.github.maxwel.becaDesafiosMaxwel.dtos.responses.GetAgendamentoListarResponseDto;
import io.github.maxwel.becaDesafiosMaxwel.dtos.responses.PostAgendamentoResponseDto;

import java.util.List;

public interface AgendamentoService {

    public PostAgendamentoResponseDto criar(PostAgendamentoRequestDto postAgendamentoRequestDto);

    public void deletar(Long id);

    public Agendamento atualizar(Agendamento agendamento, Long id);

    public Agendamento obter(Long id);

    public List<GetAgendamentoListarResponseDto> listar();
}
