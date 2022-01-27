package io.github.maxwel.becaDesafiosMaxwel.services;

import io.github.maxwel.becaDesafiosMaxwel.domains.Cliente;

import java.util.List;

public interface ClienteService {

    public Cliente criar(Cliente cliente);

    public void deletar(String cpf);

    public Cliente atualizar(Cliente clienteAtualizado, String cpf);

    public Cliente obter(String cpf);

    public List<Cliente> listar();

}
