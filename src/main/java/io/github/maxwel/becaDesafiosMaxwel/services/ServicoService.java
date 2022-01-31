package io.github.maxwel.becaDesafiosMaxwel.services;

import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;

import java.util.List;

public interface ServicoService {

    public Servico criar(Servico servico);

    public void deletar(Long id);

    public Servico atualizar(Servico servico, Long id);

    public Servico obter(Long id);

    public List<Servico> listar();
}
