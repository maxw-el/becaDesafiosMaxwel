package io.github.maxwel.becaDesafiosMaxwel.services.servicesImpl;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import io.github.maxwel.becaDesafiosMaxwel.domains.Cliente;
import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;
import io.github.maxwel.becaDesafiosMaxwel.dtos.requests.AgendamentoRequestDto;
import io.github.maxwel.becaDesafiosMaxwel.dtos.responses.AgendamentoResponseDto;
import io.github.maxwel.becaDesafiosMaxwel.mappers.MapperAgendamentoRequestToAgendamento;
import io.github.maxwel.becaDesafiosMaxwel.mappers.MapperAgendamentoToAgendamentoResponse;
import io.github.maxwel.becaDesafiosMaxwel.repositories.AgendamentoRepository;
import io.github.maxwel.becaDesafiosMaxwel.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final MapperAgendamentoRequestToAgendamento mapperAgendamentoRequestToAgendamento;
    private final MapperAgendamentoToAgendamentoResponse mapperAgendamentoToAgendamentoResponse;

    @Override
    public AgendamentoResponseDto criar(AgendamentoRequestDto agendamentoRequestDto) {

        Agendamento agendamento = mapperAgendamentoRequestToAgendamento.toDomain(agendamentoRequestDto);

        agendamentoRepository.save(agendamento);

        AgendamentoResponseDto agendamentoResponseDto = mapperAgendamentoToAgendamentoResponse.toResponse(agendamento);

        return agendamentoResponseDto;

    }

    @Override
    public void deletar(Long id) {
        agendamentoRepository.deleteById(id);
    }

    @Override
    public Agendamento atualizar(Agendamento agendamento, Long id) {
        Agendamento agendamentoAtualizado = agendamentoRepository.findById(id).get();
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
    public List<AgendamentoResponseDto> listar() {
        List<Agendamento> listaAgendamentos = agendamentoRepository.findAll();

        return listaAgendamentos
                .stream()
                .map(mapperAgendamentoToAgendamentoResponse::toResponse)
                .collect(Collectors.toList());

    }
}