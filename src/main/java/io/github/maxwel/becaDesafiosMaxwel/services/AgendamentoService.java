package io.github.maxwel.becaDesafiosMaxwel.services;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import io.github.maxwel.becaDesafiosMaxwel.dtos.requests.AgendamentoRequestDto;
import io.github.maxwel.becaDesafiosMaxwel.dtos.responses.AgendamentoResponseDto;

import java.util.List;

public interface AgendamentoService {

    public AgendamentoResponseDto criar(AgendamentoRequestDto agendamentoRequestDTO);

    public void deletar(Long id);

    public Agendamento atualizar(Agendamento agendamento, Long id);

    public Agendamento obter(Long id);

    public List<AgendamentoResponseDto> listar();
}
