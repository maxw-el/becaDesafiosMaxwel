package io.github.maxwel.becaDesafiosMaxwel.services.servicesImpl;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import io.github.maxwel.becaDesafiosMaxwel.repositories.AgendamentoRepository;
import io.github.maxwel.becaDesafiosMaxwel.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    @Override
    public Agendamento criar(Agendamento agendamento) {
        Agendamento agendamentoCriado = agendamentoRepository.save(agendamento);

        return agendamentoCriado;
    }

    @Override
    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }

    @Override
    public Agendamento atualizar(Agendamento agendamento, Long id) {
        Agendamento agendamentoAtualizado = this.obter(id);
        agendamentoAtualizado.setServico(agendamento.getServico());
        agendamentoAtualizado.setHorario(agendamento.getHorario());
        agendamentoAtualizado.setCliente(agendamento.getCliente());

        agendamentoRepository.save(agendamentoAtualizado);

        return agendamentoAtualizado;
    }

    @Override
    public Agendamento obter(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id).get();

        return agendamento;
    }

    @Override
    public List<Agendamento> listar() {
        List<Agendamento> listaAgendamentos = agendamentoRepository.findAll();

        return listaAgendamentos;
    }
}
