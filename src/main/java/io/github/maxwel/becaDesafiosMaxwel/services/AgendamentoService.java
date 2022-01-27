package io.github.maxwel.becaDesafiosMaxwel.services;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;

import java.util.List;

public interface AgendamentoService {

    public Agendamento criar(Agendamento agendamento);

    public void deletar(Integer id);

    public Agendamento atualizar(Agendamento agendamentoAtualizado, Integer id);

    public Agendamento obter(Integer id);

    public List<Agendamento> listar();
}
