package io.github.maxwel.becaDesafiosMaxwel.servicesImplements;

import io.github.maxwel.becaDesafiosMaxwel.domains.Servico;
import io.github.maxwel.becaDesafiosMaxwel.services.ServicoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicoServiceImplements implements ServicoService {

    static List<Servico> listaServicos = new ArrayList<>();
    Integer id = 0;

    @Override
    public Servico criar(Servico servico) {
        listaServicos.add(new Servico(++id, servico.getNome(), servico.getPreco()));

        return servico;
    }

    @Override
    public void deletar(Integer id) {
        for (int i = 0; i < listaServicos.size(); i++) {
            if (listaServicos.get(i).getId() == id) {
                listaServicos.remove(i);
            }
        }
    }

    @Override
    public Servico atualizar(Servico servicoAtualizado, Integer id) {
        Servico servico = null;

        for (int i = 0; i < listaServicos.size(); i++) {
            if (listaServicos.get(i).getId() == id) {
                servico = listaServicos.set(i, servicoAtualizado);
            }
        }

        return servico;
    }

    @Override
    public Servico obter(Integer id) {
        Servico servico = null;

        for (int i = 0; i < listaServicos.size(); i++) {
            if (listaServicos.get(i).getId() == id) {
                servico = listaServicos.get(i);
            }
        }

        return servico;
    }

    @Override
    public List<Servico> listar() {

        return listaServicos;
    }
}
