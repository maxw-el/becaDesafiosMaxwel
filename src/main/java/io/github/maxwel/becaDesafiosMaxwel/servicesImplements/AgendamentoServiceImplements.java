package io.github.maxwel.becaDesafiosMaxwel.servicesImplements;

import io.github.maxwel.becaDesafiosMaxwel.domains.Agendamento;
import io.github.maxwel.becaDesafiosMaxwel.services.AgendamentoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AgendamentoServiceImplements implements AgendamentoService {

    static List<Agendamento> listaAgendamentos = new ArrayList<>();
    Integer id = 0;

    @Override
    public Agendamento criar(Agendamento agendamento) {
        listaAgendamentos.add(new Agendamento(++id, agendamento.getServico(), agendamento.getHorario(), agendamento.getCliente()));

        return agendamento;
    }

    @Override
    public void deletar(Integer id) {
        for (int i = 0; i < listaAgendamentos.size(); i++) {
            if (listaAgendamentos.get(i).getId() == id) {
                listaAgendamentos.remove(i);
            }
        }
    }

    @Override
    public Agendamento atualizar(Agendamento agendamentoAtualizado, Integer id) {
        Agendamento agendamento = null;

        for (int i = 0; i < listaAgendamentos.size(); i++) {
            if (listaAgendamentos.get(i).getId() == id) {
                agendamento = listaAgendamentos.set(i, agendamentoAtualizado);
            }
        }

        return agendamento;
    }

    @Override
    public Agendamento obter(Integer id) {
        Agendamento agendamento = null;

        for (int i = 0; i < listaAgendamentos.size(); i++) {
            if (listaAgendamentos.get(i).getId() == id) {
                agendamento = listaAgendamentos.get(i);
            }
        }

        return agendamento;
    }

    @Override
    public List<Agendamento> listar() {

        return listaAgendamentos;
    }
}
