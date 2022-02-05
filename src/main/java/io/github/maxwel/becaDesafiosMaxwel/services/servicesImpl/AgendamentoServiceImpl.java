package io.github.maxwel.becaDesafiosMaxwel.services.servicesImpl;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import io.github.maxwel.becaDesafiosMaxwel.domains.Cliente;
import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;
import io.github.maxwel.becaDesafiosMaxwel.dtos.requests.PostAgendamentoRequestDto;
import io.github.maxwel.becaDesafiosMaxwel.dtos.responses.GetAgendamentoListarResponseDto;
import io.github.maxwel.becaDesafiosMaxwel.dtos.responses.PostAgendamentoResponseDto;
import io.github.maxwel.becaDesafiosMaxwel.mappers.AgendamentoMapper;
import io.github.maxwel.becaDesafiosMaxwel.repositories.AgendamentoRepository;
import io.github.maxwel.becaDesafiosMaxwel.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AgendamentoServiceImpl implements AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final ServicoServiceImpl servicoService;
    private final ClienteServiceImpl clienteService;
    private final AgendamentoMapper agendamentoMapper;

    @Override
    public PostAgendamentoResponseDto criar(PostAgendamentoRequestDto postAgendamentoRequestDto) {
        Servico servicoObtido = servicoService.obter(postAgendamentoRequestDto.getIdServico());
        Cliente clienteObtido = clienteService.obter(postAgendamentoRequestDto.getIdCliente());

        Agendamento agendamento = new Agendamento();
        agendamento.setServico(servicoObtido);
        agendamento.setHorario(postAgendamentoRequestDto.getHorario());
        agendamento.setCliente(clienteObtido);

        Agendamento agendamentoCriado = agendamentoRepository.save(agendamento);

        PostAgendamentoResponseDto postAgendamentoResponseDto = new PostAgendamentoResponseDto();
        postAgendamentoResponseDto.setServico(agendamentoCriado.getServico());
        postAgendamentoResponseDto.setHorario(agendamentoCriado.getHorario());
        postAgendamentoResponseDto.setMensagem("Seu agendamento foi concluído!");

        return postAgendamentoResponseDto;

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
    public List<GetAgendamentoListarResponseDto> listar() {
        List<Agendamento> listaAgendamentos = agendamentoRepository.findAll();

        List<GetAgendamentoListarResponseDto> getAgendamentoListarResponseDto = new ArrayList<>();
        listaAgendamentos.stream().forEach(agendamento -> getAgendamentoListarResponseDto.add(new GetAgendamentoListarResponseDto(agendamento)));

        return getAgendamentoListarResponseDto;

    }
}