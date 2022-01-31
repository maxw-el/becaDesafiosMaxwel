package io.github.maxwel.becaDesafiosMaxwel.services.servicesImpl;

import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;
import io.github.maxwel.becaDesafiosMaxwel.repositories.ServicoRepository;
import io.github.maxwel.becaDesafiosMaxwel.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Override
    public Servico criar(Servico servico) {
        Servico servicoCriado = servicoRepository.save(servico);

        return servicoCriado;
    }

    @Override
    public void deletar(Long id) {
        servicoRepository.deleteById(id);
    }

    @Override
    public Servico atualizar(Servico servico, Long id) {
        Servico servicoAtualizado = this.obter(id);
        servicoAtualizado.setNome(servico.getNome());
        servicoAtualizado.setPreco(servico.getPreco());

        servicoRepository.save(servicoAtualizado);

        return servicoAtualizado;
    }

    @Override
    public Servico obter(Long id) {
        Servico servico = servicoRepository.findById(id).get();

        return servico;
    }

    @Override
    public List<Servico> listar() {
        List<Servico> listaServicos = servicoRepository.findAll();

        return listaServicos;
    }
}
