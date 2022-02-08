package io.github.maxwel.becaDesafiosMaxwel.services.servicesImpl;

import io.github.maxwel.becaDesafiosMaxwel.domains.Cliente;
import io.github.maxwel.becaDesafiosMaxwel.exceptions.TamanhoNaoValidoException;
import io.github.maxwel.becaDesafiosMaxwel.repositories.ClienteRepository;
import io.github.maxwel.becaDesafiosMaxwel.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public Cliente criar(Cliente cliente) {
        if (cliente.getNome().length() <= 3) {
            throw new TamanhoNaoValidoException("Nome não pode ter menos que 3 caracteres.");
        }

        return clienteRepository.save(cliente);
    }

    @Override
    public void deletar(String cpf) {
        clienteRepository.deleteById(cpf);
    }

    @Override
    public Cliente atualizar(Cliente cliente, String cpf) {
        Cliente clienteAtualizado = this.obter(cpf);
        clienteAtualizado.setNome(cliente.getNome());

        clienteRepository.save(clienteAtualizado);

        return clienteAtualizado;
    }

    @Override
    public Cliente obter(String cpf) {
        Cliente cliente = clienteRepository.findById(cpf).get();

        return cliente;
    }

    @Override
    public List<Cliente> listar() {
        List<Cliente> listaClientes = clienteRepository.findAll();

        return listaClientes;
    }

}
