package io.github.maxwel.becaDesafiosMaxwel.servicesImplements;

import io.github.maxwel.becaDesafiosMaxwel.domains.Cliente;
import io.github.maxwel.becaDesafiosMaxwel.services.ClienteService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImplements implements ClienteService {

    static List<Cliente> listaClientes = new ArrayList<>();

    @Override
    public Cliente criar(Cliente cliente) {
        listaClientes.add(new Cliente(cliente.getNome(), cliente.getCpf()));

        return cliente;

    }

    @Override
    public void deletar(String cpf) {

        for (int i = 0; i < listaClientes.size(); i++) {
            if (cpf.equals(listaClientes.get(i).getCpf())) {
                listaClientes.remove(i);
            }
        }

    }

    @Override
    public Cliente atualizar(Cliente clienteAtualizado, String cpf) {

        Cliente cliente = null;
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCpf().equals(clienteAtualizado.getCpf())) {
                cliente = listaClientes.set(i, clienteAtualizado);
            }
        }

        return cliente;

    }

    @Override
    public Cliente obter(String cpf) {
        Cliente cliente = null;
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getCpf() == cpf) {
                cliente = listaClientes.get(i);
            }
        }

        return cliente;
    }

    @Override
    public List<Cliente> listar() {

        return listaClientes;
    }
}
