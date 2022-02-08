package io.github.maxwel.becaDesafiosMaxwel.services.servicesImpl;

import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;
import io.github.maxwel.becaDesafiosMaxwel.exceptions.TamanhoNaoValidoException;
import io.github.maxwel.becaDesafiosMaxwel.repositories.ServicoRepository;
import io.github.maxwel.becaDesafiosMaxwel.services.ServicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ServicoServiceImpl implements ServicoService {

    private final ServicoRepository servicoRepository;

    @Override
    public Servico criar(Servico servico) {
        if (servico.getNome().length() <= 2) {
            throw new TamanhoNaoValidoException("Nome do serviço não pode ter menos que 2 caracteres.");
        }

        return servicoRepository.save(servico);
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
