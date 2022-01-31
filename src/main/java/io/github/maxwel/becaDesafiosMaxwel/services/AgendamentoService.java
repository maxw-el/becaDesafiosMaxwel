package io.github.maxwel.becaDesafiosMaxwel.services;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;

import java.util.List;

public interface AgendamentoService {

    public Agendamento criar(Agendamento agendamento);

    public void deletar(Long id);

    public Agendamento atualizar(Agendamento agendamento, Long id);

    public Agendamento obter(Long id);

    public List<Agendamento> listar();
}
