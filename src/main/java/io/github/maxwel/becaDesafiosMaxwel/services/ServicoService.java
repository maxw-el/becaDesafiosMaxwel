package io.github.maxwel.becaDesafiosMaxwel.services;

import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;

import java.util.List;

public interface ServicoService {

    public Servico criar(Servico servico);

    public void deletar(Integer id);

    public Servico atualizar(Servico servicoAtualizado, Integer id);

    public Servico obter(Integer id);

    public List<Servico> listar();
}
